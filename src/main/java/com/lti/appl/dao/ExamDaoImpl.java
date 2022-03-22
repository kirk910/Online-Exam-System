package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.beans.Exam;


@Repository
public class ExamDaoImpl implements ExamDao {
	
	@PersistenceContext
	EntityManager entityManager;

	
	//ExamDetails Started
	
	@Transactional
	public Exam getOneExam(int ExamId) {
		Exam examdetail = entityManager.find(Exam.class, ExamId);
		return examdetail;
	}

	@Transactional
	public List<Exam> getAllExams() {
		
			Query query = entityManager.createQuery(" from Exam");
			List<Exam>  examdetail = query.getResultList();
			return examdetail;
		
	}

	@Transactional
	public void addExam(Exam ref) {
			System.out.println(entityManager);
			entityManager.persist(ref);
		
	}

	@Transactional
	public void removeExam(int ExamId) {
		Exam examdetail = entityManager.find(Exam.class, ExamId);
		entityManager.remove(examdetail);
		
	}
	
	
	@Transactional
	public Exam getOneExam(String examspecialization, String examlevel) {
		Query query =  entityManager.createQuery("FROM Exam  WHERE EXAM_SPECIALIZATION = '"+examspecialization+"' and EXAM_LEVEL = '"+examlevel+"'");
		
		System.out.println("query created");
		 List<Exam> udList = query.getResultList();
		 
		Exam ed = udList.get(0);
		
		System.out.println("--------------------------------------------");
		System.out.println("Got the exam");
		System.out.println("--------------------------------------------");
		System.out.println(ed);
		return ed;

		
	}


}
