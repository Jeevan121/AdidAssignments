package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class HomePage extends BasePage{
	WebDriver driver;
	public HomePage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	
	By productStoreLnk = new By.ByXPath("//a[contains(text(),'PRODUCT STORE')]");
	By laptopLnk = new By.ByXPath("//a[text()='Laptops']");
	By cartLnk = new By.ByXPath("//a[text()='Cart']");
	
	
	public boolean validateProductStore(){
		boolean flag = isElementPresent(productStoreLnk);
		return flag;
	}
	
	public LaptopPage navigateToLaptopPage(){
		//safeClick(laptopLnk);
		moveToElementAndClick(laptopLnk);
		return new LaptopPage(driver);
		
	}
	
	public HomePage navigateToHomePage(){
		//safeClick(laptopLnk);
		moveToElementAndClick(productStoreLnk);
		return this;
		
	}
	
	public HomePage navigateToCartPage(){
		//safeClick(laptopLnk);
		moveToElementAndClick(cartLnk);
		return this;
		
	}

}
