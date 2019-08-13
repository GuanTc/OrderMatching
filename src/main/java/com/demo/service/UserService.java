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
     * 查找全部
     * @return
     */
    List<User> findAll();
}
