package com.comenie.pattern.other.asyncMethodInvocation;

import java.util.Optional;


/**
 * Created by 波 on 2017/2/9.
 */
public interface AsyncCallback<T> {

    /**
     * Complete handler which is executed when async task is completed or fails execution.
     *
     * @param value the evaluated value from async task, undefined when execution fails
     * @param ex empty value if execution succeeds, some exception if executions fails
     */
    void onComplete(T value, Optional<Exception> ex);
}
