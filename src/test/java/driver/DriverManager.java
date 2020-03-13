package driver;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class DriverManager {

	protected WebDriver driver;
	protected DriverType type;
	
    protected abstract void createDriver();
    protected abstract void setUpDriverBinary(String browserVersion);

    public void quitDriver() {
    	
        if (null != driver) {
            driver.quit();
            driver = null;
        }
    }
    
    public void createDriverBinary(String browserVersion) {
    	setUpDriverBinary(browserVersion);
    }

    public WebDriver getDriver() {
    	
    	   if (null == driver) {
    		   createDriver();
    	   }

        return this.driver;
    }
    public void ClearCache() {
    	
    	switch(this.type) {
		  case CHROME:
			  WebDriverManager.chromedriver().clearCache();
		    break;
		  case FIREFOX:
			  WebDriverManager.firefoxdriver().clearCache();
		    break;
		  case IE:
			  WebDriverManager.iedriver().clearCache();
		    break;
		  default:
    	}
    	
    	
    }
    
}
