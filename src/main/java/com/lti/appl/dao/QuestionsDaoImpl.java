package com.lti.appl.dao;
import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.beans.*;


@Repository
public class QuestionsDaoImpl implements QuestionsDao {
	
	@PersistenceContext
	EntityManager entityManager;

	@Transactional//imp1
	public List<Questions> getQuestions(int examId) {		
		System.out.println("----------------------------------------------------");
		System.out.println("GetQuestions() is called");
		System.out.println("----------------------------------------------------");
		
		//Query query =  entityManager.createQuery("select q.questionid,q.answer FROM QuestionsDetail q WHERE q.examDetail.examid="+examId);	
		
		Query query =  entityManager.createQuery(" FROM Questions  WHERE examid="+examId);
		
		//query.setParameter("tid","examid");
		List<Questions> quesList = query.getResultList();
		
		System.out.print(quesList);
		
		return quesList;		
	}
	
	@Transactional//imp2
	public Questions getOneQuestion(int qId) {		
		Questions question = entityManager.find(Questions.class, qId);
		
		return question;
		
	}

	@Transactional//imp3
	public void addQuestion(Questions question) {
		entityManager.persist(question);
	}
	

	
	
	
	  @Transactional 
	  public void deleteQuestion(int questionId) {
		  System.out.println("------------------------------------------");
		  System.out.println("deleteQuestion() called");
		  System.out.println("------------------------------------------");
		  
		  
		  Questions question = entityManager.find(Questions.class, questionId);
		  entityManager.remove(question);
		  
		  
		  
		  System.out.println("------------------------------------------");
		  System.out.println("removed using entity manager");
		  System.out.println("------------------------------------------"); }
	 
	
	
	@Transactional//imp4
	public void deleteQuestionByHql(int questionId) {
		Query query=entityManager.createQuery(" delete from Questions where questionid= "+questionId);
		int rowsDeleted=query.executeUpdate();
		System.out.println(+rowsDeleted+"----------------------------------------");
		System.out.println("removed the question");
		System.out.println("------------------------------------------");
	}
		
	

	
	
	
	  @Transactional //imp5
	  public void updateQuestion(Questions question) {
			System.out.println("--------------------------------------------------");
			System.out.println("updateQuestion() called");
			System.out.println("--------------------------------------------------");
		    entityManager.merge(question);
			System.out.println("--------------------------------------------------");
			System.out.println("updated the question ");
			System.out.println("--------------------------------------------------");
	  
	  }
	  
	  @Transactional//imp7
	  public void deleteQuestionsByExam(int examId) {
		  
		  Query query=entityManager.createQuery("delete from Questions where examid="+examId);
		  int rowsDeleted=query.executeUpdate();
		  System.out.println("------------------------------------------");
		  System.out.println("No of question removed : "+rowsDeleted);
		  System.out.println("removed questions in the exam : "+examId);
		  System.out.println("------------------------------------------");
		  
		  
	  }


}
