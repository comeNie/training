package com.comenie.springboot.actuator.controller;

import com.comenie.springboot.actuator.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 波 on 2017/2/20.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/{name}/{age}")
    public  String addUser(@PathVariable String name, @PathVariable int age){
        userService.addUser(name,age);
        return "success";
    }

    @RequestMapping("/{name}")
    public  Integer getUser(@PathVariable String name){
        return  userService.getUser(name);
    }
}
