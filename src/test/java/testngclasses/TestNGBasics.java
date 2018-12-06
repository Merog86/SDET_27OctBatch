package testngclasses;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners(ReportingListeners.class)
public class TestNGBasics {
	
	@BeforeTest
	public void beforeTest()
	{
	System.out.println("** Inside Before suite");	
	}
	
	@Test(priority=1)
	public void testMethod1()
	{
		System.out.println("*** Inside Method1");
	}
	
	@Test(priority=2)
	public void testMethod2()
	{
		System.out.println("*** Inside Method2");
		Assert.fail();
	}
	
	@Test(priority=3, dependsOnMethods="testMethod2")
	public void testMethod3()
	{
		System.out.println("*** Inside Method3");
	}
	
	@AfterTest
	public void afterTestMethod()
	{
		System.out.println("** Inside After testMethod");
	}

}
