package com.clarion_Promise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(name="txtUsername")
	@CacheLookup
	WebElement txtUsername;
	
	@FindBy(name="txtPassword")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="submit1")
	@CacheLookup
	WebElement loginbtn;
	
	

	
	public void setUserName(String uname)
	{
		txtUsername.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void ClickSubmit()
	{
		loginbtn.click();
		
	}
	

	



}
