package utility;
		
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import test.BaseTest;

public class TestListener extends BaseTest implements ITestListener						
{		
	private static String getTestMethodName(ITestResult iTestResult) {
		
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
	
	private static String getTestClass(ITestResult iTestResult) {
		
        return iTestResult.getTestClass().getName().toString();
    }
 
    @Override
    public void onStart(ITestContext iTestContext) {
    	
    	Log.info("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
    }
 
    @Override
    public void onFinish(ITestContext iTestContext) {}
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
    	
    	Log.info("I am in onTestStart method " + getTestMethodName(iTestResult) + " start");
    }
 
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    	
    	 Log.info("I am in onTestSuccess method " + getTestMethodName(iTestResult) + " succeed");
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult) {
    	
    	String message = null;
    	if (iTestResult.getThrowable() != null) {
    		final Throwable testResultThrowable = iTestResult.getThrowable();
            message = testResultThrowable.getMessage() != null ? testResultThrowable.getMessage() :
                    testResultThrowable.getCause().getMessage();
    	}
    	if (message == null) {
             message = "Test failed";
    	}
    	
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
		Utils.takeScreenshot(webDriver, message, getTestClass(iTestResult), getTestMethodName(iTestResult));
    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Log.info("I am in onTestSkipped method " + getTestMethodName(iTestResult) + " skipped");

    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    	 Log.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
}	