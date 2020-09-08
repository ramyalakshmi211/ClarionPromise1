package com.clarion_Promise.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SearchPage {
	
WebDriver ldriver;
	
	public SearchPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this);
	}
	
	
	@FindBy(how=How.ID, using="cboEmp")
    @CacheLookup
    WebElement promisor;
	
	@FindBy(how=How.ID, using="txtStartDate")
    @CacheLookup
    WebElement StartDate;
	
	@FindBy(how=How.NAME, using="btnSearch")
    @CacheLookup
    WebElement Searchbtn;
	
	@FindBy(how=How.XPATH, using="/html/body/table/tbody/tr[6]/td/table/tbody/tr[6]/td/table/tbody/tr/td/table")
    @CacheLookup
    WebElement table;
	
	@FindBy(how=How.XPATH, using="//b[contains(text(),'LOGOUT')]")
    @CacheLookup
    WebElement Logoutlnk;
	
	
	public void ClickPromisor()
	{
		promisor.click();
	}
	
	public void SelectPromisor(String str)
	{
		Select set=new Select(promisor);
		set.selectByVisibleText(str);
				
	}
	
	public void ClickSearch()
	{
		Searchbtn.click();
	}
	
	public void CheckPromiseadded()
	{
		String data=table.getText();
		System.out.println(data);
		
	}
	
	public void ClickLogout()
	{
		Logoutlnk.click();
	}


}
