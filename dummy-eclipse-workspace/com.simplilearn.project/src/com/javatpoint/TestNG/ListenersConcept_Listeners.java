package com.javatpoint.TestNG;

import org.testng.*;

public class ListenersConcept_Listeners implements ITestListener {
	
	@Override
	public void onTestStart(ITestResult result) {
		
		
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Success of the  test case and its details are \t : "+result.getName());
		
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failure of the  test case and its details are \t : "+result.getName());
		
	}
	
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Skip of the  test case and its details are \t : "+result.getName());
		
	}
	
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Partial Failure of the  test case and its details are \t : "+result.getName());
		
	}
	
	@Override
	public void onStart(ITestContext context) {
		
	}
	
	@Override
	public void onFinish(ITestContext context) {
		
	}
	
}
