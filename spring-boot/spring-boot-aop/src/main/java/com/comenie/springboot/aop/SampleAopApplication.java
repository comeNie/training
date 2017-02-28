package com.comenie.springboot.aop;

import com.comenie.springboot.aop.service.HelloWorldService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by 波 on 2017/2/16.
 */
@SpringBootApplication
public class SampleAopApplication implements CommandLineRunner {

    @Autowired
    public HelloWorldService helloWorldService;

    public static void main(String[] args) {
        SpringApplication.run(SampleAopApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloWorldService.getValue("hello world", "11"));
    }
}
