package com.example.demo.model;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Component
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"name",
"age",
"message",
"id"
})
public class AgeModel {
	@JsonProperty("id")
	private String id;
	@JsonProperty("id")
	public String getId() {
		return id;
	}
	@JsonProperty("id")
	public void setId(String id) {
		this.id = id;
	}
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
	

}
