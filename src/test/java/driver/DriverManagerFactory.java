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
		  case IE:
			  driveManager = new IEDriverManager();
		    break;
		  default:
			  driveManager = new ChromeDriverManager();
		}
		
		driveManager.type = type;
		return driveManager;
	}
}
