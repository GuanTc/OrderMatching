package com.demo.service;

import com.demo.user.pojo.User;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
public interface UserService {

    void register(User user);

    List<User> findAll();
}
