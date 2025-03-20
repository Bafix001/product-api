package com.api.api.services;

import com.api.api.models.Product;
import com.api.api.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }


    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Désolé ! produit inexistant");
        }

        return optionalProduct.get();
    }

    public String deletedProductById(Long id) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Suppression impossible ! Produit inexistant");
        }

        productRepository.delete(optionalProduct.get());

        return "Produit supprimé avec succes";
    }

    public Product updateProductById(Long id, Product product) {
        Optional<Product> optionalProduct = productRepository.findById(id);

        if(optionalProduct.isEmpty()){
            throw new RuntimeException("Modification impossible ! Produit inexistant");
        }

        Product productAModifier = optionalProduct.get();

        productAModifier.setName(product.getName());
        productAModifier.setPrice(product.getPrice());

        return productRepository.save(productAModifier);

    }
}
