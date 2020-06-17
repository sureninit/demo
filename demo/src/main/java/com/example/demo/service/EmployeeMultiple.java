package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.EmployeeModelEntity;
import com.example.demo.model.EmployeeMultipleModel;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeMultiple {
	
	@Autowired 
	private EmployeeRepository employeeRepo;

	public EmployeeMultipleModel employeeMul(EmployeeMultipleModel employeeMultiple) {
		List<EmployeeModelEntity> arrayEmployee = new ArrayList<EmployeeModelEntity>();
		for(EmployeeModelEntity emp : employeeMultiple.getEmployeeMultiple()) {
			arrayEmployee.add(emp);
		}
		employeeRepo.saveAll(arrayEmployee);
		return employeeMultiple;
	}

	public EmployeeMultipleModel developers() {
		List<EmployeeModelEntity> employees = (List<EmployeeModelEntity>) employeeRepo.findAll();
		EmployeeMultipleModel employeeMul=new EmployeeMultipleModel();
		employeeMul.setEmployeeMultiple(employees);
		return employeeMul;
		
	}

}