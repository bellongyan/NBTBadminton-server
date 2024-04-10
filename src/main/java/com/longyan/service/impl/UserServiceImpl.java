package com.longyan.service.impl;

import com.longyan.mapper.UserMapper;
import com.longyan.pojo.User;
import com.longyan.service.UserService;
import com.longyan.utils.Md5Util;
import com.longyan.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User findByUserName(String userid) {
        User user = userMapper.findByUserName(userid);
        return user;
    }

    @Override
    public void register(String userid, String password, String nickname, Integer sex, String email) {
        String md5Password = Md5Util.getMD5String(password);
        userMapper.addUserPwd(userid, md5Password, nickname, sex, email);
    }

    @Override
    public void update(User user) {
        userMapper.update(user);
    }

    @Override
    public void updateAvatar(String avatarUrl) {
        Map<String, Object> map = ThreadLocalUtil.get();
        String userid = (String) map.get("username") ;
        userMapper.updateAvatar(avatarUrl, userid);
    }
}
