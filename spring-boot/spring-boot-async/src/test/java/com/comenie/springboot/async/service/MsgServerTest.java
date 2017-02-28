package com.comenie.springboot.async.service;

import com.comenie.springboot.async.Application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 波 on 2017/2/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class MsgServerTest {

    @Autowired
    private MsgServer msgServer;

    @Test
    public void testAsync() throws Exception {
        msgServer.sendA();
        msgServer.sendB();
        Thread.sleep(5000L);
    }
}