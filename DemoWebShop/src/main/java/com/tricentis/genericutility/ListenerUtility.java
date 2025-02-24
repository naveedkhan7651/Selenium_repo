package com.tricentis.genericutility;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

public class ListenerUtility extends BaseClass implements ITestListener {

	public void onTestStart(ITestResult result) {
	test=extReports.createTest(result.getName());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, "Test Script is Failed");
		TakesScreenshot ts= (TakesScreenshot) driver;
		test.addScreenCaptureFromBase64String(ts.getScreenshotAs(OutputType.BASE64));
		try {
			wUtil.screenShot(driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

}
