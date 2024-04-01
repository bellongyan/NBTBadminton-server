package com.longyan.mapper;

import com.longyan.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //    根据用户名查询用户
    @Select("select * from user where userid=#{userid};")
    User findByUserName(String userid);

    //    添加用户信息
    @Insert("insert into user (userid, password, nickname, sex, email, userPic, isBan) values (#{userid}, #{password}, #{nickname}, #{sex}, #{email}, null,0);")
    void addUserPwd(String userid, String password, String nickname, Integer sex, String email);
}
