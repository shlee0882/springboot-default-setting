package com.example.demo.api.exception;

public class DemoException extends RuntimeException {
	/**
	 *
	 */
	private static final long serialVersionUID = -7335922882733051201L;
	public static final String errorCode = "DEMO_EXCEPTION";

	public DemoException() {
		super();
	}

	public DemoException(final String message, final Throwable cause) {
	    super(message, cause);
	}

	public DemoException(final String message) {
	    super(message);
	}

	public DemoException(final Throwable cause) {
	    super(cause);
	}
}
