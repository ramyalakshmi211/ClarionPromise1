package com.clarion_Promise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class AddPromise {
	
WebDriver ldriver;
	
	public AddPromise(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(xpath="//select[@name='cboEmp']")
	@CacheLookup
	WebElement PromiseFrom;
	
	@FindBy(xpath="//textarea[@id='txtPromise']")
	@CacheLookup
	WebElement txtPromise;
	
	@FindBy(xpath="//input[@id='btnSubmit']")
	@CacheLookup
	WebElement logpromise;
	
	
	
	public void ClickPromiseFrom()
	{
		PromiseFrom.click();
	}
	
	public void addpromise(String str)
	{
		Select se =new Select(PromiseFrom);
		se.selectByVisibleText(str);
	}
	
	public void SetPromise(String promise)
	{
		txtPromise.sendKeys(promise);
	}
	
	public void Clickbtn()
	{
		logpromise.click();
	}
	
}
