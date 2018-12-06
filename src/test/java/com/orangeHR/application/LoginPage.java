package com.orangeHR.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private By username=By.id("txtUsername");
	private By password=By.id("txtPassword");
	private By loginButton=By.id("btnLogin");
	WebDriver driver=null;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}

	public void enterUsername(String uid)
	{
		driver.findElement(username).sendKeys(uid);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
}
