package com.comenie.pattern.other.asyncMethodInvocation;

import java.util.concurrent.ExecutionException;

/**
 * AysncResult  Interface
 *
 * Created by 波 on 2017/2/9.
 */
public interface AsyncResult<T> {

    /**
     * Status of the async task execution.
     *
     * @return <code>true</code> if execution is completed or failed
     */
    boolean isCompleted();

    /**
     * Gets the value of completed async task.
     *
     * @return evaluated value or throws ExecutionException if execution has failed
     * @throws ExecutionException if execution has failed, containing the root cause
     * @throws IllegalStateException if execution is not completed
     */
    T getValue() throws ExecutionException;

    /**
     * Blocks the current thread until the async task is completed.
     *
     * @throws InterruptedException if the execution is interrupted
     */
    void await() throws InterruptedException;
}
