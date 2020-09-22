package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.qa.base.Base;

public class TestUtil extends Base
{
   public static long PAGE_LOAD_TIMEOUT=25;
   public static long IMPLICIT_WAIT=25;
   XSSFWorkbook workbook;
   XSSFSheet sheet;
   
   public void GetDatafromDD() throws Exception
   {
	   
	   File src= new File("D:\\Lex_Selenium\\POM_With_DDFramwork\\src\\main\\java"
	   		+ "\\com\\qa\\testdata\\POM_With_DDF.xlsx");
	   FileInputStream fis= new FileInputStream(src);
	   workbook= new XSSFWorkbook(fis);
	   sheet=workbook.getSheet("sheet1");
	   int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
	   for (int i = 1; i <= rowcount; i++)
	   {
		   driver.findElement(By.xpath("//a[text()='Holidays in India'][1]")).click();
		   driver.findElement(By.xpath("//input[@id='holiday-key']")).
		   sendKeys(sheet.getRow(i).getCell(0).getStringCellValue() );
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Search' and @class='btn-search'][1]")).click();
		 Thread.sleep(5000);
		 System.out.println("Data driven passed");
	}
   }
}
