package assignment_week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examples.TestData;

public class Question1 {

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
	
/*	Scenario 1-
	a- Login Page validation of Wordpress application, create submit page method
	b- Write TestNG Test in Test Scenario file and write login flow*/
	
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
	
	/*Scenario 2-
	a- Create Directory Page class, Create method for All User search.(Users>All Users)
	b- Write 1 test method one for
	c- search(enter value in text box, Select Search, Validate search result using Assert)
	*/
	
	@Test(priority=2, enabled=false)
	public void TestUserSearch() throws InterruptedException
	{
		DemoSiteDashboardPage dashboardPage=new DemoSiteDashboardPage(driver);
		dashboardPage.clickOnUsersLink();
		dashboardPage.clickOnAllUsersLink();
		Thread.sleep(5000);
		UsersPage usersPage=new UsersPage(driver);
		usersPage.enterSearchUserName("admin");
		usersPage.clickSearchUsersButton();
		Assert.assertEquals(usersPage.getUserNames().contains("admin"), true);

	}
	
	/*Scenario 3-
	a- Go to Add New User Page(Inside User), Write POM structure for creating a new user, Create different methods for all text box’s available and dropdown.
	b- Write 1 test method on Test scenario class, one is for-
	a. Create a test for adding new user.*/
	
	@Test(priority=3, enabled=true)
	public void AddNewUser() throws InterruptedException
	{
		DemoSiteDashboardPage dashboardPage=new DemoSiteDashboardPage(driver);
		WebElement usersMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name' and contains(.,'Users')]"));
		//	WebElement allPostsSubmenu=driver.findElement(By.xpath("//div[@class='wp-first-item' and contains(.,'All Posts')]"));
			WebElement addNewSubmenu = null;
			try {
			Actions action=new Actions(driver);
			action.moveToElement(usersMenu).build().perform();
			Thread.sleep(15000);
			driver.switchTo().defaultContent();
			addNewSubmenu=driver.findElement(By.linkText("Add New"));
			addNewSubmenu.click();
			Thread.sleep(8000);
			}
			catch(Exception e) {
				addNewSubmenu.click();
			}
		Thread.sleep(8000);
		AddNewPage addNew=new AddNewPage(driver);
		addNew.enterUserName("Srinivas");
		addNew.enterEmail("sivasrinivas.jayanthi@gmail.com");
		addNew.enterFirstName("Srinivas");
		addNew.enterLastName("Jayanthi");
		addNew.clickAddNewUserButton();
		
		
	}
	
/*	Scenario 4-
	a- Go to Update profile page and create POM class page for Updating profile.(Mention all text box’s and dropdown, checkbox in a method.
	b- Write a method in Test scenario to update scenario,.*/
	
	@Test(priority=4, enabled=true)
	public void UpdateProfile() throws InterruptedException
	{
		DemoSiteDashboardPage dashboardPage=new DemoSiteDashboardPage(driver);
		WebElement usersMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name' and contains(.,'Users')]"));
		//	WebElement allPostsSubmenu=driver.findElement(By.xpath("//div[@class='wp-first-item' and contains(.,'All Posts')]"));
			WebElement yourProfileSubmenu = null;
			try {
			Actions action=new Actions(driver);
			action.moveToElement(usersMenu).build().perform();
			Thread.sleep(15000);
			driver.switchTo().defaultContent();
			yourProfileSubmenu=driver.findElement(By.linkText("Your Profile"));
			yourProfileSubmenu.click();
			Thread.sleep(8000);
			}
			catch(Exception e) {
				yourProfileSubmenu.click();
			}
		Thread.sleep(8000);
		YourProfilePage profilePage=new YourProfilePage(driver);
		profilePage.selectLanguage("English (United States)");
		profilePage.enterFirstName("Srinivas");
		profilePage.enterLastName("Jayanthi");
		profilePage.enterNickName("admin1");
		profilePage.selectDisplayName("admin");
		profilePage.enterEmail("sivasrinivas.jayanthi@admin.com");
		profilePage.enterWebsiteURL("https://stackoverflow.com");
		profilePage.clickOnUpdateProfileButton();
	}
}
