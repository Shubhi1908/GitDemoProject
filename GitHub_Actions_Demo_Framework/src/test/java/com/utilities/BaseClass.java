package com.utilities;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {

	ReadConfig readconfig = new ReadConfig();

	public String userName = readconfig.getUserName();
	public String password = readconfig.getPasswrord();
	public String baseURL = readconfig.getApplicationURL();
	public String platformType = readconfig.getPlatformType();
	public String browser = readconfig.getBrowser();

	public static WebDriver webDriver;
	public static Logger logger = LogManager.getLogger(BaseClass.class);

	public void setUp() {
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

	public void tearDown() {
		if (platformType.equalsIgnoreCase("web") && !webDriver.equals(null)) {
			webDriver.quit();
			logger.info("Successfully quit driver!!!");
		}
	}
}
