package com.inetbanking.pageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.inetbanking.testCases.CommonMethods;

public class FinanceLoginPage {
	
		WebDriver ldriver;

		public FinanceLoginPage(WebDriver rdriver) {
			ldriver = rdriver;
			PageFactory.initElements(rdriver, this);
		}

		@FindBy(id = "ancopenlogin1")
		@CacheLookup
		WebElement btnLogin;
		
		@FindBy(name = "UserName")
		@CacheLookup
		WebElement txtUserNme;
		
		@FindBy(name = "Password")
		@CacheLookup
		WebElement txtPwd;
		
		@FindBy(id = "btnsigninHome")
		@CacheLookup
		WebElement btnSubmit;
		
		
		public void clickLogin() throws InterruptedException, IOException {
			//txtUserName.sendKeys(uname);
			CommonMethods.click(ldriver, btnLogin);
		}

		public void setUsrName(String usr) throws InterruptedException, IOException {
			//txtPassword.sendKeys(pwd);
			CommonMethods.inputData(ldriver, txtUserNme, usr);
		}
		
		public void setPasswrd(String pwd) throws InterruptedException, IOException {
			//txtPassword.sendKeys(pwd);
			CommonMethods.inputData(ldriver, txtPwd, pwd);
		}

		public void clickSubmit() throws InterruptedException, IOException {
			//txtUserName.sendKeys(uname);
			CommonMethods.click(ldriver, btnSubmit);
		}
}
