package com.comenie.springboot.springApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by 波 on 2017/2/16.
 */
@Component
public class AfterApplicationRunner implements ApplicationRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(AfterApplicationRunner.class);
    @Override
    public void run(ApplicationArguments args) throws Exception {
        LOGGER.warn("after application run----------------------args:{}",args.getSourceArgs());
    }
}
