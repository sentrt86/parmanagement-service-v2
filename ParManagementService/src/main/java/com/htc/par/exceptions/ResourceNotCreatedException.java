package com.htc.par.exceptions;


public class ResourceNotCreatedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotCreatedException() {
		super();
	}


	public ResourceNotCreatedException(String message, Throwable cause, boolean
			enableSuppression, boolean writableStackTrace) { 
		super(message, cause,enableSuppression, writableStackTrace); 
	}

	public ResourceNotCreatedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotCreatedException(String message) { 
		super(message); 
	}

	public ResourceNotCreatedException(Throwable cause) { 
		super(cause);
	}

}
