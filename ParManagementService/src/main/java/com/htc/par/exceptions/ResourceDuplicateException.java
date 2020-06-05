package com.htc.par.exceptions;


public class ResourceDuplicateException extends RuntimeException {


	private static final long serialVersionUID = 1L;
	
	public ResourceDuplicateException() {
		super();
	}


	public ResourceDuplicateException(String message, Throwable cause, boolean
			enableSuppression, boolean writableStackTrace) { 
		super(message, cause,enableSuppression, writableStackTrace); 
	}

	public ResourceDuplicateException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceDuplicateException(String message) { 
		super(message); 
	}

	public ResourceDuplicateException(Throwable cause) { 
		super(cause);
	}
}
