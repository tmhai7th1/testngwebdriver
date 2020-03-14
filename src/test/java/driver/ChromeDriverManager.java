package driver;

import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import utility.Log;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected void createDriver() {
		
		this.driver = new ChromeDriver();
	}
	
	@Override
	protected void setUpDriverBinary(String browserVersion) {
		
		List<String> lsVersions = WebDriverManager.chromedriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(browserVersion)) 
    	{
    		WebDriverManager.chromedriver().version(browserVersion).setup();
    		
    	}else
		{
    		if (browserVersion == null || browserVersion.length() == 0) 
			{
				WebDriverManager.chromedriver().setup();
			}else
			{
				
				Log.error(browserVersion +"of" + ChromeDriverManager.class.toString() + "does NOT support");
			}
		}
		
	}
	
}
