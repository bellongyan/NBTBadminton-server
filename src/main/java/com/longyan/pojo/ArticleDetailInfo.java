package com.longyan.pojo;

import lombok.Data;

@Data
public class ArticleDetailInfo {
    private Article article;
    private Category category;
    private User user;
}
