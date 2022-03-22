package com.lti.appl.dao;

public class ExamInformationDto {
	
	private String examSpecialization;
	private String examLevel;
	private String examTime;
	private int passingMark;
	

	public String getExamLevel() {
		return this.examLevel;
	}
	
	public void setExamLevel(String examLevel) {
		this.examLevel = examLevel;
	}
	
	public String getExamSpecialization() {
		return this.examSpecialization;
	}
	
	public void setExamSpecialization(String examSpecialization) {
		this.examSpecialization = examSpecialization;
	}
	public int getPassingMark() {
		return this.passingMark;
	}
	
	public void setPassingMark(int passingMark) {
		this.passingMark = passingMark;
	}
	
	
	
	public String getExamTime() {
		return examTime;
	}
	
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}


}

