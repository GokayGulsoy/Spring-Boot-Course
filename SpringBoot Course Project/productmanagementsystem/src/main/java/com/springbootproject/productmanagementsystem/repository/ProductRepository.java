package com.springbootproject.productmanagementsystem.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springbootproject.productmanagementsystem.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // we will add custom queries if needed
    Optional<Product> findByName(String name);
}
