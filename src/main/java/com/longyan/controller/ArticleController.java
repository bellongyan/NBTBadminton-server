package com.longyan.controller;

import com.longyan.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController()
@RequestMapping("/articles")
public class ArticleController {
    @GetMapping("/list")
    public Result<String> list() {
        return Result.success("所有文章数据");
    }
}

