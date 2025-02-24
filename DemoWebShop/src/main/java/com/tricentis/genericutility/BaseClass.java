package com.tricentis.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.tricentis.objectRepository.HomePage;
import com.tricentis.objectRepository.LoginPage;
import com.tricentis.objectRepository.WelcomePage;

public class BaseClass {
	public JavaUtility jutil = new JavaUtility();
	public WebDriverUtility wUtil = new WebDriverUtility();
	public FileUtility fUtil = new FileUtility();
    
	public static ExtentReports extReports;
	public static ExtentTest test;
	public static WebDriver driver;
	
	public WelcomePage wp;
	public LoginPage lp;
	public HomePage hp;

	@BeforeSuite
	public void configReport() {
		ExtentSparkReporter spark = new ExtentSparkReporter(
				"./HTML_reports/ExtentReport_" + jutil.getSystemTime() + ".html");
		extReports = new ExtentReports();
		extReports.attachReporter(spark);
	}

	@BeforeClass
	public void openBrowser() throws IOException {
		driver = new FirefoxDriver();
		wUtil.windowMaximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fUtil.getDatafromProperty("url"));
	}

	@AfterMethod
	public void login() throws IOException {
		wp = new WelcomePage(driver);
		wp.getLoginLink().click();
		
		lp=new LoginPage(driver);
		lp.getEmailTextFeild().sendKeys(fUtil.getDatafromProperty("email"));
		lp.getPasswordTextField().sendKeys(fUtil.getDatafromProperty("password"));
		lp.getLoginButton().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	@AfterMethod
	public void logout() {
		hp = new HomePage(driver);
		hp.getLogoutLink().click();
	}

	@AfterSuite
	public void reportBackup() {
		extReports.flush();
	}
}
