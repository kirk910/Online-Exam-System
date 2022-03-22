package com.lti.appl.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the STUDENT_RESPONSES database table.
 * 
 */
@Entity
@Table(name="STUDENT_RESPONSES")
@NamedQuery(name="Responses.findAll", query="SELECT s FROM Responses s")
public class Responses implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="RESPONSEID")
	private int responseid;

	@Column(name="QUESTION_STATUS")
	private int questionStatus;

	@Column(name="RESPONSE")
	private String response;

	//bi-directional many-to-one association to QuestionsDetail
	@ManyToOne
	@JoinColumn(name="QUESTIONID")
	private Questions questions;

	//bi-directional many-to-one association to user
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;

	
	public Responses() {
		super();
	}
	

	public int getResponseid() {
		return this.responseid;
	}

	public void setResponseid(int responseid) {
		this.responseid = responseid;
	}

	public int getQuestionStatus() {
		return this.questionStatus;
	}

	public void setQuestionStatus(int questionStatus) {
		this.questionStatus = questionStatus;
	}

	public String getResponse() {
		return this.response;
	}

	public void setResponse(String response) {
		this.response = response;
	}

	public Questions getQuestions() {
		return this.questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}

	public User getuser() {
		return this.user;
	}

	public void setuser(User user) {
		this.user = user;
	}
	

	@Override
	public String toString() {
		return "Responses [responseid=" + responseid + ", questionStatus=" + questionStatus + ", response="
				+ response + "]";
	}
	
}