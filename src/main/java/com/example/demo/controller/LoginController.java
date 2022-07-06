package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.SignUpRequstDto;
import com.example.demo.service.LoginService;
import com.example.demo.util.JwtUtils;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signup")
	public ResponseEntity<ApiResponse> signUp(@RequestBody SignUpRequstDto signUpRequstDto) {
		
		ApiResponse AR=loginService.signUp(signUpRequstDto);
		
		return ResponseEntity.status(AR.getStatus()).body(AR);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<ApiResponse> login(@RequestBody LoginRequestDto loginRequestDto) {
		
		ApiResponse AR=loginService.login(loginRequestDto);
		
		return ResponseEntity.status(AR.getStatus()).body(AR);
		
	}
	
	@GetMapping("/privateapi")
	public ResponseEntity<ApiResponse> privateApi(@RequestParam(value ="authorization") String auth) throws Exception {
		ApiResponse AR=new ApiResponse();
		System.out.println("print key :"+auth);
		jwtUtils.verify(auth);
		
		AR.setData("this is private api");
		return ResponseEntity.status(AR.getStatus()).body(AR);
	}
}
