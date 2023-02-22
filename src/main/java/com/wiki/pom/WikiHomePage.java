package com.wiki.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagarant.genericLibraries.Base;


public class WikiHomePage extends Base
{
	public WikiHomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchTextbox;
	
	@FindBy(xpath = "//button[text()='Search']")
	private WebElement searchButton;

	
	
	public WebElement getsearchTextbox() {
		return searchTextbox;
	}
	
	public WebElement getsearchButton() {
		return searchButton;
	}

	
}
