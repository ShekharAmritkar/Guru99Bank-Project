package com.banking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;
import com.banking.utilities.XLUtility;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) {
		
		maximizeWindow();
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(user);
		logger.info("username provided");
		lp.setPassword(pwd);
		logger.info("password provided");
		lp.clickSubmit();
		
		if (isAlertPresent()==true) {
			driver.switchTo().alert().accept();	// close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();	// close logout alert
			driver.switchTo().defaultContent();
		}	
	}

	
	// user defined method created to check the presence alert 
	public boolean isAlertPresent() {
		
		try {
		driver.switchTo().alert();
		return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException  {

		String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\banking\\testData\\LoginData.xlsx";
		XLUtility xl=new XLUtility(path);
		
		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);
		
		String logindata[][] =new String [rownum] [colcount];
		
		for (int i = 1; i < rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}
		 return logindata;
	}
}
