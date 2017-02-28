package come.comenie.guava.Concurrency;

/**
 * Guava包里的Service{@link com.google.common.util.concurrent.Service}接口用于封装一个服务对象的运行状态、包括start和stop等方法
 *
 * Service 生命周期 {@link com.google.common.util.concurrent.Service.State}：
 * Service.State.NEW
 * Service.State.STARTING
 * Service.State.RUNNING
 * Service.State.STOPPING
 * Service.State.TERMINATED
 *
 * 服务基础实现：
 * AbstractIdleService {@link com.google.common.util.concurrent.AbstractIdleService}
 *  AbstractIdleService 类简单实现了Service接口、其在running状态时不会执行任何动作–因此在running时也不需要启动线程–但需要处理开启/关闭动作。
 *  要实现一个此类的服务，只需继承AbstractIdleService类，然后自己实现startUp() 和shutDown()方法就可以了。
 *
 *  AbstractExecutionThreadService {@link com.google.common.util.concurrent.AbstractExecutionThreadService}
 *  AbstractExecutionThreadService 通过单线程处理启动、运行、和关闭等操作。你必须重载run()方法，同时需要能响应停止服务的请求
 *  还可以重载triggerShutdown()方法让run()方法结束返回。
 *
 *  AbstractScheduledService{@link com.google.common.util.concurrent.AbstractScheduledService}
 *  AbstractScheduledService类用于在运行时处理一些周期性的任务。子类可以实现 runOneIteration()方法定义一个周期执行的任务，以及相应的startUp()和shutDown()方法。
 *  为了能够描述执行周期，你需要实现scheduler()方法。
 *  通常情况下，你可以使用AbstractScheduledService.Scheduler类提供的两种调度器：newFixedRateSchedule(initialDelay, delay, TimeUnit)
 *  和newFixedDelaySchedule(initialDelay, delay, TimeUnit)，
 *  类似于JDK并发包中ScheduledExecutorService类提供的两种调度方式。如要自定义schedules则可以使用 CustomScheduler类来辅助实现
 *
 *  AbstractService{@link com.google.common.util.concurrent.AbstractService}
 *
 *  继承AbstractService方法必须实现两个方法.
 *  doStart():  首次调用startAsync()时会同时调用doStart(),doStart()内部需要处理所有的初始化工作、如果启动成功则调用notifyStarted()方法；启动失败则调用notifyFailed()
 *  doStop():  首次调用stopAsync()会同时调用doStop(),doStop()要做的事情就是停止服务，如果停止成功则调用 notifyStopped()方法；停止失败则调用 notifyFailed()方法。
 *  doStart和doStop方法的实现需要考虑下性能，尽可能的低延迟。如果初始化的开销较大，如读文件，打开网络连接，或者其他任何可能引起阻塞的操作，建议移到另外一个单独的线程去处理。
 *
 *  ServiceManager{@link com.google.common.util.concurrent.ServiceManager}
 *
 *  通过实例化ServiceManager类来创建一个Service集合，你可以通过以下方法来管理它们：
 *  startAsync()  ： 将启动所有被管理的服务。如果当前服务的状态都是NEW的话、那么你只能调用该方法一次、这跟 Service#startAsync()是一样的。
 *  stopAsync() ：将停止所有被管理的服务。
 *  addListener ：会添加一个ServiceManager.Listener，在服务状态转换中会调用该Listener
 *  awaitHealthy() ：会等待所有的服务达到Running状态
 *  awaitStopped()：会等待所有服务达到终止状态
 *
 *  检测类的方法有：
 *  isHealthy()  ：如果所有的服务处于Running状态、会返回True
 *  servicesByState()：以状态为索引返回当前所有服务的快照
 *  startupTimes() ：返回一个Map对象，记录被管理的服务启动的耗时、以毫秒为单位，同时Map默认按启动时间排序。
 *
 * Created by 波 on 2017/1/22.
 */
public class ServiceUtil {
}
