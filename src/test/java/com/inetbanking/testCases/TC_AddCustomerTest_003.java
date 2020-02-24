package com.inetbanking.testCases;

import java.io.IOException;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.AddCustomerPage;
import com.inetbanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass {

	@Test
	public void loginGuru() throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		lp.setPassword(password);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Clicked on submit button");	
		Thread.sleep(1000);
	}
	
	
	@Test(dependsOnMethods= {"loginGuru"})
	public void addNewCustomer() throws InterruptedException, IOException {		

		AddCustomerPage addcust = new AddCustomerPage(driver);
		driver.switchTo().frame("flow_close_btn_iframe");
		driver.findElement(By.xpath("//div[@id='closeBtn']")).click();
		;
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
		addcust.clickNewCustomerLink();
		logger.info("Clicked on new customer link");
		addcust.cName("Vijayshree");
		logger.info("Entered customer name");
		addcust.cGender();
		logger.info("Clicked on gender");
		addcust.custdob("16", "09", "85");
		logger.info("Entered dob");
		Thread.sleep(2000);
		addcust.cAddress("INDIA");
		logger.info("Entered address");
		addcust.cCity("Mumbai");
		logger.info("Entered city");
		addcust.cState("Maharashtra");
		logger.info("Entered state");
		addcust.cPinNo("400072");
		logger.info("Entered pincode");
		addcust.cMobileNumber("9833323133");
		logger.info("Entered mobile number");

		String email = randomlyGeneratedAlphabhets() + "@gmail.com";
		addcust.cEmailAddress(email);
		logger.info("Entered email address");
		addcust.cPassword("jjjjd");
		logger.info("Entered password");
		Thread.sleep(1000);
		addcust.cSubmitButton();
		logger.info("Clicked on new customer submission");

		Thread.sleep(2000);
		if (isAlertPresent() == true) {			
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Invalid credentials, login failed or user already exist");
			captureScreen(driver, "addNewCustomer");
			Assert.assertTrue(false);
		} else {
			logger.info("Successful login");
			Assert.assertTrue(true);
		}

	}

	// user defined method for this scenario to check if alert is present or not
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
	}

}
