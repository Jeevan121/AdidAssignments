package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demo.utils.BasePage;

public class LaptopPage extends BasePage{
	WebDriver driver;
	public LaptopPage(WebDriver driver){
		super(driver);
		this.driver=driver;
	}
	
	public LaptopPage clickLaptopLnk(String lapTopName){
		By lapTopLnk = new By.ByXPath("//a[text()='"+lapTopName+"']");
		moveToElementAndClick(lapTopLnk);
		return this;
	}
	
}
