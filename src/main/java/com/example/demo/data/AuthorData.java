package com.example.demo.data;

import java.util.List;

import com.example.demo.common.PaginationMeta;
import com.example.demo.model.Author;

public class AuthorData {

	private List<Author> author;
	private PaginationMeta pm;
	public List<Author> getAuthor() {
		return author;
	}
	public void setAuthor(List<Author> author) {
		this.author = author;
	}
	public PaginationMeta getPm() {
		return pm;
	}
	public void setPm(PaginationMeta pm) {
		this.pm = pm;
	}
	
	
}
