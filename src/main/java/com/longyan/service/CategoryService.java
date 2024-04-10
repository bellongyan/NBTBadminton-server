package com.longyan.service;

import com.longyan.mapper.CategoryMapper;
import com.longyan.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

public interface CategoryService {
    public void add(Category category);
}
