package com.demo;

import com.demo.controller.UserController;
import com.demo.service.UserService;
import com.demo.service.serviceImpl.UserServiceImpl;
import com.demo.user.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


public class DemoApplicationTests {
   @Autowired
   private UserService userService;
    @Test
    public void contextLoads() {
        User user = new User();
        user.setUsername("1");
        user.setPassword("1");
       User user1 = userService.login(user);
        System.out.println(user1);
    }

}
