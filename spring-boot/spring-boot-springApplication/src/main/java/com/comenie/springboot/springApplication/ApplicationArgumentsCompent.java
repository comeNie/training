package com.comenie.springboot.springApplication;

import com.google.gson.Gson;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

/**
 * Created by 波 on 2017/2/16.
 */
@Component
public class ApplicationArgumentsCompent {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationArgumentsCompent.class);

    private String[] args;

    @Autowired
    public ApplicationArgumentsCompent(ApplicationArguments arguments){
        args=arguments.getSourceArgs();
        LOGGER.warn("autowired args------------------args:{}", new Gson().toJson(arguments.getSourceArgs()));
    }

    public String[] getArgs() {
        return args;
    }
}
