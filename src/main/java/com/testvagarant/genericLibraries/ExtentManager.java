package com.testvagarant.genericLibraries;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class ExtentManager {
	static DateFormat df = new SimpleDateFormat("ddMMyyHHmmss");
	static Calendar calobj = Calendar.getInstance();
	
	protected static ExtentReports extent;
	protected final static String filePath = "./test-output/TestVagarant_Test"+df.format(calobj.getTime())+".html";
	protected static ExtentHtmlReporter htmlReporter;

	public synchronized static ExtentReports getReporter() {
		if (extent != null) {
			return extent;
		} else {

			extent = new ExtentReports();

			extent.setSystemInfo("Environment", "Qa");
			extent.attachReporter(getHtmlReporter());
			extent.setAnalysisStrategy(AnalysisStrategy.CLASS);
			return extent;
		}

	}

	public static ExtentHtmlReporter getHtmlReporter() {

		htmlReporter = new ExtentHtmlReporter(filePath);
		htmlReporter.setAppendExisting(false);
		htmlReporter.loadXMLConfig(
				System.getProperty("user.dir") + "/src/main/resources/configFiles/extent-config.xml");

		return htmlReporter;
	}

}
