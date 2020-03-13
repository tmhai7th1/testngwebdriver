package webpages;

import utility.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;
	
	public BasePage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(this.driver, this);
	}
	
	protected void waitForElementToVisibility(WebElement element){
		
		wait = new WebDriverWait(driver, Constants.TIMEOUTINSECONDS, Constants.POLLING);
		wait.until(ExpectedConditions.visibilityOf(element));
    }
}
