package com.cts.eauction.microservices.seller.exception;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class EauctionHouseCustomExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({EauctionHouseException.class})
	ResponseEntity<?> EauctionHouseHandler(Exception ex, ServletWebRequest request){
		APIError apiError = new APIError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setPathUri(request.getDescription(false));
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(Arrays.asList(ex.getMessage()));
		
		return new ResponseEntity(apiError,new HttpHeaders(),apiError.getStatus());
	}
	
	@ExceptionHandler({RequestNotValidException.class})
	ResponseEntity<?> RequestNotValidHandler(Exception ex, ServletWebRequest request){
		APIError apiError = new APIError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setPathUri(request.getDescription(false));
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(Arrays.asList(ex.getMessage()));
		
		return new ResponseEntity(apiError,new HttpHeaders(),apiError.getStatus());
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
		
		List<String> errors = fieldErrors.stream()
				.map(err -> err.getField() +  " : " + err.getDefaultMessage())
				.collect(Collectors.toList());
		
		APIError apiError = new APIError();
		apiError.setTimestamp(LocalDateTime.now());
		apiError.setPathUri(request.getDescription(false));
		apiError.setStatus(HttpStatus.BAD_REQUEST);
		apiError.setErrors(errors);
		
		return new ResponseEntity(apiError,headers,apiError.getStatus());
	}
	
	
}
