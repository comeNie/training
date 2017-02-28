package com.comenie.springboot.springApplication.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by 波 on 2017/2/16.
 */
public class ApplicationEnvironmentPreparedListener implements ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationEnvironmentPreparedListener.class);
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        LOGGER.warn("ApplicationEnvironmentPreparedListener-----------------------------");
    }
}
