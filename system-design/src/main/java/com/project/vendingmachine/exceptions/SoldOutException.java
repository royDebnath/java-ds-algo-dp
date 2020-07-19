package com.project.vendingmachine.exceptions;

public class SoldOutException extends RuntimeException {

	private static final long serialVersionUID = 7971480676649901216L;
	private String message;

	public SoldOutException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
