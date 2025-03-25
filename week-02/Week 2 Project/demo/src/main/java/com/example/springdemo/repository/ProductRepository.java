package com.example.springdemo.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.springdemo.model.Product;

@Repository
public class ProductRepository {

    private List<Product> productRepo;

    public ProductRepository() {
        // create an empty repository
        productRepo = new ArrayList<>();
        Product product = new Product(1,"cup",50.50);
        productRepo.add(product);
    }

    public String findProductById(int id) {
        // get the Product with given id
        // and return it
        for (Product product : productRepo) {

            if (id == product.getId()) {
                return product.toString();
            }
        }

        return "Product Not Found";
    }

    public String updateProductById(int id, double price) {
        // update the Product with given id
        // and update it
        int indexOfProduct = 0;
        for (Product product: productRepo) {
            if (id == product.getId()) {
                break;
            }
            
            indexOfProduct++;
        }

        Product updatedProduct = productRepo.get(indexOfProduct);
        updatedProduct.setPrice(price);

        return updatedProduct.toString();
    }

    public String deleteProductById(int id) {
        // find the Product with given id
        // and delete it
        int indexToRemove = 0;
        for (int i = 0; i < productRepo.size(); i++) {
            if (id == productRepo.get(i).getId()) {
                indexToRemove = i;
            }
        }

        Product removedProduct = productRepo.remove(indexToRemove);
        return removedProduct.toString();
    }

    public String createProduct(int id, String name, double price) {
        // create product with given id, name, and price
        Product newProduct = new Product(id, name, price);
        // add newly created product to repository
        productRepo.add(newProduct);

        return newProduct.toString();
    }

    public boolean checkProductAlreadyExists(int id) {
        // check if product with given id
        // already exists in
        for (Product product : productRepo) {
            if (id == product.getId()) {
                return true;
            }
        }

        return false;
    }

}