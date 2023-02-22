package com.imbd.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagarant.genericLibraries.Base;


public class TitlePage extends Base
{
	
	public TitlePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='Pushpa: The Rise - Part 1']")
	private WebElement moviLink;
	
	@FindBy(xpath = "//span[text()='Details']")
	private WebElement detailsTitle;
	
	@FindBy(xpath = "//a[text()='Release date']//ancestor :: li//div")
	private WebElement releaseDate;
	
	@FindBy(xpath = "//button[text()='Country of origin']//ancestor :: li//div")
	private WebElement country;

	public WebElement getmoviLink() {
		return moviLink;
	}
	
	public WebElement getdetailsTitle() {
		return detailsTitle;
	}
	
	public WebElement getreleaseDate() {
		return releaseDate;
	}
	
	public WebElement getcountry() {
		return country;
	}

	private String Xpath = "//a[text()='DynamicMoviName']";

	private WebElement WebElementWithDynamicXpath (String xpathValue, String newValue ) {

	        return driver.findElement(By.xpath(xpathValue.replace("DynamicMoviName", newValue)));
	}

	public void getMoviLink (String dynamicValue) {

	    WebElement dynamicMoviLink = WebElementWithDynamicXpath(Xpath, dynamicValue);

	    dynamicMoviLink.click();

	}
	
}
