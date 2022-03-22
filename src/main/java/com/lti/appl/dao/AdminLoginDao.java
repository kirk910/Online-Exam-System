package com.lti.appl.dao;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.*;

@Repository
public interface AdminLoginDao  {
	
	
	public AdminLogin getAdmin(String email);

}
