package assignment_week4;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import examples.TestData;
/*Assignment Question 8- Write a java method for testing broken link in Wordpress application login
page and page appear after login.*/

public class Question8 {
	WebDriver driver;
	List<String> brokenlinks;
	TestData data=new TestData();

	@Test
	public void verifyForBrokenLinks() throws IOException, InterruptedException {
		launchBrowser();
		driver.get("http://demosite.center/wordpress/wp-login.php");
		List<WebElement> loginPageLinks = driver.findElements(By.tagName("a"));
		for (int i = 0; i < loginPageLinks.size(); i++) {
			WebElement ele = loginPageLinks.get(i);
			// if (ele.getAttribute("href") != "") {
			String link = ele.getAttribute("href");
			// System.out.println("**URL -> " + link);
			brokenlinks = new ArrayList<String>();
			validateLink(link);
		
		}
		
		DemoSiteLoginPage page=new DemoSiteLoginPage(driver);
		page.enterUsername("admin");
		page.enterPassword("demo123");
		page.clickLoginButton();
		Thread.sleep(10000);
		List<WebElement> DashboardPageLink = driver.findElements(By.tagName("a"));
		for (int i = 0; i < DashboardPageLink.size(); i++) {
			WebElement ele = DashboardPageLink.get(i);
			// if (ele.getAttribute("href") != "") {
			String link = ele.getAttribute("href");
			// System.out.println("**URL -> " + link);
			brokenlinks = new ArrayList<String>();
			validateLink(link);
		
		}
		
	}

	private void validateLink(String link) throws IOException {
		URL url = new URL(link);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		try {
			connection.connect();
			connection.setConnectTimeout(3000);
			int responseCode = connection.getResponseCode();
			String responseMessage = connection.getResponseMessage();
			// System.out.println(response);

			if (responseCode == 200) {
				 System.out.println(link + " - " + responseMessage);
				brokenlinks.add(link);
			} else if (responseCode != 200) {
				 System.out.println(link + " - " + responseMessage);

			} else if (responseCode == connection.HTTP_NOT_FOUND) {
				// System.out.println("URL not found");
				brokenlinks.add(link);
			}
			connection.disconnect();
		}

		catch (Exception exp)

		{
		}

	}

	public void launchBrowser() {
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	
	public void launchApplication() {
		
		driver.get(data.getUrl());
	}
	

	public void openAndCloseLink(String link)
	{
		String defaultWindow=driver.getWindowHandle();
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		for(String winHandle : driver.getWindowHandles()){
		    driver.switchTo().window(winHandle);
		}
		try {
		driver.get(link);
		}
		catch(Exception e) {
			System.out.println("page not loading for url: "+link);
		}
		driver.close();
		driver.switchTo().window(defaultWindow);
	}

}
