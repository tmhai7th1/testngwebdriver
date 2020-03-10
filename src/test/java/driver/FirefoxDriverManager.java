package driver;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Constants;
public class FirefoxDriverManager extends DriverManager {

	@Override
	protected void createDriver() {
		
		try {
			String pathDriver = new File(".").getCanonicalPath() + Constants.PATH_FIREFOXDRIVER;
			System.setProperty("webdriver.gecko.driver",pathDriver);
			this.driver = new FirefoxDriver();
			this.driver.manage().deleteAllCookies();
			this.driver.manage().window().maximize();  
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
