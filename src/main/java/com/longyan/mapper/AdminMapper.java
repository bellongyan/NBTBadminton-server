package com.longyan.mapper;

import com.longyan.pojo.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AdminMapper {
    @Select("select * from admin where admin_id=#{adminId};")
    Admin findByAdminId(String adminId);
}
