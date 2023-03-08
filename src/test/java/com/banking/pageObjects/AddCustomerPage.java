package com.banking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {

	WebDriver ldriver;
	
	public AddCustomerPage(WebDriver rdriver) {
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	@FindBy(css  = "a[href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;
	
	@FindBy(xpath = "//input[@name='name']")
	@CacheLookup
	WebElement txtCustomerName;
	
	@FindBy(xpath = "//input[@name='rad1']")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(xpath = "//textarea[@name='addr']")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(xpath = "//input[@name='city']")
	@CacheLookup
	WebElement txtCity;
	
	@FindBy(xpath = "//input[@name='state']")
	@CacheLookup
	WebElement txtState;
	
	@FindBy(xpath = "//input[@name='pinno']")
	@CacheLookup
	WebElement txtPIN;
	
	@FindBy(xpath = "//input[@name='telephoneno']")
	@CacheLookup
	WebElement txtMobileNumber;

	@FindBy(xpath = "//input[@name='emailid']")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(xpath = "//input[@name='password']")
	@CacheLookup
	WebElement txtpassword;
	
	@FindBy(xpath = "//input[@name='sub']")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath = "//input[@name='res']")
	@CacheLookup
	WebElement btnReset;
	
	public void clickAddNewCustomer() {
		lnkAddNewCustomer.click();
	}

	public void custName(String cname) {
		txtCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.click();;
	}
	
	public void custdob(String mm,String dd,String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}

	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}

	public void custCity(String ccity) {
		txtCity.sendKeys(ccity);
	}

	public void custState(String cstate) {
		txtState.sendKeys(cstate);
	}

	public void custPIN(String cpin) {
		txtPIN.sendKeys(String.valueOf(cpin));
	}

	public void custMobile(String cmobile) {
		txtMobileNumber.sendKeys(cmobile);
	}

	public void custemailid(String cemailid) {
		txtemailid.sendKeys(cemailid);
	}

	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}

	public void clickSubmit() {
		btnSubmit.click();
	}

	public void clickReset() {
		btnReset.click();
	}
	
	
}
