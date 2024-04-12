package com.longyan.controller;

import com.longyan.pojo.*;
import com.longyan.service.ArticleService;
import com.longyan.service.CategoryService;
import com.longyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.cache.CacheStatistics;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/add")
    public Result add(@RequestBody @Validated Article article) {
        articleService.add(article);
        return Result.success();
    }

    @GetMapping
    public Result<PageBean<Article>> list(Integer pageNum,
                                          Integer pageSize,
                                          @RequestParam(required = false) String categoryId) {
        PageBean<Article> pb = articleService.list(pageNum, pageSize, categoryId);

        return Result.success(pb);
    }

    @GetMapping("/{articleId}")
    public Result<ArticleDetailInfo> getArticleById(@PathVariable Integer articleId) {
        Article article = articleService.getArticleById(articleId);

        String userId = article.getAuthorId();
        Integer categoryId = article.getCategoryId();

        User user = userService.findByUserName(userId);
        Category category = categoryService.findCategoryById(categoryId);

        ArticleDetailInfo articleDetailInfo = new ArticleDetailInfo();
        articleDetailInfo.setArticle(article);
        articleDetailInfo.setCategory(category);
        articleDetailInfo.setUser(user);


        return Result.success(articleDetailInfo);
    }
}

