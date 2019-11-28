package com.sgeneral.employee.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
@RestController
public class CustomizedResponseEntitiyExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {
		ErrorFormat errorFormat = new ErrorFormat(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorFormat, HttpStatus.INTERNAL_SERVER_ERROR);

	}

	@ExceptionHandler(ItemNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request) throws Exception {
		ErrorFormat errorFormat = new ErrorFormat(new Date(), ex.getMessage(), request.getDescription(false));

		return new ResponseEntity(errorFormat, HttpStatus.NOT_FOUND);

	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorFormat errorFormat = new ErrorFormat(new Date(), "Validation error", ex.getBindingResult().toString());

		return new ResponseEntity(errorFormat, HttpStatus.BAD_REQUEST);
	}

}

