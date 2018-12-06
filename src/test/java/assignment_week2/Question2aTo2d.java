package assignment_week2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import week4Sessions.DemoSiteDashboardPage;
import week4Sessions.DemoSiteLoginPage;

/*2- Write a TestNG test , with below requirement
	a) Launch a browser in @Beforesuite annotation
	b) Get a url -http://demosite.center/wordpress/wp-login.php(Admin/demo123) in @BeforeTest annotation
	c) Login to application in @Test method, set priority 1 of the same method
	After logging in try to click atleast 3 sub-menu using action class.
	d) Read and store all the menus in an array(string) and print all array inside a loop
	*/

public class Question2aTo2d {
	static WebDriver driver;
	@BeforeSuite
	public void launchBrowser()
	{
		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver=new FirefoxDriver();
	//	driver.manage().window().maximize();
	}
	
	@BeforeTest
	public void beforeTest()
	{
		driver.get("http://demosite.center/wordpress/wp-login.php");
	}
	
	@Test(priority=1)
	public void loginIntoApplication() throws InterruptedException
	{
		DemoSiteLoginPage loginPage=new DemoSiteLoginPage(driver);
		loginPage.enterUsername("admin");
		loginPage.enterPassword("demo123");
		loginPage.clickLoginButton();
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test(priority=2)
	public void clickOnAllPostsSubmenu() throws InterruptedException
	{
		WebElement postsMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name' and contains(.,'Posts')]"));
	//	WebElement allPostsSubmenu=driver.findElement(By.xpath("//div[@class='wp-first-item' and contains(.,'All Posts')]"));
		WebElement allPostsSubmenu = null;
		try {
		Actions action=new Actions(driver);
		action.moveToElement(postsMenu).perform();
		Thread.sleep(3000);
		allPostsSubmenu=driver.findElement(By.linkText("All Posts"));
		allPostsSubmenu.click();
		}
		catch(MoveTargetOutOfBoundsException e) {
			allPostsSubmenu.click();
		}
		Thread.sleep(8000);
	}
	
	@Test(priority=3)
	public void clickOnLibrarySubmenu() throws InterruptedException
	{
		WebElement mediaMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name' and contains(.,'Media')]"));
	//	WebElement allPostsSubmenu=driver.findElement(By.xpath("//div[@class='wp-first-item' and contains(.,'All Posts')]"));
		WebElement librarySubmenu = null;
		try {
		Actions action=new Actions(driver);
		action.moveToElement(mediaMenu).perform();
		Thread.sleep(5000);
		librarySubmenu=driver.findElement(By.linkText("Library"));
		librarySubmenu.click();
		}
		catch(MoveTargetOutOfBoundsException e) {
			librarySubmenu.click();
		}
		Thread.sleep(6000);
	}
	@Test(priority=4)
	public void clickOnAllPagesSubmenu() throws InterruptedException
	{
		WebElement pagesMenu=driver.findElement(By.xpath("//div[@class='wp-menu-name' and contains(.,'Pages')]"));
	//	WebElement allPostsSubmenu=driver.findElement(By.xpath("//div[@class='wp-first-item' and contains(.,'All Posts')]"));
		WebElement allPagesSubmenu = null;
		try {
		Actions action=new Actions(driver);
		action.moveToElement(pagesMenu).perform();
		Thread.sleep(3000);
		allPagesSubmenu=driver.findElement(By.linkText("All Pages"));
		allPagesSubmenu.click();
		}
		catch(MoveTargetOutOfBoundsException e) {
			allPagesSubmenu.click();
		}

	}
	
}
