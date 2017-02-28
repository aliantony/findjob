package com.yhan219.service;

import com.yhan219.domain.User;
import com.yhan219.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by yhan219 on 2017/2/12.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userReposirory;

    public User getUserByUsername(String username){

        return userReposirory.getUserByUsername(username);
    }

}
