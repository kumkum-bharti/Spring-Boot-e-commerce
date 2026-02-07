package com.example.dreamshop.dto;

import com.example.dreamshop.model.Category;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ProductDto {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory; //quantity
    private String description ;
    private String categoryName;


    private List<ImageDto> images;

    public void setCategoryName(String name) {
    }
}
