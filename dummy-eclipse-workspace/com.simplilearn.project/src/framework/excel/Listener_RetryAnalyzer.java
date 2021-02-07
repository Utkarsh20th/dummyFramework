package framework.excel;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import framework.excel.CustomTestNGAnnotation;

public class Listener_RetryAnalyzer implements IRetryAnalyzer {

	int counter = 0;

	@Override
	public boolean retry(ITestResult result) {

	 // concept of creating Listener class taking input from custom-TestNG-annotation value, referred from --> toolsqa.com
		CustomTestNGAnnotation annotation = result.getMethod().getConstructorOrMethod().getMethod().getAnnotation(CustomTestNGAnnotation.class);
		if((annotation != null) && (counter < annotation.value())) {
			counter++;
			return true;
			
		}
		return false;
		
	}
}