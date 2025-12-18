package com.example.dreamshop.services.product;

import com.example.dreamshop.model.Product;

import java.util.List;

public class ProductService implements IProductService {
    @Override
    public Product addProduct(Product product) {
        return null;
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void updateProductById(Long id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public List<Product> getProductById(Long id) {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrand(String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {
        return List.of();
    }

    @Override
    public List<Product> getProductByName(String name) {
        return List.of();
    }

    @Override
    public List<Product> getProductByBrandAndNAme(String brand, String name) {
        return List.of();
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {
        return 0L;
    }
}
