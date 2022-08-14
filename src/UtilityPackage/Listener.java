package UtilityPackage;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import BasePackage.BaseNew;

public class Listener extends BaseNew implements ITestListener
{
	@Override
	public void onTestFailure(ITestResult result) 
	{
		try {
			BaseNew.captureshot("112345");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		Reporter.log("start the execuation"+result.getName(), true);
	}
	
	@Override
	public void onTestSkipped(ITestResult result) 
	{
		Reporter.log("Case skipped"+result.getName(), true);
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		Reporter.log("Successful"+result.getName(), true);
	}

}
