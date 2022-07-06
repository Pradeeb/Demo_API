package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "books")
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "page_count")
	private int pageCount;
	@Column(name = "publishing_date")
	private String publishingDate;
	@Column(name = "name")
	private String name;
	
	Books(){
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public String getPublishingDate() {
		return publishingDate;
	}

	public void setPublishingDate(String publishingDate) {
		this.publishingDate = publishingDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "books [id=" + id + ", pageCount=" + pageCount + ", publishingDate=" + publishingDate + ", name=" + name
				+ "]";
	}

	public Books(int id, int pageCount, String publishingDate, String name) {
		super();
		this.id = id;
		this.pageCount = pageCount;
		this.publishingDate = publishingDate;
		this.name = name;
	}
	
	
	
}