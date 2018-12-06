package assignment_week2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.orangeHR.application.LoginPage;

/*1- How to handle exception when driver is returned null, for e.g. in other class where we were passing.
*/
public class Question1 {
	
	static WebDriver driver;

	public static void main(String[] args) {
		
	// handling the chance of getting NullPointerException in below way	
		if(driver==null)
		{
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		else {
			
		}
		LoginIntoOrangeHRMApplication();
	}
	
	// For the below method there is a chance of getting the NullPointerException for driver variable
	public static void LoginIntoOrangeHRMApplication()
	{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		LoginPage page=new LoginPage(driver);
		page.enterUsername("admin");
		page.enterPassword("admin123");
		page.clickLoginButton();
	}

}
