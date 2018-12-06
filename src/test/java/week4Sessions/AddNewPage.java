package week4Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AddNewPage {
	WebDriver driver=null;
	Select select;
	public AddNewPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By username=By.id("user_login");
	private By email=By.id("email");
	private By firstName=By.id("first_name");
	private By lastName=By.id("last_name");
	private By webSite=By.id("url");
	private By addNewUser=By.id("createusersub");
	
	public void enterUserName(String name)
	{
		driver.findElement(username).sendKeys(name);
	}
	
	public void enterEmail(String mail)
	{
		driver.findElement(email).sendKeys(mail);
	}
	
	public void enterFirstName(String fName)
	{
		driver.findElement(firstName).sendKeys(fName);
	}
	
	public void enterLastName(String lName)
	{
		driver.findElement(lastName).sendKeys(lName);
	}
	
	public void enterWebsite(String url)
	{
		driver.findElement(webSite).sendKeys(url);
	}
	
	public void clickAddNewUserButton()
	{
		driver.findElement(addNewUser).click();
	}
}
