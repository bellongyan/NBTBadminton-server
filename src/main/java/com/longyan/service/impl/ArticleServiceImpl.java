package com.longyan.service.impl;

import com.longyan.mapper.ArticleMapper;
import com.longyan.pojo.Article;
import com.longyan.service.ArticleService;
import com.longyan.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}
