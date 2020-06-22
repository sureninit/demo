package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.EmployeeModelEntity;

@Component
public interface EmployeeRepository extends CrudRepository<EmployeeModelEntity,Integer> {
	
	@Query("select emp from EmployeeModelEntity emp where emp.employeeDepartment like %:dep%")
	List<EmployeeModelEntity> findDepEmployees(@Param("dep") String dep);
	
	@Modifying
	@Transactional
	@Query("UPDATE  EmployeeModelEntity emp SET emp.salary =:sal WHERE emp.employeeId=:empId")
	int updateEmployees(@Param("sal") double salary,@Param("empId") int empId );
	
	
	
}
