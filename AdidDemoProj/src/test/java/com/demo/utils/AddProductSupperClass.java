package com.demo.utils;

import org.testng.Assert;
import org.testng.Reporter;

public class AddProductSupperClass extends BaseTest{
	
	public void navigateToRespectivePageAndAddProctIntoCart(String productName,String cartSuccuessMsg){
		//navigating to the laptop page and then click on the respective laptop
		getHomePage().navigateToLaptopPage().clickLaptopLnk(productName);
		Reporter.log("Navigating to the Laptop Page and Then Click on the Respective Laptop::"+productName);
		//Getting the selected laptop title from the laptop details page and then validating against test input data
		String selectLaptop=getLaptopDetailsPage().getSelectedProductTitle(productName);
		Assert.assertEquals(selectLaptop,productName,"The selected laptop title is not matching");
		Reporter.log("The Selected Laptop Title is Present ::"+productName);
		
		//Validating the add to card link is should present on the laptop details page
		String addToCart = getLaptopDetailsPage().getAddToCartText();
		Assert.assertEquals(addToCart, "Add to cart","The add to cart Btn is not present");
		Reporter.log("The Add to Cart Button is Present");
		//clicking on the add to card link
		getLaptopDetailsPage().clickOnAddToCartBtn();
		Reporter.log("Click on the  Add to Cart Button");
		//Validating the product should be added into the card
		String alertTxt=getBasePage().getAlertText();
		Assert.assertEquals(alertTxt,cartSuccuessMsg,"The Product is added into the card");
		Reporter.log("Product Added into the cart");
		//Clicking on the alert ok btn
		getBasePage().clickOnAlertOKBtn();
		Reporter.log("clicked on the alert ok btn");
	}

}
