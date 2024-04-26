package com.test.test.person.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.test.test.person.handler.error.StandardError;
import com.test.test.person.handler.error.ValidationError;
import com.test.test.person.handler.exception.WebApplicationException;
import com.test.test.person.utils.EnumUtils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandlerRest {
	
	
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<StandardError> errorResponse(EntityNotFoundException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND, e.getMessage(), request);
        return ResponseEntity.status(err.getStatus()).body(err);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST, "Erro de validação", request);
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<StandardError> validation(HttpMessageNotReadableException e, HttpServletRequest request) {
    	String message = EnumUtils.getMessage(e);
    	if(message != null) {
    		ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST, "Erro de validação", request);
    		err.addError("Sex", message);
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    	}
        return ResponseEntity.badRequest().body(new ValidationError(HttpStatus.BAD_REQUEST, message, request));
    }
    
    @ExceptionHandler(WebApplicationException.class)
    public ResponseEntity<StandardError> errorResponse(WebApplicationException e, HttpServletRequest request) {
        StandardError err = new StandardError(e.getStatus(), e.getMessage(), request);
        return ResponseEntity.status(e.getStatus()).body(err);
    }

}
