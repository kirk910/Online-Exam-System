package com.lti.appl.dao;

public class ReportCardDto {

	private String fullName;
	private int marks;
	private String examLevel;						
	private String examSpec;
	private String status;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getExamLevel() {
		return examLevel;
	}
	public void setExamLevel(String examLevel) {
		this.examLevel = examLevel;
	}
	public String getExamSpec() {
		return examSpec;
	}
	public void setExamSpec(String examSpec) {
		this.examSpec = examSpec;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
