package com.utilities;

import org.apache.logging.log4j.Logger;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass {
	
	public static WebDriver driver;
	public ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest loggerNew;

	ReadConfig readconfig = new ReadConfig();

	public String userName = readconfig.getUserName();
	public String password = readconfig.getPasswrord();
	public String baseURL = readconfig.getApplicationURL();
	public String platformType = readconfig.getPlatformType();
	public String browser = readconfig.getBrowser();

	public static WebDriver webDriver;
	public static Logger logger = LogManager.getLogger(BaseClass.class);

	public void setUp() {
		reportSetup();
		try {
			if (platformType.equalsIgnoreCase("web")) {
				if (browser.equalsIgnoreCase("chrome")) {
					System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
					webDriver = new ChromeDriver();
					logger.info("Chrome Browser opened successfully!!!");
				} else if (browser.equalsIgnoreCase("ie")) {
					System.setProperty("webdriver.ie.driver", readconfig.getIEPath());
					webDriver = new InternetExplorerDriver();
					logger.info("IE Browser opened successfully!!!");
				} else
					logger.info("Invalid Browser: " + browser);

				webDriver.get(baseURL);
				logger.info("URL is opened!!");
				webDriver.manage().window().maximize();
			}
		} catch (Exception e) {
			logger.info("Exception occured while returning the driver");
		}
	}
	

	private void reportSetup() {
		// TODO Auto-generated method stub
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport.html");

		// configuration items to change the look and feel
		// add content, manage tests etc
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setDocumentTitle("Simple Automation Report");
		htmlReporter.config().setReportName("Test Report");
		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
		
		// initialize ExtentReports and attach the HtmlReporter
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}


	public void tearDown() {
		if (platformType.equalsIgnoreCase("web") && !webDriver.equals(null)) {
			webDriver.quit();
			logger.info("Successfully quit driver!!!");
		}
	}
}
