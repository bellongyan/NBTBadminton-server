package com.longyan.controller;

import com.longyan.pojo.Article;
import com.longyan.pojo.PageBean;
import com.longyan.pojo.Result;
import com.longyan.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController()
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

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
}

