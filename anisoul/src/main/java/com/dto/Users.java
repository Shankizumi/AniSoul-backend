package com.dto;

import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// annotation to create table into database

@Entity
public class Users {
	private static final BCryptPasswordEncoder pwEncoder = new BCryptPasswordEncoder();
	// annotation to create id as primary key and auto increment
	@Id
	@GeneratedValue
	private int userId;
	private String fullName;
	@Column(unique = true)
	private String emailId;
	private String phoneNo;
	@Column(unique = true)
	private String userName;
	private String password;

	// constructer to initialize the values
	public Users(String fullName, String emailId, String phoneNo, String userName, String password) {
		super();
		this.fullName = fullName;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.userName = userName;
		this.password = password;
	}

	public Users() {

	}

	// getters and setters to get and set the values
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public String getencodedPassword() {
		return pwEncoder.encode(password);
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", fullName=" + fullName + ", emailId=" + emailId + ", phoneNo=" + phoneNo
				+ ", userName=" + userName + ", password=" + password + "]";
	}

}
