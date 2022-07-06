package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name ="author")
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "author_name")
    private String name;
	@Column(name="updated_at")
	private Date updatedDate;
	@Column(name="created_at")
	private Date createdDate;
	
	public Author() {
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
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + ", updatedDate=" + updatedDate + ", createdDate=" + createdDate
				+ "]";
	}
	public Author(int id, String name, Date updatedDate, Date createdDate) {
		super();
		this.id = id;
		this.name = name;
		this.updatedDate = updatedDate;
		this.createdDate = createdDate;
	}
	
	
	
}
