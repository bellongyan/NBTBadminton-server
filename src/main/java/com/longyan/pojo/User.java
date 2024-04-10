package com.longyan.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
public class User {
    private String userid;
    @JsonIgnore
    private String password;
    private String nickname;
    private Integer sex;
    private String email;
    private Integer isBan;
}
