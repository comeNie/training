package com.comenie.springboot.springApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 波 on 2017/2/16.
 */
@Component
public class AfterCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(AfterCommandLineRunner.class);
    @Override
    public void run(String... args) throws Exception {
        LOGGER.warn("after run------------------------- args:{}",args);
    }
}
