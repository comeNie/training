package com.comenie.pattern.other.callback;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/9.
 */
public class TaskImplTest {

    @Test
    public void testCallBack() {
        Task task = new TaskImpl();
        Callback callback = new Callback() {
            @Override
            public void call() {
                System.out.println("I'm done now.");
            }
        };
        task.executeWith(callback);
    }
}