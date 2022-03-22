package com.lti.appl.beans;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the QUESTIONS_DETAILS database table.
 * 
 */
@Entity
@Table(name="QUESTIONS_DETAILS")
@NamedQuery(name="Questions.findAll", query="SELECT q FROM Questions q")
public class Questions implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="QUESTIONID")
	private int questionid;

	@Column(name="ANSWER")
	private String answer;

	@Column(name="OPTIONA")
	private String optiona;

	@Column(name="OPTIONB")
	private String optionb;

	@Column(name="OPTIONC")
	private String optionc;

	@Column(name="OPTIOND")
	private String optiond;

	@Column(name="QUESTION")
	private String question;	
	
	//bi-directional many-to-one association to exam
	@ManyToOne
	@JoinColumn(name="EXAMID")
	private Exam exam;

	//bi-directional many-to-one association to Responses
	@OneToMany(mappedBy="questions",  cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<Responses> studentResponses;

	
	public Questions() {
	}
	

	public int getQuestionid() {
		return this.questionid;
	}

	public void setQuestionid(int questionid) {
		this.questionid = questionid;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getOptiona() {
		return this.optiona;
	}

	public void setOptiona(String optiona) {
		this.optiona = optiona;
	}

	public String getOptionb() {
		return this.optionb;
	}

	public void setOptionb(String optionb) {
		this.optionb = optionb;
	}

	public String getOptionc() {
		return this.optionc;
	}

	public void setOptionc(String optionc) {
		this.optionc = optionc;
	}

	public String getOptiond() {
		return this.optiond;
	}

	public void setOptiond(String optiond) {
		this.optiond = optiond;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Exam getexam() {
		return this.exam;
	}

	public void setexam(Exam exam) {
		this.exam = exam;
	}

	public Set<Responses> getStudentResponses() {
		return this.studentResponses;
	}

	public void setStudentResponses(Set<Responses> studentResponses) {
		this.studentResponses = studentResponses;
	}
	
	public Questions(int questionid, String answer, String optiona, String optionb, String optionc,
			String optiond, String question, Exam exam, Set<Responses> studentResponses) {
		super();
		this.questionid = questionid;
		this.answer = answer;
		this.optiona = optiona;
		this.optionb = optionb;
		this.optionc = optionc;
		this.optiond = optiond;
		this.question = question;
		this.exam = exam;
		this.studentResponses = studentResponses;
	}
	
	public Responses addStudentResponses(Responses studentResponses) {
		getStudentResponses().add(studentResponses);
		studentResponses.setQuestions(this);

		return studentResponses;
	}

	public Responses removeStudentResponses(Responses studentResponses) {
		getStudentResponses().remove(studentResponses);
		studentResponses.setQuestions(null);

		return studentResponses;
	}
	
	@Override
	public String toString() {
		return "Questions [questionid=" + questionid + ", answer=" + answer + ", optiona=" + optiona
				+ ", optionb=" + optionb + ", optionc=" + optionc + ", optiond=" + optiond + ", question=" + question
				+ "]";
	}

	

}