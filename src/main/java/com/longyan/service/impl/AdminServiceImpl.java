package com.longyan.service.impl;

import com.longyan.mapper.AdminMapper;
import com.longyan.pojo.Admin;
import com.longyan.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin findByAdminId(String adminId) {
        Admin admin = adminMapper.findByAdminId(adminId);
        return admin;
    }
}
