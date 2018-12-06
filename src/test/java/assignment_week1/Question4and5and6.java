package assignment_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.orangeHR.application.LoginPage;

import cucumber.api.java.it.Data;
import examples.TestData;
import week4Sessions.DemoSiteLoginPage;

/*Qs4- Print Get current page url after logging-in .
Qs 5- Print Get currentpage source after logging-in.
Qs 6- Pass webdriver object in another class and use the same (driver) in other class.
*/
public class Question4and5and6 {
	
	static WebDriver driver;
	
	public static void main(String[] args)
	{
		try {
			launchBrowser();
			printLoggedInPageURLAndSourceForOrangeHRMApplication();
			printLoggedInPageURLAndSourceForDemoSite();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void launchBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	//Print Get current page url,currentpage source after logging-in for OrangeHRM application
	public static void printLoggedInPageURLAndSourceForOrangeHRMApplication() throws InterruptedException
	{

	
		// Open OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		//Passing webdriver object into other class and using that class here
		LoginPage page=new LoginPage(driver);
		page.enterUsername("admin");
		page.enterPassword("admin123");
		page.clickLoginButton();
		Thread.sleep(10000);
		//Printing the current page url after logged in
		System.out.println("current page url: "+driver.getCurrentUrl());
		//Printing the current page source after logged in
		System.out.println("current page source: "+driver.getPageSource());
		 
	}
	
	public static void printLoggedInPageURLAndSourceForDemoSite() throws InterruptedException
	{

	
		// Open Demosite
		driver.get("http://demosite.center/wordpress/wp-login.php");
		 
		//Passing webdriver object into other class and using that class here
		DemoSiteLoginPage page=new DemoSiteLoginPage(driver);
		page.enterUsername("admin");
		page.enterPassword("demo123");
		page.clickLoginButton();
		Thread.sleep(10000);
		//Printing the current page url after logged in
		System.out.println("current page url: "+driver.getCurrentUrl());
		//Printing the current page source after logged in
		System.out.println("current page source: "+driver.getPageSource());
		 
	}
}
