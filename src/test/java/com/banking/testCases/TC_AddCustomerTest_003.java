package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.banking.pageObjects.AddCustomerPage;
import com.banking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		
		logger.info("URL is launched");
		maximizeWindow();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("username is provided");
		lp.setPassword(password);
		logger.info("password is provided");
		lp.clickSubmit();
		
		Thread.sleep(3000);
		
		AddCustomerPage addcust = new AddCustomerPage(driver);
		addcust.clickAddNewCustomer();
		
		Thread.sleep(3000);
		
// This try block is for blocking add coming on webpage...		
		try {

			WebElement frame1 = driver.findElement(By.id("google_ads_iframe_/24132379/INTERSTITIAL_DemoGuru99_0"));
		    driver.switchTo().frame(frame1);
		    WebElement frame2 = driver.findElement(By.id("ad_iframe"));
		    driver.switchTo().frame(frame2);
		    driver.findElement(By.xpath("//div[@id='dismiss-button']/div/span")).click();
		    driver.switchTo().defaultContent();
		    Thread.sleep(5000);
			
		} catch (Exception e) {
		
		}
		
		logger.info("providing customer details");
		
		addcust.custName("Vikrant");
		addcust.custGender("male");
		addcust.custdob("01","13","1994");
		Thread.sleep(3000);
		addcust.custAddress("INDIA");
		addcust.custCity("Nashik");
		addcust.custState("MH");
		addcust.custPIN("283940");
		addcust.custMobile("3647589201");
		
		String email = randomstring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("9876");
		addcust.clickSubmit();
		Thread.sleep(3000);
		
		logger.info("validation is started");
		boolean res = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if (res==true) {
			Assert.assertTrue(true);
			logger.info("test case passed !!");
		} else {
			logger.info("test case failed !!");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		}
	}

}
