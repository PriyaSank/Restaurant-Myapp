package com.priya.exception;

public class ItemNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ItemNotFound(String message, Throwable cause) {
		super(message, cause);

	}

	public ItemNotFound(String message) {
		super(message);

	}

}
