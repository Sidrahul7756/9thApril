package ListenerStudy;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Listener implements ITestListener
{
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("Take Screenshot", true);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("start the execuation", true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Case skipped", true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("Succesful", true);
	}

}
