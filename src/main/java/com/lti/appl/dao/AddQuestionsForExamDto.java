package com.lti.appl.dao;

import java.util.Set;

public class AddQuestionsForExamDto extends ExamInformationDto  {
	
	private Set<AddQuestionDto> questionsList;

	public Set<AddQuestionDto> getQuestionsList() {
		return questionsList;
	}

	public void setQuestionsList(Set<AddQuestionDto> questionsList) {
		this.questionsList = questionsList;
	}
	
}
