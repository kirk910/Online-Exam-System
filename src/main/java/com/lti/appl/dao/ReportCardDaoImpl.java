package com.lti.appl.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.appl.beans.*;

@Repository
public class ReportCardDaoImpl implements ReportCardDao {

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	

	
	@Transactional //this is imp
	public void addReportCard(ReportCard ref) {
		
		System.out.println(entityManager);
		entityManager.merge(ref);
		System.out.println("--------------------------------------------");
		System.out.println("report card added..........");
		System.out.println("--------------------------------------------");

	}

	
	
	
	@Transactional  //This is important 
	public void removeReportCard(int reportId) {

			Query query=entityManager.createQuery("delete from ReportCard where reportid="+reportId);
			int rowsDeleted=query.executeUpdate();
			System.out.println("------------------------------------------");
			System.out.println("removed using entity manager");
			System.out.println("------------------------------------------");
	}
	
		
	  @Transactional //get report cards of user
	  public List<ReportCard> getReportCards(int userid) { 
		  
		  Query query = entityManager.createQuery(" from ReportCard where userid= "+userid);
		  List<ReportCard> reportdetails = query.getResultList(); 
		  return reportdetails; 
	  }
	 	
	

	@Transactional //get all report cards
	public List<ReportCard> getAllReportCards() {
		
		Query query = entityManager.createQuery(" from ReportCard");
		List<ReportCard> reportdetails = query.getResultList();
		return reportdetails;
	}
	
}
