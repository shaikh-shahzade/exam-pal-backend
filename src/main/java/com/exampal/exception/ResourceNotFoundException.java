package com.exampal.exception;

public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8742805477867830187L;

	public ResourceNotFoundException(String resource , String value , Long id) {
		// TODO Auto-generated constructor stub
		super(String.format("Resource:[%s] not found for [%s: %l]",resource,value,id));
	}
}
