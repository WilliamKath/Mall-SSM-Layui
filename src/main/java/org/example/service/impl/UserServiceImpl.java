package org.example.service.impl;

import org.example.dao.UserMapper;
import org.example.entity.User;
import org.example.entity.UserDo;
import org.example.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    public UserMapper userMapper;
    
    @Override
    public User Login(String username, String password) {
        //调用根据用户名查询用户信息的方法
        User user = userMapper.findByUsername(username);
        if(user!=null){
            //比较密码是否一致
            if(user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return userMapper.addUser(user)>0;
    }

    @Override
    public boolean existUsername(String username) {
        return userMapper.existUsername(username);
    }
}
