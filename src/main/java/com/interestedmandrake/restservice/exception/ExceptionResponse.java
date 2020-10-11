package com.interestedmandrake.restservice.exception;

import java.util.Date;

// to create a single format to return as response for exception
public class ExceptionResponse {
	private Date date;
	private String message;
	private String details;

	public ExceptionResponse(Date date, String message, String details) {
		super();
		this.date = date;
		this.message = message;
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}

}
