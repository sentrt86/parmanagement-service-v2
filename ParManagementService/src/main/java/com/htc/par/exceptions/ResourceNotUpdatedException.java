package com.htc.par.exceptions;


public class ResourceNotUpdatedException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotUpdatedException() {
		super();
	}


	public ResourceNotUpdatedException(String message, Throwable cause, boolean
			enableSuppression, boolean writableStackTrace) { 
		super(message, cause,enableSuppression, writableStackTrace); 
	}

	public ResourceNotUpdatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotUpdatedException(String message) { 
		super(message); 
	}

	public ResourceNotUpdatedException(Throwable cause) { 
		super(cause);
	}

}
