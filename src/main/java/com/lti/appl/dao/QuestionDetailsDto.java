package com.lti.appl.dao;

public class QuestionDetailsDto extends ExamInformationDto {

	private int questionid;
	private String question;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	
	


	public int getQuestionid() {
		return this.questionid;
	}
	
	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}
	
	public String getOptionA() {
		return this.optionA;
	}
	
	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}
	
	public String getOptionB() {
		return this.optionB;
	}
	
	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}
	
	public String getOptionC() {
		return this.optionC;
	}
	
	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}
	
	public String getOptionD() {
		return this.optionD;
	}
	
	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public void setQuestion(String question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "QuestionDetailsDto [questionid=" + questionid + ", question=" + question + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC + ", optionD=" + optionD + "]";
	}
	
	
}