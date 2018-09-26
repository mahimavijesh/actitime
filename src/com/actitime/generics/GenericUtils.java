package com.actitime.generics;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class GenericUtils 
{
   public static void getScreenshot(WebDriver driver,String name)
   {
	 try 
	 {
		 TakesScreenshot ts=(TakesScreenshot) driver;
		  File src = ts.getScreenshotAs(OutputType.FILE);
		  File dest = new File("./screenshots/"+name+".png");
		  FileUtils.copyFile(src, dest);
	 } 
	 catch (IOException e) 
	 {
		
	 }
   }
   public static void selectByIndex(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.selectByIndex(index);
   }
   public static void selectByValue(WebElement element,String value)
   {
	   Select sel=new Select(element);
	   sel.selectByValue(value);
   }
   public static void selectByVisibleText(WebElement element,String text)
   {
	   Select sel=new Select(element);
	   sel.selectByVisibleText(text);
   }
   public static void deselectByIndex(WebElement element,int index)
   {
	   Select sel=new Select(element);
	   sel.deselectByIndex(index);
   }
   public static void deselectByValue(WebElement element,String value)
   {
	   Select sel=new Select(element);
	   sel.deselectByValue(value);
   }
   public static void deselectByVisibleText(WebElement element,String text)
   {
	   Select sel=new Select(element);
	   sel.deselectByVisibleText(text);
   }
   public static void deselectAll(WebElement element)
   {
	   Select sel=new Select(element);
	   sel.deselectAll();
   }
   public static List<WebElement> getOptions(WebElement element)
   {
	   Select sel=new Select(element);
	   return sel.getOptions();
   }
   public static List<WebElement> getAllSelectedOptions(WebElement element)
   {
	   Select sel=new Select(element);
	   return sel.getAllSelectedOptions();
   }
   public static WebElement getFirstSelectedOption(WebElement element)
   {
	   Select sel=new Select(element);
	   return sel.getFirstSelectedOption();
   }
   public static boolean isMultiple(WebElement element)
   {
	   Select sel=new Select(element);
	   return sel.isMultiple();
   }
  
}
