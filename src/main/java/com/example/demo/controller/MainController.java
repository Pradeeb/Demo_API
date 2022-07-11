package com.example.demo.controller;

import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Author;
import com.example.demo.model.BookAuthor;
import com.example.demo.model.Books;
import com.example.demo.repository.BooksDao;
import com.example.demo.restApi.consume.PostRequest;
import com.example.demo.service.BookService;




 @RestController
public class MainController {
	
	@Autowired
	BooksDao bookDAO;
	
	@Autowired
	BookService bookservice;
	
	Logger log=LoggerFactory.getLogger(MainController.class);
			
	
	//1.get all book list
	@RequestMapping(value ="/books")
	public List<Books> getBookList() {
		
		log.error("this is first");
		return bookservice.getBooks();
	}
	
	//2.add book in db
	@RequestMapping(value ="/books",method =RequestMethod.POST)
	public Books addBook(@RequestBody Books book) {
		return bookservice.addBook(book);
	}
	
	//3.get particular ID value & get author details
	@RequestMapping(value ="/books/{id}")
	public BookDto getBookById(@PathVariable("id") int bookId,
			@RequestParam(value="authorData",required =false)
	        boolean authorData) {
		
		return bookservice.getBookById(bookId,authorData);
	}
	
	//4.updating book
	@PutMapping(value ="/books")
	public Books updateBook(@RequestBody Books updateBook) {
		return bookservice.updateBook(updateBook);
	}
	
	//5.delete book
	@DeleteMapping(value ="/books/{id}")
	public String updateBook(@PathVariable("id") int deleteBookId) {
		return bookservice.deletBook(deleteBookId);
	}
	
	//6.year wise get book
	@GetMapping(value="/yearOfPublications/{year}")
	public List<Books> getBookYearWise(@PathVariable("year") Set<String > year) {
		return bookservice.getBooksYearWise(year);
	}
	
	//7.updating author
		@PutMapping(value ="/author")
		public List<Author> updateAuthor(@RequestBody List<Author>author) {
			return bookservice.updateAuthor(author);
		}
	//8.find author
		@GetMapping(value="/author")
		public List<Author> findAuthor() {
			return bookservice.findAuthor();
		}
		
   //8.find author
		@GetMapping(value="/status")
		public ApiResponse getBookStatus(@RequestParam("status") Set<Integer> status) {
		  return bookservice.getBookStatus(status);
		}
		
		
		 static int num=0;
		    @Scheduled(initialDelay = 1000, fixedRate = 1000)
		    public void testSchdul() {
		    	
		    	PostRequest obj=new PostRequest();
		    	obj.getAllProducts();
		    }
		
}
