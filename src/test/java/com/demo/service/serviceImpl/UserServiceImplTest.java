package com.demo.service.serviceImpl;

import com.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceImplTest {
    @Autowired
    private UserService userService;
    @Test
    public void register() {
    }

    @Test
    public void findAll() {
        System.out.println(userService.findAll());
    }

    @Test
    public void login() {
    }

    @Test
    public void update() {
    }
}