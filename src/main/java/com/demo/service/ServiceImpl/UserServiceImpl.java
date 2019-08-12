package com.demo.service.ServiceImpl;

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
    public void register(User user) {
        userMapper.insert(user);
    }

    @Override
    public List<User> findAll() {
        return userMapper.finAll();
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        userMapper.updateByPrimaryKey(user);
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
        if(result == null || result.size()==0){
            return null;
        }
        return result.get(0);
    }
}
