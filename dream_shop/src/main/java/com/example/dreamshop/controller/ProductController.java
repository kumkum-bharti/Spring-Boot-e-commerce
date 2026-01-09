package com.example.dreamshop.controller;

import com.example.dreamshop.dto.productDto;
import com.example.dreamshop.exceptions.ResourceNotFoundException;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.requests.AddProductRequest;
import com.example.dreamshop.requests.ProductUpdateRequest;
import com.example.dreamshop.response.ApiResponse;
import com.example.dreamshop.services.product.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")

public class ProductController {
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
            productDto response = new productDto();
            response.setId(product.getId());
            response.setName(product.getName());
            response.setBrand(product.getBrand());
            response.setPrice(product.getPrice());
            response.setCategoryName(
                    product.getCategory().getName()
            );

            return ResponseEntity.ok(
                    new ApiResponse("Add product success", response)
            );
        } catch (Exception e) {
             return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @PostMapping("/products/{productId}/update")
    public ResponseEntity<ApiResponse> updateProduct(@RequestBody ProductUpdateRequest request,@PathVariable Long productId){
        try {
            Product theProduct=productService.updateProductById(request,productId);
            return ResponseEntity.ok(new  ApiResponse("Update product success",theProduct));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @DeleteMapping ("products/{productId}/delete")
    public ResponseEntity<ApiResponse> deleteProduct(@PathVariable Long productId){
        try {
            productService.deleteProductById(productId);
            return ResponseEntity.ok(new ApiResponse("Delete product success",null));
        }
        catch(ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/ products/by/Brand-and-name")
    public ResponseEntity<ApiResponse> getProductByBrandAndName(@RequestParam String brandName, @RequestParam String productName){
        try{
            List<Product> products=productService.getProductByBrandAndName(brandName,productName);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Product not found",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",products));
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/by/category-and-brand")
    public ResponseEntity<ApiResponse> getProductByCategoryAndBrand(@RequestParam String brand, @RequestParam String category){
        try{
            List<Product> products=productService.getProductByCategoryAndBrand(brand,category);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Product not found",null));
            }
            return ResponseEntity.ok(new ApiResponse("success",products));
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/{name}/products")
    public ResponseEntity<ApiResponse> getProductByName(@PathVariable String name){
        try{
            List<Product> products=productService.getProductByName(name);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Product not found",null));
            }

            return ResponseEntity.ok(new ApiResponse("success",products));
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/by-brand")
    public ResponseEntity<ApiResponse> findProductByBrand(@RequestParam String brand){
        try{
            List<Product> products=productService.getProductByBrand(brand);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Product not found",null));
            }

            return ResponseEntity.ok(new ApiResponse("success",products));
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("/products/{category}/all/products")
    public ResponseEntity<ApiResponse> getProductByCategory(@PathVariable String category){
        try{
            List<Product> products=productService.getProductByName(category);
            if(products.isEmpty()){
                return ResponseEntity.status(NOT_FOUND).body(new ApiResponse("Product not found",null));
            }

            return ResponseEntity.ok(new ApiResponse("success",products));
        }
        catch(Exception e){
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }
    }

    @GetMapping("products/count/")
    public ResponseEntity<ApiResponse> countProductsByBrandAndNames(@RequestParam String brand, @RequestParam String name){
        try {
            var productCount=productService.countProductsByBrandAndName(brand,name);
            return ResponseEntity.ok(new ApiResponse("success",productCount));
        } catch (Exception e) {
            return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(new ApiResponse(e.getMessage(),null));
        }

    }




}

