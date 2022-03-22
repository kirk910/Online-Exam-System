package com.lti.appl.service;

import java.util.ArrayList;
import java.util.HashSet;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.appl.beans.*;
import com.lti.appl.dao.*;
import com.lti.appl.exception.OnlineExamException;


@Service
public class ExamServiceImpl implements ExamService {

	@Autowired
	UserDao udRepo;
	
	@Autowired
	QuestionsDao qdRepo;
	
	@Autowired
	ExamDao edRepo;
	
	@Autowired
	ResponsesDao srRepo;

	@Autowired
	ReportCardService rcSer;

	@Override
	public String addQuestionsForExamService(AddQuestionsForExamDto aqeDto) throws OnlineExamException {
		
		
		Exam exam = edRepo.getOneExam(aqeDto.getExamSpecialization(),	aqeDto.getExamLevel());//Fetching exam based on specializationa and level
		
		for( AddQuestionDto addQuestionDto : aqeDto.getQuestionsList()) {
			
			try {
				Questions questionDetail = new Questions();
				questionDetail.setQuestion(addQuestionDto.getQuestion());
				questionDetail.setOptiona(addQuestionDto.getOptionA());
				questionDetail.setOptionb(addQuestionDto.getOptionB());
				questionDetail.setOptionc(addQuestionDto.getOptionC());
				questionDetail.setOptiond(addQuestionDto.getOptionD());
				questionDetail.setAnswer(addQuestionDto.getAnswer());
				questionDetail.setexam(exam);
				qdRepo.addQuestion(questionDetail);
				
				System.out.println("------------------------------------------");
				System.out.println("Questions added");
				System.out.println("------------------------------------------");
				
			} catch (Exception e) {
				System.out.println("Error: Unable to add the Questions");
				throw new OnlineExamException("N");
			}	
			
		}
		return "Y";
	}


	@Override
	public Set<QuestionDetailsDto> getAllquestionsForExamService(ExamInformationDto examInfoDto){
			
			Exam exam = edRepo.getOneExam(examInfoDto.getExamSpecialization(), examInfoDto.getExamLevel());
			System.out.println(exam.getExamid());
			List<Questions> questionList = qdRepo.getQuestions(exam.getExamid());
			Set<QuestionDetailsDto> questionListDto = new HashSet<QuestionDetailsDto>();
			
			for(Questions question: questionList) {
				
				QuestionDetailsDto questionDetailDto = new QuestionDetailsDto();
				questionDetailDto.setQuestionid(question.getQuestionid());
				questionDetailDto.setQuestion(question.getQuestion());
				questionDetailDto.setOptionA(question.getOptiona());
				questionDetailDto.setOptionB(question.getOptionb());
				questionDetailDto.setOptionC(question.getOptionc());
				questionDetailDto.setOptionD(question.getOptiond());
				questionDetailDto.setExamLevel(examInfoDto.getExamLevel());
				questionDetailDto.setExamSpecialization(examInfoDto.getExamSpecialization());
				questionDetailDto.setExamTime(examInfoDto.getExamTime());
				
				questionListDto.add(questionDetailDto);
			}
			return questionListDto;		
	}
	
	@Override//will return all the available exams 
	public Set<ExamInformationDto> selectExamsService(){
		
		List<Exam> allExams = edRepo.getAllExams();
		
		Set<ExamInformationDto> allExamsDto = new HashSet<ExamInformationDto>();
		
		for(Exam exam : allExams) {
			ExamInformationDto examInfoDto = new ExamInformationDto();
			
			examInfoDto.setExamLevel(exam.getExamLevel());
			examInfoDto.setExamSpecialization(exam.getExamSpecialization());
			examInfoDto.setExamTime(exam.getTime());
			examInfoDto.setPassingMark(exam.getPassingMark());
			
			allExamsDto.add(examInfoDto);
			
		}
		
		
		return allExamsDto;
		
	}
	
	@Override
	public String deleteQuestionsForExamService(DeleteQuestionsForExamDto dqeDto) throws OnlineExamException{
		
		
			try {
				Exam exam = edRepo.getOneExam(dqeDto.getExamSpecialization(), dqeDto.getExamLevel());
				qdRepo.deleteQuestionsByExam(exam.getExamid());
				return "questions deleted";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				throw new OnlineExamException("Not deleted");
				
			
			}
		
	}
	

	@Override
	public ReportCardDto addResponsesService(AddResponsesForExamDto areDto) {
		
		
		Set<ResponseInfoDto> riDtoList = areDto.getResponseList();
		
		
		
		List<Responses> srAddedList = new ArrayList<Responses>();
		
		Exam exam = edRepo.getOneExam(areDto.getExamSpecialization(), areDto.getExamLevel());
		 
		System.out.println(exam.getExamid());
		
		
		int userIdforReportCard=0;
		
		
		for (ResponseInfoDto responseInfoDto : riDtoList) {
			
			int userId = responseInfoDto.getUserId();
			int questionId = responseInfoDto.getQuestionId();
			
			User userDetail = udRepo.getOneUser(userId);
			Questions questionsDetail = qdRepo.getOneQuestion(questionId);
		
			Responses sr = new Responses();
			
			sr.setuser(userDetail);
			sr.setQuestions(questionsDetail);
			sr.setResponse(responseInfoDto.getResponse());
			System.out.println("the above one .......");
			String answer = questionsDetail.getAnswer();
			System.out.println("the below.......");
			int responseStatus = 0;
			
			if(answer.equalsIgnoreCase(responseInfoDto.getResponse())) {	
				responseStatus = 1;
			}
			System.out.println("-------------------------------------------------------------------");
			System.out.println("Dto questionid : "+questionId);
			System.out.println("db questionid : "+questionsDetail.getQuestionid());
			System.out.println("Dto response : "+responseInfoDto.getResponse());
			System.out.println("db answer : "+questionsDetail.getAnswer());
			System.out.println("responsStatus : "+responseStatus);
			System.out.println("-------------------------------------------------------------------");
			
			sr.setQuestionStatus(responseStatus);
			
			srRepo.addstudentresponses(sr);
			
			Responses studentRespons = srRepo.getsingleresponse(userId,questionId );
			srAddedList.add(studentRespons);
			
			
			userIdforReportCard = userId;
			
		}
		
	
		rcSer.generateReportCard(exam.getExamid(), userIdforReportCard);
		
		
		Set<ReportCardDto> rcList = rcSer.getReportCardService(userIdforReportCard);
		ReportCardDto rcForThisExam = new ReportCardDto();
		
		
		for(ReportCardDto rcDto : rcList) {
			int rcDtoExamID = edRepo.getOneExam(rcDto.getExamSpec(), rcDto.getExamLevel()).getExamid();
			if(exam.getExamid() == rcDtoExamID) {
				
				rcForThisExam = rcDto;
			}
		}
		return rcForThisExam;
	}
	
	


}
