package com.comenie.springcloud.eureka.feign.controller;

import com.comenie.springcloud.eureka.entity.User;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by 波 on 2017/2/24.
 */
@FeignClient(name = "user-service")
public interface FeignControllerClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);
}
