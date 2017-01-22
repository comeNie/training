package come.comenie.guava.Concurrency;

import com.google.common.util.concurrent.ListenableFuture;

import org.junit.After;
import org.junit.Before;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.google.common.base.Preconditions.checkNotNull;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;

/**
 * Created by 波 on 2017/1/22.
 */
public class ListenableFutureUtilTest {

    private final ExecutorService exec;
    private final ListenableFuture<?> future;
    private final CountDownLatch latch;

    public ListenableFutureUtilTest(ListenableFuture<?> future) {
        this.exec = Executors.newCachedThreadPool();
        this.future = checkNotNull(future);
        this.latch = new CountDownLatch(1);
    }

    @Before
    public void setUp() {
        future.addListener(new Runnable() {
            @Override public void run() {
                latch.countDown();
            }
        }, exec);

        assertEquals(1, latch.getCount());
        assertFalse(future.isDone());
        assertFalse(future.isCancelled());
    }

    @After
    public void tearDown() {
        exec.shutdown();
    }



}