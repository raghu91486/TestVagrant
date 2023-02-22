package com.testvagarant.genericLibraries;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;



public class Base {
	
	public static WebDriver driver;
	public ExcelFileUtility excel=new ExcelFileUtility();
	protected static ThreadLocal<ExtentTest> testLevelLogger = new ThreadLocal<ExtentTest>();

	protected static ThreadLocal<ExtentTest> classLevelLogger = new ThreadLocal<ExtentTest>();

	public static ExtentReports extent;	

	
		
	@BeforeSuite()
	public void initiateReport() throws IOException {
		extent = com.testvagarant.genericLibraries.ExtentManager.getReporter();	
		
	}
	
	@BeforeClass()
	public void getClassNameForExtentReport() {		
		ExtentTest parent = extent.createTest(getClass().getSimpleName());// Will give the className
		classLevelLogger.set(parent);		
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		ExtentTest child = classLevelLogger.get().createNode(method.getName());
		testLevelLogger.set(child);
		System.out.println(testLevelLogger);
		
	}
	@BeforeTest
	public static void before(){
		
		 WebDriverUtility utility = new WebDriverUtility();
		 System.setProperty("webdriver.chrome.driver", IPathConstants.ChromeDriverPath);
		 driver = new ChromeDriver();
		 System.out.println("raghu");
		 driver.navigate().to(ObjectReader.reader.imbdUrl());
		 utility.maximizeWindow(driver);
	}
	
	@AfterTest
	public static void after(){
		
		 driver.quit();
	}
	@AfterMethod(alwaysRun = true)
	public void getResult(ITestResult result) {
		extent.flush();
	}
	
	@AfterSuite(alwaysRun = true)
	public void CloseReport() {
		com.testvagarant.genericLibraries.ExtentManager.getReporter().flush();
	}

	public static ExtentTest testLogger() {
		return testLevelLogger.get();
	}

}
