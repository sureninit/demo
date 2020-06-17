package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="age_details")
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"name",
"age",
"message"
})
public class AgeDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("id")
	private Long id;
	@JsonProperty("name")
	private String name;
	@JsonProperty("age")
	private int age;

	@JsonProperty("message")
	private String message;
	@JsonProperty("name")
	public String getName() {
		return name;
	}
	@JsonProperty("name")
	public void setName(String name) {
		this.name = name;
	}
	@JsonProperty("age")
	public int getAge() {
		return age;
	}
	@JsonProperty("age")
	public void setAge(int age) {
		this.age = age;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	@JsonProperty("id")
	public Long getId() {
		return id;
	}
	

}
