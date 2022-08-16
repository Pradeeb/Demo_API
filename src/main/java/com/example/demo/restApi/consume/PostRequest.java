package com.example.demo.restApi.consume;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

public class PostRequest {
	
	private static final String GET_ALL_PRODUCTS="http://localhost:8081/BookStore/rest/getProducts";
	private static final String ADD_PRODUCTS="http://localhost:8081/BookStore/rest/addProducts";
		
	private static final String keyValue="eyJhbGciOiJIUzUxMiJ9.eyJpc3MiOiIifQ.DC7dkI19wFRX19XMzohJpisbNsYeXEhgrmV9lzS7WeNimcujDmFsigtIpz1tcsQKaGQnruolBnA_DRIps0W9jQ";

		
	static RestTemplate reastTemplat=new RestTemplate();
	
//    public static void main(String[] args) {
//    	
//    	addProducts();
////    	getAllProducts();
//
//	}
	
	String key="";
    
    public static void getAllProducts() {
    	HttpHeaders heaters=new HttpHeaders();
    	heaters.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    	heaters.set("key", keyValue);

    	HttpEntity<String> entity=new HttpEntity<>("parameters",heaters);
    	ResponseEntity<String> result=reastTemplat.exchange(GET_ALL_PRODUCTS, HttpMethod.GET, entity, String.class);
    	System.out.println(result);
    }
    
    private static void addProducts() {
    	
    	Products addProduct=new Products(0,"poco ", 15601, "new mobile", "realMe", "mobile", 456, 56, false, "new", null);
    	ResponseEntity<Products> product=reastTemplat.postForEntity(ADD_PRODUCTS, addProduct, Products.class);
    	System.out.println(product);
    }
    
   

}
