package com.comenie.springcloud.eureka.feign.controller;

import com.comenie.springcloud.eureka.entity.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 波 on 2017/2/24.
 */
@RestController
public class FeignConsumerController {

    @Autowired
    private FeignControllerClient feignControllerClient;

    @RequestMapping(value = "/feign/user/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable Long id) {
        return feignControllerClient.findById(id);
    }
}
