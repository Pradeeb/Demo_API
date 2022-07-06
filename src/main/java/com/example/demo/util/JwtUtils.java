package com.example.demo.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.common.AccessDeniedException;
import com.example.demo.common.ErrorHandler;
import com.example.demo.model.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	
	@Autowired
	ErrorHandler eh;
	
	private static String secret="Bhavish Print Solution";
	private static long timeDuration=60*30;
	
    public String generateJwt(User user) {
    	long milliSec=System.currentTimeMillis();
    	long expiryTime=milliSec +timeDuration*1000;
    	
    	Date issuedAt=new Date(milliSec);
    	Date tokkenDuration=new Date(expiryTime);
    	
    	//claims
    	Claims claims=Jwts.claims()
    			.setIssuer(String.valueOf(user.getId()))
    			.setIssuedAt(issuedAt)
    			.setExpiration(tokkenDuration);
    	
    	//optional claims
    	claims.put("type", user.getUserType());

	return Jwts.builder()
			.setClaims(claims)
			.signWith(SignatureAlgorithm.HS512,secret )
			.compact();
	
}

    public void verify(String authorization) {
	try {
    	Jwts.parser().setSigningKey(secret).parseClaimsJws(authorization);
    	
	}catch(Exception e) {
	  throw new AccessDeniedException("Access Denied");
	}
    }

}
