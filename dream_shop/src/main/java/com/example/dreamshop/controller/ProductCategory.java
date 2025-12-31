package com.example.dreamshop.controller;

import com.example.dreamshop.exceptions.ResourceNotFoundException;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.requests.AddProductRequest;
import com.example.dreamshop.response.ApiResponse;
import com.example.dreamshop.services.category.CategoryService;
import com.example.dreamshop.services.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("{api.prefix}/products")

public class ProductCategory {
    private final IProductService productService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProducts(){
        try {
            List<Product> products=productService.getAllProducts();
            return ResponseEntity.ok(new ApiResponse("success",products));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/product/{id}/product")
    public ResponseEntity<ApiResponse> getProductById(@PathVariable Long id){
        try {
            Product theProduct=productService.getProductById(id);
            return ResponseEntity.ok(new ApiResponse("success",theProduct));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addProduct(@RequestBody AddProductRequest product){
        try {
            Product theProduct=productService.addProduct(product);
            return ResponseEntity.ok(new  ApiResponse("Add product success",theProduct));
        } catch (Exception e) {
             return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    



}
