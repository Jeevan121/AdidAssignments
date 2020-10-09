package com.demo.utils;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredUtils {
	
	Response response;
	
	public Response getRequest(String endPoint){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.queryParam("status",AutomationConstants.status).request(Method.GET);
		return response;
	}
	
	public Response postRequest(String endPoint,String jsonRequest){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		 httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonRequest);
		Response response = httpRequest.request(Method.POST);
		return response;
	}
	
	public Response putRequest(String endPoint,String jsonRequest){
		RestAssured.baseURI=endPoint;
		RequestSpecification httpRequest = RestAssured.given();
		 httpRequest.header("Content-Type", "application/json");
		httpRequest.body(jsonRequest);
		Response response = httpRequest.request(Method.PUT);
		return response;
	}
	
	public Response deleteRequest(String endPoint){
		 RestAssured.baseURI = endPoint;
		 RequestSpecification httpRequest = RestAssured.given(); 
		 httpRequest.header("Content-Type", "application/json"); 
		 Response res = httpRequest.request(Method.DELETE);
		 return res;
	}

}
