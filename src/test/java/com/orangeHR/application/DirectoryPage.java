package com.orangeHR.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class DirectoryPage {
	WebDriver driver=null;
	Select select;
	public DirectoryPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By searchName=By.id("searchDirectory_emp_name_empName");
	private By searchButton = By.id("searchBtn");
	private By resetButton = By.id("resetBtn");
	private By jobTitle=By.id("searchDirectory_job_title");
	private By location=By.id("searchDirectory_location");
	private By searchResult=By.id("resultTable");
	
	public void enterSearchName(String name)
	{
		driver.findElement(searchName).sendKeys(name);
	}
	
	public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
	}
	
	public void clickResetButton()
	{
		driver.findElement(resetButton).click();
	}
	
	public void selectJobTitle(String title)
	{
		select=new Select(driver.findElement(jobTitle));
		select.selectByVisibleText(title);
	}
	
	public void selectLocation(String locationName)
	{
		select=new Select(driver.findElement(location));
		select.selectByVisibleText(locationName);
	}
	
	public String returnSearchResults()
	{
		return driver.findElement(searchResult).getText();
			
	}
}
