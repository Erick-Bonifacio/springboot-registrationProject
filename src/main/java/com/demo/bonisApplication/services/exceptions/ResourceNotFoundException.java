package com.demo.bonisApplication.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(Long id) {
		super("ID número " + id.toString() + " não encontrado!");
	}
}
