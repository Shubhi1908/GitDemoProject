package com.testCases;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
		} else {
			Assert.assertTrue(false);
			logger.info("Login Test Failed!!");
		}
	}

	@AfterClass(alwaysRun = true)
	public void quitDriver() {
		tearDown();
	}

}
