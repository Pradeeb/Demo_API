package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "is_active")
	private Boolean isActive;
	
	@Column(name = "sso_type")
	private String ssoType;
	
	@Column(name = "login_count")
	private int loginCount;
	
	@Column(name = "login_at")
	private Date loginAt;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	public User() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public String getSsoType() {
		return ssoType;
	}

	public void setSsoType(String ssoType) {
		this.ssoType = ssoType;
	}

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public Date getLoginAt() {
		return loginAt;
	}

	public void setLoginAt(Date loginAt) {
		this.loginAt = loginAt;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", emailId=" + emailId + ", phoneNumber="
				+ phoneNumber + ", password=" + password + ", userType=" + userType + ", isActive=" + isActive
				+ ", ssoType=" + ssoType + ", loginCount=" + loginCount + ", loginAt=" + loginAt + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}

	public User(int id, String name, String gender, String emailId, String phoneNumber, String password,
			String userType, Boolean isActive, String ssoType, int loginCount, Date loginAt, Date createdAt,
			Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.userType = userType;
		this.isActive = isActive;
		this.ssoType = ssoType;
		this.loginCount = loginCount;
		this.loginAt = loginAt;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
		
	
}
