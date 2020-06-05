package com.htc.par.exceptions;


public class ResourceNotDeletedException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ResourceNotDeletedException() {
		super();
	}


	public ResourceNotDeletedException(String message, Throwable cause, boolean
			enableSuppression, boolean writableStackTrace) { 
		super(message, cause,enableSuppression, writableStackTrace); 
	}

	public ResourceNotDeletedException(String message, Throwable cause) {
		super(message, cause);
	}

	public ResourceNotDeletedException(String message) { 
		super(message); 
	}

	public ResourceNotDeletedException(Throwable cause) { 
		super(cause);
	}
}
