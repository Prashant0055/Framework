package com.learnmaven.Pages;


import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnmaven.utility.BrowserFactory;
import com.learnmaven.utility.ExcelDataProvider;
import com.learnmaven.utility.Helper;
import com.learnmaven.utility.ReadConfigData;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ReadConfigData config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() 
	{
		Reporter.log("Setting Up reports and Test is getting ready", true);
		
		excel=new ExcelDataProvider();
		config=new ReadConfigData();
		
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FB_"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be Started", true);
	}
	
	@BeforeClass
	public void setUp() 
	{
		Reporter.log("Trying to start Browser", true);
		driver=BrowserFactory.startApp(driver, config.getBrowser(), config.getURL());
		Reporter.log("Browser is up and running", true);
	}
	
    @AfterClass
	public void shutDown() 
	{
    	Reporter.log("Trying to Close Browser", true);
		BrowserFactory.quitBrowser(driver);
		Reporter.log("Browser is Closed", true);
	}
    
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
    	
    	Reporter.log("Test is about to end", true);
		
    	if (result.getStatus()==ITestResult.FAILURE) {
				logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
    	else if (result.getStatus()==ITestResult.SUCCESS) {
    		logger.pass("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
    	else if (result.getStatus()==ITestResult.SKIP) {
    		logger.skip("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
    	
    	report.flush();
    	
    	Reporter.log("Test Completed >> Reports generated", true);
	}

}
