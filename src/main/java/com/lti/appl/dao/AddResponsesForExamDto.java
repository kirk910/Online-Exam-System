package com.lti.appl.dao;


import java.util.Set;

public class AddResponsesForExamDto extends ExamInformationDto{

	 
	private Set<ResponseInfoDto> responseList;

	public Set<ResponseInfoDto> getResponseList() {
		return responseList;
	}

	public void setResponseList(Set<ResponseInfoDto> responseList) {
		this.responseList = responseList;
	}
	
	
}
