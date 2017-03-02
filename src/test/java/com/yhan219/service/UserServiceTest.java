package com.yhan219.service;

import com.yhan219.domain.User;
import com.yhan219.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yhan219 on 2017/2/12.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userReposirory;

    @Test
    public void findByName(){
        User user = userReposirory.getUserByUsername("123");
        Assert.assertEquals(user.getPhone(),"123");
    }

    @Test
    public void getAuth(){
    }

}
