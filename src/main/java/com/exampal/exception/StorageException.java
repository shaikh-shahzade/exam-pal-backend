package com.exampal.exception;

public class StorageException extends RuntimeException{

	private static final long serialVersionUID = -3721172072734540660L;

	
	public StorageException(String message) {
		super(String.format("Unable to store file: %s", message));
	}
}
