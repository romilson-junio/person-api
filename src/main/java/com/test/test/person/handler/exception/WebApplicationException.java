package com.test.test.person.handler.exception;

import org.springframework.http.HttpStatus;

public class WebApplicationException extends RuntimeException {
	
    private static final long serialVersionUID = 1L;
	private final HttpStatus status;
    
    public WebApplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }

	public HttpStatus getStatus() {
		return status;
	}
    
}
