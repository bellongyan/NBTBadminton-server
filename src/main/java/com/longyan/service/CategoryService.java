package com.longyan.service;

import com.longyan.mapper.CategoryMapper;
import com.longyan.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CategoryService {
    void add(Category category);

    // 列表查询
    List<Category> list();

    Category findCategoryById(Integer categoryId);
}
