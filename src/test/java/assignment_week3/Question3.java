package assignment_week3;

/*Assignment Question 3- Please write Superclass, Subclass with below points and write basic method which follow below points
I-Methods declared public in a superclass also must be public in all subclasses.
ii-Methods declared protected in a superclass must either be protected or public in subclasses; they cannot be private.
*/
import org.testng.annotations.Test;

public class Question3 extends SuperClass{

	//for below method protected is not allowing because we are trying to decrease the visibility of method from public to protected
	/*protected void methodA()
	{
		System.out.println("In super class method A");
	}*/
	
	public void methodB()
	{
		System.out.println("In sub class method B");
	}
	
	//for below method protected is not allowing because we are trying to decrease the visibility of method from protected to private
/*	private void mehodC()
	{
		System.out.println("In sub class method C");
	}*/	
	
	protected void mehodD()
	{
		System.out.println("In sub class method D");
	}
	
	@Test
	public void test()
	{
		methodA();
		methodB();
		mehodC();
	}
}
