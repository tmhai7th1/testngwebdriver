package driver;

public class DriverManagerFactory {

	public static DriverManager getDriverManager(DriverType type) {
		DriverManager driveManager;
		switch(type) {
		  case CHROME:
			  driveManager = new ChromeDriverManager();
		    break;
		  case FIREFOX:
			  driveManager = new FirefoxDriverManager();
		    break;
		  default:
			  driveManager = new ChromeDriverManager();
		}
		
		return driveManager;
	}
}
