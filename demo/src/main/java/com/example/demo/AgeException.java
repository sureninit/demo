package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class AgeException extends Exception {

	public AgeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AgeException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AgeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AgeException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
