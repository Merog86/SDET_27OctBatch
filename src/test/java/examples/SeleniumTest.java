package examples;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {
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
 @Test(enabled=false)
	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
				driver.get(data.getUrl());
				driver.findElement(By.id("txtUsername")).sendKeys(data.getUsername());
				driver.findElement(By.id("txtPassword")).sendKeys(data.getPassword());
				driver.findElement(By.id("btnLogin")).click();

	}

}
