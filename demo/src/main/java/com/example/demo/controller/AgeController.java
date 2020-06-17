package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.AgeException;
import com.example.demo.model.AgeDetails;
import com.example.demo.model.AgeDetailsMultiple;
import com.example.demo.model.AgeModel;
import com.example.demo.model.AgeMultiple;
import com.example.demo.service.AgeMultipleService;
import com.example.demo.service.AgeService;

@RestController
public class AgeController {

	@Autowired
	private AgeService ageservice;
	
	@Autowired
	private AgeDetailsMultiple ageDetailsMultiple;

	@RequestMapping(value = "/check")
	public String check() {
		return "ok";
	}

	@Autowired
	private AgeMultipleService ageMultipleService;

	@RequestMapping(value = "/cust", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> cust(@RequestParam("name") String name, @RequestParam("age") int age) {
		AgeModel result = null;
		try {
			result = ageservice.validation(name, age);
		} catch (AgeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.EXPECTATION_FAILED);

		}
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@RequestMapping(value = "/custmultiple", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public AgeMultiple custmultiple(@RequestBody AgeMultiple agemulti) {

		AgeMultiple result1 = ageMultipleService.validationMultiple(agemulti);
		return result1;
	}
	//search single customer in mysql
	@RequestMapping(value = "/agedata", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Object> ageDetails(@RequestParam("id") Long id) {
		Optional<AgeDetails> result = ageservice.ageData(id);

		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	/*
	 * post method to mongodb*/
	@RequestMapping(value="/agemultipost", method=RequestMethod.POST, produces="application/json", consumes="application/json")
	public AgeDetailsMultiple ageDMultipost(@RequestBody AgeDetailsMultiple ageDetailsMultiple) {
		AgeDetailsMultiple  result2= ageMultipleService.ageDetailsMysql(ageDetailsMultiple);
		return result2;
	}
	// search single custumer in mongodb
	@RequestMapping(value="/searchtomongo", method=RequestMethod.GET, produces="application/json")
	public Optional<AgeMultiple> SearchToMongo(@RequestParam("id") String id) {
		Optional<AgeMultiple> result3 = ageservice.searchCust(id);
		return result3;
	}
	
	

}
