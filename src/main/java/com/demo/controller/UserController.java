//package com.demo.controller;
//
//import com.demo.service.UserServiceImpl.UserSerciveImpl;
//import com.demo.user.pojo.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//
///**
// * @author: WANGSHUAIYI
// * @date : 2019/8/12
// * @description:
// */
//@Controller
//@RequestMapping("/user")
//public class UserController {
//    @Autowired
//    private UserSerciveImpl userSercive;
//    @RequestMapping("/register")
//    public String register(User user){
//        userSercive.register(user);
//        return "index";
//    }
//
//    @RequestMapping("/findAll")
//    @ResponseBody
//    private List<User> findAll(){
//        return userSercive.findAll();
//    }
//}
