package assignment_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/*Qs3-Launch Application in Chrome, Firefox and Internet explorer browser.
*/
public class Question3 {
	
	public static void main(String[] args)
	{
		launchApplicationInFirefox();
		launchApplicationInChrome();
		launchApplicationInInternetExplorer();
	}

	public static void launchApplicationInFirefox()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
	
		// Open OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Title of Login page: "+driver.getTitle());
		// Open Demo site
		
		driver.get("http://demosite.center/wordpress/wp-login.php");
		System.out.println("Title of Login page: "+driver.getTitle());
		 driver.close();
		 
	}
	
	public static void launchApplicationInChrome()
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		 
		// Initialize browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();

		// Open OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		System.out.println("Title of Login page: "+driver.getTitle());
		 
		// Open Demo site
		driver.get("http://demosite.center/wordpress/wp-login.php");
		
		System.out.println("Title of Login page: "+driver.getTitle());

        driver.close();
	}
	
	public static void launchApplicationInInternetExplorer()
	{
		System.setProperty("webdriver.ie.driver","IEDriverServer.exe");

		WebDriver driver=new InternetExplorerDriver();
		 
		// Open OrangeHRM
		driver.get("https://opensource-demo.orangehrmlive.com/");
		System.out.println("Title of Login page: "+driver.getTitle());
		// Open Demo site
		driver.get("http://demosite.center/wordpress/wp-login.php");
		System.out.println("Title of Login page: "+driver.getTitle());
		driver.close();
	}
}
