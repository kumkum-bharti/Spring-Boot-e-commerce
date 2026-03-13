package com.example.dreamshop.requests;

import com.example.dreamshop.model.Category;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductUpdateRequest {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory; //quantity
    private String description ;
    private Category category;
}
