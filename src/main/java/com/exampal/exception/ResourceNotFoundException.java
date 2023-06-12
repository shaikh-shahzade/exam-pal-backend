package com.exampal.exception;

public class ResourceNotFoundException extends Exception{

	public ResourceNotFoundException(String resource , String value , Long id) {
		// TODO Auto-generated constructor stub
		super(String.format("Resource:[%s] not found for [%s: %l]",resource,value,id));
	}
}
