package com.example.appDemo.fullStackAppDemo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usersdetails")
public class UserEntity implements Serializable{
	private static final long serialVersionUID = 9008901114047645627L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="autoid")
	private long AutoId;
	@Column(name="userid",nullable=false)
	private String userId;
	@Column(nullable=false,length=50, name="firstname")
	private String firstName;
	@Column(nullable=false,length=50, name="lastname")
	private String lastName;
	@Column(nullable=false,length=120, name="email")
	private String email;
	@Column(nullable=false,length=120, name="phonenumber")
	private Long phoneNumber;
	@Column(nullable=true,length=120, name="alternatephonenumber")
	private Long alternatePhoneNumber;
	@Column(nullable=false,length=120, name="adderessline")
	private String adderessline;
	@Column(nullable=false,length=120, name="pincode")
	private Long pincode;
	@Column(nullable=false,length=120, name="city")
	private String city;
	@Column(length=120, name="accountnumber")
	private Long accountNumber;
	@Column(length=120, name="bankname")
	private String BankName;
	@Column(length=120, name="cardnumber")
	private Long cardNumber;
	@Column(length=120, name="cvv")
	private Long cvv;
	@Column(nullable=false, name="encryptedpassword")
	private String encryptedPassword;
	@Column(name="emailverificationtoken")
	private String emailVerificationToken;
	@Column(nullable=false, name="emailverificationstatus")
	private Boolean emailVerificationStatus = false;
	public UserEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserEntity(long autoId, String userId, String firstName, String lastName, String email, Long phoneNumber,
			Long alternatePhoneNumber, String adderessline, Long pincode, String city, Long accountNumber,
			String bankName, Long cardNumber, Long cvv, String encryptedPassword, String emailVerificationToken,
			Boolean emailVerificationStatus) {
		super();
		AutoId = autoId;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.adderessline = adderessline;
		this.pincode = pincode;
		this.city = city;
		this.accountNumber = accountNumber;
		BankName = bankName;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.encryptedPassword = encryptedPassword;
		this.emailVerificationToken = emailVerificationToken;
		this.emailVerificationStatus = emailVerificationStatus;
	}
	public long getAutoId() {
		return AutoId;
	}
	public void setAutoId(long autoId) {
		AutoId = autoId;
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
	public String getAdderessline() {
		return adderessline;
	}
	public void setAdderessline(String adderessline) {
		this.adderessline = adderessline;
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
		return BankName;
	}
	public void setBankName(String bankName) {
		BankName = bankName;
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
		return "UserEntity [AutoId=" + AutoId + ", userId=" + userId + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", alternatePhoneNumber="
				+ alternatePhoneNumber + ", adderessline=" + adderessline + ", pincode=" + pincode + ", city=" + city
				+ ", accountNumber=" + accountNumber + ", BankName=" + BankName + ", cardNumber=" + cardNumber
				+ ", cvv=" + cvv + ", encryptedPassword=" + encryptedPassword + ", emailVerificationToken="
				+ emailVerificationToken + ", emailVerificationStatus=" + emailVerificationStatus + "]";
	}
}
