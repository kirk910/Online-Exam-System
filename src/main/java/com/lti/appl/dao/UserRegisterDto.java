package com.lti.appl.dao;


public class UserRegisterDto {
	
	private String fullName;
	private String email;
	private String password;
	private String mobile;
	private String city;
	private String dateOfBirth;
	private String state;
	private String qualification;
	private int yearOfCompletion;

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
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getYearOfCompletion() {
		return yearOfCompletion;
	}
	public void setYearOfCompletion(int yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}
	
	@Override
	public String toString() {
		return "UserRegisterDto [fullName=" + fullName + ", email=" + email + ", mobile=" + mobile + ", city=" + city
				+ ", dateOfBirth=" + dateOfBirth + ", state=" + state + ", qualification=" + qualification + ", yearOfCompletion="
				+ yearOfCompletion + "]";
	}

	
}
