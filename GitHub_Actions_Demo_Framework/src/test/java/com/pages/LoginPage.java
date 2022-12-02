package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilities.BaseClass;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name = "uid")
	WebElement userName;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(name = "btnLogin")
	WebElement btnLogin;
	
	public void setUserName(String uname) {
		userName.sendKeys(uname);
		BaseClass.loggerNew.info("Entering username");
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
		BaseClass.loggerNew.info("Entering password");
	}
	
	public void clickOnLogin() {
		btnLogin.click();
		BaseClass.loggerNew.info("Clicking login button");
	}
	
}
