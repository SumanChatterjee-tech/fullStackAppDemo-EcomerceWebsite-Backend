package com.example.appDemo.fullStackAppDemo.model;

public class userResponse {
	private String userId;
	private String email;
	private String firstName;
	private String lastName;
	private Long phoneNumber;
	private Long alternatePhoneNumber;
	private String adderessLine;
	private Long pincode;
	private String city;
	
	public userResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public userResponse(String userId, String email, String firstName, String lastName, Long phoneNumber,
			Long alternatePhoneNumber, String adderessLine, Long pincode, String city) {
		super();
		this.userId = userId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.alternatePhoneNumber = alternatePhoneNumber;
		this.adderessLine = adderessLine;
		this.pincode = pincode;
		this.city = city;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
	
}
