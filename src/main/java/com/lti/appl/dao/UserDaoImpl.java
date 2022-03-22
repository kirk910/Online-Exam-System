package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.lti.appl.beans.User;

@Repository
public class UserDaoImpl  implements UserDao {

	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional
	public User getOneUser(int userId) {
		User userdetail = entityManager.find(User.class, userId);
		return userdetail;
	}
	
	@Transactional
	public List<User> getAllUsers() {
		String s = "From User";
		Query query = entityManager.createQuery(s);
		List<User> userdetail = query.getResultList();
		return userdetail;
	}

	@Transactional
	public void addUser(User ref) {
		System.out.println(entityManager);
		entityManager.merge(ref);
		
	}

	@Transactional
	public void updateUserEmail(int userId, String newEmail) {
		User userdetail = entityManager.find(User.class, userId);
		userdetail.setEmail(newEmail);
		entityManager.merge(userdetail);
		
	}

	@Transactional
	public void updateUserPassword(int userId, String newPass) {
		User userdetail = entityManager.find(User.class, userId);
		userdetail.setPassword(newPass);
		entityManager.merge(userdetail);
		
	}

	@Transactional
	public void updateUserMobilNumber(int userId, String newMobileNumber) {
		User userdetail = entityManager.find(User.class, userId);
		userdetail.setMobile(newMobileNumber);
		entityManager.merge(userdetail);
		
	}

	@Transactional
	public void removeUser(int userId) {
		User userdetail = entityManager.find(User.class, userId);
		entityManager.remove(userdetail);
		
	}

	@Transactional
	public List<User> getuser(int userid) {
		
		 Query query =  entityManager.createQuery("FROM User  WHERE userid="+userid);
		 List<User> singleuserdetail = query.getResultList();
		 
		return singleuserdetail;
	}

	@Transactional
	public List<User> getuserswithstateandcity(String state, String city) {
		
		
		Query query =  entityManager.createQuery("FROM User  WHERE state= "+state+" and city = "+city);
		 List<User> singleuserdetail = query.getResultList();
		 
		return singleuserdetail;
	}

	@Transactional
	public User getOneUser(String email) {
		System.out.println("--------------------------------------------");
		System.out.println("getOneUSer(email) is called");
		System.out.println("--------------------------------------------");
		
		Query query =  entityManager.createQuery(" FROM User  WHERE email= "+"'"+email+"'");
		System.out.println("query created");
		 List<User> udList = query.getResultList();
		 User ud = udList.get(0);
		
		System.out.println("--------------------------------------------");
		System.out.println("Got the user");
		System.out.println("--------------------------------------------");
		return ud;
	}

	
	

	
	
}