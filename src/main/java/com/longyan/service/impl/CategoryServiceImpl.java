package com.longyan.service.impl;

import com.longyan.mapper.CategoryMapper;
import com.longyan.pojo.Category;
import com.longyan.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public void add(Category category) {
        categoryMapper.add(category);
    }

    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public Category findCategoryById(Integer categoryId) {
        return categoryMapper.findCategoryById(categoryId);
    }
}
