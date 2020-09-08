package com.clarion_Promise.TestCases;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.clarion_Promise.Utilities.ReadConfig;

public class BaseClass {
	
ReadConfig readconfig=new ReadConfig();
	
	public String baseURL=readconfig.getApplicationURL();
	public String Username=readconfig.getUserName();
	public String Password=readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void Setup(String br)
	{
		logger=Logger.getLogger("Clarion Promise");
		PropertyConfigurator.configure("log4j.properties2");
	
	    if(br.equals("chrome"))
        {
		System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
		driver=new ChromeDriver();
        }
	    else if(br.equals("IEdriver"))
	    {
		System.setProperty("webdriver.iedriver.driver",readconfig.getIEdriverpath());
		driver=new InternetExplorerDriver();
	    }
	    
	    driver.get(baseURL);

}
		
	
	
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	
	public String RandomString()
	{
	String generatedstring =RandomStringUtils.randomAlphabetic(8);
	return (generatedstring);
		
	}
	
}