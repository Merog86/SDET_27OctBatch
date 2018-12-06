package week4Sessions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class YourProfilePage {
	WebDriver driver=null;
	Select select;
	public YourProfilePage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	private By language=By.id("locale");
	private By firstName=By.id("first_name");
	private By lastName=By.id("last_name");
	private By nickName=By.id("nickname");
	private By displayName=By.id("display_name");
	private By email=By.id("email");
	private By website=By.id("url");
	private By updateProfileButton=By.id("submit");
}
