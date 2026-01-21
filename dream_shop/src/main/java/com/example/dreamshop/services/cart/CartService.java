package com.example.dreamshop.services.cart;

import com.example.dreamshop.model.Cart;
import com.example.dreamshop.repository.CartRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@NoArgsConstructor
public class CartService implements ICartService {
    private final CartRepository cartRepository;
    @Override
    public Cart getCart(Long id){
        return null;
    }

    @Override
    public void clearCart(Long id){

    }

    @Override
    public BigDecimal getTotalPrice(Long id){
        return null;
    }
}
