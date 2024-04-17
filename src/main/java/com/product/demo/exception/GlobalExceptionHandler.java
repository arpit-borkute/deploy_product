package com.product.demo.exception;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public HashMap<String, Object> MethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		HashMap<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		map.put("code", HttpStatus.BAD_REQUEST);

		BindingResult bindingResult = ex.getBindingResult();
		List<FieldError> fieldErrors = bindingResult.getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			map.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		return map;

	}

	@ResponseStatus(code = HttpStatus.ALREADY_REPORTED)
	@ExceptionHandler(ResourceAlreadyExistsException.class)
	public ResponseEntity<String> ResourceAlreadyExistsException(ResourceAlreadyExistsException ex) {

		return ResponseEntity.ok(ex.getMessage());

	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ProductNotFound.class) //we can do different ways
	public HashMap<String, Object> ProductNotFound(ProductNotFound ex) {
		HashMap<String, Object> map = new HashMap<>();
		map.put("Time", new Date());
		map.put("message", ex.getMessage());
		map.put("stackTrace", ex.getStackTrace());
		map.put("status", HttpStatus.NOT_FOUND.value());
		map.put("metadata", ex.getSuppressed());
		map.put("localizedMessage", ex.getLocalizedMessage());
		map.put("userMessage",
				"Sorry, the requested product was not found. Please check the product ID and try again.");

		return map;
	}
}
