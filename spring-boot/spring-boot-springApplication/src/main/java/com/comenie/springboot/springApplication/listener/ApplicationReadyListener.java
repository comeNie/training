package com.comenie.springboot.springApplication.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by 波 on 2017/2/16.
 */
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationReadyListener.class);
    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        LOGGER.warn("ApplicationReadyListener--------------------------");
    }
}
