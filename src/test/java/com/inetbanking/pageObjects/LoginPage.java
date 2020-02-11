package com.inetbanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.CommonMethods;

public class LoginPage {

	WebDriver ldriver;

	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	@FindBy(name = "uid")
	@CacheLookup
	WebElement txtUserName;

	@FindBy(name = "password")
	@CacheLookup
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnLogin;

	@FindBy(xpath = "//a[@href='Logout.php']")
	@CacheLookup
	WebElement lgOut;

	public void setUserName(String uname) throws InterruptedException, IOException {
		//txtUserName.sendKeys(uname);
		CommonMethods.inputData(ldriver, txtUserName, uname);
	}

	public void setPassword(String pwd) throws InterruptedException, IOException {
		//txtPassword.sendKeys(pwd);
		CommonMethods.inputData(ldriver, txtPassword, pwd);
	}

	public void clickSubmit() throws InterruptedException, IOException {
		//btnLogin.click();
		CommonMethods.click(ldriver, btnLogin);
	}

	public void clickLogOut() throws InterruptedException, IOException {
		//lgOut.click();
		CommonMethods.click(ldriver, lgOut);
	}
}
