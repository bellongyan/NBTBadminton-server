package com.longyan.service;

import com.longyan.pojo.User;
import com.longyan.pojo.UserLogin;

import java.io.UnsupportedEncodingException;

public interface UserService {
    //    根据用户名查询用户
    UserLogin findByUserName(String username);

    //    注册
    void register(String username, String password);
}
