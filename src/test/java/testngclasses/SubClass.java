package testngclasses;

import org.testng.annotations.Test;

public class SubClass extends SuperClass{

	//for below method protected is not allowing because we are trying to decrease the visibility of method
	/*protected void methodA()
	{
		System.out.println("In super class method A");
	}*/
	
	public void methodB()
	{
		System.out.println("In sub class method B");
	}
	
	public void mehodC()
	{
		System.out.println("In sub class method C");
	}	
	
	@Test
	public void test()
	{
		methodA();
		methodB();
		mehodC();
	}
}
