package com.demo.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class CustomerFeedback {

	@Id
	private Integer id;
	private String fullName;
	private String email;
	private String country;
	private String description;
	private int rate;
	public CustomerFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerFeedback(Integer id, String fullName, String email, String country, String description, int rate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.country = country;
		this.description = description;
		this.rate = rate;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getRate() {
		return rate;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}
	@Override
	public String toString() {
		return "CustomerFeedback [id=" + id + ", fullName=" + fullName + ", email=" + email + ", country=" + country
				+ ", description=" + description + ", rate=" + rate + "]";
	}
	
	
}
