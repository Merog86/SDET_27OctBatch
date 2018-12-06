package com.orangeHR.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AssignLeavePage {
	WebDriver driver=null;
	Select select;
	public AssignLeavePage(WebDriver driver)
	{
		this.driver=driver;
	}
	private By employeeName=By.id("assignleave_txtEmployee_empName");
	private By leaveType=By.id("assignleave_txtLeaveType");
	private By fromDate=By.id("assignleave_txtFromDate");
	private By toDate=By.id("assignleave_txtToDate");
	private By duration=By.id("assignleave_duration_duration");
	private By assignButton=By.id("assignBtn");

	public void enterEmployeeName(String name)
	{
		driver.findElement(employeeName).sendKeys(name);
	}
	
	public void selectLeaveType(String leave)
	{
		select= new Select(driver.findElement(leaveType));
		select.selectByVisibleText(leave);
	}
	
	public void enterFromDate(String fromDt)
	{
		driver.findElement(fromDate).clear();
		driver.findElement(fromDate).sendKeys(fromDt);
	}
	
	public void enterToDate(String toDt)
	{
		driver.findElement(toDate).clear();
		driver.findElement(toDate).sendKeys(toDt);
	}
	
	public void selectDuration(String durationType)
	{
		select= new Select(driver.findElement(duration));
		select.selectByVisibleText(durationType);
	}
	
	public void clickAssignButton()
	{
		driver.findElement(assignButton).click();
	}
}
