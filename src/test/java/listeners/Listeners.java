package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
// 		any Test annotation can execute this method will be executed once
		System.out.println("Test method start .... ");
//		Start extent test logic can be moved here
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// When your @test method passes each time
		System.out.println("Test method passed.... ");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// When your @test method fails each time
		System.out.println("Test method failed .... ");
//		Capture screenshot
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// When your @test method skip each time
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("Test method finish .... ");
	}

}
