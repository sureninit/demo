package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="emp_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"employeeId",
"employeeName",
"employeeDepartment",
"salary",
"status"
})
public class EmployeeModelEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="employee_id")
	@JsonProperty("employeeId")
	private int employeeId;
	
	@Column(name="employee_name")
	@JsonProperty("employeeName")
	private String employeeName;
	
	@Column(name="employee_department")
	@JsonProperty("employeeDepartment")
	private  String employeeDepartment;
	
	@Column(name="salary")
	@JsonProperty("salary")
	private double salary;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("employeeId")
	public int getEmployeeId() {
		return employeeId;
	}
	@JsonProperty("employeeName")
	public String getEmployeeName() {
		return employeeName;
	}
	@JsonProperty("employeeName")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	@JsonProperty("employeeDepartment")
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	@JsonProperty("employeeDepartment")
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	@JsonProperty("salary")
	public double getSalary() {
		return salary;
	}
	@JsonProperty("salary")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
