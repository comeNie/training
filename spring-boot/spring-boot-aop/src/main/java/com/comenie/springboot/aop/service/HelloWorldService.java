package com.comenie.springboot.aop.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * Created by 波 on 2017/2/16.
 */
@Service
public class HelloWorldService {

    @Value("${name}")
    private  String name;

    public  String getMessage(){
        return  "hello " + name;
    }

    public  String getMessage(String message){
        return message + name;
    }

    public String getValue(String value,String message){
        return  value + name;
    }
}
