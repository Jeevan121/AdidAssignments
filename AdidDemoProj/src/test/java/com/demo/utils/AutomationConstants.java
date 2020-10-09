package com.demo.utils;

public class AutomationConstants {
	
	public static String applicationUrl = PropertiesUtils.initEnvironmentProperties().getProperty("environmentUrl");
	public static String apiEndPoint = PropertiesUtils.initEnvironmentProperties().getProperty("apiEndPoint");
	
	public static String browserType = PropertiesUtils.initAutomatioProperties().getProperty("BrowserType");
	
	public static String firefox="firefox";
	public static String chrome="chrome";
	
	public static String availableStatus="available";
	public static String soldStatus="sold";
	public static String petsFilterResource="findByStatus";
	public static String status="status";
	public static String name="name";
	public static String id="id";
	
	public static String nameField ="name";
	public static String countyField ="country";
	public static String cityField ="city";
	public static String cardField ="card";
	public static String monthField ="month";
	public static String yearField ="year";
}
