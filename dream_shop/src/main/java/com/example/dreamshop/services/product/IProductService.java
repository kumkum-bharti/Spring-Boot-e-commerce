package com.example.dreamshop.services.product;

import com.example.dreamshop.dto.ProductDto;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.requests.AddProductRequest;
import com.example.dreamshop.requests.ProductUpdateRequest;

import java.util.List;

public interface IProductService {
    Product addProduct (AddProductRequest product);

    void deleteProductById(Long id);

    Product updateProductById(ProductUpdateRequest request, Long productId);

    List<Product> getAllProducts();
    Product getProductById(Long id);
    List<Product> getProductByCategory(String category);
    List<Product> getProductByBrand(String brand);
    List<Product> getProductByCategoryAndBrand(String category,String brand);
    List<Product> getProductByName(String name);
    List<Product> getProductByBrandAndName(String brand,String name);

    Long countProductsByBrandAndName(String brand,String name);

    ProductDto convertToDto(Product product);
}