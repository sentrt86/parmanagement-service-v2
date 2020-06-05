package com.htc.par.exceptions;


public class ResourceAccessException  extends RuntimeException{
	

	private static final long serialVersionUID = 1L;

	public ResourceAccessException() {
		super();
	}


	public ResourceAccessException(String message, Throwable cause, boolean
			enableSuppression, boolean writableStackTrace) { 
		super(message, cause,enableSuppression, writableStackTrace); 
	}

	public ResourceAccessException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceAccessException(String message) { 
		super(message); 
	}

	public ResourceAccessException(Throwable cause) { 
		super(cause);
	}

}
