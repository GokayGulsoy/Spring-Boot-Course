package com.project2.springjpa.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project2.springjpa.model.Product;
import com.project2.springjpa.repository.ProductRepository;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(@Autowired ProductRepository repository) {
        this.repository = repository;
    }

    public String getProductById(int id) {
        if (id < 0) {
            return "Invalid id is provided!!";
        }

        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            return product.get().toString();
        }

        else { // product with given id does not exist in database
            return null;
        }

    }   

    public String updateProductById(int id, double price) {
        if (id < 0) {
            return "Invalid id is provided!!";
        }

        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            Product updatedProduct = product.get();
            updatedProduct.setPrice(price);

            return repository.save(updatedProduct).toString();
        }

        else { // product to be updated does not exist in database
            return "Product to be updated does not exist!!";
        }

    }

    public String deleteProductById(int id) {
        if (id < 0) {
            return "Invalid id is provided!!";
        }

        Optional<Product> product = repository.findById(id);
        if (product.isPresent()) {
            Product deletedProduct = product.get();
            repository.deleteById(id);

            return deletedProduct.toString();
        }

        else { // product to be deleted does not exist in database
            return "Product to be deleted does not exist!!";
        }

    }

    public String createProduct(Product product) {
        return repository.save(product).toString();
    }

    
}
