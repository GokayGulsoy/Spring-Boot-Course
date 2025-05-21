package com.springbootproject.productmanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springbootproject.productmanagementsystem.model.Product;

public interface ProductService {
    public ResponseEntity<List<Product>> getAllProducts();

    public ResponseEntity<Product> getProduct(Long id);

    public ResponseEntity<Product> updateProduct(Long id, Product product, Long categoryId);

    public ResponseEntity<Product> createProduct(Long categoryId, Product product);

    public ResponseEntity<Product> deleteProduct(Long id);
}
