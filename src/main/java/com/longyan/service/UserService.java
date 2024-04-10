package com.longyan.service;

import com.longyan.pojo.User;

public interface UserService {
    //    根据用户名查询用户
    User findByUserName(String userid);

    //    注册
    void register(String username, String password, String nickname, Integer sex, String email);

    // 更新
    void update(User user);

    // 更新用户头像
    void updateAvatar(String avatarUrl);

    // 更新用户密码
    void updatePwd(String newPwd);
}
