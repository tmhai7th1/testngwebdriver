package driver;

import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import utility.Log;

public class ChromeDriverManager extends DriverManager {
	
	@Override
	protected void createDriver() {
		
		this.driver = new ChromeDriver();
	}
	
	@Override
	protected void setUpDriverBinary(String v_driver) {
		
		List<String> lsVersions = WebDriverManager.chromedriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(v_driver)) 
    	{
    		WebDriverManager.chromedriver().version(v_driver).setup();
    		
    	}else
		{
    		if (v_driver == null || v_driver.length() == 0) 
			{
				WebDriverManager.chromedriver().setup();
			}else
			{
				
				Log.error(v_driver +"of" + ChromeDriverManager.class.toString() + "does NOT support");
			}
		}
		
	}
	
}
