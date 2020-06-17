package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AgeDetailsMultiple {

	private List<AgeDetails> ageDetails;

	public List<AgeDetails> getAgeDetails() {
		return ageDetails;
	}

	public void setAgeDetails(List<AgeDetails> ageDetails) {
		this.ageDetails = ageDetails;
	} 
}
