package com.longyan.mapper;

import com.longyan.pojo.User;
import com.longyan.pojo.UserLogin;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //    根据用户名查询用户
    @Select("select * from login_user where id=#{usernama};")
    UserLogin findByUserName(String username);

    //    添加用户信息
    @Insert("insert into login_user (id, password) values (#{username}, #{password});")
    void add(String username, String password);
}
