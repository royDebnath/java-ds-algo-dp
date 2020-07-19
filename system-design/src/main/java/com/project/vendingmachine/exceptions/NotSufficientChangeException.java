package com.project.vendingmachine.exceptions;

public class NotSufficientChangeException extends RuntimeException {

	private static final long serialVersionUID = -1308547046419367106L;
	private String message;

	public NotSufficientChangeException(String string) {
		this.message = string;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
