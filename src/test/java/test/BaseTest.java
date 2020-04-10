package test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import driver.DriverManager;
import driver.DriverManagerFactory;
import driver.DriverType;

public class BaseTest {
	
	  protected DriverManager driverManager;
	  protected WebDriver driver;
	  
	  public WebDriver getDriver() {
	     return driver;
	    }
	  @Parameters({"browser","v_driver"})
	  @BeforeClass
	  public void beforeClass(String browser, String v_driver) {
		  
		  driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(browser));
		  driverManager.createDriverBinary(v_driver);
	  }
	
	  @AfterClass
	  public void afterClass() {
			
		  driverManager.ClearCache();
	  }
	  
	  @BeforeMethod
	  public void beforeMethod() {
		 
		  driver = driverManager.getDriver();
		  driver.manage().deleteAllCookies();
		  driver.manage().window().maximize();
	  }
	
	  @AfterMethod
	  public void afterMethod() {
		  
		  driverManager.quitDriver();
	  }

}
