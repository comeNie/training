package com.comenie.pattern.other.callback;

/**
 * Created by 波 on 2017/2/9.
 */
public  abstract  class Task {

    public final void executeWith(Callback callback) {
        execute();
        if (callback != null) {
            callback.call();
        }
    }

    public abstract void execute();
}
