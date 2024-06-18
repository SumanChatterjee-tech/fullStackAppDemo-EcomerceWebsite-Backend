package com.example.appDemo.fullStackAppDemo.model;

public class Changepassword {
	private String email;
	private String password;
	public Changepassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Changepassword(String email, String password) {
		super();
		this.email = email;
		this.password = password;
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
	@Override
	public String toString() {
		return "Changepassword [email=" + email + ", password=" + password + "]";
	}
}
