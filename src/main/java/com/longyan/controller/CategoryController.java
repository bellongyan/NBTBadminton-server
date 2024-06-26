package com.longyan.controller;

import com.longyan.pojo.Category;
import com.longyan.pojo.Result;
import com.longyan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public Result add(@RequestBody @Validated Category category) {
        categoryService.add(category);
        return Result.success();
    }


    @GetMapping
    public Result<List<Category>> list() {
        List<Category> cs = categoryService.list();
        return Result.success(cs);
    }
}
