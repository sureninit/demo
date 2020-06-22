package com.example.demo.model;

import org.springframework.stereotype.Component;

@Component
public class DeletedFromMysql {
	private String deleteMessage;

	public String getDeleteMessage() {
		return deleteMessage;
	}

	public void setDeleteMessage(String deleteMessage) {
		this.deleteMessage = deleteMessage;
	}

}
