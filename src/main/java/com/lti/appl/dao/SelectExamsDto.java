package com.lti.appl.dao;

import java.util.Set;

public class SelectExamsDto {
	
	private Set<ExamInformationDto> examsList;

	public Set<ExamInformationDto> getExamsList() {
		return examsList;
	}

	public void setExamsList(Set<ExamInformationDto> examsList) {
		this.examsList = examsList;
	}
	
	

}
