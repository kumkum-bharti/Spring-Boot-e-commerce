package com.example.dreamshop.services.category;

import com.example.dreamshop.model.Category;

import java.util.List;

public interface ICategoryService {
    Category getCategoryById(Long id);
    Category getCategoryByName(String name);
    List<Category> getAllCategories();
    Category addCategory(Category categroy);

    Category updateCategory(Category category, Long id);

    void deleteCategoryById(Long id);
}
