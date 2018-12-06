package assignment_week1;

import org.openqa.selenium.By;

/*1- Dummry URL- https://opensource-demo.orangehrmlive.com/
2- http://demosite.center/wordpress/wp-login.php
UserID- Demo/admin123
Qs1- Find Xpath and CssSelector of Login page of both the login page mentioned above.*/
public class Question1 {
	
	// https://opensource-demo.orangehrmlive.com/index.php/auth/login
	private By HRMloginPageXpath=By.xpath("//form[@id='frmLogin']");
	private By HRMloginPageCss=By.cssSelector("form#frmLogin");
	
	//http://demosite.center/wordpress/wp-login.php
	private By WPloginPageXpath=By.xpath("//form[@id='loginform']");
	private By WPloginPageCss=By.cssSelector("form#loginform");

}
