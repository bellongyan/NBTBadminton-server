package com.longyan.mapper;

import com.longyan.pojo.Article;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article ( article_title, content, cover_img, category_id, author_id, create_time )" +
            "values (#{articleTitle}, #{content}, #{coverImg}, #{categoryId}, #{authorId}, #{createTime});")
    void add(Article article);
}
