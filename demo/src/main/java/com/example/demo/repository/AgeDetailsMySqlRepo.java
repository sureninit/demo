package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.demo.model.AgeDetails;

@Component
public interface AgeDetailsMySqlRepo extends CrudRepository<AgeDetails, Integer> {
	
   
}
