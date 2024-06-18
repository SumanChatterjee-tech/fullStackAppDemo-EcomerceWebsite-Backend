package com.example.appDemo.fullStackAppDemo.exception;

public class EmailSendingException extends Exception {
	private static final long serialVersionUID = -4672441977882390338L;
	public EmailSendingException(String message) {
		super(message);
	}
}
