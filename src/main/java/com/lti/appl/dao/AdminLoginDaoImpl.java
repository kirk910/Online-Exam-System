package com.lti.appl.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.*;

@Repository
public class AdminLoginDaoImpl  implements AdminLoginDao{
	
	@PersistenceContext
	EntityManager EntityManager;

	@Transactional
	public AdminLogin getAdmin(String email) {

		AdminLogin adminLogin = EntityManager.find(AdminLogin.class, email);
		
		return adminLogin;
	}

}
