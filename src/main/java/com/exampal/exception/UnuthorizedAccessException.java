package com.exampal.exception;

public class UnuthorizedAccessException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UnuthorizedAccessException(String resource , String value , Long id) {
		super(String.format("Not Authorised to access or update Resource:[%s] for [%s : %d]",resource,value,id));
	}
}