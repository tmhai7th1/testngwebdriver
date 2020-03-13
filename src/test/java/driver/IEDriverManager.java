package driver;

import java.util.List;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.ie.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import utility.Log;

public class IEDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		DesiredCapabilities capability = DesiredCapabilities.internetExplorer();
		capability.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capability.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		this.driver = new InternetExplorerDriver(capability);
	}
	
	@Override
	protected void setUpDriverBinary(String browserVersion) {
		
		List<String> lsVersions = WebDriverManager.iedriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(browserVersion)) 
    	{
    		WebDriverManager.iedriver().version(browserVersion).setup();
    		
    	}else
		{
    		if (browserVersion == null || browserVersion.length() == 0) 
			{
				WebDriverManager.iedriver().setup();
			}else
			{
				Log.error(browserVersion +"of" + IEDriverManager.class.toString() + "does NOT support");
			}
		}
	}

}
