package com.example.dreamshop.services.product;

import com.example.dreamshop.exceptions.ProductNotFoundException;
import com.example.dreamshop.model.Category;
import com.example.dreamshop.model.Product;
import com.example.dreamshop.repository.CategoryRepository;
import com.example.dreamshop.repository.ProductRepository;
import com.example.dreamshop.requests.AddProductRequest;
import com.example.dreamshop.requests.ProductUpdateRequest;
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
    public Product updateProductById(ProductUpdateRequest request, Long productId) {
        return productRepository.findById(productId)
                .map(existingProduct-> updateExistingProduct(existingProduct,request))
                .map(productRepository :: save)
                .orElseThrow(()-> new ProductNotFoundException("Product Not Found!"));

}

    public Product updateExistingProduct(Product existingProduct, ProductUpdateRequest request){
        existingProduct.setName(request.getName());
        existingProduct.setBrand(request.getBrand());
        existingProduct.setPrice(request.getPrice());
        existingProduct.setInventory(request.getInventory());
        existingProduct.setDescription(request.getDescription());

        Category category=categoryRepository.findByName(request.getCategory().getName());
        existingProduct.setCategory(category);
        return existingProduct;
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
    //error thrown else productobject will be undefined
    @Override
    public List<Product> getProductByCategory(String category) {
        System.out.println("CATEGORY RECEIVED = " + category);
        return productRepository.findByCategory_Name(category);
    }
    //we have not thrown error as returned list can be empty

    @Override
    public List<Product> getProductByBrand(String brand) {

        return productRepository.findByBrand(brand);
    }

    @Override
    public List<Product> getProductByCategoryAndBrand(String category, String brand) {

        return productRepository.findByCategory_NameAndBrand(category,brand);
    }

    @Override
    public List<Product> getProductByName(String name) {

        return productRepository.findByName(name);
    }

    @Override
    public List<Product> getProductByBrandAndName(String brand, String name) {

        return productRepository. findByBrandAndName(brand,name);
    }

    @Override
    public Long countProductsByBrandAndName(String brand, String name) {

        return productRepository.countByBrandAndName(brand,name);
    }
}
