package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.beans.*;

@Repository
public class ResponsesDaoImpl implements ResponsesDao {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Transactional
    public void addstudentresponses(Responses resp) { //3. to add new student responses
        
        System.out.println(entityManager);
        //entityManager.persist(resp);
        entityManager.merge(resp);
    }
	
	@Transactional
    public void removeStudentresponse(int responseid) {	//4.to remove student responses
        Query query=entityManager.createQuery("delete from Responses where responseid="+responseid);
        int rowsDeleted=query.executeUpdate();
        System.out.println("------------------------------------------");
        System.out.println("removed using entity manager");
        System.out.println("------------------------------------------");
    }
	
	
	 @Transactional //1. to get only one user response	
 	 public List<Responses> getResponses(int userId) {
		 Query query =  entityManager.createQuery("FROM Responses WHERE userid="+userId); 
		 System.out.println("Query generated...");
		 List<Responses> stdlist = query.getResultList();
		 System.out.println("List has generated...");
		 
		 return stdlist;
	 }

	@Transactional
	public List<Responses> getallresponses() {	//2. to get all the responses
		Query query = entityManager.createQuery(" from Responses");
		List<Responses> sr = query.getResultList();
		return sr;
	}


	@Override
	public Responses getsingleresponse(int userid, int questionid) {
		Query query = entityManager.createQuery(" FROM Responses WHERE userid = "+userid+" and questionid = "+questionid);
		List<Responses> srList = query.getResultList();
		return srList.get(0);
	}


}


