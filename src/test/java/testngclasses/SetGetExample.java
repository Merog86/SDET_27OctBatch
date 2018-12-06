package testngclasses;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import examples.TestData;
@Listeners(ReportingListeners.class)
public class SetGetExample{
	
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
