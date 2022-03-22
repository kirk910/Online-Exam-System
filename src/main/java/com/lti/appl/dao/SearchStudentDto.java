package com.lti.appl.dao;

public class SearchStudentDto {

	
	private String examSpecialization;
	private String state;
	private String city;
	private String levels;
	private int marks;
	
	
	public String getExamSpecialization() {
		return examSpecialization;
	}
	public void setExamSpecialization(String examSpecialization) {
		this.examSpecialization = examSpecialization;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLevels() {
		return levels;
	}
	public void setLevels(String levels) {
		this.levels = levels;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	
	
	
}
