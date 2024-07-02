package com.longyan.controller;


import com.longyan.pojo.Admin;
import com.longyan.pojo.Result;
import com.longyan.service.AdminService;
import com.longyan.utils.JwtUtil;
import com.longyan.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/admin")
@Validated
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/login")
    public Result<String> login(@Pattern(regexp = "^\\S{5,16}$") String adminId, @Pattern(regexp = "^\\S{5,16}$") String password) {
        // 查询用户
        Admin admin = adminService.findByAdminId(adminId);

        if (admin == null) {
            return Result.error("用户名错误");
        }

        if (Md5Util.getMD5String(password).equals(admin.getPassword())) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", admin.getAdminId());
            String token = JwtUtil.genToken(claims);
            ValueOperations<String, String> operations = stringRedisTemplate.opsForValue();
            operations.set(token, token, 7, TimeUnit.DAYS);
            return Result.success(token);
        }

        return Result.error("密码错误");
    }
}
