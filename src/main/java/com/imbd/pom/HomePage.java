package com.imbd.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagarant.genericLibraries.Base;


public class HomePage extends Base
{
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@id='suggestion-search']")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//button[@id='suggestion-search-button']")
	private WebElement searchButton;

	
	
	public WebElement getsearchTextbox() {
		return searchTextbox;
	}
	
	public WebElement getsearchButton() {
		return searchButton;
	}

	
}
