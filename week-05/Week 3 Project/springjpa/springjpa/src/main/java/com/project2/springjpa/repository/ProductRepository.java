package com.project2.springjpa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project2.springjpa.model.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {    


}
