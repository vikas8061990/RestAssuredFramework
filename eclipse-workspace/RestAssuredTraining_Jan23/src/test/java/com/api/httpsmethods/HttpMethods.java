package com.api.httpsmethods;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.Test;
/*
 * 
 * 
 * 
 * given()
 * ---- content type, header information, Bearer token, pre-requisite, add param , autho,
 * 
 * when()
 * ---- http method (get, delete, post, put), hit on the api
 * 
 * then()
 * ----- validating status code, json body, parameter, extract
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class HttpMethods {

	@Test
	void getAPICall()
	{
		given()
		
		.when()
		.get("https://reqres.in/api/users?page=2")
	
		.then()
		.statusCode(200)
		.body("page", equalTo(2))
		.log().all();
		
	}
	
	@Test
	void createUser()
	{
		
		HashMap data=new HashMap();
		data.put("name", "morpheus");
		data.put("Job","lender");
		
		given()
		.contentType("application/json")
		.body(data)
		
		.when()
		.post("https://reqres.in/api/users")
		.then()
		.statusCode(201)
		.body("name", equalTo("morpheus"))
		.body("Job",equalTo("lender"))
		.log().all();
	}
	
}
