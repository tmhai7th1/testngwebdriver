package driver;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import utility.Constants;

public class ChromeDriverManager extends DriverManager {

	@Override
	protected void createDriver(){
		
		try {
			ChromeOptions options = new ChromeOptions();
			String pathDriver = new File(".").getCanonicalPath() + Constants.PATH_CHROMEDRIVER;
			System.setProperty("webdriver.chrome.driver", pathDriver);
			this.driver = new ChromeDriver(options);
			options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			this.driver.manage().deleteAllCookies();
			this.driver.manage().window().maximize();  
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
