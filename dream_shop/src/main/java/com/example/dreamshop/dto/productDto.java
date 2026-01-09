package com.example.dreamshop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class productDto {
    private Long id;
    private String name;
    private String brand;
    private Double price;
    private String categoryName;

    public void setPrice(BigDecimal price) {
    }
}
