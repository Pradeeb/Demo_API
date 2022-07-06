package com.example.demo.confic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.example.demo.util.JwtUtils;

@Component
public class JwtIterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	JwtUtils jwtUtils;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		String auth=request.getParameter("authorization");
		
		if(!(request.getRequestURI().contains("login") || request.getRequestURI().contains("signup"))) {
			
			System.out.println(auth);
			jwtUtils.verify(auth);
			
		}
		
		
		
		
		
		return super.preHandle(request, response, handler);
	}
}
