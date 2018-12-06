package assignment_week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoSiteDashboardPage {
	WebDriver driver=null;
	
	private By users=By.linkText("Users");
	private By allUsers=By.linkText("All Users");
	private By addNew=By.linkText("Add New");
	
	public DemoSiteDashboardPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	public void clickOnUsersLink() throws InterruptedException
	{
		driver.findElement(users).click();
		
	}
	
	public void clickOnAllUsersLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(allUsers).click();
		
	}
	
	public void clickOnAddNewLink() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(addNew).click();
		
	}

}
