package com.lti.appl.dao;

public class UserInfoDto extends UserRegisterDto{
	
	private int userId;
	private String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	

	
	
}
