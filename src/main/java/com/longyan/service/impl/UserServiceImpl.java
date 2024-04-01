package com.longyan.service.impl;

import com.longyan.mapper.UserMapper;
import com.longyan.pojo.UserLogin;
import com.longyan.service.UserService;
import com.longyan.utils.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public UserLogin findByUserName(String username) {
        UserLogin user = userMapper.findByUserName(username);
        return user;
    }

    @Override
    public void register(String username, String password) {
        String md5Password = MD5Utils.MD5Lower(password);
        userMapper.add(username, md5Password);
    }
}
