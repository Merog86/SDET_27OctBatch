package assignment_week3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class AdminPage {
	WebDriver driver=null;
	Select select;
	public AdminPage(WebDriver driver)
	{
		this.driver=driver;
	}

	private By userName=By.id("searchSystemUser_userName");
	private By searchButton = By.id("searchBtn");
	private By resetButton = By.id("resetBtn");
	private By selectUserRole=By.id("searchSystemUser_userType");
	private By employeeName=By.id("searchSystemUser_employeeName_empName");
	private By status=By.id("searchSystemUser_status");
	private By resultTable=By.id("resultTable");
	private By addButton=By.cssSelector("input#btnAdd");
	
	public void enterUserName(String name)
	{
		driver.findElement(userName).sendKeys(name);
	}
	
	public void clickSearchButton()
	{
		driver.findElement(searchButton).click();
	}
	
	public void clickResetButton()
	{
		driver.findElement(resetButton).click();
	}
	
	public void selectUserRole(String roleName)
	{
		select=new Select(driver.findElement(selectUserRole));
		select.selectByVisibleText(roleName);
	}
	
	public void enterEmployeeName(String employee)
	{
		driver.findElement(employeeName).sendKeys(employee);
	}
	
	public void selectStatus(String statusName)
	{
		select=new Select(driver.findElement(status));
		select.selectByVisibleText(statusName);
	}
	
	public String returnSearchResults()
	{
		return driver.findElement(resultTable).getText();
			
	}

	public void clckCheckBoxForAUser(String Username) {
	//	driver.findElement(By.xpath("//table[@id='resultTable']//tr[contains(.,'"+Username+"')]/td[2]/preceding-sibling::td/input")).click();
	driver.findElement(By.xpath("//input[contains(@id,'ohrmList_chkSelectRecord')]")).click();
	}
	
	public void clickAddButton()
	{
		driver.findElement(addButton).click();
	}
}
