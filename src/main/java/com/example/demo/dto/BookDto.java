package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;


public class BookDto {

	private int id;
	private int pageCount;
	private String publishingDate;
	private String name;
	
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private List<AuthorDto> author;
	
	public BookDto(){
		
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

	public List<AuthorDto> getAuthor() {
		return author;
	}

	public void setAuthor(List<AuthorDto> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookDto [id=" + id + ", pageCount=" + pageCount + ", publishingDate=" + publishingDate + ", name="
				+ name + ", author=" + author + "]";
	}

	public BookDto(int id, int pageCount, String publishingDate, String name, List<AuthorDto> author) {
		super();
		this.id = id;
		this.pageCount = pageCount;
		this.publishingDate = publishingDate;
		this.name = name;
		this.author = author;
	}
	
	
}
