package com.comenie.springcloud.eureka.ribbon.controller;

import com.comenie.springcloud.eureka.entity.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by 波 on 2017/2/24.
 */
@RestController
public class RibbonConsumerController {
        private static final Logger LOGGER = LoggerFactory.getLogger(RibbonConsumerController.class);
        @Autowired
        private RestTemplate restTemplate;
        @Autowired
        private LoadBalancerClient loadBalancerClient;

        @GetMapping("/ribbon/user/{id}")
        public User findById(@PathVariable Long id) {
                return this.restTemplate.getForObject("http://user-service/" + id, User.class);
        }

        @GetMapping("/ribbon/log-user-instance")
        public void logUserInstance() {
                ServiceInstance serviceInstance = this.loadBalancerClient.choose("user-service");
                // 打印当前选择的是哪个节点
                RibbonConsumerController.LOGGER.info("{}:{}:{}", serviceInstance.getServiceId(), serviceInstance.getHost(), serviceInstance.getPort());
        }

}
