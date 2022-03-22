package com.lti.appl.beans;


import java.io.Serializable;
import javax.persistence.*;

import java.util.Set;


/**
 * The persistent class for the EXAM_DETAILS database table.
 * 
 */
@Entity
@Table(name="EXAM_DETAILS")
@NamedQuery(name="Exam.findAll", query="SELECT e FROM Exam e")
public class Exam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EXAMID")
	private int examid;

	@Column(name="EXAM_LEVEL")
	private String examLevel;

	@Column(name="EXAM_SPECIALIZATION")
	private String examSpecialization;

	@Column(name="NUMBER_OF_QUESTIONS")
	private int numberOfQuestions;

	@Column(name="PASSING_MARK")
	private int passingMark;

	@Column(name="TIME")
	private String time;

	//bi-directional many-to-one association to QuestionsDetail
	@OneToMany(mappedBy="exam", cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<Questions> questions;

	//bi-directional many-to-one association to ReportCard
	@OneToMany(mappedBy="exam", cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<ReportCard> reportCards;
	

	public Exam() {
		System.out.println("Exams CONSTRUCTOR()..........");
	}

	public int getExamid() {
		return this.examid;
	}

	public void setExamid(int examid) {
		this.examid = examid;
	}

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

	public int getNumberOfQuestions() {
		return this.numberOfQuestions;
	}

	public void setNumberOfQuestions(int numberOfQuestions) {
		this.numberOfQuestions = numberOfQuestions;
	}

	public int getPassingMark() {
		return this.passingMark;
	}

	public void setPassingMark(int passingMark) {
		this.passingMark = passingMark;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Set<Questions> getQuestions() {
		return this.questions;
	}

	public void setQuestions(Set<Questions> questions) {
		this.questions = questions;
	}


	public Set<ReportCard> getReportCards() {
		return this.reportCards;
	}

	public void setReportCards(Set<ReportCard> reportCards) {
		this.reportCards = reportCards;
	}
	

/*
	 * public QuestionsDetail addQuestionsDetail(QuestionsDetail questionsDetail) {
	 * getQuestionsDetails().add(questionsDetail);
	 * questionsDetail.setExam(this);
	 * 
	 * return questionsDetail; }
	 * 
	 * public QuestionsDetail removeQuestionsDetail(QuestionsDetail questionsDetail)
	 * { getQuestionsDetails().remove(questionsDetail);
	 * questionsDetail.setExam(null);
	 * 
	 * return questionsDetail; }
	 */

	/*
	 * public ReportCard addReportCard(ReportCard reportCard) {
	 * getReportCards().add(reportCard); reportCard.setExam(this);
	 * 
	 * return reportCard; }
	 * 
	 * public ReportCard removeReportCard(ReportCard reportCard) {
	 * getReportCards().remove(reportCard); reportCard.setExam(null);
	 * 
	 * return reportCard; }
	 */

	@Override
	public String toString() {
		return "Exam [examid=" + examid + ", examLevel=" + examLevel + ", examSpecialization="
				+ examSpecialization + ", numberOfQuestions=" + numberOfQuestions + ", passingMark=" + passingMark
				+ ", time=" + time + "]";
	}
}
