package com.TestVagarant.All;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.imbd.pom.HomePage;
import com.imbd.pom.TitlePage;
import com.testvagarant.genericLibraries.Base;
import com.testvagarant.genericLibraries.ObjectReader;
import com.testvagarant.genericLibraries.WebDriverUtility;
import com.wiki.pom.MoviPage;
import com.wiki.pom.WikiHomePage;

public class TC001 extends Base
{
	
	@Test
	public void merchantlogin() throws Throwable
	{
		
		String pushpaPart1=excel.getExcelData("testdata", 1, 1);
		String moviname=excel.getExcelData("testdata", 1, 2);
		HomePage home = new HomePage();
		TitlePage titlepage = new TitlePage();
		WikiHomePage wikihome = new WikiHomePage();
		MoviPage movi = new MoviPage();
        WebDriverUtility utility = new WebDriverUtility();
		SoftAssert asert = new SoftAssert();

		
        
		home.getsearchTextbox().sendKeys(pushpaPart1);
		home.getsearchButton().click();
		utility.waitforElement(driver);
		titlepage.getMoviLink(pushpaPart1);
		String releaseDate = titlepage.getreleaseDate().getText();
		WebDriverUtility.logger(releaseDate);
		String countryName = titlepage.getcountry().getText();
		WebDriverUtility.logger(countryName);		
		
		
		utility.openNewTab(driver);	
		utility.switchToDifferentTab(1,driver);
	    driver.get(ObjectReader.reader.wikiUrl());
	    wikihome.getsearchTextbox().sendKeys(moviname);
		utility.waitforElement(driver);
	    wikihome.getsearchButton().click();
		utility.waitforElement(driver);
		utility.ScrolltoWebElement(movi.getreleaseDate(),driver);	    
	    String WikireleaseDate = movi.getreleaseDate().getText();
		WebDriverUtility.logger(WikireleaseDate);		
	    System.out.println(WikireleaseDate);
	    String wikicountry = movi.getcountry().getText();
		WebDriverUtility.logger(wikicountry);
		asert.assertEquals(WikireleaseDate, releaseDate);
		asert.assertEquals(wikicountry, countryName);
		asert.assertAll();
	}
	
}
