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
 *      expireAfterAccess(long, TimeUnit)：缓存项在给定时间内没有被读/写访问，则回收。
 *      请注意这种缓存的回收顺序和基于大小回收一样。
 *      expireAfterWrite(long, TimeUnit)：缓存项在给定时间内没有被写访问（创建或覆盖），
 *      则回收。如果认为缓存数据总是在固定时候后变得陈旧不可用，这种回收方式是可取的。
 *  3. 引用：CacheBuilder.weakKeys() CacheBuilder.weakValues()  CacheBuilder.softValues()
 *      CacheBuilder.weakKeys()：使用弱引用存储键。当键没有其它（强或软）引用时，缓存项可以被垃圾回收。因为垃圾回收仅依赖恒等式（==），
 *      使用弱引用键的缓存用==而不是equals比较键。
 *      CacheBuilder.softValues()：使用软引用存储值。软引用只有在响应内存需要时，才按照全局最近最少使用的顺序回收。
 *      考虑到使用软引用的性能影响，我们通常建议使用更有性能预测性的缓存大小限定（见上文，基于容量回收）。使用软引用值的缓存同样用==而不是equals比较值。
 *  4. 明确的删除：invalidate(key)  invalidateAll(keys)  invalidateAll()
 *      个别清除：Cache.invalidate(key)
 *      批量清除：Cache.invalidateAll(keys)
 *      清除所有缓存项：Cache.invalidateAll()
 *  5. 删除监听器：CacheBuilder.removalListener(RemovalListener)
 *      通过CacheBuilder.removalListener(RemovalListener)，你可以声明一个监听器，以便缓存项被移除时做一些额外操作。
 *      缓存项被移除时，RemovalListener会获取移除通知[RemovalNotification]，其中包含移除原因[RemovalCause]、键和值。
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
 *  空值处理：
 *  实际上Guava整体设计思想就是拒绝null的，很多地方都会执行com.google.common.base.Preconditions.checkNotNull的检查。
 *  默认情况guava cache将会抛出异常，如果试图加载null value–因为cache null 是没有任何意义的。
 *
 *  Notes:
 *  什么时候用get，什么时候用getUnchecked?
 *  如果你的CacheLoader没有定义任何checked Exception，那你可以使用getUnchecked
 *
 * Created by 波 on 2017/1/13.
 */
public class CacheUtil {
}
