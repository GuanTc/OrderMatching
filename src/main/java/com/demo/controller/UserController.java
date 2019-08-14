
package com.demo.controller;

import com.demo.common.ResultMap;
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
    @ResponseBody
    public ResultMap register(User user){
        ResultMap map = new ResultMap();
       try {
           userService.register(user);
           map.Success();
           map.setMsg("注册成功");
       }catch (Exception e){
           map.Error();
           map.setMsg("网络异常");
       }
       return map;
    }

    /**
     * 查询全部
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    private ResultMap findAll(){
        ResultMap map = new  ResultMap();
        try {
             List<User> list = userService.findAll();
             map.Success();
             map.setData(list);
        }catch (Exception e){
            map.Error();
            map.setMsg("network anomaly");
        }
        return map;
    }

    /**
     * 登陆
     * @param user
     * @return
     */
    @RequestMapping("/login")
    @ResponseBody
    public ResultMap login(User user){
        user = userService.login(user);
        ResultMap map = new ResultMap();
        if(user == null){
            map.Error();
            map.setMsg("账号密码错误");
            return map;
        }else {
            map.Success();
            map.setMsg("登陆成功");
            return map;
        }
    }

    /**
     * 修改密码
     * @param user
     * @return
     */
    @RequestMapping("/update")
    @ResponseBody
    public ResultMap update(User user){
        ResultMap map = new ResultMap();
        try {
            System.out.println(user);
            userService.update(user);
            map.Success();
            map.setMsg("修改成功");
            return  map;
        }catch (Exception e){
            map.Error();
            map.setMsg("网络异常");
            return map;
        }
    }
    @RequestMapping("/toAdd")
    public  String toAdd(){
        return "index";
    }


}

