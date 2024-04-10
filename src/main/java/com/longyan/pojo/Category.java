package com.longyan.pojo;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Category {
    private Integer id;
    @NotEmpty
    private String categoryName;
}
