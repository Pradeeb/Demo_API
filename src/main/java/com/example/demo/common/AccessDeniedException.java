package com.example.demo.common;

import com.mysql.cj.protocol.Message;

public class AccessDeniedException extends RuntimeException {

	public AccessDeniedException(String message) {
		super(message);
	}


}
