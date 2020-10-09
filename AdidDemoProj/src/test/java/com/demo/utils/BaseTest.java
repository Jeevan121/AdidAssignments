package com.demo.utils;
import java.util.Random;

import org.openqa.selenium.WebDriver;

import com.demo.pages.LaptopPage;
import com.demo.pages.PlaceOrderPage;
import com.demo.pages.HomePage;
import com.demo.pages.LaptopDetailsPage;
import com.demo.pages.CartPage;



public class BaseTest {
	
	private WebDriver driver;
	BasePage basePage;
	HomePage homePage;
	LaptopPage lapTopPage;
	LaptopDetailsPage lapTopDetailsPage;
	CartPage cartPage;
	PlaceOrderPage placeOrderPage;
	RestAssuredUtils restAssuredUtlis;
	JsonUtils jsonUtils;
	
	public void launchApplication(){
		driver=new BrowserCreation().createBrowser();
	}
	
	public WebDriver getDriver(){
		return driver;
	}
	
	public BasePage getBasePage() {
	    if (basePage == null) {
	      basePage = new BasePage(driver);
	    }
	    return basePage;
	}
	
	public HomePage getHomePage() {
	    if (homePage == null) {
	    	homePage = new HomePage(driver);
	    }
	    return homePage;
	}
	
	public LaptopPage getLaptopPage() {
	    if (lapTopPage == null) {
	    	lapTopPage = new LaptopPage(driver);
	    }
	    return lapTopPage;
	}
	
	public LaptopDetailsPage getLaptopDetailsPage() {
	    if (lapTopDetailsPage == null) {
	    	lapTopDetailsPage = new LaptopDetailsPage(driver);
	    }
	    return lapTopDetailsPage;
	}
	
	public CartPage getCartPage() {
	    if (cartPage == null) {
	    	cartPage = new CartPage(driver);
	    }
	    return cartPage;
	}
	
	public PlaceOrderPage getPlaceOrderPage() {
	    if (placeOrderPage == null) {
	    	placeOrderPage = new PlaceOrderPage(driver);
	    }
	    return placeOrderPage;
	}
	
	
	public RestAssuredUtils getRestAssuredUtils(){
		if(restAssuredUtlis==null){
			restAssuredUtlis = new RestAssuredUtils();
		}
		return restAssuredUtlis;
	}
	
	public JsonUtils getJsonUtils(){
		if(jsonUtils==null){
			jsonUtils = new JsonUtils();
		}
		return jsonUtils;
	}
	
	public static int getRandomNumber(){
		  Random rand = new Random(); 
	      int rand_int1 = rand.nextInt(1000);
	      return rand_int1;
	}
	
	
}
