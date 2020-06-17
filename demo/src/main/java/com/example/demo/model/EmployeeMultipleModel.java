package com.example.demo.model;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class EmployeeMultipleModel {
	private List<EmployeeModelEntity> employeeMultiple;

	public List<EmployeeModelEntity> getEmployeeMultiple() {
		return employeeMultiple;
	}

	public void setEmployeeMultiple(List<EmployeeModelEntity> employeeMultiple) {
		this.employeeMultiple = employeeMultiple;
	}

	

}
