package com.example.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.common.ApiResponse;
import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.SignUpRequstDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.util.JwtUtils;

@Service
public class LoginService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	JwtUtils jwtUtils;

	public ApiResponse signUp(SignUpRequstDto signUpRequstDto) {
		ApiResponse AR=new ApiResponse();
		
		
		
		//dto to entity
		User userEntity=new User();
		
		userEntity.setName(signUpRequstDto.getName());
		userEntity.setEmailId(signUpRequstDto.getEmailId());
		userEntity.setPhoneNumber(signUpRequstDto.getPhoneNumber());
		userEntity.setGender(signUpRequstDto.getGender());
		userEntity.setPassword(signUpRequstDto.getPassword());
		userEntity.setIsActive(Boolean.TRUE);
		//store entity
		
		userEntity=userRepository.save(userEntity);
		
		AR.setData(userEntity);
		
		return AR;
	}

	public ApiResponse login(LoginRequestDto loginRequestDto) {
		
		ApiResponse AR=new ApiResponse();
		
		//valitation
		User user=userRepository.findOneByEmailIdAndPassword(loginRequestDto.getEmailId(),loginRequestDto.getPassword());
		
		if(user == null) {
			AR.setData("login failed");
			return AR;
		}		
		
		String token=jwtUtils.generateJwt(user);
		
		Map<String, Object> data=new HashMap<String, Object>();
		data.put("accessToken", token);

		AR.setData(data);
		return AR;
	}


}
