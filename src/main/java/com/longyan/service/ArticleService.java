package com.longyan.service;

import com.longyan.pojo.Article;
import com.longyan.pojo.PageBean;

import java.util.List;

public interface ArticleService {
    void add(Article article);

    PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId);
    PageBean<Article> listLike(Integer pageNum, Integer pageSize, String userid);
    PageBean<Article> listCollect(Integer pageNum, Integer pageSize, String userid);

    Article getArticleById(Integer articleId);

    PageBean<Article> get24HoursHotArticles(Integer pageNum, Integer pageSize);

    PageBean<Article> get7DaysHotArticles(Integer pageNum, Integer pageSize);

    PageBean<Article> get1MonthHotArticles(Integer pageNum, Integer pageSize);

    PageBean<Article> getHotArticles(Integer pageNum, Integer pageSize);

    PageBean<Article> getArticlesByUserid(Integer pageNum, Integer pageSize, String userid);

    void deleteArticle(Integer articleId, String userId);
}
