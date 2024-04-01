package com.longyan.pojo;


import lombok.Data;

@Data
public class User {
    private String userid;
    private String nickname;
    private Integer sex;
    private String email;
    private Integer isBan;
}
