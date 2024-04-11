package com.longyan.pojo;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

@Data
public class Article {
    private Integer articleId;
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String articleTitle;
    @NotEmpty
    private String content;
    @NotEmpty
    @URL
    private String coverImg;
    @NotNull
    private Integer categoryId;
    private String authorId;
    private LocalDateTime createTime;
}
