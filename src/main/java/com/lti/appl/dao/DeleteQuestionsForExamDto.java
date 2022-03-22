package com.lti.appl.dao;

import java.util.Set;

public class DeleteQuestionsForExamDto extends ExamInformationDto {
	 
	private Set<DeleteQuestionDto> questionsList;
	
	public Set<DeleteQuestionDto> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(Set<DeleteQuestionDto> questionsList) {
		this.questionsList = questionsList;
	}
	
	
}

