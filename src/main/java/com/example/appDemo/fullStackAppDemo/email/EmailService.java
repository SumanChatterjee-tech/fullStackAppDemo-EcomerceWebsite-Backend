package com.example.appDemo.fullStackAppDemo.email;

import com.example.appDemo.fullStackAppDemo.exception.EmailSendingException;
import com.example.appDemo.fullStackAppDemo.model.sendFeedBack;

public interface EmailService {
	public String sendSimpleEmail(String to) throws EmailSendingException;
	public boolean sendFeedBackMail(sendFeedBack feedback) throws EmailSendingException;
}
