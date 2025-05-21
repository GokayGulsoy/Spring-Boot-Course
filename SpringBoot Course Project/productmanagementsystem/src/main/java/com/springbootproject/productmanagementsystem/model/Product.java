package com.springbootproject.productmanagementsystem.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "product_category")
    @JsonBackReference
    private ProductCategory productCategory;

    protected Product() {
    } // required for jpa

    public Product(String name, ProductCategory category, double price) {
        this.name = name;
        this.productCategory = category;
        this.price = price;
    }

    // getters
    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public ProductCategory getProductCategory() {
        return this.productCategory;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setProductCategory(ProductCategory category) {
        this.productCategory = category;
    }

    @Override
    public String toString() {
        return "Product name: " + this.name + " Product price: " + this.price + " Product category: "
                + this.productCategory.getName();
    }

}
