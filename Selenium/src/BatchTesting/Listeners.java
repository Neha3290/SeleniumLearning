package BatchTesting;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class Listeners extends TestListenerAdapter{
	
	@Override
	public void onTestStart(ITestResult tr) {
		
		System.out.println("Test is started.");
	}
	
	@Override
	public void onTestSuccess(ITestResult tr) {
		
		System.out.println("Test is passed.");
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
			
			System.out.println("Test is Failed.");
		}
	
	@Override
	public void onTestSkipped(ITestResult tr) {
		
		System.out.println("Test is skipped.");
	}
	
	

}
