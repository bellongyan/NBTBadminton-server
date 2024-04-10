package com.longyan.pojo;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class User {
    @NotNull
    private String userid;
    @JsonIgnore
    private String password;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String nickname;
    private Integer sex;
    @NotEmpty
    @Email
    private String email;
    private String userPic;
    private Integer isBan;
}
