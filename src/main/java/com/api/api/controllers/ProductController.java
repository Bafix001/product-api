package com.api.api.controllers;

import com.api.api.models.Product;
import com.api.api.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id,@RequestBody Product product){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deletedProductById(@PathVariable Long id){
        return productService.deletedProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductById(@PathVariable Long id, @RequestBody Product product){
        return productService.updateProductById(id, product);
    }

}
