package framework.excel;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import framework.excel.ExcelUtil;
import framework.excel.Constants;
import framework.excel.CustomTestNGAnnotation;

public class TestNG_with_ExcelDataProvider {
	
    FluentWait<WebDriver> wait = null;
	WebDriver driver;
	JavascriptExecutor js = (JavascriptExecutor) driver;
	String url = Constants.url, windowID = null;
	int i=0;

	
	  @BeforeSuite
	  public void beforeSuite() {
		  
	      Reporter.log("********** Inside the @BeforeSuite where Chrome browser is getting instantiated", true);
	      
		  System.setProperty("webdriver.chrome.driver", "//home//utkarsh20thgmai//dummy-eclipse-workspace//com.simplilearn.project//Libraries/JARs//webdriver_chrome_driver_version83//chromedriver");
		  driver = new ChromeDriver();
		  
		  driver.manage().window().maximize();
		  
		  js = (JavascriptExecutor) driver;
		  
		  wait = new FluentWait<WebDriver> (driver);
		  wait.withTimeout(10, TimeUnit.SECONDS);
		  wait.pollingEvery(250, TimeUnit.MILLISECONDS);
		  wait.ignoring(NoSuchElementException.class);
		  
		  Reporter.log("********** End of the @BeforeSuite where Chrome browser is getting instantiated", true);
		  System.out.println();
		  
	  }
	  
	  @BeforeTest
	  public void beforeTest() throws InterruptedException {
		  
		  Reporter.log("********** Inside the @BeforeTest where URL is entered and navigated to the target \"Practice Form\"", true);
		  
		  driver.get(url);
		  windowID = driver.getWindowHandle();
		  Thread.sleep(10000);

    	  Reporter.log("********** Now navigating to the target \"Pratice Form\"", true);
    	  
	      WebElement elm1 = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[2]/div/div[3]/h5"));
	      js.executeScript("arguments[0].scrollIntoView();", elm1);
	      Thread.sleep(2000);
	      elm1.click();
	      Thread.sleep(3000);
	      
	      WebElement elm2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[1]/div/div/div[2]/div/ul/li/span"));
	      js.executeScript("arguments[0].scrollIntoView();", elm2);
	      Thread.sleep(2000);
	      elm2.click();
	      
	      Reporter.log("********** End of the @BeforeTest where URL is entered and navigated to the target \"Practice Form\"", true);
	      System.out.println();
		  
	  }	
  
      @DataProvider (name = "ExcelAsDataProvider")
      public Object[][] dpExcel() throws Exception{
    	  
          Object[][] testObjArray = ExcelUtil.getTableArray(Constants.pathname,Constants.sheetname);
          return (testObjArray);

      }
  
      @DataProvider (name = "MethodAsDataProvider")
      public Object[][] dpMethod (Method m){
    	  
          switch (m.getName()) {
            case "Sum":
              return new Object[][] {{2, 3 , 5}, {5, 7, 9}};
            case "Diff":
              return new Object[][] {{2, 3, -1}, {5, 7, -18}};
            }
            return null;
            
      }

      @Test(dataProvider="ExcelAsDataProvider")
      public void Registration_data(String sFirstName,String sLastName, String sEmail, String sMobile)throws  Exception{

	      System.out.println();
	      Reporter.log("********** Inside the @Test which uses [ExcelAsDataProvider] data provider", true);
	      
	      WebElement elm1=driver.findElement(By.id("firstName"));
	      js.executeScript("arguments[0].scrollIntoView();", elm1);
	      Thread.sleep(2000);
	      
	      WebElement elm2 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[1]/div[2]/input"));
	      elm2.click();
	      elm2.sendKeys(sFirstName);
	      Thread.sleep(3000);
	     
	      WebElement elm3 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[1]/div[4]/input"));
	      elm3.click();
	      elm3.sendKeys(sLastName);
	      Thread.sleep(3000);
	     
	      WebElement elm4 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[2]/div[2]/input"));
	      elm4.click();
	      elm4.sendKeys(sEmail);
	      Thread.sleep(3000);
	     
	      driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[3]/div[2]/div[1]/label")).click();
	      Thread.sleep(3000);
	     
	      WebElement elm5 = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div[2]/div[1]/form/div[4]/div[2]/input"));
	      elm5.click();
	      elm5.sendKeys(sMobile);
	      Thread.sleep(3000);
	      
	      String s = String.valueOf(++i);
	      String screenshotPath = "//home//utkarsh20thgmai//dummy-eclipse-workspace//com.simplilearn.project//Libraries//Screenshots//Screenshot_"+s+".png";
	      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	      try {
	          FileUtils.copyFile(screenshot, new File(screenshotPath));
	      } catch (IOException e) {
	          System.out.println(e.getMessage());
	      }
	      
	      WebElement elm6 = driver.findElement(By.id("submit"));
	      js.executeScript("arguments[0].scrollIntoView();", elm6);	      
	      Thread.sleep(5000);
	      
	      driver.findElement(By.id("submit")).click();
	      driver.navigate().refresh();
	      
		  Reporter.log("********** End of the @Test which uses [ExcelAsDataProvider] data provider", true);
		  System.out.println();
		      
          }
  
      @CustomTestNGAnnotation(10)
      @Test (dataProvider = "MethodAsDataProvider", retryAnalyzer = framework.excel.Listener_RetryAnalyzer.class)
      public void Diff (int a, int b, int result) {
    	  
	      System.out.println();
    	  Reporter.log("********** Inside the @Test which uses [MethodAsDataProvider] data provider", true);
    	  
	      int diff = a - b;
	      System.out.println("************* Using [ MethodAsDataProvider ] : ");
	      Assert.assertEquals(result, diff);
	      
	      Reporter.log("********** End of the @Test which uses [MethodAsDataProvider] data provider", true);
	      System.out.println();
	      
      }

      @AfterSuite
      public void afterSuite() {
    	  
	      System.out.println();
    	  Reporter.log("********** Inside the @AfterSuite where Chrome browser is getting closed", true);
    	  
	      driver.close();
	      
	      Reporter.log("********** Outside the @AfterSuite where Chrome browser is getting closed", true);
	      System.out.println();
	  
      }

}
