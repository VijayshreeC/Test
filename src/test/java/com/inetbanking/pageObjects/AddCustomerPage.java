package com.inetbanking.pageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.CommonMethods;

public class AddCustomerPage {

	WebDriver ldriver;

	public AddCustomerPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(xpath = "//a[@href='addcustomerpage.php']")
	@CacheLookup
	WebElement lnkAddNewCustomer;

	@FindBy(name = "name")
	@CacheLookup
	WebElement txtCustomerName;

	@FindBy(xpath = "//input[@value='f']")
	@CacheLookup
	WebElement rdGender;

	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement txtdob;

	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement txtaddress;

	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement txtcity;

	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement txtstate;

	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement txtpin;

	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement txtmobilenumber;

	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement txtemail;

	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement txtpassword;

	@FindBy(how = How.XPATH, using = "//input[@type='submit']")
	@CacheLookup
	WebElement btnSubmit;

	// this is to close the java popup after login
	@FindBy(xpath = "//div[@id='closeBtn']")
	@CacheLookup
	public List<WebElement> nothanks;

	public void clickNewCustomerLink() throws InterruptedException, IOException {
		//lnkAddNewCustomer.click();
		CommonMethods.click(ldriver, lnkAddNewCustomer);
	}

	public void cName(String cname) throws InterruptedException, IOException {
		//txtCustomerName.sendKeys(cname);
		CommonMethods.inputData(ldriver, txtCustomerName, cname);
	}

	public void cGender() throws InterruptedException, IOException {
		//rdGender.click();
		CommonMethods.click(ldriver, rdGender);
	}

	public void custdob(String mm, String dd, String yy) throws InterruptedException, IOException {
		//txtdob.sendKeys(mm);
		CommonMethods.inputData(ldriver, txtdob, mm);
		CommonMethods.inputData(ldriver, txtdob, dd);
		CommonMethods.inputData(ldriver, txtdob, yy);
		/*txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);*/
	}

	public void cAddress(String caddress) throws InterruptedException, IOException {
		//txtaddress.sendKeys(caddress);
		CommonMethods.inputData(ldriver, txtaddress, caddress);
	}

	public void cCity(String ccity) throws InterruptedException, IOException {
		//txtcity.sendKeys(ccity);
		CommonMethods.inputData(ldriver, txtcity, ccity);
	}

	public void cState(String cstate) throws InterruptedException, IOException {
		//txtstate.sendKeys(cstate);
		CommonMethods.inputData(ldriver, txtstate, cstate);
	}

	public void cPinNo(String cpin) throws InterruptedException, IOException {
		//txtpin.sendKeys(String.valueOf(cpin));
		CommonMethods.inputData(ldriver, txtpin, cpin);
	}

	public void cMobileNumber(String cmobnum) throws InterruptedException, IOException {
		//txtmobilenumber.sendKeys(String.valueOf(cmobnum));
		CommonMethods.inputData(ldriver, txtmobilenumber, String.valueOf(cmobnum));
	}

	public void cEmailAddress(String cemailaddr) throws InterruptedException, IOException {
		//txtemail.sendKeys(String.valueOf(cemailaddr));
		CommonMethods.inputData(ldriver, txtemail, String.valueOf(cemailaddr));
	}

	public void cPassword(String cpass) throws InterruptedException, IOException {
		//txtpassword.sendKeys(String.valueOf(cpass));
		CommonMethods.inputData(ldriver, txtpassword, String.valueOf(cpass));
	}

	public void cSubmitButton() throws InterruptedException, IOException {
		//btnSubmit.click();
		CommonMethods.click(ldriver, btnSubmit);
	}

/*	public int noThanksSize() {
		return nothanks.size();
	}

	public WebElement popUpNoThanks() {
		return nothanks.get(0);

	}*/

}
