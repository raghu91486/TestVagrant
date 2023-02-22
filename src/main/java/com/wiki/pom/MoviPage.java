package com.wiki.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testvagarant.genericLibraries.Base;

public class MoviPage extends Base {
	public MoviPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[text()='Release date']/ancestor::tr//td//div")
	private WebElement releaseDate;

	@FindBy(xpath = "//th[text()='Country']/ancestor::tr//td")
	private WebElement country;

	public WebElement getreleaseDate() {
		return releaseDate;
	}

	public WebElement getcountry() {
		return country;
	}

}
