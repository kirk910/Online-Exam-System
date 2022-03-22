package com.lti.appl.beans;


import java.io.Serializable;


import javax.persistence.*;

import java.util.Date;
import java.util.Set;

/**
 * The persistent class for the USER_DETAILS database table.
 * 
 */
@Entity
@Table(name="USER_DETAILS")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="USERID")
	private int userid;

	@Column(name="CITY")
	private String city;

	@Temporal(value=TemporalType.DATE)
	@Column(name="DATE_OF_BIRTH")
	private Date dateOfBirth;

	@Column(name="EMAIL")
	private String email;

	@Column(name="FULLNAME")
	private String fullname;

	@Column(name="MOBILE")
	private String mobile;

	@Column(name="PASSWORD")
	private String password;

	@Column(name="QUALIFICATION")
	private String qualification;

	@Column(name="STATE")
	private String state;

	@Column(name="YEAR_OF_COMPLETION")
	private int yearOfCompletion;


	//bi-directional many-to-one association to ReportCard
	@OneToMany(mappedBy="user",cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<ReportCard> reportCards;

	//bi-directional many-to-one association to StudentRespons
	@OneToMany(mappedBy="user", cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private Set<Responses> studentResponses; 

	
	public User() {
		System.out.println("USER CONSTRUCTOR is  called .......");
	}

	public User(int userid, String city, Date dateOfBirth, String email, String fullname, String mobile,
			String password, String qualification, String state, int yearOfCompletion, Set<ReportCard> reportCards,
			Set<Responses> studentResponses) {
		super();
		this.userid = userid;
		this.city = city;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.fullname = fullname;
		this.mobile = mobile;
		this.password = password;
		this.qualification = qualification;
		this.state = state;
		this.yearOfCompletion = yearOfCompletion;
		this.reportCards = reportCards;
		this.studentResponses = studentResponses;
	}

	public User(String city, Date dateOfBirth, String email, String fullname, String mobile, String password,
			String qualification, String state, int yearOfCompletion, Set<ReportCard> reportCards,
			Set<Responses> studentResponses) {
		super();
		this.city = city;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.fullname = fullname;
		this.mobile = mobile;
		this.password = password;
		this.qualification = qualification;
		this.state = state;
		this.yearOfCompletion = yearOfCompletion;
		this.reportCards = reportCards;
		this.studentResponses = studentResponses;
	}

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQualification() {
		return this.qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getYearOfCompletion() {
		return this.yearOfCompletion;
	}

	public void setYearOfCompletion(int yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	public Set<ReportCard> getReportCards() {
		return this.reportCards;
	}

	public void setReportCards(Set<ReportCard> reportCards) {
		this.reportCards = reportCards;
	}

	public ReportCard addReportCard(ReportCard reportCard) {
		getReportCards().add(reportCard);
		reportCard.setUser(this);

		return reportCard;
	}

	public ReportCard removeReportCard(ReportCard reportCard) {
		getReportCards().remove(reportCard);
		reportCard.setUser(null);

		return reportCard;
	}

	public Set<Responses> getStudentResponses() {
		return this.studentResponses;
	}

	public void setStudentResponses(Set<Responses> studentResponses) {
		this.studentResponses = studentResponses;
	}

	public Responses addStudentResponses(Responses studentResponses) {
		getStudentResponses().add(studentResponses);
		studentResponses.setuser(this);

		return studentResponses;
	}

	public Responses removeStudentResponses(Responses studentResponses) {
		getStudentResponses().remove(studentResponses);
		studentResponses.setuser(null);

		return studentResponses;
	}
	@Override
	public String toString() {
		return "User [userid=" + userid + ", city=" + city + ", dateOfBirth=" + dateOfBirth + ", email=" + email
				+ ", fullname=" + fullname + ", mobile=" + mobile + ", password=" + password + ", qualification="
				+ qualification + ", state=" + state + ", yearOfCompletion=" + yearOfCompletion + ", reportCards="
				+ reportCards + ", studentResponses=" + studentResponses + "]";
	}
}