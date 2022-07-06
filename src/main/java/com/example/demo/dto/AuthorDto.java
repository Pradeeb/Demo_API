package com.example.demo.dto;

import java.util.Date;

public class AuthorDto {

	private int id;
	private String name;
	private Date createdDate;
	
	public AuthorDto() {
		// TODO Auto-generated constructor stub
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

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Override
	public String toString() {
		return "AuthorDto [id=" + id + ", name=" + name + ", createdDate=" + createdDate + "]";
	}

	public AuthorDto(int id, String name, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.createdDate = createdDate;
	}
	
}
