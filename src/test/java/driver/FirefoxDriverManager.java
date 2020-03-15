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
	protected void setUpDriverBinary(String v_driver) {
		List<String> lsVersions = WebDriverManager.firefoxdriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(v_driver)) 
    	{
    		WebDriverManager.firefoxdriver().version(v_driver).setup();
    		
    	}else
		{
    		if (v_driver == null || v_driver.length() == 0) 
			{
				WebDriverManager.firefoxdriver().setup();
			}else
			{
				Log.error(v_driver +"of" + FirefoxDriverManager.class.toString() + "does NOT support");
			}
		}	
	}
}
