package com.lti.appl.service;


import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.beans.*;
import com.lti.appl.dao.*;
import com.lti.appl.exception.OnlineExamException;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	UserDao udRepo;
	
	@Autowired
	AdminLoginDao alRepo;
	

	
	@Override
	public UserInfoDto userLoginService(UserLoginDto ulDto) throws OnlineExamException{
		
		
			UserInfoDto userInfoDto = new UserInfoDto();
			try {
				String email = ulDto.getUserEmail();
				String password = ulDto.getPassword();
				
				User udRef;
				try {
					udRef = udRepo.getOneUser(email);
					userInfoDto.setStatus("Y");
				} catch (Exception e) {
					throw new OnlineExamException("Invalid Credentials");
				} 
				System.out.println("====================================");
				System.out.println("got the udRef :"+udRef.getPassword()+"  userid "+udRef.getUserid());
				System.out.println("====================================");
				
				System.out.println("====================================");
				System.out.println("ulDto :"+ulDto.getPassword());
				System.out.println("====================================");
				
				
				if(password.equals(udRef.getPassword())) {
					userInfoDto.setUserId(udRef.getUserid());
					userInfoDto.setEmail(udRef.getEmail());
					
					System.out.println("PasswordMatched");
				}else {
					userInfoDto.setStatus("N");
				}
			} catch (OnlineExamException e) {
				userInfoDto.setStatus("N");
			}
			
		return userInfoDto;		
	}


	@Override
	public AdminLoginDto adminLoginService(AdminLoginDto alDto) throws OnlineExamException {
		
		AdminLoginDto adminLoginDto = new AdminLoginDto();
		try {
			String email = alDto.getAdminEmail();
			String password = alDto.getPassword(); 
			
			AdminLogin alRef;
			
				try {
					alRef = alRepo.getAdmin(email);
					adminLoginDto.setStatus("Y");
				} catch (Exception e) {
					throw new OnlineExamException("Invalid details");
				}
			
				
			if(password.equals(alRef.getPassword())) {
				adminLoginDto.setAdminEmail(alRef.getEmail());
				System.out.println("PasswordMatched");
			}else {
				adminLoginDto.setStatus("N");
			}
		} catch (OnlineExamException e) {
			adminLoginDto.setStatus("N");
		}
		
	return adminLoginDto;	
	}


	@Override
	public String resetPasswordService(ResetPasswordDto rpDto) throws OnlineExamException{ //In rpDto in  email and newpassword
		
		try {
		
				User uRef = udRepo.getOneUser(rpDto.getEmail());//based pm email we get one user(in user we have uerid)
				//for update password we need userid and password
				udRepo.updateUserPassword(uRef.getUserid(), rpDto.getNewPassword());
			
				return "Password changed successfully";
	
			
			
			
		} catch (Exception e) {
	
			throw new OnlineExamException("Invalid email-Id");
		}

	}
	
	@Override
	public String userRegisterService(UserRegisterDto rgDto) throws OnlineExamException {

		List<User> user = udRepo.getAllUsers();
		
		try {
	
			User userdetail = new User();
						
			userdetail.setEmail(rgDto.getEmail());
			System.out.println(rgDto.getEmail());
			userdetail.setFullname(rgDto.getFullName());
			System.out.println(rgDto.getFullName());
			userdetail.setPassword(rgDto.getPassword());
			System.out.println(rgDto.getPassword());
	        
			//System.out.println(sqlDate);
			userdetail.setCity(rgDto.getCity());
			System.out.println(rgDto.getCity());
			userdetail.setMobile(rgDto.getMobile());
			System.out.println(rgDto.getMobile());
			userdetail.setQualification(rgDto.getQualification());
			System.out.println(rgDto.getQualification());
			userdetail.setYearOfCompletion(rgDto.getYearOfCompletion());
			System.out.println(rgDto.getYearOfCompletion());
			userdetail.setState(rgDto.getState());
			System.out.println(rgDto.getState());
			System.out.println(rgDto.getDateOfBirth());
			Date date = new SimpleDateFormat("yyyy-MM-dd").parse(rgDto.getDateOfBirth());
	        java.sql.Date sqlDate = new java.sql.Date(date.getTime());	
	       
			userdetail.setDateOfBirth(sqlDate);
			System.out.println(sqlDate);
			
			udRepo.addUser(userdetail);
			
			
			System.out.println("------------------------------------------");
			System.out.println("User Registered");
			System.out.println("------------------------------------------");
			return "User registered";
		
		} catch (Exception e) {
	
			throw new OnlineExamException("Unable to register"+ e);
		}
	
	
		


	}
	
}
	