package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import com.example.demo.model.AgeMultiple;

@Component
public interface AgeRepository extends MongoRepository<AgeMultiple,String>{

}
