package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;
@Component
public class AgeMultiple {
	
	private List<AgeModel> agemodel;

	public List<AgeModel> getAgemodel() {
		return agemodel;
	}

	public void setAgemodel(List<AgeModel> agemodel) {
		this.agemodel = agemodel;
	}


}
