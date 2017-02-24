package com.comenie.springcloud.eureka.controller;

import com.comenie.springcloud.eureka.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 波 on 2017/2/24.
 */
@RestController
public class SimpleConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return this.restTemplate.getForObject("http://localhost:8081/" + id, User.class);
    }

    @RequestMapping("/infos")
    public String info(){
        return "SimpleConsumerController";
    }
}
