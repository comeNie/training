package com.comenie.springboot.springApplication.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by 波 on 2017/2/16.
 */
public class ApplicationStartingListener implements ApplicationListener<ApplicationStartingEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationStartingListener.class);
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        LOGGER.warn("ApplicationStartingListener -----------------------------------------");
    }
}
