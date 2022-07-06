package com.example.demo.common;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

   @ExceptionHandler
	public ResponseEntity errorStatus(Exception e) {
		
	   ApiResponse apir=new ApiResponse();
	   apir.setError("Internal server error");
	   apir.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	   
	   return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(apir);
		
	}
   
   @ExceptionHandler
  	public ResponseEntity accessDenied(AccessDeniedException e) {
  		
  	   ApiResponse apir=new ApiResponse();
  	   apir.setError("UNAUTHORIZED SERVER ERROR");
  	   apir.setStatus(HttpStatus.UNAUTHORIZED.value());
  	   
  	   return ResponseEntity.status(HttpStatus.UNAUTHORIZED.value()).body(apir);
  		
  	}
   
   
}
