package com.demo.tests;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.demo.dataprovider.DataProviderUtils;
import com.demo.utils.AddProductSupperClass;
import com.demo.utils.AutomationConstants;

public class Exercise2WebAutomationTest extends AddProductSupperClass{
	
	@BeforeTest
	public void setUp(){
		launchApplication();
	}
	
	@Test(dataProviderClass=DataProviderUtils.class,dataProvider="exercise2WebAutomationTest",enabled=true,alwaysRun=true)
	public void exercise2WebAutomationTest(String lapTop1,String lapTop2,String	cartSuccuessMsg,String	name,String	country,
			String city,String	cardNum,String	month,String	year){
		
		//Validating the Product Store Title should present in the home page
		boolean isProductStore=getHomePage().validateProductStore();
		Assert.assertEquals(isProductStore, true,"The Product Store Title is not present on the homepage");
		Reporter.log("The Product Store Title is Present On the Home Page");
		//Navigate tot he Laptop page and clicking on the respective lap and then added into cart and validating the product should be added int cart
		navigateToRespectivePageAndAddProctIntoCart(lapTop1, cartSuccuessMsg);
		//Navigating to  Home Page
		getHomePage().navigateToHomePage();
		//Navigate tot he Laptop page and clicking on the respective lap and then added into cart and validating the product should be added int cart
		navigateToRespectivePageAndAddProctIntoCart(lapTop2, cartSuccuessMsg);
		//navigating to the cart page
		getHomePage().navigateToCartPage();
		// deleting the product2 from the cart
		getCartPage().deleteRespectiveProduct(lapTop2);
		//Getting the total amount the cart page
		String total = getCartPage().getCartTotal();
		//Click on the place order button
		getCartPage().clickOnPlaceOrderBtn();
		//Entering the purchaser details
		getPlaceOrderPage().enterPlaceOrderDetails(AutomationConstants.nameField,name).
		enterPlaceOrderDetails(AutomationConstants.countyField,country).
		enterPlaceOrderDetails(AutomationConstants.cityField,city).
		enterPlaceOrderDetails(AutomationConstants.cardField,cardNum).
		enterPlaceOrderDetails(AutomationConstants.monthField, month).
		enterPlaceOrderDetails(AutomationConstants.yearField, year);
		//Getting the total amount from the purchase page
		String totalAmt = getPlaceOrderPage().getTotalAmount();
		String[] totalAmountExpected = totalAmt.trim().split(":");
		//click on the purchase button
		getPlaceOrderPage().clickOnPurchaseBtn();
		// getting the purchase summary
		String purSummary=getPlaceOrderPage().getPurhaseSummary();
		String[] purchaseDetails = purSummary.trim().split(" ");
		//Logging the purchase id
		Reporter.log("The purchase Id id::"+purchaseDetails[1]);
		System.out.println("The purchase Id id::"+purchaseDetails[1]);
	
		//Validating the Actual Purchase amount should be same as total place order amount
		Assert.assertEquals(purchaseDetails[2].trim(),totalAmountExpected[1].trim(),"the purchase amount actual is "+purchaseDetails[2]+" is not matching with Expected Amount "+totalAmountExpected[1]);
		getPlaceOrderPage().clickOnOKBtn();
	}
	
	@AfterTest
	public void tearDown(){
		getDriver().quit();
	}
}
