package com.qa.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;

public class LogInPage extends Base
{
     //page Factory 
	

	@FindBy(xpath="//input[@class='form-control' and contains(@placeholder,'Enter email')]")
	WebElement username1;
	@FindBy(xpath="//input[@type='password']")
	WebElement password1;
	
	@FindBy(xpath="//button[text()=' Login']")
	WebElement submit;
		
	

public LogInPage()
{
	PageFactory.initElements(driver, this);// initialize element 
	
	}
public Homepage Login(String username,String password)
{
	 
	 username1.sendKeys(username);
	 password1.sendKeys(password);
	 
	 submit.click();
	 return new Homepage();
}
 public String validateLoginPageTitle()
 {
	 return driver.getTitle();
 }


}