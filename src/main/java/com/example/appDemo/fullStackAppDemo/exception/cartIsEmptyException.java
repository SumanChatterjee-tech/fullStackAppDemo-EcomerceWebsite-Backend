package com.example.appDemo.fullStackAppDemo.exception;

public class cartIsEmptyException extends Exception {
	private static final long serialVersionUID = 4246823202397991378L;
	public cartIsEmptyException(String message) {
		super(message);
	}
}
