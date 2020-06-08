package com.htc.par.exceptions;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.htc.par.model.ResponseException;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ResponseException> handleResourceNotFoundException(WebRequest request, ResourceNotFoundException ex) {
		logger.error("PAR_Management_Service__API :: " 
		+ " HttpStatus code: " + String.valueOf(HttpStatus.NOT_FOUND) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.NOT_FOUND),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotDeletedException.class)
	public ResponseEntity<ResponseException> handleResourceNotDeletedException(WebRequest request, ResourceNotDeletedException ex) {
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.NOT_FOUND) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.NOT_FOUND),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ResourceNotCreatedException.class)
	public ResponseEntity<ResponseException> handleResourceNotCreatedException(WebRequest request, ResourceNotCreatedException ex) {		
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.GONE) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.GONE),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.GONE);
	}

	@ExceptionHandler(ResourceNotUpdatedException.class)
	public ResponseEntity<ResponseException> handleResourceNotUpdatedException( WebRequest request, ResourceNotUpdatedException ex) {
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.GONE) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.GONE),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.GONE);
	}

	@ExceptionHandler(ResourceDuplicateException.class)
	public ResponseEntity<ResponseException> handleResourceDuplicateFoundException( WebRequest request,ResourceDuplicateException ex) {
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.NOT_FOUND) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.CONFLICT),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.CONFLICT);
	}

	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<ResponseException> handleResourceAccessException(WebRequest request, ResourceAccessException ex) {
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.NOT_FOUND) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.BAD_REQUEST),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseException> handleException(WebRequest request, Exception ex) {
		logger.error("PAR_Management_Service__API :: " 
				+ " HttpStatus code: " + String.valueOf(HttpStatus.BAD_REQUEST) + "exception :" + ex.toString());
		ResponseException response = new ResponseException(new Date(),String.valueOf(HttpStatus.BAD_REQUEST),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
	}

}
