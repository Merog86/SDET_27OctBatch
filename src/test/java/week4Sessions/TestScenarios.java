package week4Sessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
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
	@BeforeTest
	void beforeTest() throws IOException
	{
		File file=new File("data.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties prop=new Properties();
		prop.load(fis);
				
		data.setUrl(prop.getProperty("demo_url"));
		data.setUsername(prop.getProperty("demo_username"));
		data.setPassword(prop.getProperty("demo_password"));
		
		System.out.println(prop.getProperty("demo_url"));
		System.out.println(prop.getProperty("demo_username"));
		System.out.println(prop.getProperty("demo_password"));
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	//Scenario1- Login into WordPress application
	@Test(priority=1)
	public void DemoLogin() throws InterruptedException
	{
		driver.get(data.getUrl());
		DemoSiteLoginPage loginPage=new DemoSiteLoginPage(driver);
		loginPage.enterUsername(data.getUsername());
		loginPage.enterPassword(data.getPassword());
		loginPage.clickLoginButton();
		Thread.sleep(5000);
	}
	// Scenario2 - Search a users from All users tab and assert it
	@Test(priority=2, enabled=true)
	public void TestUserSearch() throws InterruptedException
	{
		
		DemoSiteDashboardPage dashboardPage=new DemoSiteDashboardPage(driver);
		dashboardPage.clickOnUsersLink();
		dashboardPage.clickOnAllUsersLink();
		Thread.sleep(5000);
		UsersPage usersPage=new UsersPage(driver);
		usersPage.enterSearchUserName("admin");
		usersPage.clickSearchUsersButton();
		Assert.assertEquals(usersPage.getUserNames().contains("admi"), true);

	}
	
	// Scenario3 - Add New User
	@Test(priority=3, enabled=false)
	public void AddNewUser() throws InterruptedException
	{
		DemoSiteDashboardPage dashboardPage=new DemoSiteDashboardPage(driver);
		dashboardPage.clickOnUsersLink();
		driver.switchTo().defaultContent();
		dashboardPage.clickOnAddNewLink();
		Thread.sleep(10000);
		AddNewPage addNew=new AddNewPage(driver);
		addNew.enterUserName("Merog86");
		addNew.enterEmail("sivasrinivas.jayanthi@gmail.com");
		addNew.enterFirstName("Srinivas");
		addNew.enterLastName("Jayanthi");
		addNew.clickAddNewUserButton();
	}
}
