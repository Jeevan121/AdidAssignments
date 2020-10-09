package com.demo.dataprovider;

import java.io.File;

import org.testng.annotations.DataProvider;

import com.demo.utils.ExcelUtils;




public class DataProviderUtils {
	
	@DataProvider(name = "postNewAvailablePetToStoreTest")
	  public static Object[][] postNewAvailablePetToStoreTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "postNewAvailablePetToStoreTest");
	    return objReturn;
	  }
	
	@DataProvider(name = "exercise2WebAutomationTest")
	  public static Object[][] exercise2WebAutomationTest() {
	    final Object[][] objReturn = ExcelUtils.getTableArray(
	        System.getProperty("user.dir") +File.separator+"testdata"+File.separator+"Automation_Test_Input_Data.xls", "Demo", "exercise2WebAutomationTest");
	    return objReturn;
	  }
	
	
	
	
}
