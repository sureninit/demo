package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.EmployeeModelEntity;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public Optional<EmployeeModelEntity> employeeSearch(int id) {
		Optional<EmployeeModelEntity> output = employeeRepository.findById(id);
		return output;
	}

	public EmployeeModelEntity empladded(EmployeeModelEntity empAdd) {
		empAdd.getEmployeeName();
		empAdd.getEmployeeDepartment();
		empAdd.getSalary();
		employeeRepository.save(empAdd);
		return empAdd;
		
	}

	public String delete(int id) {
		employeeRepository.deleteById(id);
		return "Deleted Employee id:"+id;
		
	}


	public List<EmployeeModelEntity> findEmpByDep(String dep) {
		return employeeRepository.findDepEmployees(dep);
		
		
	}
	


	public int updateEmp(double sal,int empId) {
		return employeeRepository.updateEmployees(sal, empId);
		
		
	}
	
	
}
