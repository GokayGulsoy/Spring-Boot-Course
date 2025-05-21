package com.springbootproject.productmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.productmanagementsystem.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Long> {
    // we will add custom queries if needed
    Optional<ProductCategory> findByName(String name);
}
