package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class CartPage extends BasePage{
	WebDriver driver;
	public CartPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By cartDeleteLnk= new By.ByXPath("//td[text()='Sony vaio i5']/parent::*//a[text()='Delete']");
	
	By colorSize= new By.ByXPath("//td[@class='cart_description']//small/a");
		
	By cartTotal= new By.ByXPath("//h3[@id='totalp']");
	
	By placeOrderBtn= new By.ByXPath("//button[text()='Place Order']");
	
	
	
	public String getCartTotal(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String prdName = getText(cartTotal).trim();
		return prdName;
	}
	
	public CartPage deleteRespectiveProduct(String prdName){
		By cartDeleteLnk= new By.ByXPath("//td[text()='"+prdName+"']/parent::*//a[text()='Delete']");
		moveToElementAndClick(cartDeleteLnk);
		return this;
	}
	
	public CartPage clickOnPlaceOrderBtn(){
		moveToElementAndClick(placeOrderBtn);
		return this;
	}
	

}
