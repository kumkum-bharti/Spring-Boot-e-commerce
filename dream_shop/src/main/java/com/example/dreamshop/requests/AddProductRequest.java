package com.example.dreamshop.requests;

import com.example.dreamshop.model.Category;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.math.BigDecimal;

//created as we cannot manipulate real model directly
@Data
// to get getter and setter, we do not use this in real model not recommended
public class AddProductRequest {
    private long id;
    private String name;
    private String brand;
    private BigDecimal price;
    private int inventory; //quantity
    private String description ;
    private Category category;

}
