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

import com.htc.par.model.ResponseException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Object> handleResourceNotFoundException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotDeletedException.class)
	public ResponseEntity<Object> handleResourceNotDeletedException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ResourceNotCreatedException.class)
	public ResponseEntity<Object> handleResourceNotCreatedException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.GONE);
	}
	
	@ExceptionHandler(ResourceNotUpdatedException.class)
	public ResponseEntity<Object> handleResourceNotUpdatedException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.GONE);
	}
	
	@ExceptionHandler(ResourceDuplicateException.class)
	public ResponseEntity<Object> handleResourceDuplicateFoundException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(ResourceAccessException.class)
	public ResponseEntity<Object> handleResourceAccessException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,ResourceNotFoundException ex){
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(HttpServletRequest httpServletRequest,HttpStatus status, WebRequest request,Exception ex) {
		logger.error("PAR_Management_Service__API :: " + "Requested url:"+ httpServletRequest.getRequestURL()+ " HttpStatus code: " + String.valueOf(status.value()) + "exception :" + ex.toString());
		return generateResponseEntity(ex.getMessage(), request.getDescription(false), HttpStatus.BAD_REQUEST);
	}
	
	private ResponseEntity<Object> generateResponseEntity(String message, String description, HttpStatus httpStatus) {
		ResponseException responseException = new ResponseException(new Date(),String.valueOf(httpStatus.value()), message, description);
		return new ResponseEntity<Object>(responseException, httpStatus);
	}

}
