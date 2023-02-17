package com.demo.api.entity;

public class Register {

	private String name;
	private String username;
	private String email;
	private String password;
	private String role;
	public Register() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Register(String name, String username, String email, String password, String role) {
		super();
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Register [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
