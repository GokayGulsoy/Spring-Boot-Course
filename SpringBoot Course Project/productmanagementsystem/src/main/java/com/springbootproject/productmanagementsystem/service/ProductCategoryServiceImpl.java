package com.springbootproject.productmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.productmanagementsystem.exception.CategoryAlreadyExistsException;
import com.springbootproject.productmanagementsystem.exception.CategoryDoesNotExistException;
import com.springbootproject.productmanagementsystem.model.ProductCategory;
import com.springbootproject.productmanagementsystem.repository.ProductCategoryRepository;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<ProductCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryRepository.findAll());
    }

    @Override
    public ResponseEntity<ProductCategory> getCategory(Long id) throws CategoryDoesNotExistException {
        Optional<ProductCategory> category = categoryRepository.findById(id);

        if (categoryRepository.findById(id).isEmpty()) {
            throw new CategoryDoesNotExistException("Category with id " + id + " does not exist !!");
        }

        return ResponseEntity.ok(category.get());
    }

    @Override
    public ResponseEntity<ProductCategory> createProductCategory(ProductCategory category)
            throws CategoryAlreadyExistsException {
        Optional<ProductCategory> existingCategory = categoryRepository.findByName(category.getName());

        if (existingCategory.isPresent()) {
            throw new CategoryAlreadyExistsException(
                    "Category with name: " + category.getName() + " already exists !!");
        }

        ProductCategory createdCategory = categoryRepository.save(category);

        return ResponseEntity.ok(createdCategory);
    }

    @Override
    public ResponseEntity<ProductCategory> updateCategory(Long id, ProductCategory category) {
        Optional<ProductCategory> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isEmpty()) {
            throw new CategoryDoesNotExistException("Category to be updated with id " + id + " does not exist !!");
        }

        ProductCategory updatedCategory = existingCategory.get();
        updatedCategory.setName(category.getName());
        updatedCategory = categoryRepository.save(updatedCategory);

        return ResponseEntity.ok(updatedCategory);
    }

    @Override
    public ResponseEntity<ProductCategory> deleteCategory(Long id) {
        Optional<ProductCategory> existingCategory = categoryRepository.findById(id);

        if (existingCategory.isEmpty()) {
            throw new CategoryDoesNotExistException("Category to be deleted with id " + id + " does not exist !!");
        }

        ProductCategory deletedCategory = existingCategory.get();
        categoryRepository.delete(deletedCategory);

        return ResponseEntity.ok(deletedCategory);
    }

}
