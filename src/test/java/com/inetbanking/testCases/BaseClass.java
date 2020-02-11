package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.inetbanking.utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String baseURL = readconfig.getApplicationUrl();
	public String username = readconfig.getUserName();
	public String password = readconfig.getPassword();
	public static WebDriver driver;
	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		logger = Logger.getLogger("eBanking");
		PropertyConfigurator.configure("log4j.properties");

		if (br.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
			driver = new ChromeDriver();
			System.out.println("RUNNING TESTS IN CHROME BROWSER");
			System.out.println();
		} else if (br.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfig.getFireFoxPath());
			driver = new FirefoxDriver();
			System.out.println("RUNNING TESTS IN FIREFOX BROWSER");
			System.out.println();
		} else if (br.equals("ie")) {
			System.setProperty("webdriver.ie.driver", readconfig.getIePath());
			driver = new InternetExplorerDriver();
			System.out.println("RUNNING TESTS IN INTERNET EXPLORER BROWSER");
			System.out.println();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(baseURL);
	}

	@AfterClass
	public void tearDown() throws IOException {
		
		driver.quit();
	}

	// to capture screenshots on failure.
	public static void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot is taken for this failed test case");
	}

	// to generate random characters using an inbuilt java function
	public String randomlyGeneratedAlphabhets() {
		String generateRandom = RandomStringUtils.randomAlphabetic(8);
		return generateRandom;
	}

	// to generate random numbers using an inbuilt java function
	public String randomlyGeneratedNumbers() {
		String generateRandom1 = RandomStringUtils.randomNumeric(4);
		return generateRandom1;
	}

}
