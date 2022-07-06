package com.example.demo.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Books;

@Repository
public interface BooksDao extends JpaRepository<Books,Integer> {
	
	    String getBookById="SELECT * FROM  `books` WHERE id=:GBBI";
	    @Query(value =getBookById,nativeQuery = true)
	    public Books getBookById(@Param("GBBI") int bookId);

	    String query1="SELECT * FROM  `books` WHERE publishing_date IN :GPYW";
	    @Query(value =query1,nativeQuery = true)
	    public List<Books> getBookYearWise(@Param("GPYW") Set<String> year);
	    
	    String getBookId="SELECT * FROM  `books` WHERE id IN :GBBI";
	    @Query(value =getBookId,nativeQuery = true)
	    public List<Books> getBookId(@Param("GBBI") Set<Integer> bookId);

}
