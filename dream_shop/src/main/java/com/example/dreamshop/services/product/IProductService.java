package com.example.dreamshop.services.product;

import com.example.dreamshop.model.Product;
import com.example.dreamshop.requests.AddProductRequest;

import java.util.List;

public interface IProductService {
    Product addProduct (AddProductRequest product);

    void deleteProductById(Long id);
    void updateProductById(Long id);

    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category,String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductByBrandAndNAme(String brand,String name);

    Long countProductsByBrandAndName(String brand,String name);





}