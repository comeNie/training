package com.comenie.springboot.profile.service;

import com.comenie.springboot.profile.entity.UserProterties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 波 on 2017/2/17.
 */
@Service
public class UserService {

    @Autowired
    private UserProterties userProterties;

    public String getUserProtertiesString(){
        return  userProterties.toString();
    }

}
