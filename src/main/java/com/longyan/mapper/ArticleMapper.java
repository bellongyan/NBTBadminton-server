package com.longyan.mapper;

import com.longyan.pojo.Article;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ArticleMapper {

    @Insert("insert into article ( article_title, content, cover_img, category_id, author_id, create_time )" +
            "values (#{articleTitle}, #{content}, #{coverImg}, #{categoryId}, #{authorId}, #{createTime});")
    void add(Article article);

    List<Article> list(String categoryId);

    List<Article> listLike(String userid);

    List<Article> listCollect(String userid);

    @Select("select * from article where article_id=#{articleId};")
    Article getArticleById(Integer articleId);

    List<Article> get24HoursHotArticles();

    List<Article> get7DaysHotArticles();

    List<Article> get1MonthHotArticles();

    List<Article> getHotArticles();

    List<Article> getArticlesByUserid(String userid);

    @Delete("delete from article_like where article_id=#{articleId};")
    void deleteArticleLikes(Integer articleId);

    @Delete("delete from `comment` where comment_article_id=#{articleId};")
    void deleteArticleComments(Integer articleId);

    @Delete("delete from article_collect where article_id=#{articleId};")
    void deleteArticleCollections(Integer articleId);

    @Delete("delete from article where article_id=#{articleId} and author_id=#{userId};")
    void deleteArticle(Integer articleId, String userId);

}