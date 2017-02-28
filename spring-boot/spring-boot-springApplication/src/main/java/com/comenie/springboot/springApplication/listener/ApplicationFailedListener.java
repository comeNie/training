package com.comenie.springboot.springApplication.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by 波 on 2017/2/16.
 */
public class ApplicationFailedListener implements ApplicationListener<ApplicationFailedEvent>{

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationFailedListener.class);
    @Override
    public void onApplicationEvent(ApplicationFailedEvent event) {
        LOGGER.warn("ApplicationFailedListener --------------");
    }
}
