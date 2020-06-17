package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.ProductModel;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductModel productmodel;
	
	@Autowired
	private ProductService productService;
	@RequestMapping(value="/procheck")
	public String productCheck() {
		return "prodouct check ok";
	}
	
	@RequestMapping(value="/product", method=RequestMethod.GET, produces="application/json")
	public ProductModel productModel(@RequestParam("pid") int pid, @RequestParam("pname") String pname, @RequestParam("prate") int prate) {
		ProductModel createTable = productService.productCreatTable(pid,pname,prate);
		return createTable;
	}
	
}
