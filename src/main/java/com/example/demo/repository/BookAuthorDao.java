package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.BookAuthor;


@Repository
public interface BookAuthorDao extends JpaRepository<BookAuthor, Integer> {

	
	    String getBookById="SELECT * FROM books AS b JOIN book_author AS ba ON "
	    		+ "b.id = ba.book_id JOIN author AS a ON ba.author_id = a.id WHERE b.id=:GBBI";
	    @Query(value =getBookById,nativeQuery = true)
	    List<BookAuthor> findAllByBooksid(@Param("GBBI") int bookId);

}
