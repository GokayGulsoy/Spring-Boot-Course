package com.project2.springjpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.springjpa.model.Product;
import com.project2.springjpa.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("springmvc/{id}")
    public String getProductById(@PathVariable int id) {
        return service.getProductById(id);
    }
    
    @PatchMapping("springmvc/{id}/{price}") 
    public String updateProductById(@PathVariable int id, @PathVariable double price) {
        return service.updateProductById(id, price);
    }

    @DeleteMapping("springmvc/{id}")
    public String deleteProductById(@PathVariable int id) {
        return service.deleteProductById(id);
    }

    @PostMapping("springmvc")
    public String createProduct(@Validated @RequestBody Product product) {
        return service.createProduct(product);
    } 


}
