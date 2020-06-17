package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity

@Table(name = "prod_details")
public class ProductModel {
	@Id
	@Column(name = "pid")
	private int productId;
	@Column(name = "pname")
	private String productName;
	 @Column(name = "prate")
	private int productRate;
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getProductRate() {
		return productRate;
	}
	public void setProductRate(int productRate) {
		this.productRate = productRate;
	}

}
