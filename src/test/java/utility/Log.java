package utility;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
public class Log {
	
	 private static Logger Log = Logger.getLogger(Log.class.getName());
	 
	 public static void info(String message) {
		//BasicConfigurator.configure();
		DOMConfigurator.configure(Constants.PATH_LOGGING);
		Log.info(message);
	 }

	 public static void warn(String message) {
		//BasicConfigurator.configure();
		DOMConfigurator.configure(Constants.PATH_LOGGING);
	    Log.warn(message);
	 }

	 public static void error(String message) {
		//BasicConfigurator.configure();
		DOMConfigurator.configure(Constants.PATH_LOGGING);
	    Log.error(message);
	 }

	 public static void fatal(String message) {
		//BasicConfigurator.configure();
		DOMConfigurator.configure(Constants.PATH_LOGGING);
	    Log.fatal(message);
	 }

	 public static void debug(String message) {
		//BasicConfigurator.configure();
		DOMConfigurator.configure(Constants.PATH_LOGGING);
	    Log.debug(message);
	 }
}
