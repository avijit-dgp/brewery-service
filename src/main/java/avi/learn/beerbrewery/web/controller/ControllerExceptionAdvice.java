package avi.learn.beerbrewery.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerExceptionAdvice {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException argumentNotValidException) {
		List<String> errors = new ArrayList<>();
		argumentNotValidException.getBindingResult().getFieldErrors()
			.forEach(fieldError -> {
				errors.add(fieldError.getField() + " : " + fieldError.getDefaultMessage());
			});
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(BindException.class)
	public ResponseEntity<?> handleBindException(BindException bindException) {
		return new ResponseEntity<>(bindException.getAllErrors(), HttpStatus.BAD_REQUEST);
	}

}
