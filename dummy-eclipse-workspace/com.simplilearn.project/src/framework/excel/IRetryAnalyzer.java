package framework.excel;

import org.testng.ITestResult;

public interface IRetryAnalyzer {

	  public boolean retry(ITestResult result);
	  
}