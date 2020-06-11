package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.AgeModel;
import com.example.demo.model.AgeMultiple;
import com.example.demo.repository.AgeRepository;

@Component
public class AgeMultipleService {
	@Autowired
	private AgeRepository agerepository;

	@Autowired
	private AgeMultiple agemulti;
	public AgeMultiple validationMultiple(AgeMultiple agemulti) {
		
		List<AgeModel> arrayAgeModel = new ArrayList<AgeModel>();
		
		for(AgeModel ageout: agemulti.getAgemodel()) {
			if(ageout.getAge()<18) {
				ageout.setMessage("not eligiable");
			}else if(ageout.getAge()>18) {
				ageout.setMessage("eligiable");
			}
			arrayAgeModel.add(ageout);
		}
		agemulti=new AgeMultiple();
		agemulti.setAgemodel(arrayAgeModel);
		
		agerepository.save(agemulti);
		return agemulti;
	}

}
