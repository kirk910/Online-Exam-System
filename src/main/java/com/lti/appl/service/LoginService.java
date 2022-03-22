package com.lti.appl.service;


import com.lti.appl.dao.*;
import com.lti.appl.exception.OnlineExamException;


public interface LoginService {
	
	public UserInfoDto userLoginService(UserLoginDto ulDto) throws OnlineExamException;
	public AdminLoginDto adminLoginService(AdminLoginDto alDto) throws OnlineExamException;
	public String resetPasswordService(ResetPasswordDto rpDto) throws OnlineExamException;
	public String userRegisterService(UserRegisterDto rgDto ) throws  OnlineExamException;
	


}
