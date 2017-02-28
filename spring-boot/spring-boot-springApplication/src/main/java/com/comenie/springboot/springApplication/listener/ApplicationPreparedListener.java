package com.comenie.springboot.springApplication.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationListener;

/**
 * Created by 波 on 2017/2/16.
 */
public class ApplicationPreparedListener implements ApplicationListener<ApplicationPreparedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationPreparedListener.class);

    @Override
    public void onApplicationEvent(ApplicationPreparedEvent event) {
        LOGGER.warn("ApplicationPreparedListener-----------------------");
    }
}
