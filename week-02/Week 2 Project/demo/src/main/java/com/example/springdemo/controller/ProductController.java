package com.example.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.springdemo.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


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
        return service.updateProductById(id,price);
    }
    
    @DeleteMapping("springmvc/{id}")
    public String deleteProductById(@PathVariable int id) {
        return service.deleteProductById(id);
    }

    @PutMapping("springmvc/{id}/{name}/{price}")
    public String createProductById(@PathVariable int id, @PathVariable String name, @PathVariable double price) {
        return service.createProduct(id,name,price);
    }


}
