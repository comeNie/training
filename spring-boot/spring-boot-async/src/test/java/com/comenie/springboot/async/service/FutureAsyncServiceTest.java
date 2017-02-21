package com.comenie.springboot.async.service;

import com.comenie.springboot.async.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.Future;

/**
 * Created by 波 on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class FutureAsyncServiceTest {

    @Autowired
    private FutureAsyncService futureAsyncService;

    @Test
    public void testAsync() throws Exception {
        long startTime = System.currentTimeMillis();

        Future<String> task1 = futureAsyncService.sendA();
        Future<String> task2 = futureAsyncService.sendB();

        while(true) {
            if(task1.isDone() && task2.isDone() ) {
                break;
            }
        }

        long endTime = System.currentTimeMillis();
        System.out.println("总耗时：" + (endTime - startTime));

    }
}