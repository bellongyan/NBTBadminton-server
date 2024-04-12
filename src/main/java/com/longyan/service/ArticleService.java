package com.longyan.service;

import com.longyan.pojo.Article;
import com.longyan.pojo.PageBean;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId);

    Article getArticleById(Integer articleId);
}
