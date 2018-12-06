package week4Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class UsersPage {
	WebDriver driver=null;
	Select select;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By userSearchTextBox=By.id("user-search-input");
	private By searchUsersButton=By.id("search-submit");
	private By usersList=By.id("the-list");
	
	public void enterSearchUserName(String name)
	{
		driver.findElement(userSearchTextBox).sendKeys(name);
	}
	public void clickSearchUsersButton()
	{
		driver.findElement(searchUsersButton).click();
	}
	
	public String getUserNames()
	{
		return driver.findElement(usersList).getText();
			
	}
}
