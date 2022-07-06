package com.example.demo.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.model.Books;

@Component
public class BookValidater {

	public List<Error> createBookValidater(Books book) {
		
		List<Error> errorList=new ArrayList<Error>();
		
		if(book.getName() == null) {
			 Error error = new Error("name"+"  book name is null");
			 errorList.add(error);
		}
		
		if(book.getPublishingDate() == null) {
			 Error error = new Error("publishingDate"+"  Publishing date is null");
			 errorList.add(error);
		}
		
		return errorList;
	}
}
