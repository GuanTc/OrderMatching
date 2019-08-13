
package com.demo.controller;

import com.demo.service.UserService;
import com.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @RequestMapping("/register")
    public String register(User user,Model model){
        int result = userService.register(user);
        if(result==0){
            model.addAttribute("msg","username不可用");
            return "add";
        }else {
            return "login";
        }
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    private List<User> findAll(){
        return userService.findAll();
    }

    /**
     * 登陆
     * @param user
     * @param model
     * @return
     */
    @RequestMapping("/login")
    public String login(User user,Model model){
        user = userService.login(user);
        if(user == null){
            model.addAttribute("msg","账号密码错误");
            return "login";
        }else {
            return "index";
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping("/update")
    public String update(User user){
        try {
            System.out.println(user);
            userService.update(user);
            return "login";
        }catch (Exception e){
            return "index";
        }
    }
    @RequestMapping("/toAdd")
    public  String toAdd(){
        return "add";
    }


}

