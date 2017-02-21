package com.comenie.springboot.async.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

/**
 * Created by 波 on 2017/2/21.
 */
@Service
public class FutureAsyncService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MsgServer.class);

    @Async
    public Future<String> sendA() throws Exception{
        LOGGER.warn("send A start.......");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        Long endTime = System.currentTimeMillis();
        LOGGER.warn("send A 耗时：" + (endTime - startTime));
        return  new AsyncResult<String>("success");
    }

    @Async
    public Future<String> sendB() throws Exception {
        LOGGER.warn("send B start.......");
        Long startTime = System.currentTimeMillis();
        Thread.sleep(2000);
        Long endTime = System.currentTimeMillis();
        LOGGER.warn("send B 耗时：" + (endTime - startTime));
        return  new AsyncResult<String>("success");
    }
}
