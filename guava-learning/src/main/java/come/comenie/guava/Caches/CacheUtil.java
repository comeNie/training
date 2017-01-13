package come.comenie.guava.Caches;

/**
 * 缓存管理：Cache {@link com.google.common.cache.Cache}
 * guava cache 是一个全内存的本地缓存实现，它提供了线程安全的实现机制
 *
 * 创建Cache的两种方式：
 * 通过CacheBuilder构造指定的缓存
 * 1  CacheLoader {@link com.google.common.cache.CacheLoader}
 * 2  Callable {@link java.util.concurrent.Callable} 如果有缓存则返回；否则运算、缓存、然后返回
 *
 * Cache 回收：
 *  1. 大小的设置：CacheBuilder.maximumSize(long)  CacheBuilder.weigher(Weigher)  CacheBuilder.maxumumWeigher(long)
 *  2. 时间：expireAfterAccess(long, TimeUnit) expireAfterWrite(long, TimeUnit)
 *  3. 引用：CacheBuilder.weakKeys() CacheBuilder.weakValues()  CacheBuilder.softValues()
 *  4. 明确的删除：invalidate(key)  invalidateAll(keys)  invalidateAll()
 *  5. 删除监听器：CacheBuilder.removalListener(RemovalListener)
 *
 * refresh机制：
 *  1. LoadingCache.refresh(K)  在生成新的value的时候，旧的value依然会被使用。
 *  2. CacheLoader.reload(K, V) 生成新的value过程中允许使用旧的value
 *  3. CacheBuilder.refreshAfterWrite(long, TimeUnit) 自动刷新cache
 *
 *  统计：
 *  CacheBuilder.recordStats()用来开启Guava Cache的统计功能。 统计打开后，Cache.stats()方法会返回CacheStats对象以提供如下统计信息：
 *  hitRate()：缓存命中率；
 *  averageLoadPenalty()：加载新值的平均时间，单位为纳秒；
 *  evictionCount()：缓存项被回收的总数，不包括显式清除。
 *
 *
 *  entry不存在或失效时，保证单线程回源
 *  1 避免了所有读不到该entry的线程一起去后面的数据库或Redis访问，压力暴炸。虽然自己做也行，但不就怕普通程序员一不小心没写好么。
 *  后台定时刷新数据
 *  1 数据放入缓存后，定时刷新，而且在正确配置后（后详），在刷新的过程中，依然使用旧数据响应请求，不会造成卡顿
 *  WeakHashMap的并发安全版
 *  Map里的Key或Value是 WeakReference的好处，就是对象本身失效后被GC掉，而不会因为对象依然在Map里保存而GC不掉。
 *
 *
 * Created by 波 on 2017/1/13.
 */
public class CacheUtil {
}
