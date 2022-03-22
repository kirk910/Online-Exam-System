package com.lti.appl.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.appl.beans.*;

@Repository
public interface ResponsesDao {
	
	//StudentResponses Operations
	 
		public List<Responses> getResponses(int userId); 	   //1. to get a single student response using userid
		public List<Responses> getallresponses();		       //2. to get all the responses
		public void addstudentresponses(Responses resp);	   //3. to add the new student responses depend upon user id
		public void removeStudentresponse(int responseId);	       //4. to remove a student response
		public  Responses getsingleresponse(int userid, int questionid);  //to get a single student response
	
	
	
	
}


