package com.demo.tests;
import java.io.IOException;
import java.util.List;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.AutomationConstants;
import com.demo.utils.BaseTest;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.response.Response;

public class Exercise1RestAPIAutomationTest extends BaseTest{
	
	@Test
	public void getPetStatusByAvailbleTest() throws ParseException, IOException{
		//Hitting to the server and then Getting the Pets from store with status as Available
		Response res = getRestAssuredUtils().getRequest(AutomationConstants.apiEndPoint+AutomationConstants.petsFilterResource);
		int resCode = res.getStatusCode();
		Reporter.log("The code is::"+resCode);
		
		//Got JsonArray of Objects and then parsing with object mapper and then validating all the pet status should be available
		JsonNode getResNode=new ObjectMapper().readTree(res.asString());
		List<JsonNode>statusNode=getResNode.findValues(AutomationConstants.status);
		for(int i=0;i<statusNode.size();i++){
			String statusActual = statusNode.get(0).asText();
			Assert.assertEquals(statusActual,AutomationConstants.availableStatus,"the pet status is not matching");
		}
	}
	
	// This test will be posting pet to store, updating the pet status and then deleting the pet based on their ID
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="postNewAvailablePetToStoreTest",enabled=true,alwaysRun=true)
	public void postNewAvailablePetToStoreTest(String categoryName,String	petName,String	tagName,String	status) throws IOException{
		
		//Generating the Unique pet name and then framing the json request object according to the requirement
		String petNameExpected = petName+getRandomNumber();
		String framedJsonReq = getJsonUtils().frameJsonReq(categoryName, petNameExpected,tagName, status);
		
		//Posting the Pets to the Store
		Response res = getRestAssuredUtils().postRequest(AutomationConstants.apiEndPoint, framedJsonReq);
		//Parsing the Response and then validating the pet name against test input data
		JSONObject resObj = getJsonUtils().parseJsonResponse(res);
		String petNameActual = resObj.get(AutomationConstants.name).toString().trim();
		Reporter.log("The pet name from the post response ::"+petNameActual);
		Assert.assertEquals(petNameActual, petNameExpected,"the Actual pet name "+petNameActual+" is not matching with Expected Pet name is"+petNameExpected);
		
		//Retrieved the pet id and then hitting to the server with ID.
		String petIDActual = resObj.get("id").toString().trim();
		Response getRes = getRestAssuredUtils().getRequest(AutomationConstants.apiEndPoint+petIDActual);
		//Got Response and then validating the pet name against with expected pet name
		JSONObject getResObj = getJsonUtils().parseJsonResponse(getRes);
		String getResPetNameActual = getResObj.get(AutomationConstants.name).toString().trim();
		Reporter.log("The pet name got from Get response ::"+getResPetNameActual);
		Assert.assertEquals(getResPetNameActual, petNameExpected,"the Actual pet name got from get "+getResPetNameActual+" is not matching with Expected Pet name is"+petNameExpected);
		
		//Now preparing the json request for the updating the existing pet status as sold.
		//Retrieved the status and updating the json request status as sold instead of available.
		String statusTxt =  getResObj.get(AutomationConstants.status).toString().trim();
		if(statusTxt.equals(AutomationConstants.availableStatus)){
			getResObj.put(AutomationConstants.status, AutomationConstants.soldStatus);
		}
		//Hitting to the server with newly framed json request file status as sold
		Response putRes = getRestAssuredUtils().putRequest(AutomationConstants.apiEndPoint, getResObj.toJSONString());
		//Parsing the Updated response and then validating the pet status should be updated as sold
		JSONObject putResObj = getJsonUtils().parseJsonResponse(putRes);
		String putResStatusActual = putResObj.get(AutomationConstants.status).toString().trim();
		Reporter.log("The the updated status from the put response is::"+putResStatusActual);
		Assert.assertEquals(putResStatusActual, AutomationConstants.soldStatus,"the Actual pet name got from get "+putResStatusActual+" is not matching with Expected Pet name is"+AutomationConstants.soldStatus);
		
		//Retrieved the id from the put response and then deleting the pets based this ID.
		String putResIDActual = putResObj.get(AutomationConstants.id).toString().trim();
		Response deleteRes = getRestAssuredUtils().deleteRequest(AutomationConstants.apiEndPoint+putResIDActual);
		//Validating the delete status code,type and message
		Assert.assertEquals(deleteRes.getStatusCode(), 200,"the status code is not matching");
		
		JSONObject deleteResObj = getJsonUtils().parseJsonResponse(deleteRes);
		String deleteType = deleteResObj.get("type").toString().trim();
		Reporter.log("The type  from delete response is::"+deleteType);
		Assert.assertEquals(deleteType, "unknown","the Actual pet name got from get "+deleteType+" is not matching with Expected Pet name is"+"unknown");

		String message = deleteResObj.get("message").toString().trim();
		Reporter.log("The message  from delete response is::"+message);
		Assert.assertEquals(message, putResIDActual,"the Actual pet name got from get "+message+" is not matching with Expected Pet name is"+putResIDActual);
	}
}
