package cucumbertest;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import com.orangeHR.application.BasePage;
import com.orangeHR.application.DirectoryPage;
import com.orangeHR.application.LoginPage;
import com.orangeHR.application.OrangeHRMHomePage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition {
	WebDriver driver;
	int result=0;
	List<Integer> numbers=new ArrayList<Integer>();
	DirectoryPage dirPage=new DirectoryPage(driver);
	OrangeHRMHomePage homePage=new OrangeHRMHomePage(driver);
	@Given("^UserId and Password are visible$")
	public void userid_and_Password_are_visible() throws Throwable {
		System.out.println("**In UserId and Password are visible");
	}

	@When("^User is able to enter values in login page$")
	public void user_is_able_to_enter_values_in_login_page() throws Throwable {
		System.out.println("**In User is able to enter values in login page");
	}

	@Then("^Login page is successfully submitted and landing page is loaded$")
	public void login_page_is_successfully_submitted_and_landing_page_is_loaded() throws Throwable {
		System.out.println("**In Login page is successfully submitted and landing page is loaded");
	}

	@Given("^Dashboard Page is visible and UI is as per business rule$")
	public void dashboard_Page_is_visible_and_UI_is_as_per_business_rule() throws Throwable {
		System.out.println("** In Dashboard Page is visible and UI is as per business rule");
	}

	@When("^Dashboard page is completely loaded$")
	public void dashboard_page_is_completely_loaded() throws Throwable {
		System.out.println("**In Dashboard page is completely loaded");
	}
	@Given("^Availability of report$")
	public void availability_of_report() throws Throwable {
		System.out.println("**In Availability of report");
	}

	@When("^User is having report access rights$")
	public void user_is_having_report_access_rights() throws Throwable {
	    System.out.println("**In User is having report access rights");
	}

	@Then("^Perform validation on data$")
	public void perform_validation_on_data() throws Throwable {
	    System.out.println("**In Perform validation on data");
	}

	@Given("^I open my application$")
	public void i_open_my_application() throws Throwable {
	    System.out.println("**In I open my application");
	    
	    System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/");
	/*	br.launchBrowser();
	    br.launchApplication();*/
	    
	}

	@Given("^I login with following credentials$")
	public void i_login_with_following_credentials(DataTable table) throws Throwable {

		 System.out.println("**In I login with following credentials");
		 
		 List<String> list=table.asList(String.class);
		 System.out.println("*Username - "+list.get(0));
		 System.out.println("*Password - "+list.get(1));
		 LoginPage login=new LoginPage(driver);
	   login.enterUsername(list.get(0));
	   login.enterPassword(list.get(1));
	   login.clickLoginButton();
	   
	  // Assert.assertedriver.getTitle()
	}
	
	@Given("^I validate the title$")
	public void i_validate_the_title(DataTable table) throws Throwable {
		List<String> list=table.asList(String.class);
	   Assert.assertEquals(driver.getTitle(), list.get(0));
	}
	
	@Given("^a list of numbers$")
	public void a_list_of_numbers(List<Integer> numbers) throws Throwable {
	   this.numbers=numbers;
	}

	@When("^I summarize them$")
	public void i_summarize_them() throws Throwable {
		
	    for(int num: numbers)
	    {
	    	result=result+num;
	    }
	}

	@Then("^I should get (\\d+)$")
	public void i_should_get(int arg1) throws Throwable {
	    Assert.assertEquals(arg1, result);
	}
	
	@When("^I Multiply them$")
	public void i_Multiply_them() throws Throwable {
		int k=1;
		 for(int num: numbers)
		    {
		    	k=k*num;
		    }
		 result=k;
	}

	
	@When("^I click on Directory tab$")
	public void i_click_on_Directory_tab() throws Throwable {
		Thread.sleep(5000);
		homePage.clickDirectoryTab();
	}

	@When("^I enter username as \"([^\"]*)\"$")
	public void i_enter_username(String name) throws Throwable {
	    dirPage.enterSearchName(name);
	}

	@When("^I select the Job Title as \"([^\"]*)\"$")
	public void i_select_the_Job_Title_as(String title) throws Throwable {
	    dirPage.selectJobTitle(title);
	}

	@When("^I select the Location as \"([^\"]*)\"$")
	public void i_select_the_Location_as(String locationName) throws Throwable {
	    dirPage.selectLocation(locationName);
	}

	@When("^I click the Search button$")
	public void i_click_the_Search_button() throws Throwable {
	   dirPage.clickSearchButton();
	}

	@Then("^I should see the user in the result table$")
	public void i_should_see_the_user_in_the_result_table() throws Throwable {
	    dirPage.returnSearchResults();
	}


}
