package webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalendarPage extends BasePage{

	public CalendarPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="/html/body/div[2]/div[1]/div[1]/div[1]/button/span/div[2]")
	private WebElement addButton;
	
	public boolean isDisplayedAddButton(){
		
		waitForElementToVisibility(addButton);
		return addButton.isDisplayed();
	}
	
	public void clickAddButton(){
		
		addButton.click();
	}
	
	@FindBy(xpath="//*[@id=\"dws12b\"]/div/div[1]/li/label/div[2]/span")
	private WebElement username;
	
	public boolean isDisplayedUsername(){
		
		waitForElementToVisibility(username);
		return username.isDisplayed();
	}
	
	public String getTextUsername(){
		
		return username.getText().trim();
	}
	
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[3]/div[1]/div[1]/div/div[1]/div/div[1]/input")
	private WebElement addTitleAppointment;
	
	public boolean isDisplayedAddTitleAppointment(){
		
		waitForElementToVisibility(addTitleAppointment);
		return addTitleAppointment.isDisplayed();
	}
	
	public void enterAddTitleAppointment(String title){
		
		this.addTitleAppointment.clear();
		this.addTitleAppointment.sendKeys(title);
	}
	
	@FindBy(xpath="//*[@id=\"yDmH0d\"]/div/div/div[2]/span/div/div[1]/div[3]/div[2]/div[3]/span/span")
	private WebElement saveButton;
	
	public void clickSaveButton(){
		
		saveButton.click();
	}
	
	@FindBy(xpath="//*[@class=\"VYTiVb\"]")
	private WebElement popupSaveSuccessful;
	
	public boolean isDisplayedPupopSaveSuccessful(){
		
		waitForElementToVisibility(popupSaveSuccessful);
		return popupSaveSuccessful.isDisplayed();
	}
	
	@FindBy(xpath = "//div[@class=\"lFe10c\"]")
	private WebElement appointment;
	
	public WebElement getAppointment(){
		
		waitForElementToVisibility(appointment);
		return appointment;
	}
	
	@FindBy(xpath="//span[@aria-label=\"Xóa\"]")
	private WebElement deleteButton;
	
	public boolean isDisplayedDeleteButton(){
		
		waitForElementToVisibility(deleteButton);
		return deleteButton.isDisplayed();
	}

	public void clickDeleteButton(){
		
		deleteButton.click();
	}
	
	@FindBy(xpath="//*[@class=\"VYTiVb\"]")
	private WebElement popupDeleteSuccessful;
	
	public boolean isDisplayedPupopDeleteSuccessful(){
		
		waitForElementToVisibility(popupDeleteSuccessful);
		return popupDeleteSuccessful.isDisplayed();
	}
}
