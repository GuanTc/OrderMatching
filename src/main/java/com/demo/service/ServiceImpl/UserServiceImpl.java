package com.demo.service.ServiceImpl;

import com.demo.service.UserService;
import com.demo.user.mapper.UserMapper;

import com.demo.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: WANGSHUAIYI
 * @date : 2019/8/12
 * @description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.finAll();
    }
}
