package com.longyan.controller;

import com.longyan.pojo.*;
import com.longyan.service.ArticleService;
import com.longyan.service.CategoryService;
import com.longyan.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
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

    @GetMapping("/like")
    public Result<PageBean<Article>> listLike(Integer pageNum,
                                              Integer pageSize,
                                              String userid) {
        PageBean<Article> pb = articleService.listLike(pageNum, pageSize, userid);

        return Result.success(pb);
    }

    @GetMapping("/collect")
    public Result<PageBean<Article>> listCollect(Integer pageNum,
                                              Integer pageSize,
                                              String userid) {
        PageBean<Article> pb = articleService.listCollect(pageNum, pageSize, userid);

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

    @GetMapping("/hot/{hotTag}")
    public Result<PageBean<Article>> getHotArticles(@PathVariable String hotTag, Integer pageNum, Integer pageSize) {
        if (hotTag.equals("all")) {
            PageBean<Article> pb = articleService.getHotArticles(pageNum, pageSize);
            return Result.success(pb);
        } else if (hotTag.equals("1")) {
            PageBean<Article> pb = articleService.get1MonthHotArticles(pageNum, pageSize);
            return Result.success(pb);
        } else if (hotTag.equals("7")) {
            PageBean<Article> pb = articleService.get7DaysHotArticles(pageNum, pageSize);
            return Result.success(pb);
        } else if (hotTag.equals("24")) {
            PageBean<Article> pb = articleService.get24HoursHotArticles(pageNum, pageSize);
            return Result.success(pb);
        }
        return Result.error("没有获取到数据");
    }

    @GetMapping("/user/{userid}")
    public Result<PageBean<Article>> getArticlesByUserid(Integer pageNum,
                                                         Integer pageSize,
                                                         @PathVariable String userid) {
        PageBean<Article> pb = articleService.getArticlesByUserid(pageNum, pageSize, userid);
        return Result.success(pb);
    }

    @DeleteMapping()
    public Result deleteArticle(Integer articleId, String userId) {
        articleService.deleteArticle(articleId, userId);

        return Result.success("成功删除");
    }
}

