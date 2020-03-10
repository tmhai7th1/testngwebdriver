package testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import driver.DriverManagerFactory;
import driver.DriverType;
import utility.Constants;
import webpages.CalendarPage;
import webpages.SignInPage;

public class CalendarGoogle {

  private WebDriver driver;
  @Parameters({"browserName"})
  @BeforeMethod
  public void beforeMethod(String browserName) {
	  
	  driver = DriverManagerFactory.getDriverManager(DriverType.valueOf(browserName)).getDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  
	  if (driver != null)
	  {
		  driver.quit();
	  }
  }
  
  @Test
  public void createTheAppointment() throws InterruptedException{
	  
	  driver.get(Constants.PAGE_URL);
	  SignInPage signinpage = new SignInPage(driver);
	  
	  CalendarPage calendarPage = signinpage.login("zamodemo63@gmail.com", "demozamo@63");
	  
	  Assert.assertTrue(calendarPage.isDisplayedUsername());
	  Assert.assertEquals(calendarPage.getTextUsername(), "Zamo Demo");
	  
	  Assert.assertTrue(calendarPage.isDisplayedAddButton());
	  calendarPage.clickAddButton();
	  
	  calendarPage.isDisplayedAddTitleAppointment();
	  calendarPage.enterAddTitleAppointment("Zamo Demo Appointment");
	  
	  calendarPage.clickSaveButton();
		
	  calendarPage.isDisplayedPupopSaveSuccessful();
	  
	  WebElement appointment = calendarPage.getAppointment();
	  Assert.assertTrue(appointment.isDisplayed());
	  
	  Actions actions = new Actions(driver);
	  actions.contextClick(appointment).perform();
	  
	  calendarPage.isDisplayedDeleteButton();
	  calendarPage.clickDeleteButton();
	  
	  calendarPage.isDisplayedPupopDeleteSuccessful();
	  Thread.sleep(5000);
  }
}
