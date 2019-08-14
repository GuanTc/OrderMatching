package com.demo.service.serviceImpl;

import com.demo.service.UserService;
import com.demo.user.mapper.UserMapper;
import com.demo.user.pojo.User;
import com.demo.user.pojo.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public int register(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user != null){
            if(!"".equals(user.getUsername())){
                criteria.andUsernameEqualTo(user.getUsername());
            }
        }
        List<User> users = userMapper.selectByExample(example);
        if(users == null || users.size()==0){
            return  userMapper.insert(user);
        }
        return 0;
    }

    @Override
    public List<User> findAll() {
        return userMapper.finAll();
    }

    @Override
    public User login(User user) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(user != null){
            if(!"".equals(user.getUsername())){
                criteria.andUsernameEqualTo(user.getUsername());
            }
            if(!"".equals(user.getPassword())){
                criteria.andPasswordEqualTo(user.getPassword());
            }
        }
        List<User> result = userMapper.selectByExample(example);
        if(result==null||result.size()==0){
            return null;
        }
        return result.get(0);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKey(user);
    }
}
