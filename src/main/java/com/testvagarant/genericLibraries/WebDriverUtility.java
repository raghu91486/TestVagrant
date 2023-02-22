package com.testvagarant.genericLibraries;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.aventstack.extentreports.Status;


public class WebDriverUtility extends Base
{
	
	protected static Logger logger = LoggerFactory.getLogger(WebDriverUtility.class);

	public WebDriver driver;

	public void waitforElement(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();

	}

	public void ScrolltoWebElement(WebElement webelement,WebDriver driver)
	{
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", webelement);
	}
	
	public void openNewTab(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open()");
	}
	
	public void switchToDifferentTab(int index,WebDriver driver)
	{
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(newTb.get(index));
	}
	
	public static void logger(String methodName) {
		testLogger().log(Status.INFO, "Test step name is : " + methodName);

		logger.info("Test step name is : " + methodName);
	}	
	
		
}

