package com.example.dreamshop.services.product;

import com.example.dreamshop.exceptions.ProductNotFoundException;
import com.example.dreamshop.model.Category;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.repository.CategoryRepository;
import com.example.dreamshop.repository.ProductRepository;
import com.example.dreamshop.requests.AddProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class ProductService implements IProductService {
    private final ProductRepository productRepository; // so as req annotation can get it and no one can change it later
    private final CategoryRepository categoryRepository;
    @Override

    public Product addProduct(AddProductRequest request) {
        Category category= Optional.ofNullable(categoryRepository.findByName(request.getCategory().getName()))
                .orElseGet(()->{
                        Category newCategory=new Category(request.getCategory().getName());
                        return categoryRepository.save(newCategory);
                        });
        request.setCategory(category);
        return productRepository.save(createProduct(request,category));
    }

    private Product createProduct(AddProductRequest request, Category category){
        return new Product(
                request.getName(), //pull this below and copy using ctrl+d
                request.getBrand(),
                request.getPrice(),
                request.getInventory(),
                request.getDescription(),
                category
        );
    }

    @Override
    public void deleteProductById(Long id) {
         productRepository.findById(id)
                 .ifPresentOrElse(productRepository :: delete,
                         ()->{ throw new ProductNotFoundException("Product not found!");
                 });
    }

    @Override
    public void updateProductById(Long id) {

    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new ProductNotFoundException("Product not found!"));
    }

    @Override
    public List<Product> getProductByCategory(String category) {

        return productRepository.findByCategoryName(category);
    }

    @Override
    public List<Product> getProductByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {

        return productRepository.findByCategoryNameAndBrand(category,brand);
    }

    @Override
    public List<Product> getProductByName(String name) {

        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductByBrandAndNAme(String brand, String name) {

        return productRepository. findByBrandAndName(brand,name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {

        return productRepository.countByBrandAndName(brand,name);
    }
}
