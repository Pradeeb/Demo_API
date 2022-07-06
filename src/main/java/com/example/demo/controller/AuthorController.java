package com.example.demo.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.common.ApiResponse;
import com.example.demo.service.AuthorService;



@RestController
public class AuthorController {
	
	@Autowired
	AuthorService authorService;
	
	@GetMapping(value="/authors")
	public ApiResponse getAuthors(Pageable pageable) {
		
		ApiResponse apir=authorService.getAuthors(pageable);

		System.out.println("author apir run");
		return apir;
		
	}
}
