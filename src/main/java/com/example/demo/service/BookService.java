package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.ApiResponse;
import com.example.demo.data.BookData;
import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.BookDto;
import com.example.demo.model.Author;
import com.example.demo.model.BookAuthor;
import com.example.demo.model.Books;
import com.example.demo.repository.AuthorDao;
import com.example.demo.repository.BookAuthorDao;
import com.example.demo.repository.BooksDao;
import com.example.demo.validation.BookValidater;

@Service
public class BookService {
	

	@Autowired
	BooksDao bookDAO;
	
	@Autowired
	AuthorDao authorDAO;
	
	@Autowired
	BookAuthorDao bookAuthorDao;
	
	@Autowired
	BookValidater bookValidater;
 
	public List<Books> getBooks(){

		List<Books> bookList=new ArrayList<Books>();
		
		bookDAO.findAll().forEach(book -> bookList.add(book));
		return bookList;	
	}
	
	public Books addBook(Books book) {
		// validation
		bookValidater.createBookValidater(book);
		return bookDAO.save(book);
	}

	public Books updateBook(Books updateBook) {
		return bookDAO.save(updateBook);
	}

	public String deletBook(int deleteBookId) {
		bookDAO.deleteById(deleteBookId);
		return "delete successFully";
	}
	public List<Books> getBooksYearWise(Set<String> year) {
		
		List<Books> bookList=new ArrayList<Books>();
	    bookDAO.getBookYearWise(year).
	    forEach(Book -> bookList.add(Book));
		return bookList;
	}

	public BookDto getBookById(int bookId ,Boolean authorData) {
		 
		Books book;
		List<BookAuthor> bookAuthors=null;
		
		book= bookDAO.getBookById(bookId);
		
		if (authorData) {
			 bookAuthors=bookAuthorDao.findAllByBooksid(bookId);
			
		}
		BookDto bookDto=new BookDto();
		
		bookDto.setId(book.getId());
		bookDto.setName(book.getName());
		bookDto.setPageCount(book.getPageCount());
		bookDto.setPublishingDate(book.getPublishingDate());
		
		 List<AuthorDto> authorDTOList = new ArrayList<>();
         if(bookAuthors != null ) {
        	 for(BookAuthor Ba:bookAuthors) {
        		 Author author=Ba.getAuthor();
        		 
        		 AuthorDto ADTO=new AuthorDto();
        		 ADTO.setId(author.getId());
        		 ADTO.setName(author.getName());        
        		 ADTO.setCreatedDate(author.getCreatedDate());
        		 
        		 authorDTOList.add(ADTO);
        		 }
         bookDto.setAuthor(authorDTOList);
         }
		
		return bookDto;
	}

	public List<Author> updateAuthor(List<Author> updateAuthor) {
		return (List<Author>) authorDAO.saveAll(updateAuthor);
	}

	public List<Author> findAuthor() {
		List<Author> authorList=new ArrayList<Author>();
		authorDAO.findAll().forEach(author -> authorList.add(author));
		return authorList;
	}

	public ApiResponse getBookStatus(Set<Integer> status) { 
		
		ApiResponse ar=new ApiResponse();
		
		 List<Books> bookList= bookDAO.getBookId(status);
		 
//		 Map data=new HashMap();
//		 data.put("Book", bookList);
		 
		 BookData BD=new BookData();
		 BD.setBooks(bookList);
		 
		
		ar.setData(BD);
		return ar;
	}

	public  ApiResponse getBooksByDsl(int year) {

		ApiResponse ar=new ApiResponse();
		return ar;
	}
	
}
