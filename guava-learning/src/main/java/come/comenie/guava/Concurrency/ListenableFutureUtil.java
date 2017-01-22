package come.comenie.guava.Concurrency;

/**
 *
 *  ListenableFuture{@link com.google.common.util.concurrent.ListenableFuture}接口并继承了JDK concurrent包下的Future 接口
 *
 *  ListenableFuture 中的基础方法是addListener(Runnable, Executor), 该方法会在多线程运算完的时候，指定的Runnable参数传入的对象会被指定的Executor执行。
 *
 *  回调（CallBack）
 *  多数用户喜欢使用 Futures.addCallback(ListenableFuture<V>, FutureCallback<V>, Executor)的方式,
 *  或者 另外一个版本version（译者注：addCallback(ListenableFuture<V> future,FutureCallback<? super V> callback)），
 *  默认是采用 MoreExecutors.sameThreadExecutor()线程池, 为了简化使用，Callback采用轻量级的设计.
 *  FutureCallback<V> 中实现了两个方法:
 *      onSuccess(V),在Future成功的时候执行，根据Future结果来判断。
 *      onFailure(Throwable), 在Future失败的时候执行，根据Future结果来判断。
 *
 *  ListenableFuture的创建
 *
 *  对应JDK中的 ExecutorService.submit(Callable) 提交多线程异步运算的方式，Guava 提供了ListeningExecutorService 接口,
 *  该接口返回 ListenableFuture 而相应的 ExecutorService 返回普通的 Future。
 *  将 ExecutorService 转为 ListeningExecutorService，可以使用MoreExecutors.listeningDecorator(ExecutorService)进行装饰。
 *
 *  假如你是从 FutureTask转换而来的, Guava 提供ListenableFutureTask.create(Callable<V>) 和ListenableFutureTask.create(Runnable, V).
 *  和 JDK不同的是, ListenableFutureTask 不能随意被继承（译者注：ListenableFutureTask中的done方法实现了调用listener的操作）。
 *
 *  假如你喜欢抽象的方式来设置future的值，而不是想实现接口中的方法，可以考虑继承抽象类AbstractFuture<V> 或者直接使用 SettableFuture 。
 *
 *  JdkFutureAdapters.listenInPoolThread(Future)
 *
 *
 *  Futures
 *  transform(ListenableFuture<A>, AsyncFunction<A, B>, Executor)   返回一个新的ListenableFuture ，该ListenableFuture 返回的result是由传入的AsyncFunction 参数指派到传入的 ListenableFuture中.
 *  transform(ListenableFuture<A>, Function<A, B>, Executor)    返回一个新的ListenableFuture ，该ListenableFuture 返回的result是由传入的Function 参数指派到传入的 ListenableFuture中.
 *  allAsList(Iterable<ListenableFuture<V>>)            	返回一个ListenableFuture ，该ListenableFuture 返回的result是一个List，List中的值是每个ListenableFuture的返回值，假如传入的其中之一fails或者cancel，这个Future fails 或者canceled
 *  successfulAsList(Iterable<ListenableFuture<V>>)       返回一个ListenableFuture ，该Future的结果包含所有成功的Future，按照原来的顺序，当其中之一Failed或者cancel，则用null替代
 *
 *  AsyncFunction<A, B> 中提供一个方法ListenableFuture<B> apply(A input)，它可以被用于异步变换值
 *
 *  CheckFuture {@link com.google.common.util.concurrent.CheckedFuture}
 *
 * Created by 波 on 2017/1/22.
 */
public class ListenableFutureUtil {
}
