package driver;

import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;
import utility.Log;

public class FirefoxDriverManager extends DriverManager {
	
	@Override
	protected void createDriver() {
		
		this.driver = new FirefoxDriver();
	}
	
	@Override
	protected void setUpDriverBinary(String browserVersion) {
		List<String> lsVersions = WebDriverManager.firefoxdriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(browserVersion)) 
    	{
    		WebDriverManager.firefoxdriver().version(browserVersion).setup();
    		
    	}else
		{
    		if (browserVersion == null || browserVersion.length() == 0) 
			{
				WebDriverManager.firefoxdriver().setup();
			}else
			{
				Log.error(browserVersion +"of" + FirefoxDriverManager.class.toString() + "does NOT support");
			}
		}	
	}
}
