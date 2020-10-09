package com.demo.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import io.restassured.response.Response;

public class JsonUtils extends BaseTest{
	
	public  JSONObject parseJsonResponse(Response res){
		JSONObject obj = (JSONObject) JSONValue.parse(res.asString());
		return obj;
	}
	
	public String frameJsonReq(String categoryName,String petName,String tagsName,String status){
		//Integer idd = Integer.parseInt(id);
		JSONObject mainObj = new JSONObject();
		mainObj.put("id", 0);
			JSONObject categoryObj = new JSONObject();
			categoryObj.put("id", 0);
			categoryObj.put("name",categoryName);
		mainObj.put("category", categoryObj);
		mainObj.put("name", petName);
			JSONArray photoUrlsArry = new JSONArray();
			photoUrlsArry.add("string");
		mainObj.put("photoUrls", photoUrlsArry);
			JSONArray tagsArry = new JSONArray();
				JSONObject tagsObj = new JSONObject();
				tagsObj.put("id", 0);
				tagsObj.put("name", tagsName);
				tagsArry.add(tagsObj);
		mainObj.put("tags", tagsArry);
		mainObj.put("status", status);
		
		return mainObj.toJSONString();
			
		
	}
	
	

}
