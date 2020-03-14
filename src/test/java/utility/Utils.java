package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.Reporter;

import utility.Constants;

public class Utils {

	public static void takeScreenshot (WebDriver driver, String messageEx, String className, String methodName)
	{ 
			String testcaseName  = className + "_" + methodName;
			String destination = getDestinationPath(testcaseName);
			StringBuilder contentlog = new StringBuilder();
			contentlog.append(testcaseName);
			contentlog.append(Constants.STATUS_FAILED);
			contentlog.append(System.lineSeparator());
			contentlog.append(destination);
			contentlog.append(System.lineSeparator());
			contentlog.append(messageEx);
			Reporter.log(contentlog.toString());
			try {
				WebDriver augmentedDriver = new Augmenter().augment(driver);
				File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
				File destFile = new File(destination);
				FileUtils.copyFile(scrFile, destFile);
			} catch (IOException e) {
				Log.error(e.getMessage());
			}
	}
	
	private static String getDestinationPath(String testcaseName)
	{
		String dateName = new SimpleDateFormat(Constants.SIMPLEDATEFORMAT).format(new Date());
		StringBuilder destination = new StringBuilder();
		destination.append(System.getProperty("user.dir"));
		destination.append(Constants.PATH_FAILEDTESTSCREENSHOT);
		destination.append(testcaseName);
		destination.append("_");
		destination.append(dateName);
		destination.append(Constants.IMAGE_FORMAT);
		
		return destination.toString();
	}
}
