package com.testCases;

import java.lang.reflect.Method;

import org.testng.Assert;
//import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.pages.LoginPage;
import com.utilities.BaseClass;


public class TC_LoginTest extends BaseClass {

	@BeforeClass
	public void initTest() throws Exception {
		setUp();		
	}

	@Test
	public void loginTest() {
		LoginPage lp = new LoginPage(webDriver);
		lp.setUserName(userName);
		logger.info("Entered Username!!");

		lp.setPassword(password);
		logger.info("Entered Password!!");

		lp.clickOnLogin();
		logger.info("Clicked on Login Button!!");
		
		

		if (webDriver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed!!");
			String logText = "Test Case: loginTest Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			loggerNew.log(Status.PASS, m);
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test Failed!!");
			String logText = "Test Case: loginTest Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			loggerNew.log(Status.FAIL, m);
		}
	}
	
	@BeforeMethod
	public void beforeMethodMethod(Method testMethod) {
		loggerNew = extent.createTest(testMethod.getName());
	}

	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		tearDown();
	}
	
	/*
	@AfterMethod
	public void afterMethodMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: "+methodName+" Passed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
			loggerNew.log(Status.PASS, m);
		}else if(result.getStatus() == ITestResult.FAILURE) {
			String methodName = result.getMethod().getMethodName();
			String logText = "Test Case: "+methodName+" Failed";
			Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
			loggerNew.log(Status.FAIL, m);
		}
	}
	*/

	@AfterTest
	public void afterTestMethod() {
		extent.flush();
	}

}
