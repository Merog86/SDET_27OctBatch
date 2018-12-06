package com.orangeHR.application;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import examples.TestData;

public class BasePage {
	public WebDriver driver;
	List<String> brokenlinks;
	TestData data=new TestData();
	
	public BasePage()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void launchApplication() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
