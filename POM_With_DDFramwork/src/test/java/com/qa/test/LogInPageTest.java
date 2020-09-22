package com.qa.test;

import java.io.FileNotFoundException;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.page.Homepage;
import com.qa.page.HotDeals;
import com.qa.page.LogInPage;

public class LogInPageTest extends Base
{
	LogInPage loginpage;

	Homepage homepage;
	public LogInPageTest() {
		super();
	}
	@BeforeMethod
    public void Setup()
    {
    	initialization();
    	loginpage= new LogInPage();
    	
    	
    }
	
    @Test
    public void loginPageTitleTest() throws FileNotFoundException
    {
    	//Using Log4j we are generating logs
		//Logger log = Logger.getLogger(LogInPageTest.class);	
		//Basic Configurator
		//BasicConfigurator.configure();
		//PropertyConfigurator.configure("log4j.properties"); ///fileNotFoundException is getting generated
		//PropertyConfigurator.configure("log4j.properties");
		//log.info("Launchimg browser");
		String title=loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "Domestic, International Tour Packages | International Holidays Packages, Travel From India, "
				+ "Travel Agents In India - Pack N Go Holidays");
		System.out.println("Title is correct");
		//log.info("Application is launched");
    }
    @Test
    public void loginTest()
    {
    	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    	System.out.println("Login is successful");
    }
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
    
}
