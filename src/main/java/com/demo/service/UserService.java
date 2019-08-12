package com.demo.service;

import com.demo.user.pojo.User;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface UserService {
    /**
     * 注册
     * @param user
     */
    void register(User user);

    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 更新密码
     * @param user
     */
    void updateUser(User user);

    /**
     * 登陆
     * @param user
     * @return
     */
    User login(User user);
}
