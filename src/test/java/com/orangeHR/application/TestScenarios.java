package com.orangeHR.application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examples.TestData;

public class TestScenarios {
	TestData data=new TestData();
	WebDriver driver;

	public TestScenarios() throws IOException
	{
		File file=new File("data.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
				
		data.setUrl(prop.getProperty("url"));
		data.setUsername(prop.getProperty("Username"));
		data.setPassword(prop.getProperty("Password"));
		
		System.out.println(prop.getProperty("url"));
		System.out.println(prop.getProperty("Username"));
		System.out.println(prop.getProperty("Password"));
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
        driver.get(data.getUrl());
	}
	
//Assignment 3 - Scenario1: Login into OrangeHRM application
 @Test(enabled=true,priority=1)
	public void testLogin() {
	 
		LoginPage login=new LoginPage(driver);
		login.enterUsername(data.getUsername());
		login.enterPassword(data.getPassword());
		login.clickLoginButton();

	}
 
//Assignment 3 - Scenario2: Search Directory for a user and assert the user from search results
 @Test(enabled=false)
 public void searchDirectory() throws InterruptedException
 {
	 testLogin();
	 Thread.sleep(8000);
	 OrangeHRMHomePage homePage=new OrangeHRMHomePage(driver);
	 String welcomeText=homePage.getWelcomeMessage();
	 Assert.assertEquals(welcomeText.contains(data.getUsername()), true);
	 homePage.clickDirectoryTab();

	 Thread.sleep(5000);
	 DirectoryPage directoryPage=new DirectoryPage(driver);
	 directoryPage.enterSearchName("Linda Anderson");
	 directoryPage.selectJobTitle("HR Manager");
	 directoryPage.selectLocation("    Texas R&D");
	 directoryPage.clickSearchButton();
	 
	 Assert.assertEquals(directoryPage.returnSearchResults().contains("Linda Anderson"),true);
	 
	 directoryPage.clickResetButton();
 }
 
 // Assignment 3- Scenario3: Search for Admin user and click add button for searched employee/user
 @Test(enabled=false)
 public void searchAdmin() throws InterruptedException
 {
	 testLogin();
	 Thread.sleep(8000);
	 OrangeHRMHomePage homePage=new OrangeHRMHomePage(driver);
	 homePage.clickAdminTab();
	 Thread.sleep(4000);
	 AdminPage admin=new AdminPage(driver);
	/* admin.enterUserName("Daniel");
	 admin.selectUserRole("ESS");
	 admin.enterEmployeeName("Daniel Daniel Daniel");
	 admin.selectStatus("Enabled");*/
	 
	 admin.enterUserName("fiona.grace");
	 admin.selectUserRole("ESS");
	 admin.enterEmployeeName("Fiona Grace");
	 admin.selectStatus("Enabled");
	 
	 admin.clickSearchButton();
	 
	// Assert.assertEquals(admin.returnSearchResults().contains("Daniel"),true);
	 Assert.assertEquals(admin.returnSearchResults().contains("fiona.grace"),true);
	 Thread.sleep(5000);
	 admin.clckCheckBoxForAUser("Daniel");
	 admin.clickAddButton();
	// admin.clickResetButton();
 }
 
//Assignment 3 - Scenario4: Assign Leave from Leave tab
 @Test(enabled=true,priority=2)
 public void AssignLeave() throws InterruptedException
 {
	 Thread.sleep(5000);
	 OrangeHRMHomePage homePage=new OrangeHRMHomePage(driver);
	 homePage.clickLeaveTab();
	 Thread.sleep(3000);
	 homePage.clickAssignLeaveTab();
	 AssignLeavePage leavePage=new AssignLeavePage(driver);
	 Thread.sleep(3000);
	 leavePage.enterEmployeeName("Robert Craig");
	 leavePage.selectLeaveType("Sick");
	 String pattern = "yyyy-MM-dd";
	 
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date1 = simpleDateFormat.format(new Date());
	//	System.out.println(date1);
		LocalDate date2=LocalDate.now().plusDays(3);
	//	System.out.println(LocalDate.now().plusDays(3));
		
	 leavePage.enterFromDate(date1);
	 leavePage.enterToDate(date2.toString());
	 leavePage.selectDuration("Full Day");
	 leavePage.clickAssignButton();
 }
 
}
