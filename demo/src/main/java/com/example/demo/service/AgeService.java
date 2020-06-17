package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.AgeException;
import com.example.demo.model.AgeDetails;
import com.example.demo.model.AgeModel;
import com.example.demo.model.AgeMultiple;
import com.example.demo.repository.AgeDetailsMySqlRepo;
import com.example.demo.repository.AgeRepository;

@Component
public class AgeService {
	@Autowired
	private AgeModel agemod;
	
	@Autowired
	private AgeDetailsMySqlRepo agedetailRepo;
	
	@Autowired
	private AgeRepository AgeMongoRepo;
	
	@Autowired
	private AgeException ageExcep;

	public AgeModel validation(String name, int age) throws AgeException{
		 agemod.setName(name);
		 agemod.setAge(age);
		 if(age<18) {
			 //agemod.setMessage("you are not eligiable");
			throw new AgeException("not eligiable");
		 }else if(age > 18) {
			 agemod.setMessage("you are eligiable");
		 }else if(age<0 && age>100) {
			 agemod.setMessage("Invalid age");
		 }
		 
		
		 return agemod;
		
	}
	
	public Optional<AgeDetails> ageData(Long id) {
		
		
		Optional<AgeDetails> agedata=agedetailRepo.findById(id);
		
		return agedata;
		
	}

	public Optional<AgeMultiple> searchCust(String id) {
		
		Optional<AgeMultiple> out = AgeMongoRepo.findById(id);
		return out;
	}
}
