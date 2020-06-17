package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.ProductModel;
import com.example.demo.repository.ProductRepository;

@Component
public class ProductService {
	@Autowired ProductRepository productRepository;
	
	@Autowired
	private ProductModel productModel;
	
	public ProductModel productCreatTable(int pid,String pname,int prate) {
		productModel.setProductId(pid);
		productModel.setProductName(pname);
		productModel.setProductRate(prate);
		productRepository.save(productModel);
		return productModel;
	}

}
