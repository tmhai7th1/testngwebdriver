package testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import webpages.CalculatorPage;
import webpages.CalendarPage;
import test.BaseTest;
import webpages.SignInPage;

public class CalendarGoogle extends BaseTest {

	  @Test(description = "create a appointment into calendar google")
	  public void createTheAppointment() throws InterruptedException{

		  driver.get("https://calendar.google.com/calendar");
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
		  actions.moveToElement(appointment).perform();
		  actions.contextClick(appointment).perform();
		  
		  calendarPage.isDisplayedDeleteButton();
		  calendarPage.clickDeleteButton();
		  
		  calendarPage.isDisplayedPupopDeleteSuccessful();
		  Thread.sleep(5000);
	  }	
	  
	  @Test(description = "verify multiplication from calculator")
	  public void verifyMultiplicationCalendar()
	  {
		  driver.get("https://ahfarmer.github.io/calculator/");
		  CalculatorPage calculatorPage = new CalculatorPage(driver);
		  calculatorPage.clicktw7();
		  calculatorPage.clicktwx();
		  calculatorPage.clicktw6();
		  calculatorPage.clickttwequal();
		  Assert.assertEquals(Integer.parseInt(calculatorPage.gettextcomponentdisplay()),42);
	  }
}
