package com.lti.appl.service;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.beans.*;
import com.lti.appl.dao.*;




@Service
public class ReportCardServiceImpl implements ReportCardService {
	
	
	@Autowired
	ReportCardDao rcRepo;
	
	@Autowired
	ExamDao edRepo;
	
	@Autowired
	UserDao udRepo;
	
	@Autowired
	ResponsesDao srRepo;
	
	
	@Override
	public Set<ReportCardDto> getReportCardService(int userId) {

	
		List<ReportCard> reportCardList = rcRepo.getReportCards(userId);
		Set<ReportCardDto> reportCardDtoList = new HashSet<ReportCardDto>();
		
		for(ReportCard reportCard: reportCardList) {
			ReportCardDto reportCardDto = new ReportCardDto();
			reportCardDto.setExamLevel(reportCard.getExam().getExamLevel());
			reportCardDto.setExamSpec(reportCard.getExam().getExamSpecialization());
			reportCardDto.setFullName(reportCard.getUser().getFullname());
			reportCardDto.setMarks(reportCard.getMarks());
			reportCardDto.setStatus(reportCard.getStatus());
			
			reportCardDtoList.add(reportCardDto);
		}
		 
		return reportCardDtoList;
	}

	@Override
	public Set<UserInfoDto> searchStudentService(SearchStudentDto ssDto) {
		
		
		Exam examFromDto = edRepo.getOneExam(ssDto.getExamSpecialization(), ssDto.getLevels());
		int cutOffMarksFromDto = ssDto.getMarks();
		List<ReportCard> reportCardList = rcRepo.getAllReportCards();
		Set<UserInfoDto> uiDtoList = new HashSet<UserInfoDto>();
		System.out.println("---------------------------------");
		System.out.println("Got ReportCards : ");
		System.out.println("---------------------------------");
		
		for(ReportCard rc : reportCardList) {
			
			int rcExamId = rc.getExam().getExamid();
			String rcState = rc.getUser().getState();
			String rcCity = rc.getUser().getCity();
			System.out.println("---------------------------------");
			System.out.println("Got state and city : ");
			System.out.println("---------------------------------");
			if((rcExamId == examFromDto.getExamid()) && (rc.getMarks() >= cutOffMarksFromDto)) {
				System.out.println("---------------------------------");
				System.out.println("first if");
				System.out.println("---------------------------------");
				
				if((rcState.equalsIgnoreCase(ssDto.getState())) && (rcCity.equalsIgnoreCase(ssDto.getCity()))) {
					System.out.println("---------------------------------");
					System.out.println("Second if condition : ");
					System.out.println("---------------------------------");
					
					User rcUser = rc.getUser();
					UserInfoDto uiDto = new UserInfoDto();
					uiDto.setFullName(rcUser.getFullname());
					uiDto.setEmail(rcUser.getEmail());
					uiDto.setMobile(rcUser.getMobile());
					uiDto.setCity(rcUser.getCity());
					uiDto.setState(rcUser.getState());
					uiDtoList.add(uiDto);
				}
				

			}
		}
		return uiDtoList;
		
	}

	@Override
	public String generateReportCard(int examid, int userid) {
		
				//fetching exam and user details
				Exam exam = edRepo.getOneExam(examid);
				User user = udRepo.getOneUser(userid);
				System.out.println("----------------------------------------------------------");
				System.out.println("user : "+user);
				System.out.println("----------------------------------------------------------");
				
				Set<Questions> qList = exam.getQuestions();
				List<Responses> srList = new ArrayList<Responses>();
				List<Responses> allsrList = srRepo.getResponses(userid);
				System.out.println("----------------------------------------------------------");
				System.out.println("response list length : "+allsrList.size());
				System.out.println("----------------------------------------------------------");
				
				for(Responses rs : allsrList) {
					for(Questions qd : qList) {
						int qId = qd.getQuestionid();
						if(qId == rs.getQuestions().getQuestionid()) {
							srList.add(rs);
						}
					}
					
				}
				
				//calculating the marks obtained by the user for the exam he submitted using the responses he has given.
				int marks = 0;
				String status = null;
				for(Responses sr : srList) {
					marks = marks+sr.getQuestionStatus();
					System.out.println(marks);
					System.out.println("------------------------------------------------------");
					System.out.println("Userid: "+sr.getuser().getUserid());
					System.out.println("questionid : "+sr.getQuestions().getQuestionid());
					System.out.println("status : " +sr.getQuestionStatus());
					System.out.println("Marks : "+marks);
					System.out.println("------------------------------------------------------");
				}
				
				System.out.println("Marks : "+marks);
				//Checking weather user cleared the exam or not
				if(marks < exam.getPassingMark()) {
					status = "FAIL";
				}
				else {
					status="PASS";
				}
				
				//creating a new reportcard and inserting required values. and adding it to database
				ReportCard newRC = new ReportCard();
				newRC.setExam(exam);
				newRC.setMarks(marks);
				newRC.setStatus(status);
				newRC.setUser(user);
				
				rcRepo.addReportCard(newRC);
				System.out.println("----------------------------------------------------");
				System.out.println("ReportCard added : "+newRC);
				System.out.println("----------------------------------------------------");
				return "report card generated";
	}



}
