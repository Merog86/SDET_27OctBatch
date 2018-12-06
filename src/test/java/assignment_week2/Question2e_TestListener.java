package assignment_week2;
/*e) Create a ITestListner class and customize , mentioning custom message of Pass and fail.*/
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Question2e_TestListener implements ITestListener{

	public void onTestStart(ITestResult result)
	{
		
	}

	public void onFinish(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("** Inside Listeners - Test Failure ");
		
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("** Inside Listeners - Test success ");
		
	}
}
