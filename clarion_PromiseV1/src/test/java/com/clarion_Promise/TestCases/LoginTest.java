package com.clarion_Promise.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.clarion_Promise.PageObjects.LoginPage;
import com.clarion_Promise.PageObjects.SearchPage;
import com.clarion_Promise.PageObjects.AddPromise;
import com.clarion_Promise.PageObjects.LogPromisePage;

public class LoginTest extends BaseClass {
	
	
	@Test
	public void LoginTest() 
	{
		
		
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(Username);
		
		logger.info("Entered Username");
		lp.setPassword(Password);
		
		logger.info("Entered Password");
		lp.ClickSubmit();
		
		
		if(driver.getTitle().equals("Promises Log"))
		{
			Assert.assertTrue(true);
			
			logger.info("Login Test Passed");

		}
		else {
			logger.info("Login Test Failed");
		}
		
	}
    @Test (dependsOnMethods = { "LoginTest" })
	public void LogPromisePage()
	{
	LogPromisePage lpp=new LogPromisePage(driver);
	lpp.clickLogPromise();

	
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	logger.info("Clicked on log promise");
	}
	
	@Test (dependsOnMethods = { "LoginTest", "LogPromisePage"})
	public void AddPromiseTest() 
	{
	AddPromise ap=new AddPromise(driver);
	ap.ClickPromiseFrom();
	logger.info("Clicked on Promise From");
	ap.addpromise("Sonali test");
	logger.info("Selected Sonali test");
	String text=RandomString()+"ramya";
	ap.SetPromise(text);
	ap.Clickbtn();
	logger.info("Clicked on button" );
	
	
	 boolean res=driver.getPageSource().contains("Promise added successfully");
	 if(res==true)
	 {
		 Assert.assertTrue(true);
		 logger.info("Promise added successfully");
	 }
	 else
	 {
		 Assert.assertTrue(false);
		 logger.info("Promise not added Successfully");
	 }
	}	
	
	@Test(dependsOnMethods = { "LoginTest", "LogPromisePage", "AddPromiseTest"})
	public void SearchPromise()
	{
		SearchPage sp=new SearchPage(driver);
		sp.ClickPromisor();
		sp.SelectPromisor("Sonali test");
		sp.ClickSearch();
			
		sp.CheckPromiseadded();
		
		
		
		
		sp.ClickLogout();

		if(driver.getTitle().equals("Promises Log"))
		{
			Assert.assertTrue(true);
			
			logger.info("Clicked on Logout");

		}
		else {
			logger.info("not Clicked on Logout");
		}
		
	
		
		
		
	}

}