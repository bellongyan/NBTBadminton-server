package com.longyan.controller;

import com.longyan.pojo.Result;
import com.longyan.pojo.User;
import com.longyan.service.UserService;
import com.longyan.utils.JwtUtil;
import com.longyan.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Result register(@Pattern(regexp = "^\\S{5,16}$") String userid, @Pattern(regexp = "^\\S{5,16}$") String password,
                           String nickname, Integer sex, String email) {
        // 查询用户
        User u = userService.findByUserName(userid);
        // 注册
        if (u == null) {
            userService.register(userid, password, nickname, sex, email);
            return Result.success();
        } else {
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String userid, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        User user = userService.findByUserName(userid);

        if (user == null) {
            return Result.error("用户名错误");
        }

        if (Md5Util.getMD5String(password).equals(user.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", user.getUserid());
            String token = JwtUtil.genToken(claims);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }
}
