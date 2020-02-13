package com.inetbanking.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.XLUtils;

import junit.framework.Assert;

public class TC_LoginDDT_002 extends BaseClass {

	@Test(dataProvider = "LoginData")
	public void loginDDT(String uname, String pwd) throws InterruptedException, IOException {
		driver.get(baseURL);
		logger.info("URL is opened");
		LoginPage lp = new LoginPage(driver);
		lp.setUserName(uname);
		logger.info("Entered username");
		lp.setPassword(pwd);
		logger.info("Entered password");
		lp.clickSubmit();
		logger.info("Clicked on submit Button");
		Thread.sleep(3000);
		if (isAlertPresent() == true) {
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
			logger.warn("Invalid credentials, login failed");
			captureScreen(driver, "loginDDT");
			Assert.assertTrue(false);
		} else {
			logger.info("Successful login");
			Assert.assertTrue(true);
			lp.clickLogOut();
			logger.info("Logged out of the system");
			Thread.sleep(3000);
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
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

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		String path = System.getProperty("user.dir") + "/src/test/java/com/inetbanking/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		String logindata[][] = new String[rownum][colcount];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colcount; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
	}
}
