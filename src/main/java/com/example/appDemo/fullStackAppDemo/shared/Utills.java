package com.example.appDemo.fullStackAppDemo.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utills {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private final int ITERATIONS =10000;
	private final int KEY_LENGTH = 256;
	
	public String generateUserId(int length) {
		return generateRandomString(length);
	}
	
	public String generatedEmailTokenVerification(int length) {
		return generateRandomString(length);
	}
	
	public String generateRandomString(int length) {
		StringBuilder strBuild = new StringBuilder(length);
		for(int i=0;i<length;i++) {
			strBuild.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
		return new String(strBuild);
	}
}
