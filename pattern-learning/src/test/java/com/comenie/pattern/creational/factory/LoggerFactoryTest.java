package com.comenie.pattern.creational.factory;

import org.junit.Test;

/**
 * Created by 波 on 2017/2/4.
 */
public class LoggerFactoryTest {

    @Test
    public void testFactory() {
        LoggerFactory loggerFactory = new FileLoggerFactory();
        Logger logger = loggerFactory.createLogger();
        logger.writeLog();
    }
}