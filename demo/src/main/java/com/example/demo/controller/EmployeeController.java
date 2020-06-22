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

import com.example.demo.model.EmployeeModelEntity;
import com.example.demo.model.EmployeeMultipleModel;
import com.example.demo.service.EmployeeMultiple;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeMultiple EmployeeMultiple;

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/newcheck")
	public String newcheck() {
		return "new controller ok";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<EmployeeModelEntity> employee(@RequestParam("id") int id) {
		Optional<EmployeeModelEntity> result = employeeService.employeeSearch(id);
		
		if(null==result) {
			EmployeeModelEntity emp=new EmployeeModelEntity();
			emp.setStatus("Employee not available in DB!!!");
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(emp);
		}else {
			return ResponseEntity.accepted().body(result.get()) ;
		}
			
		
	}

	@RequestMapping(value = "/employeeadd", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public EmployeeModelEntity employeeAdd(@RequestBody EmployeeModelEntity empAdd) {
		EmployeeModelEntity resultoutput = employeeService.empladded(empAdd);
		return resultoutput;
	}

	@RequestMapping(value = "/addMultipleEmployee", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	public EmployeeMultipleModel addMultipleEmployee(@RequestBody EmployeeMultipleModel employeeMultiple) {
		EmployeeMultipleModel res = EmployeeMultiple.employeeMul(employeeMultiple);
		return res;

	}
//delete employee 
	@RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@RequestParam("id") int id) {
		ResponseEntity<Object> out = employeeService.delete(id);
		return out;

	}
// search developer 
	@RequestMapping(value = "/employeebydep", method = RequestMethod.GET, produces = "application/json")
	public EmployeeMultipleModel getDevelopers(@RequestParam("dep") String dep) {
		EmployeeMultipleModel resultDevelopers = new EmployeeMultipleModel();
		resultDevelopers.setEmployeeMultiple(employeeService.findEmpByDep(dep));
		return resultDevelopers;
	}
	// update salary of employees
	@RequestMapping(value = "/employee", method = RequestMethod.PUT, produces = "application/json")
	public ResponseEntity<Object> empUpdate(@RequestParam("empId") int empId,@RequestParam("sal") double sal) {
	    
		return employeeService.updateEmp(sal,empId);
	}
}
