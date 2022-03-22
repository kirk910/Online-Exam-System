package com.lti.appl.beans;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ADMIN_LOGIN database table.
 * 
 */
@Entity
@Table(name="ADMIN_LOGIN")
@NamedQuery(name="AdminLogin.findAll", query="SELECT a FROM AdminLogin a")
public class AdminLogin implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="EMAIL")
	private String email;

	@Column(name="PASSWORD")
	private String password;
	
	

	public AdminLogin() {
	}
	
	

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}