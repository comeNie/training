package com.comenie.springboot.actuator.service;

import com.google.common.collect.Maps;

import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by 波 on 2017/2/20.
 */
@Service
public class UserService {

    private Map<String,Integer> users = Maps.newConcurrentMap();

    public  void addUser(String name, Integer age){
        users.put(name,age);
    }

    public  Integer getUser(String name){
        return  users.get(name);
    }
}
