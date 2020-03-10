package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver){
		
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id=\"identifierId\"]")
	private WebElement username;
	
	@FindBy(xpath="//*[@id=\"identifierNext\"]/span/span")
	private WebElement submitUsernameButton;
	
	@FindBy(xpath="//div[@id=\"password\"]/div[1]/div/div[1]/input")
	private WebElement password;
	
	@FindBy(xpath="//div[@id=\"passwordNext\"]/span/span")
	private WebElement submitPasswordButton;
	
	public CalendarPage login(String user, String pass)
	{
		waitForElementToVisibility(this.username);
		this.username.clear();
		this.username.sendKeys(user);
		
		this.submitUsernameButton.click();
		
		waitForElementToVisibility(this.password);
		this.password.clear();
		this.password.sendKeys(pass);
		
		this.submitPasswordButton.click();
		
		return new CalendarPage(this.driver);
	}
	
}
