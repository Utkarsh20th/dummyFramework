package com.toolsqa.DataProviders;

import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class ParallelTest {
	
  public WebDriver driver = null;
	
  @Test
  public void firefox_browser() throws InterruptedException {
	  System.out.println("Thread used for Firefox method execution is: "+Thread.currentThread().getId());
	  
	  /*
	  System.setProperty("webdriver.gecko.driver", "//home//utkarsh20thgmai//Downloads//Softwares//Selenium_softwares//webdriver_gecko_driver//geckodriver");
	  WebDriver driver = new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.get("https://www.wionews.com/");
	  WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[2]/ul/li[4]/a"));
	  ele.click();
	  Thread.sleep(1000);
	  driver.close();
	  */

	  System.setProperty("webdriver.gecko.driver", "//home//utkarsh20thgmai//Downloads//Softwares//Selenium_softwares//webdriver_gecko_driver//geckodriver");
	  FirefoxProfile profile = new FirefoxProfile();
      profile.setPreference("permissions.default.desktop-notification", 1);
      DesiredCapabilities capabilities=DesiredCapabilities.firefox();
      capabilities.setCapability(FirefoxDriver.PROFILE, profile);
      driver = new FirefoxDriver(capabilities);
      
      /*
      // old
      
      driver.get("https://www.wionews.com/");
      driver.switchTo().defaultContent();
	  WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div[1]/header/div[2]/div/div/div[2]/ul/li[4]/a"));
	  ele.click();
	  Thread.sleep(1000);
	  driver.close();
	  */
	  
	  // new
	  
		driver.get("https://www.wionews.com");  //https://www.wionews.com
		//driver.switchTo().defaultContent();
		Thread.sleep(10000);
		
		WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/div/div/div[2]/ul/li[6]/a"));
		// /html/body/div[2]/div/header/div[2]/div/div/div[2]/ul/li[6]/a ------ from Chrome browser
		ele.click();
		Thread.sleep(20000);
		
		driver.close();	 
	  
  }
  
  @Test
  public void chrome_browser() throws InterruptedException {
	  System.out.println("Thread used for Chrome method execution is: "+Thread.currentThread().getId());
	  
	  System.setProperty("webdriver.chrome.driver", "//home//utkarsh20thgmai//Downloads//Softwares//Selenium_softwares//webdriver_chrome_driver_version83//chromedriver");
	  ChromeOptions chromeOptions = new ChromeOptions();
	  chromeOptions.addArguments("--disable-notifications");
	  driver = new ChromeDriver(chromeOptions);
	  driver.manage().window().maximize();
	  
	  // new
	  
		driver.get("https://www.wionews.com");  //https://www.wionews.com
		//driver.switchTo().defaultContent();
		Thread.sleep(10000);
		
		WebElement ele = driver.findElement(By.xpath("/html/body/div[2]/div/header/div[2]/div/div/div[2]/ul/li[6]/a"));
		// /html/body/div[2]/div/header/div[2]/div/div/div[2]/ul/li[6]/a ------ from Chrome browser
		ele.click();
		Thread.sleep(20000);
		
		driver.close();	  
	  
  }
  
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  /*
   @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
  */
  
  @BeforeClass
  public void beforeClass() {
  }

  @AfterClass
  public void afterClass() {
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
  }

  @AfterSuite
  public void afterSuite() {
  }

}
