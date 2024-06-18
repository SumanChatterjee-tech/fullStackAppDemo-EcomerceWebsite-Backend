package com.example.appDemo.fullStackAppDemo.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.example.appDemo.fullStackAppDemo.exception.EmailSendingException;
import com.example.appDemo.fullStackAppDemo.model.sendFeedBack;
import com.example.appDemo.fullStackAppDemo.shared.Utills;

@Component
public class emailSender implements EmailService {
	
    @Autowired
    private JavaMailSender emailSender;
    @Autowired
    private Utills utills;
    
	@Override
	public String sendSimpleEmail(String to) throws EmailSendingException {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		String subject = "Email Verification";
		String OTP = utills.generatedEmailTokenVerification(7);
		String mailBody = "Please do not reply to this mail.";
		mailBody += " This is soley for verification purpose.";
		mailBody += " Kindly find you OTP listed"+"\r\n";
		mailBody += OTP;
        message.setTo(to); 
        message.setSubject(subject); 
        message.setText(mailBody);
        emailSender.send(message);
        return OTP;
		}
		catch(Exception e) {
			throw new EmailSendingException("Email couldn't be verified due to network. Please try again later!");
		}
	}

	@Override
	public boolean sendFeedBackMail(sendFeedBack feedback) throws EmailSendingException {
		try {
		SimpleMailMessage message = new SimpleMailMessage();
		String subject = "FeedBack from "+feedback.getFromEmail();
		String mailBody = feedback.getComments() +" rating: "+feedback.getRating();
		message.setText(mailBody);
		message.setSubject(subject); 
		message.setTo("chatterjeesuman888@gmail.com");
        emailSender.send(message);
        return true;
		}
		catch(Exception e) {
			throw new EmailSendingException("Email couldn't be send due to network. Please try again later!");
		}
	}
}
