package com.orangeHR.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrangeHRMHomePage {
	WebDriver driver=null;
	
	public OrangeHRMHomePage(WebDriver driver)
	{
		this.driver=driver;
	}

	By directory=By.linkText("Directory");
	By admin=By.linkText("Admin");
	By welcomeText=By.id("welcome");
	By leave=By.linkText("Leave");
	By assignLeave=By.linkText("Assign Leave");
	
	public void clickDirectoryTab()
	{
		driver.findElement(directory).click();
	}

	public String getWelcomeMessage() {
		
		return driver.findElement(welcomeText).getText();
		
	}
	
	public void clickAdminTab()
	{
		driver.findElement(admin).click();
	}
	
	public void clickLeaveTab()
	{
		driver.findElement(leave).click();
	}
	
	public void clickAssignLeaveTab()
	{
		driver.findElement(assignLeave).click();
	}
}
