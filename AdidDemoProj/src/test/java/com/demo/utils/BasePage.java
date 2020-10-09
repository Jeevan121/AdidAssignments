package com.demo.utils;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	 WebDriver driver;
	 public BasePage(WebDriver driver) {
		 this.driver = driver;
	 }
	 public WebDriver getDriver() {
		 return driver;
	 }
	 
	 public void safeClick(By locator) {
		waitForElementPresent(locator);
	    driver.findElement(locator).click();
	 }
	 public void safeType(By locator, String value) {
		waitForElementPresent(locator);
	    driver.findElement(locator).clear();
	    driver.findElement(locator).sendKeys(value);
	 }
	 public void waitForElementPresent(By locator) {
	    final WebDriverWait wait = new WebDriverWait(driver, 30);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 }
	 public boolean isElementPresent(By by) {
	    boolean value;
	    try {
	      waitForElementPresent(by);
	      driver.findElement(by).isDisplayed();
	      value = true;
	    } catch (final Exception e) {
	      value = false;
	    }
	    return value;
	}
	public void safeClear(By locator) {
		waitForElementPresent(locator);
	    driver.findElement(locator).clear();
	}
	
	public String getText(By locator){
		waitForElementPresent(locator);
		String title=driver.findElement(locator).getText();
		return title;
	}
	
	public String getAttributeValues(By locator,String attributeName){
		String value= driver.findElement(locator).getAttribute(attributeName);
		return value;
	}
	
	public void moveToElementAndClick(By element) {
		final Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(element)).click().build().perform();
	  }
	public void mouseOver(By element) {
		final Actions action = new Actions(driver);
	    action.moveToElement(driver.findElement(element)).build().perform();
	  }
	public void clickOnAlertOKBtn(){
		Alert simpleAlert = driver.switchTo().alert();
	    simpleAlert.accept();
	}
	
	public String getAlertText(){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		String txt = alert.getText().trim();
		return txt;
	}
	
	
	
}
