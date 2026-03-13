package com.example.dreamshop.repository;

import com.example.dreamshop.model.CartItem;
import com.example.dreamshop.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByName(String name);

    boolean existsByName(String name);

    interface CartItemRepository extends JpaRepository<CartItem, Long> {
        void deleteAllBycartId(Long id);
    }
}
