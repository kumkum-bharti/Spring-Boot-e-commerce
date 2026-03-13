package com.example.dreamshop.services.cart;

import com.example.dreamshop.exceptions.ResourceNotFoundException;
import com.example.dreamshop.model.Cart;
import com.example.dreamshop.model.CartItem;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.repository.CartRepository;
import com.example.dreamshop.repository.CategoryRepository;
import com.example.dreamshop.services.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CartItemService implements ICartItemService{
    private final ICartItemService cartItemService;
    private final CartService cartService;
    private final ProductService productService;
    private final CartRepository cartRepository;
    private final CategoryRepository.CartItemRepository cartItemRepository;

    @Override
    public void addItemToCart(Long cartId, Long productId, int quantity) {
        Cart cart=cartService.getCart(cartId);
        Product product=productService.getProductById(productId);
        CartItem cartItem=getCartItem(cartId,productId);;

        if(cartItem.getId() == null){
            cartItem.setQuantity(quantity);
            cartItem.setCart(cart);
            cartItem.setProduct(product);
            cartItem.setUnitPrice(product.getPrice());
        }
        else{
            cartItem.setQuantity(cartItem.getQuantity()+quantity);
        }
        cartItem.setTotalPrice();
        cart.addItem(cartItem);
        cartItemRepository.save(cartItem);
        cartRepository.save(cart);

    }

    @Override
    public void removeItemFromCart(Long cartId, Long productId) {
        Cart cart=cartService.getCart(cartId);
        CartItem cartItem=getCartItem(cartId,productId);

        cart.removeItem(cartItem);
        cartRepository.save(cart);
    }

    @Override
    public void updateItemQuantity(Long cartId, Long productId, int quantity) {
        Cart cart=cartService.getCart(cartId);
        cart.getItems().
                    stream().filter(item ->
                    item.getProduct().getId()==productId).
                    findFirst().
                    ifPresent(item-> {
                        item.setQuantity(quantity);
                        item.setUnitPrice(item.getProduct().getPrice());
                        item.setTotalPrice();
                        }
                    );

        BigDecimal totalAmount=cart.getTotalAmount();
        cart.updateTotalAmount();
        cartRepository.save(cart);
    }

    @Override
    public CartItem getCartItem(Long cartId, Long productId){
        Cart cart=cartService.getCart(cartId);
        return cart.getItems().
                stream().filter(item ->
                item.getProduct().getId()==productId).
                findFirst().orElseThrow(
                ()-> new ResourceNotFoundException("CartItem not found"));

    }
}
