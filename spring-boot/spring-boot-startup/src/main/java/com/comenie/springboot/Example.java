package com.comenie.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 波 on 2017/2/14.
 */
@RestController
@EnableAutoConfiguration
public class Example {

    @RequestMapping("/")
    public String home(){
        return  "comenie";
    }
    public static void main(String[] args) {
        SpringApplication.run(Example.class,args);
    }
}
