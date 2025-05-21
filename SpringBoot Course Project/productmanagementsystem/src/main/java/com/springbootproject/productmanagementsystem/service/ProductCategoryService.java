package com.springbootproject.productmanagementsystem.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.springbootproject.productmanagementsystem.model.ProductCategory;

public interface ProductCategoryService {
    public ResponseEntity<List<ProductCategory>> getAllCategories();

    public ResponseEntity<ProductCategory> getCategory(Long id);

    public ResponseEntity<ProductCategory> createProductCategory(ProductCategory category);

    public ResponseEntity<ProductCategory> updateCategory(Long id, ProductCategory category);

    public ResponseEntity<ProductCategory> deleteCategory(Long id);
}
