package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}

	@FindBy(xpath = "//input[@name='uid']")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(xpath = "(//input[@name='password'])[1]")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(xpath = "//input[@name='btnLogin']")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath = "//input[@name='btnReset']")
	@CacheLookup
	WebElement btnReset;

	@FindBy(xpath = "//a[normalize-space()='Log out']")
	@CacheLookup
	WebElement lnkLogout;
	
	
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
	
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	public void clickSubmit() {
		btnLogin.click();
	}
	
	public void resetDetails() {
		btnReset.click();
	}
	
	public void clickLogout() {
		lnkLogout.click();
	}

	
}
