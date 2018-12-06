package week4Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DemoSiteLoginPage {

	WebDriver driver=null;
	public DemoSiteLoginPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By username=By.id("user_login");
	private By password=By.id("user_pass");
	private By loginButton=By.id("wp-submit");
	
	public void enterUsername(String user)
	{
		driver.findElement(username).sendKeys(user);
	}
	
	public void enterPassword(String pwd)
	{
		driver.findElement(password).sendKeys(pwd);
	}
	
	public void clickLoginButton()
	{
		driver.findElement(loginButton).click();
	}
	
}
