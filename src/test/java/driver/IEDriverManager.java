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
	protected void setUpDriverBinary(String v_driver) {
		
		List<String> lsVersions = WebDriverManager.iedriver().getVersions();
    	if (lsVersions.size() > 0 && lsVersions.contains(v_driver)) 
    	{
    		WebDriverManager.iedriver().version(v_driver).setup();
    		
    	}else
		{
    		if (v_driver == null || v_driver.length() == 0) 
			{
				WebDriverManager.iedriver().setup();
			}else
			{
				Log.error(v_driver +"of" + IEDriverManager.class.toString() + "does NOT support");
			}
		}
	}

}
