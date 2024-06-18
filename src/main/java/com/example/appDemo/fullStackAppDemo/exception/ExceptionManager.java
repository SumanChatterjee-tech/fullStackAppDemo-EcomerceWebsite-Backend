package com.example.appDemo.fullStackAppDemo.exception;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.example.appDemo.fullStackAppDemo.shared.ErrorFields;

@ControllerAdvice
public class ExceptionManager {
	
	@ExceptionHandler(value = UserRelatedException.class)
	public ResponseEntity<Object> handledUserRelatedExceptions(UserRelatedException ex, WebRequest request){
		ErrorFields err = new ErrorFields();
		LocalDateTime ldt = LocalDateTime.now();
		err.setMessage(ex.getMessage());
		err.setTimeStamp(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = EmailSendingException.class)
	public ResponseEntity<Object> handledEmailSendingExceptions(EmailSendingException ex, WebRequest request){
		ErrorFields err = new ErrorFields();
		LocalDateTime ldt = LocalDateTime.now();
		err.setMessage(ex.getMessage());
		err.setTimeStamp(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = cartIsEmptyException.class)
	public ResponseEntity<Object> cratRelated(cartIsEmptyException ex, WebRequest request){
		ErrorFields err = new ErrorFields();
		LocalDateTime ldt = LocalDateTime.now();
		err.setMessage(ex.getMessage());
		err.setTimeStamp(DateTimeFormatter.ofPattern("MM-dd-yyyy", Locale.ENGLISH).format(ldt));
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
