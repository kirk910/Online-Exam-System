package com.lti.appl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.Exam;
import com.lti.appl.beans.Questions;
import com.lti.appl.beans.Responses;
import com.lti.appl.beans.User;

@Repository
public interface UserDao {

	//UserDetails Operations
	public User getOneUser(int userId);
	public User getOneUser(String email);
	public List<User> getAllUsers();
	public void addUser(User ref);
	public void updateUserEmail(int userId, String newEmail);
	public void updateUserPassword(int userId, String newPass);
	public void updateUserMobilNumber(int userId, String newMobileNumber);
	public void removeUser(int userId);
	public List<User> getuser(int userid);//not required
	public List<User> getuserswithstateandcity(String State ,String city);
	
		
}
