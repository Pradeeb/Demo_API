package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="book_author")
public class BookAuthor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
	private Books book;
	@OneToOne
	@JoinColumn(name = "author_id",referencedColumnName = "id",nullable = false)
	private Author author;
	
	public BookAuthor() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Books getBook() {
		return book;
	}

	public void setBook(Books book) {
		this.book = book;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "BookAuthor [id=" + id + ", book=" + book + ", author=" + author + "]";
	}

	public BookAuthor(int id, Books book, Author author) {
		super();
		this.id = id;
		this.book = book;
		this.author = author;
	}
	
	

}
