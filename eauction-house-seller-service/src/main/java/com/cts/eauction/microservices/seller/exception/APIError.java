package com.cts.eauction.microservices.seller.exception;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.HttpStatus;

public class APIError {

	private HttpStatus status;
	private List<String> errors;
	private LocalDateTime timestamp;
	private String pathUri;
	
	public APIError() {
		
	}

	public APIError(HttpStatus status, List<String> errors, LocalDateTime timestamp, String pathUri) {
		super();
		this.status = status;
		this.errors = errors;
		this.timestamp = timestamp;
		this.pathUri = pathUri;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public List<String> getErrors() {
		return errors;
	}
	public void setErrors(List<String> errors) {
		this.errors = errors;
	}
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getPathUri() {
		return pathUri;
	}
	public void setPathUri(String pathUri) {
		this.pathUri = pathUri;
	}
	
	
	
}
