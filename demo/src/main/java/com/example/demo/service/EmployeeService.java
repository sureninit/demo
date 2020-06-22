package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.model.DeleteModel;
import com.example.demo.model.DeletedFromMysql;
import com.example.demo.model.EmployeeModelEntity;
import com.example.demo.model.ErrorMessageModel;
import com.example.demo.repository.EmployeeRepository;

@Component
public class EmployeeService {
	@Autowired
	private DeletedFromMysql DeletedFromMysql;
	@Autowired
	private DeleteModel DelModel;
	
	@Autowired
	ErrorMessageModel error ;

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

	public ResponseEntity<Object> delete(int id) {
		Optional<EmployeeModelEntity> deleteOptional = employeeRepository.findById(id);
		if (deleteOptional.isPresent()) {
			employeeRepository.deleteById(id);
			DeletedFromMysql.setDeleteMessage("Deleted Employee id: "+id);
			return new ResponseEntity(DeletedFromMysql, HttpStatus.ACCEPTED);
		}else {
			DelModel.setDeleteError("Sorry !! There are no Employee with Employee Id :"+id);
			return new ResponseEntity(DelModel, HttpStatus.NOT_FOUND);
		}
		
		
	

	}

	public List<EmployeeModelEntity> findEmpByDep(String dep) {
		return employeeRepository.findDepEmployees(dep);

	}

	public ResponseEntity<Object> updateEmp(double sal, int empId) {
		
		
		Optional<EmployeeModelEntity> output = employeeRepository.findById(empId);

		if (output.isPresent()) {
			employeeRepository.updateEmployees(sal, empId);
			return new  ResponseEntity<>(output.get(),HttpStatus.ACCEPTED);
		} else {
			error.setErrorMessage("There are no Employees with EmpId:=" + empId);
			return new  ResponseEntity<>(error,HttpStatus.NOT_FOUND);
			
		}

	}

}
