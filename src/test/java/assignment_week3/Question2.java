package assignment_week3;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import examples.TestData;

/*Assignment Question 2- Implement TestNG Listner and create a class which is implement iTestListner class, 
 * Print pass , fail by printing test data for pass or fail test using Getter/Setter methods.
*/
@Listeners(testngclasses.ReportingListeners.class)
public class Question2{
	
	@Test(priority=1)
	public void Login()
	{
		TestData data=new TestData();
		data.setUsername("Admin");
		System.out.println("** Inside Setting the data Test Dashboard ** ");
	}
	
	@Test(priority=2)
	public void Dashboard()
	{
		TestData data=new TestData();
		data.getUsername();
		System.out.println("** Inside getting the data Test Dashboard ** :" +data.getUsername());
		Assert.assertEquals("Admin",data.getUsername());
	}
	
}
