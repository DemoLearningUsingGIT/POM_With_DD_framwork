package com.qa.test;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.apache.commons.io.FileUtils;

import com.qa.base.Base;
import com.qa.page.Homepage;
import com.qa.page.LogInPage;
import com.qa.util.TestUtil;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomepageTest extends Base 
{

	
	Homepage homepage;  
      LogInPage loginpage;
      TestUtil testutil;
      // ====For extent report
      ExtentReports reports;
      ExtentTest test;
      //====
	public HomepageTest() {
		super();
	}
	@BeforeMethod
    public void Setup()
    {
    	initialization();
    	loginpage=new LogInPage();
    	homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
    	System.out.println("Login is successful");
    	// ====For extent report
        reports= new ExtentReports("user.dir"+"\\extentreport.html");
        test= reports.startTest("HomepageTest");
        test.log(LogStatus.INFO, "Homepage is opened");
        //====
    	
    }
	
    @Test
    public void PageTitle() throws IOException
    {
    	String actualtitle=homepage.VerifyTheTitle();
    	//Domestic, International Tour Packages | International Holidays Packages, Travel From India, Travel Agents In India - Pack N Go Holidays
        /*Assert.assertEquals(actualtitle, "Domestic, International Tour Packages | International Holidays Packages, Travel From India, "
        		+ "Travel Agents In India - Pack N Go Holidays","Not Matched");*/
    	 System.out.println("Pagetitle is fine");
    	String Expectedtitle="Domestic, International Tour Packages | International Holidays Packages, Travel From India, Travel Agents In India - Pack N Go Holidays";
       if(actualtitle.equals(Expectedtitle))
       {
    	   test.log(LogStatus.PASS, "title is matched");
       }
       else
       {
    	   test.log(LogStatus.FAIL, "title is mismatched");
    	   test.log(LogStatus.FAIL,test.addScreenCapture(Capture(driver))+"TestFailed");
       }
    }
    private String Capture(WebDriver driver) throws IOException 
    {
    	File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    	File destFile= new File("D:\\Lex_Selenium\\POM_With_DDFramwork\\test-output\\TestingScreenShot.png");
    	String errfile=destFile.getAbsolutePath();
    	FileUtils.copyFile(src, destFile);
    	return errfile;
    }
    
	/*@Test
	public void DatabyDD() throws Exception
    {
		Actions act= new Actions(driver);
		   act.moveToElement(driver.findElement(By.xpath("//a[text()='Holiday']"))).build().perform();
		   Thread.sleep(5000);
		   testutil=new TestUtil();
		testutil.GetDatafromDD(); 
		
    	
    }*/
	
	@AfterMethod
	public void teardown()
	{
		reports.endTest(test);
		reports.flush();
		driver.quit();
	}
	
}
