package com.demo.controller;

import com.demo.service.ServiceImpl.UserServiceImpl;
import com.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Controller
@RequestMapping("/user")
public class UserController {
//    @Autowired
//    private UserServiceImpl userService;
//
//    @RequestMapping("/register")
//    public String register(User user){
//        userService.register(user);
//        return "index";
//    }
//    @RequestMapping("/toAdd")
//    public String toAdd(){
//        return "add";
//    }
//
//    @RequestMapping("/findAll")
//    @ResponseBody
//    public List<User> findAll(){
//      return userService.findAll();
//    }
//
//    @RequestMapping("/login")
//    public String login(User user){
//        user = userService.login(user);
//        if(user == null){
//            return "";
//        }else{
//            return  "";
//        }
//    }

}
