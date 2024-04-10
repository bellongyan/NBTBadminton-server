package com.longyan.mapper;

import com.longyan.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CategoryMapper {
    @Insert("insert into category (id, category_name) values (#{id}, #{categoryName});")
    void add(Category category);
}
