package com.qa.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class Homepage extends Base
{
     @FindBy(xpath="//a[text()='Gaurav Singh']")
     WebElement HomepageWithName;
     
     public Homepage()
     {
    	PageFactory.initElements(driver, this); 
     }
     
     
     public String VerifyTheTitle()
     {
    	 return driver.getTitle();
     }
     public ProfilePage CLickonVerify()
     {
    	 HomepageWithName.click();
    	 return new ProfilePage();
     }
}
