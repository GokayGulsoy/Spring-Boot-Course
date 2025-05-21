package com.springbootproject.productmanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springbootproject.productmanagementsystem.exception.CategoryDoesNotExistException;
import com.springbootproject.productmanagementsystem.exception.ProductAlreadyExistsException;
import com.springbootproject.productmanagementsystem.exception.ProductDoesNotExistException;
import com.springbootproject.productmanagementsystem.model.Product;
import com.springbootproject.productmanagementsystem.model.ProductCategory;
import com.springbootproject.productmanagementsystem.repository.ProductCategoryRepository;
import com.springbootproject.productmanagementsystem.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCategoryRepository categoryRepository;

    @Override
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @Override
    public ResponseEntity<Product> getProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException("Product with id: " + id + " does not exist !!"));

        return ResponseEntity.ok(product);
    }

    @Override
    public ResponseEntity<Product> updateProduct(Long id, Product product, Long categoryId) {
        Product updatedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException("Product with id " + id + " does not exist !!"));

        ProductCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryDoesNotExistException(
                        "Category with id " + categoryId + " does not exist !!"));

        updatedProduct.setName(product.getName());
        updatedProduct.setPrice(product.getPrice());
        updatedProduct.setProductCategory(category);

        updatedProduct = productRepository.save(updatedProduct);

        return ResponseEntity.ok(updatedProduct);
    }

    @Override
    public ResponseEntity<Product> createProduct(Long categoryId, Product product) {
        ProductCategory category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryDoesNotExistException(
                        "Category with id: " + categoryId + " for creating product does not exist !!"));

        Optional<Product> existingProduct = productRepository.findByName(product.getName());
        if (existingProduct.isPresent()) {
            throw new ProductAlreadyExistsException(
                    "Product to be created with name: " + product.getName() + " already exists !!");
        }

        product.setProductCategory(category);
        Product createdProduct = productRepository.save(product);

        return ResponseEntity.ok(createdProduct);
    }

    @Override
    public ResponseEntity<Product> deleteProduct(Long id) {
        Product deletedProduct = productRepository.findById(id)
                .orElseThrow(() -> new ProductDoesNotExistException(
                        "Product to be deleted with id: " + id + " does not exist !!"));

        productRepository.delete(deletedProduct);

        return ResponseEntity.ok(deletedProduct);
    }

}
