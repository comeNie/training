package come.comenie.guava.Caches;

import com.google.common.base.Optional;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.RemovalCause;
import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;
import com.google.common.cache.Weigher;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

/**
 * Created by 波 on 2017/1/13.
 */
public class CacheUtilTest {

    @Test
    public void testLoadingCache() throws ExecutionException {
        final String  key= "comnie";
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return "h" + key;
            }
        });
        cache.put(key,key);
        assertEquals(key,cache.get(key));
        assertEquals("h"+key+"h", cache.get(key+"h"));
    }

    @Test
    public void testCallableCache() throws ExecutionException {
        final String  key= "comnie";
        Cache<String,String> cache = CacheBuilder.newBuilder().maximumSize(100).build();
        assertEquals("helloworld",cache.get(key, new Callable<String>() {
            public String call() throws Exception {
                return "helloworld";
            }
        }));

        cache.put(key,key);
        assertEquals(key, cache.get(key, new Callable<String>() {
            public String call() throws Exception {
                return "helloworld";
            }
        }));
    }

    @Test
    public void  testWhenCacheMiss_thenValueisComputed() throws InterruptedException {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().refreshAfterWrite(1, TimeUnit.SECONDS).build(
                new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return key.toUpperCase();
                    }
                }
        );

        assertEquals(0, cache.size());
        cache.put("test", "test");
        assertEquals("test", cache.getUnchecked("test"));
        assertEquals("HELLO", cache.getUnchecked("hello"));
        assertEquals(2, cache.size());

        TimeUnit.SECONDS.sleep(2);
        assertEquals("TEST", cache.getUnchecked("test"));

    }

    /**
     * 可以通过maximumSize()方法限制cache的size，如果cache达到了最大限制，oldest items 将会被回收。
     */
    @Test
    public void  testWhenCacheReachMaxSize_thenWviction() {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().maximumSize(2).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return  key.toUpperCase();
            }
        });

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("forth");

        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("FORTH", cache.getIfPresent("forth"));
    }

    @Test
    public void testWhenCacheReachMaxWeight_thenEviction() {
        LoadingCache<String,String> cache = CacheBuilder.newBuilder().weigher(new Weigher<String, String>() {
            public int weigh(String key, String value) {
                return value.length();
            }
        }).maximumWeight(16).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                return key.toUpperCase();
            }
        });

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
        assertNull(cache.getIfPresent("first"));
        assertEquals("LAST", cache.getIfPresent("last"));
    }

    /**
     * expireAfterAccess(long, TimeUnit)：缓存项在给定时间内没有被读/写访问，则回收。请注意这种缓存的回收顺序和基于大小回收一样。
     * expireAfterWrite(long, TimeUnit)：缓存项在给定时间内没有被写访问（创建或覆盖），则回收。如果认为缓存数据总是在固定时候后变得陈旧不可用，这种回收方式是可取的。
     * @throws InterruptedException
     */
    @Test
    public void whenEntryIdle_thenEviction() throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .expireAfterAccess(2, TimeUnit.MILLISECONDS)
                .build(loader);
        cache.getUnchecked("hello");
        assertEquals(1, cache.size());
        cache.getUnchecked("hello");
        Thread.sleep(300);
        cache.getUnchecked("test");
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }

    @Test
    public void testAsyncReload() throws Exception {
        final AtomicInteger loadCount = new AtomicInteger();
        final AtomicInteger reloadCount = new AtomicInteger();
        final AtomicInteger loadAllCount = new AtomicInteger();
        CacheLoader<Object, Object> baseLoader = new CacheLoader<Object, Object>() {
            @Override
            public Object load(Object key) {
                loadCount.incrementAndGet();
                return new Object();
            }

            @Override
            public ListenableFuture<Object> reload(Object key, Object oldValue) {
                reloadCount.incrementAndGet();
                return Futures.immediateFuture(new Object());
            }

            @Override
            public Map<Object, Object> loadAll(Iterable<? extends Object> keys) {
                loadAllCount.incrementAndGet();
                return ImmutableMap.of();
            }
        };

        assertEquals(0, loadCount.get());
        assertEquals(0, reloadCount.get());
        assertEquals(0, loadAllCount.get());

        baseLoader.load(new Object());
        baseLoader.reload(new Object(), new Object());
        baseLoader.loadAll(ImmutableList.of(new Object()));
        assertEquals(1, loadCount.get());
        assertEquals(1, reloadCount.get());
        assertEquals(1, loadAllCount.get());

        QueuingExecutor executor = new QueuingExecutor();
        CacheLoader<Object, Object> asyncReloader =
                CacheLoader.asyncReloading(baseLoader, executor);

        asyncReloader.load(new Object());
        asyncReloader.reload(new Object(), new Object());
        asyncReloader.loadAll(ImmutableList.of(new Object()));
        assertEquals(2, loadCount.get());
        assertEquals(1, reloadCount.get());
        assertEquals(2, loadAllCount.get());

        executor.runNext();
        assertEquals(2, loadCount.get());
        assertEquals(2, reloadCount.get());
        assertEquals(2, loadAllCount.get());

    }

    @Test
    public void whenEntryRemovedFromCache_thenNotify() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(final String key) {
                return key.toUpperCase();
            }
        };
        RemovalListener<String, String> listener = new RemovalListener<String, String>() {
            public void onRemoval(RemovalNotification<String, String> n) {
                if (n.wasEvicted()) {
                    String cause = n.getCause().name();
                    assertEquals(RemovalCause.SIZE.toString(), cause);
                }
            }
        };
        LoadingCache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);
        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
    }


    /**
     * 刷新和回收不太一样。正如LoadingCache.refresh(K)所声明，刷新表示为键加载新值，这个过程可以是异步的。
     * 在刷新操作进行时，缓存仍然可以向其他线程返回旧值，而不像回收操作，读缓存的线程必须等待新值加载完成。
     *
     * 如果刷新过程抛出异常，缓存将保留旧值，而异常会在记录到日志后被丢弃[swallowed]。
     *
     * 重载CacheLoader.reload(K, V)可以扩展刷新时的行为，这个方法允许开发者在计算新值时使用旧的值。
     */
    @Test
    public void cache_reLoad() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
            /**
             * 重写reload方法可以定制自己的reload策略
             * @param key
             * @param oldValue
             * @return
             * @throws Exception
             */
            @Override
            public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                return super.reload(key, oldValue);
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .build(loader);
    }

    /**
     * CacheBuilder.refreshAfterWrite(long, TimeUnit)可以为缓存增加自动定时刷新功能。
     * 和expireAfterWrite相反，refreshAfterWrite通过定时刷新可以让缓存项保持可用，
     * 但请注意：缓存项只有在被检索时才会真正刷新（如果CacheLoader.refresh实现为异步，那么检索不会被刷新拖慢）。
     * 因此，如果你在缓存上同时声明expireAfterWrite和refreshAfterWrite，缓存并不会因为刷新盲目地定时重置，
     * 如果缓存项没有被检索，那刷新就不会真的发生，缓存项在过期时间后也变得可以回收。
     */
    @Test
    public void whenLiveTimeEnd_thenRefresh() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key.toUpperCase();
            }
        };
        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .refreshAfterWrite(1, TimeUnit.MINUTES)
                .build(loader);
    }

    /**
     * 默认情况guava cache将会抛出异常，如果试图加载null value–因为cache null 是没有任何意义的。
     * 但是如果null value 对你的代码而已有一些特殊的含义，你可以尝试用Optional来表达
     */
    @Test
    public void whenNullValue_thenOptional() {
        CacheLoader<String, Optional<String>> loader;
        loader = new CacheLoader<String, Optional<String>>() {
            @Override
            public Optional<String> load(String key) {
                return Optional.fromNullable(getSuffix(key));
            }
        };
        LoadingCache<String, Optional<String>> cache;
        cache = CacheBuilder.newBuilder().build(loader);
        assertEquals("txt", cache.getUnchecked("text.txt").get());
        assertFalse(cache.getUnchecked("hello").isPresent());
    }




    private String getSuffix(final String str) {
        int lastIndex = str.lastIndexOf('.');
        if (lastIndex == -1) {
            return null;
        }
        return str.substring(lastIndex + 1);
    }

    private static class QueuingExecutor implements Executor {
        private LinkedList<Runnable> tasks = Lists.newLinkedList();

        public void execute(Runnable task) {
            tasks.add(task);
        }

        private void runNext() {
            tasks.removeFirst().run();
        }
    }
}