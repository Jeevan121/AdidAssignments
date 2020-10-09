package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class PlaceOrderPage extends BasePage{
	
	WebDriver driver;
	public PlaceOrderPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	By perchaseBtn = new By.ByXPath("//button[text()='Purchase']");
	By totalAmount = new By.ByXPath("//label[@id='totalm']");
	By purchaseSummary = new By.ByXPath("//p[@class='lead text-muted ']");
	By okBtn = new By.ByXPath("//button[text()='OK']");
	
	public PlaceOrderPage enterPlaceOrderDetails(String fieldName,String name){
		By placeOrdField = new By.ByXPath("//input[@id='"+fieldName+"']");
		safeType(placeOrdField, name);
		return this;
	}
	
	public PlaceOrderPage clickOnPurchaseBtn(){
		safeClick(perchaseBtn);
		return this;
	}
	
	public String getTotalAmount(){
		String totalAmt = getText(totalAmount);
		return totalAmt;
	}
	
	public String getPurhaseSummary(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String totalAmt = getText(purchaseSummary);
		return totalAmt;
	}
	
	public PlaceOrderPage clickOnOKBtn(){
		safeClick(okBtn);
		return this;
	}

}
