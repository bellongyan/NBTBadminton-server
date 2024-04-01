package com.longyan.pojo;

import lombok.Data;

@Data
public class Rank {
    Integer id;
    Integer rank;
    String name;
    String nameChinese;
    String country;
    String secondName;
    String secondNameChinese;
    String secondCountry;
    Integer score;
    Integer steps;
    Integer attribute;
    Integer type;
}
