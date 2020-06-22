package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class DeleteModel {
	private String DeleteError;

	public String getDeleteError() {
		return DeleteError;
	}

	public void setDeleteError(String deleteError) {
		DeleteError = deleteError;
	}
}
