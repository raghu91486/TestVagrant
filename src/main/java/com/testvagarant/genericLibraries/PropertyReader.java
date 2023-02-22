package com.testvagarant.genericLibraries;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.testvagarant.genericLibraries.IPathConstants;


public class PropertyReader implements ConfigReader {

	public static Properties prop;
	private static FileInputStream file;

	public PropertyReader() {

		try {
			 //String filePath =
			 //ResourceHelper.getResourcePath("/src/main/resources/configFiles/"+System.getProperty("env")+".properties");

			String filePath = IPathConstants.propertyFile;

			System.out.println(filePath);

			file = new FileInputStream(new File(filePath));

			System.out.println(filePath + "  Path of a File ");

			prop = new Properties();
			prop.load(file);
			System.out.println("SUCCESS File Load");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String imbdUrl() {
		return prop.getProperty("imbdurl");
	}

	public String wikiUrl() {
		return prop.getProperty("wikiurl");
	}
	
}
