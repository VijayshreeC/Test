package com.inetbanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.FinanceLoginPage;

public class FivenanceLogin extends BaseClass {
	
	@Test
	public void loginFinance() throws InterruptedException, IOException
	{
		driver.get(baseURL1);
		logger.info("URL is opened");
		FinanceLoginPage flp=new FinanceLoginPage(driver);
		flp.clickLogin();
		logger.info("Login button is clicked");
		Thread.sleep(10000);
		flp.setUsrName("sachin85_nair@yahoo.co.in");
		logger.info("Entered Username");
		flp.setPasswrd("Rajesh@07");
		logger.info("Entered Password");
		flp.clickSubmit();
		logger.info("Clicked on login submit");
		Thread.sleep(10000);

		if (driver.getTitle().equals("dashboard - 5nance.com")) {
			Assert.assertTrue(true);
			logger.info("Login is successful");
		} else {
			logger.info("Login is not successful");
			captureScreen(driver, "loginFinance");
			Assert.assertTrue(false);
	}

}
}
