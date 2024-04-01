package com.longyan.pojo;

import lombok.Data;

@Data
public class Rank {
    private Integer id;
    private Integer rank;
    private String name;
    private String nameChinese;
    private String country;
    private String secondName;
    private String secondNameChinese;
    private String secondCountry;
    private Integer score;
    private Integer steps;
    private Integer attribute;
    private Integer type;
}
