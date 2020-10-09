package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class LaptopDetailsPage extends BasePage{
	
	WebDriver driver;
	public LaptopDetailsPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By addToCartBtn= new By.ByXPath("//a[text()='Add to cart']");
	
	public String getSelectedProductTitle(String laptop){
		By prdTitle = new By.ByXPath("//h2[text()='"+laptop+"']");
		String prd = getText(prdTitle);
		return prd;
	}
	
	
	
	public String getAddToCartText(){
		String addToCart = getText(addToCartBtn);
		return addToCart;
	}
	
	public LaptopDetailsPage clickOnAddToCartBtn(){
		//safeClick(addToCartLnk);
		moveToElementAndClick(addToCartBtn);
		return this;
	}

}
