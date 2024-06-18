package com.example.appDemo.fullStackAppDemo.shared;

import java.io.Serializable;

public class userDTO implements Serializable{
	private static final long serialVersionUID = 8473068651691936339L;
	private long autoId;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Long phoneNumber;
	private Long alternatePhoneNumber;
	private String adderessLine;
	private Long pincode;
	private String city;
	private Long accountNumber;
	private String bankName;
	private Long cardNumber;
	private Long cvv;
	private String encryptedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus = false;
	
	public userDTO() {
		super();
	}

	public userDTO(long autoId, String userId, String firstName, String lastName, String email, String password,
			Long phoneNumber, Long alternatePhoneNumber, String adderessLine, Long pincode, String city,
			Long accountNumber, String bankName, Long cardNumber, Long cvv, String encryptedPassword,
			String emailVerificationToken, Boolean emailVerificationStatus) {
		super();
		this.autoId = autoId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.adderessLine = adderessLine;
		this.pincode = pincode;
		this.city = city;
		this.accountNumber = accountNumber;
		this.bankName = bankName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.encryptedPassword = encryptedPassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
	}
	public long getAutoId() {
		return autoId;
	}

	public void setAutoId(long autoId) {
		this.autoId = autoId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getAlternatePhoneNumber() {
		return alternatePhoneNumber;
	}

	public void setAlternatePhoneNumber(Long alternatePhoneNumber) {
		this.alternatePhoneNumber = alternatePhoneNumber;
	}

	public String getAdderessLine() {
		return adderessLine;
	}

	public void setAdderessLine(String adderessLine) {
		this.adderessLine = adderessLine;
	}

	public Long getPincode() {
		return pincode;
	}

	public void setPincode(Long pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public Long getCvv() {
		return cvv;
	}

	public void setCvv(Long cvv) {
		this.cvv = cvv;
	}

	public String getEncryptedPassword() {
		return encryptedPassword;
	}

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	public String getEmailVerificationToken() {
		return emailVerificationToken;
	}

	public void setEmailVerificationToken(String emailVerificationToken) {
		this.emailVerificationToken = emailVerificationToken;
	}

	public Boolean getEmailVerificationStatus() {
		return emailVerificationStatus;
	}

	public void setEmailVerificationStatus(Boolean emailVerificationStatus) {
		this.emailVerificationStatus = emailVerificationStatus;
	}

	@Override
	public String toString() {
		return "userDTO [id=" + autoId + ", userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", phoneNumber=" + phoneNumber
				+ ", alternatePhoneNumber=" + alternatePhoneNumber + ", adderessLine=" + adderessLine + ", pincode="
				+ pincode + ", city=" + city + ", accountNumber=" + accountNumber + ", bankName=" + bankName
				+ ", cardNumber=" + cardNumber + ", cvv=" + cvv + ", encryptedPassword=" + encryptedPassword
				+ ", emailVerificationToken=" + emailVerificationToken + ", emailVerificationStatus="
				+ emailVerificationStatus + "]";
	}
}
