package com.test.test.person.handler.error;

import java.io.Serial;
import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.test.test.person.utils.ResponseUtils;

import jakarta.servlet.http.HttpServletRequest;

public class StandardError {
	
	@Serial
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date;
    private Integer status;
    private String error;
    private String message;
    private String path;

    public StandardError(HttpStatus status, String message, HttpServletRequest request) {
        super();
        this.date = LocalDateTime.now();
        this.status = status.value();
        this.error = status.name();
        this.message = message;
        this.path = ResponseUtils.getFullURL(request);
    }

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
