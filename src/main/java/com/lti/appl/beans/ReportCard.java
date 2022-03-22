package com.lti.appl.beans;


import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;


/**
 * The persistent class for the REPORT_CARD database table.
 * 
 */
@Entity
@Table(name="REPORT_CARD")
@NamedQuery(name="ReportCard.findAll", query="SELECT r FROM ReportCard r")
public class ReportCard implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REPORTID")
	private int reportid;

	@Column(name="EXAM_DATE")
	private LocalDate examDate = LocalDate.now();

	@Column(name="MARKS")
	private int marks;

	@Column(name="STATUS")
	private String status;

	//bi-directional many-to-one association to Exam
	@ManyToOne
	@JoinColumn(name="EXAMID")
	private Exam exam;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="USERID")
	private User user;
	

	public ReportCard() {
	}

	
	public int getReportid() {
		return this.reportid;
	}

	public void setReportid(int reportid) {
		this.reportid = reportid;
	}

	public LocalDate getExamDate() {
		return this.examDate;
	}

	public void setExamDate(LocalDate examDate) {
		this.examDate = examDate;
	}

	public int getMarks() {
		return this.marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Exam getExam() {
		return this.exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "ReportCard [reportid=" + reportid + ", examDate=" + examDate + ", marks=" + marks + ", status=" + status
				+ "]";
	}
	
}