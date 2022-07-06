package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.common.ApiResponse;
import com.example.demo.common.PaginationMeta;
import com.example.demo.data.AuthorData;
import com.example.demo.dto.AuthorDto;
import com.example.demo.model.Author;
import com.example.demo.repository.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository authorRespository;


	public ApiResponse getAuthors(Pageable pageable) {
		
		ApiResponse apir=new ApiResponse();
		
		AuthorData ad=new AuthorData();
		
         
		
		Page<Author> authorPage=authorRespository.findAll(pageable);
		
		List<Author> authors=authorPage.getContent();
		PaginationMeta pm=  PaginationMeta.createPagination(authorPage);
		
		ad.setAuthor(authors);
		ad.setPm(pm);
		
		apir.setData(ad);
		return apir;
	}

}
