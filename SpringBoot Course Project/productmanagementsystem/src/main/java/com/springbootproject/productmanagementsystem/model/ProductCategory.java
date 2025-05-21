package com.springbootproject.productmanagementsystem.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "category")
public class ProductCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_name")
    private String name;

    @OneToMany(mappedBy = "productCategory", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products = new ArrayList<>();

    protected ProductCategory() {
    } // required for jpa

    public ProductCategory(String name) {
        this.name = name;
    }

    // getters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return this.products;
    }

    // setter
    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    // method to compute total price of all products
    public double getTotalPrice() {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getPrice();
        }

        return totalPrice;
    }

    @Override
    public String toString() {
        String stringRepresentationOfProductCategory = "Product Category: ";
        stringRepresentationOfProductCategory += this.name + "\n";

        stringRepresentationOfProductCategory += "Products: ";
        for (Product product : products) {
            stringRepresentationOfProductCategory += product.toString() + "\n";
        }

        stringRepresentationOfProductCategory += "Total Price of products: " + getTotalPrice();

        return stringRepresentationOfProductCategory;
    }

}
