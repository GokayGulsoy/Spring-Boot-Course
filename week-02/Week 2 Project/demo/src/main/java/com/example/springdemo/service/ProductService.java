package com.example.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springdemo.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(@Autowired ProductRepository repository) {
        this.repository = repository;
    }

    public String getProductById(int id) {
        if (id < 0) {
            return "invalid id is provided!!";
        }

        return repository.findProductById(id);
    }

    public String updateProductById(int id, double price) {
        if (id < 0) {
            return "Invalid id is provided!!";
        }

        else if (!repository.checkProductAlreadyExists(id)) {
            return "Product does not exist!!";
        }

        return repository.updateProductById(id, price);
    }

    public String deleteProductById(int id) {
        if (id < 0) {
            return "Invalid id is provided";
        }

        else if (!repository.checkProductAlreadyExists(id)) {
            return "Product does not exists!!";
        }

        return repository.deleteProductById(id);
    }

    public String createProduct(int id, String name, double price) {
        if (id < 0) {
            return "Invalid id is provided!!";
        }

        else if (repository.checkProductAlreadyExists(id)) {
            return "Product already exists!!";
        }

        return repository.createProduct(id, name, price);
    }

}
