package com.clarion_Promise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogPromisePage {
	
WebDriver ldriver;
	
	public LogPromisePage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//a[contains(text(),'Log Promise')]")
	@CacheLookup
	WebElement LogPromise;
	
	public void clickLogPromise()
	{
		LogPromise.click();
	}
	
}	