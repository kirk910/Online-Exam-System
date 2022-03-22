package com.lti.appl.service;

import java.util.Set;

import com.lti.appl.dao.*;
import com.lti.appl.exception.OnlineExamException;


public interface ExamService{
	
	public String addQuestionsForExamService(AddQuestionsForExamDto aqeDto)  throws OnlineExamException ;
	public Set<QuestionDetailsDto> getAllquestionsForExamService(ExamInformationDto examInfoDto);
	public Set<ExamInformationDto> selectExamsService();
	public String deleteQuestionsForExamService(DeleteQuestionsForExamDto dqeDto) throws OnlineExamException;
	public ReportCardDto addResponsesService(AddResponsesForExamDto areDto);

}
