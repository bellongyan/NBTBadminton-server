package com.longyan.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.longyan.mapper.ArticleMapper;
import com.longyan.pojo.Article;
import com.longyan.pojo.PageBean;
import com.longyan.service.ArticleService;
import com.longyan.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {


    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public void add(Article article) {
        article.setCreateTime(LocalDateTime.now());

        Map<String, Object> map = ThreadLocalUtil.get();
        String authorId = (String) map.get("username");
        article.setAuthorId(authorId);
        articleMapper.add(article);
    }

    @Override
    public PageBean<Article> list(Integer pageNum, Integer pageSize, String categoryId) {
        PageBean<Article> pb = new PageBean<>();

        PageHelper.startPage(pageNum, pageSize);

        List<Article> as = articleMapper.list(categoryId);
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> listLike(Integer pageNum, Integer pageSize, String userid) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.listLike(userid);
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> listCollect(Integer pageNum, Integer pageSize, String userid) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.listCollect(userid);
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }


    @Override
    public Article getArticleById(Integer articleId) {
        Article article = articleMapper.getArticleById(articleId);
        return article;
    }

    @Override
    public PageBean<Article> get24HoursHotArticles(Integer pageNum, Integer pageSize) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.get24HoursHotArticles();
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> get7DaysHotArticles(Integer pageNum, Integer pageSize) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.get7DaysHotArticles();
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> get1MonthHotArticles(Integer pageNum, Integer pageSize) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.get1MonthHotArticles();
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> getHotArticles(Integer pageNum, Integer pageSize) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.getHotArticles();
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Override
    public PageBean<Article> getArticlesByUserid(Integer pageNum, Integer pageSize, String userid) {
        PageBean<Article> pb = new PageBean<>();
        PageHelper.startPage(pageNum, pageSize);
        List<Article> as = articleMapper.getArticlesByUserid(userid);
        Page<Article> p = (Page<Article>) as;

        pb.setTotal(p.getTotal());
        pb.setItems(p.getResult());
        return pb;
    }

    @Transactional
    @Override
    public void deleteArticle(Integer articleId, String userId) {
        articleMapper.deleteArticleLikes(articleId);
        articleMapper.deleteArticleCollections(articleId);
        articleMapper.deleteArticleComments(articleId);
        articleMapper.deleteArticle(articleId, userId);
    }
}
