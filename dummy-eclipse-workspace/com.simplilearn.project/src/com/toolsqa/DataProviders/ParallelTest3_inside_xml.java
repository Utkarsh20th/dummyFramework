package com.toolsqa.DataProviders;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;

public class ParallelTest3_inside_xml {
	
	public WebDriver driver = null;
	
  @Test (dataProvider = "dp")
  public void calculate(int num) {
	  System.out.println("Currently at calculate number: "+num+" and it is using Thread ID: "+Thread.currentThread().getId());
	  
	  
	  
  }

  @DataProvider (name="dp",parallel=true)
  public Object[][] dp1() {
    return new Object[][] {
      new Object[] { 1 },
      new Object[] { 2 },
      new Object[] { 3 },
      new Object[] { 4 },
      new Object[] { 5 },
      new Object[] { 6 },
      new Object[] { 7 },
      new Object[] { 8 },
      new Object[] { 9 }
    };
  }
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "//home//utkarsh20thgmai//Downloads//Softwares//Selenium_softwares//webdriver_chrome_driver_version83//chromedriver");
	  System.out.println("********** Running method: calculate(): ");
	  
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("********** Test execution is over");
	  
  }

}
