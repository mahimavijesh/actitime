package com.actitime.generics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class BasePage 
{
  public WebDriver driver;
  @FindBy(xpath="//div[.='TIME-TRACK']")
  private WebElement timeTrack;
  @FindBy(xpath="//div[.='TASKS']")
  private WebElement tasks;
  @FindBy(xpath="//div[.='REPORTS']")
  private WebElement reports;
  @FindBy(xpath="//div[.='USERS']")
  private WebElement users;
  @FindBy(id="logoutLink")
  private WebElement logout;
    public BasePage(WebDriver driver) 
   {
    	this.driver=driver;
	PageFactory.initElements(driver, this);
   }
    public void verifyTitle(String eTitle)
    {
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	try 
    	{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is matching: "+eTitle, true);
		} 
    	catch (Exception e) 
    	{
    	    Reporter.log("Title is not matching; expected title is: "+eTitle, true);
    	    Reporter.log("Actual title is: "+driver.getTitle(), true);
    	    Assert.fail();
    	}
    }
    public void verifyElement(WebElement element)
    {
    	WebDriverWait wait=new WebDriverWait(driver,10);
    	try 
    	{
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is present.....", true);
		} 
    	catch (Exception e) 
    	{
    	    Reporter.log("Element is not present", true);
    	    Assert.fail();
       	}
    }
    
    public void clickOnTimeTrack()
    {
    	timeTrack.click();
    }
    public void clickOnTasks()
    {
    	tasks.click();
    }
    public void clickOnReports()
    {
    	reports.click();
    }
    public void clickOnUsers()
    {
    	users.click();
    }
    
  
}

