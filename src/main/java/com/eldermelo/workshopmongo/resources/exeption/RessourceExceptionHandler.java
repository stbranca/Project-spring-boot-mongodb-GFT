package com.eldermelo.workshopmongo.resources.exeption;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.eldermelo.workshopmongo.services.exception.ObjectNotFaundException;


@ControllerAdvice
public class RessourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFaundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFaundException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "não encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
}
