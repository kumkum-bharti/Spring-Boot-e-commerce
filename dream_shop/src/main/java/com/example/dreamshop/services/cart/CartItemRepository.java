package com.example.dreamshop.services.cart;

import com.example.dreamshop.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

interface CartItemRepository extends JpaRepository<CartItem, Long> {
    void deleteAllBycartId(Long id);
}
