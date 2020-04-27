package com.lutteced.dream.handler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.lutteced.dream.dto.Response;
import com.lutteced.dream.exception.CustomeErrorDetails;
import com.lutteced.dream.exception.DataBaseException;
import com.lutteced.dream.exception.UserNameNotFoundException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	// http request method not supported exception
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		log.info("from handleHttpRequestMethodNotSupported method");
		Response response = new Response();
		response.setStatus(false);
		response.setStatusCode(405);
		response.setTimestamp(new Date());
		response.setMessage("HTTP method not supported to this url");
		response.setResult(ex.getMessage());
		return new ResponseEntity<>(response, HttpStatus.METHOD_NOT_ALLOWED);
	}

	// handling method argument not valid exception
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<String> errorsMessage = new ArrayList<>();
		for (ObjectError error : ex.getBindingResult().getAllErrors()) {
			errorsMessage.add(error.getDefaultMessage());
		}

		// Get all fields errors
		/*
		 * List<String> errors = ex.getBindingResult() .getFieldErrors() .stream()
		 * .map(x -> x.getDefaultMessage()) .collect(Collectors.toList());
		 * 
		 * body.put("errors", errors);
		 */

		Response response = new Response();
		response.setStatus(false);
		response.setStatusCode(400);
		response.setTimestamp(new Date());
		response.setMessage("Bad Request");
		response.setResult(errorsMessage);
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNameNotFoundException.class)
	public ResponseEntity<Object> handleUserNameNotFound(RuntimeException ex, HttpHeaders headers, HttpStatus status,
			WebRequest request) {
		CustomeErrorDetails details = new CustomeErrorDetails();
		details.setTimestamp(new Date());
		details.setMessage("User name not found");
		details.setErrordetails(ex.getMessage());
		return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(value = { DataBaseException.class })
	public final ResponseEntity<Object> handleDataBaseException(DataBaseException ex) {
		log.info("from DataBaseException handler  method");
		return new ResponseEntity<Object>(Response.serverError("", "Server error,Please try later"),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String name = ex.getParameterName();
		logger.error(name + " parameter is missing");

		return super.handleMissingServletRequestParameter(ex, headers, status, request);
	}

}