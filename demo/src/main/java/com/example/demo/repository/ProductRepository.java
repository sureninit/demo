package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.ProductModel;

@Component
public interface ProductRepository extends CrudRepository<ProductModel, Integer> {

}
