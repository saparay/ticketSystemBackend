package com.demo.api.entity;

public class Login {

	private String usernameOrEmail;
	private String password;
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Login(String usernameOrEmail, String password) {
		super();
		this.usernameOrEmail = usernameOrEmail;
		this.password = password;
	}
	public String getUsernameOrEmail() {
		return usernameOrEmail;
	}
	public void setUsernameOrEmail(String usernameOrEmail) {
		this.usernameOrEmail = usernameOrEmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Login [usernameOrEmail=" + usernameOrEmail + ", password=" + password + "]";
	}
	
}
