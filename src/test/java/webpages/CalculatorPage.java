package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

	public CalculatorPage(WebDriver driver) {
		
		super(driver);
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/button")
	private WebElement tw7;
	
	public void clicktw7(){
		
		this.tw7.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[3]/div[3]/button")
	private WebElement tw6;
	
	public void clicktw6(){
		
		this.tw6.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/button")
	private WebElement twx;
	
	public void clicktwx(){
		
		this.twx.click();
	}
	
	@FindBy(xpath="//*[@id=\"root\"]/div/div[2]/div[5]/div[3]/button")
	private WebElement twequal;
	
	public void clickttwequal(){
		
		this.twequal.click();
	}
	
	@FindBy(className ="component-display")
	private WebElement componentdisplay;
	
	public String gettextcomponentdisplay(){
		
		return this.componentdisplay.getText();
	}

}
