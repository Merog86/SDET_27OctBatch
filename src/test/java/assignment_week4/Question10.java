package assignment_week4;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import examples.SeleniumTest;
import examples.TestData;

public class Question10 extends SeleniumTest{
	
	TestData data=new TestData();
	@BeforeTest
	void beforeTest() throws IOException
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
	}
	
	// Following test case will print all titles of the OrangeHRM application
	@Test(enabled=false)
	public void printOrangeHRMTitles() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		List<String> titles=new ArrayList<String>();
		driver.get(data.getUrl());
		Thread.sleep(8000);
		titles.add(driver.getTitle());
		driver.findElement(By.id("txtUsername")).sendKeys(data.getUsername());
		driver.findElement(By.id("txtPassword")).sendKeys(data.getPassword());
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		titles.add(driver.getTitle());
		
		for(String title:titles)
		{
			System.out.println(title);
		}
				
	}
	
	// Following test case will print the current urls of the pages
	@Test(enabled=false)
	public void printCurrentPageUrls() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		List<String> urls=new ArrayList<String>();
		driver.get(data.getUrl());
		Thread.sleep(8000);
		urls.add(driver.getCurrentUrl());
		driver.findElement(By.id("txtUsername")).sendKeys(data.getUsername());
		driver.findElement(By.id("txtPassword")).sendKeys(data.getPassword());
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		urls.add(driver.getCurrentUrl());
		
		for(String url:urls)
		{
			System.out.println(url);
		}
	}

	@Test(enabled=true)
	public void printCurrentPageSource() throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		List<String> pageSoureces=new ArrayList<String>();
		driver.get(data.getUrl());
		Thread.sleep(8000);
		pageSoureces.add(driver.getPageSource());
		driver.findElement(By.id("txtUsername")).sendKeys(data.getUsername());
		driver.findElement(By.id("txtPassword")).sendKeys(data.getPassword());
		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);
		pageSoureces.add(driver.getPageSource());
		
		for(String source:pageSoureces)
		{
			System.out.println(source);
		}
	}
}
