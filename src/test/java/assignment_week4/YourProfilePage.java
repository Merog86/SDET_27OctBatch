package assignment_week4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public void selectLanguage(String lanuageOPtion)
	{
		WebElement languagedropdown=driver.findElement(By.id("locale"));
		select = new Select(languagedropdown);
		select.selectByVisibleText(lanuageOPtion);
	}
	
	public void enterFirstName(String name)
	{
		driver.findElement(firstName).sendKeys(name);
	}
	
	public void enterLastName(String name)
	{
		driver.findElement(lastName).sendKeys(name);
	}
	
	public void enterNickName(String name)
	{
		driver.findElement(nickName).sendKeys(name);
	}
	
	public void selectDisplayName(String name)
	{
		driver.findElement(displayName).sendKeys(name);
	}
	
	public void enterEmail(String emailId)
	{
		driver.findElement(email).sendKeys(emailId);
	}
	
	public void enterWebsiteURL(String url)
	{
		driver.findElement(website).sendKeys(url);
	}
	
	public void clickOnUpdateProfileButton()
	{
		driver.findElement(updateProfileButton).click();
	}
}
