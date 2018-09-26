package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{
    @Test(priority=2)
    public void testInvalidLogin() throws InterruptedException
    {
    	String loginTitle = ExcelData.getData(file_path,"TC01", 1, 2);
    	String eErrorMessage = ExcelData.getData(file_path, "TC02", 1, 2);
    	
    	 LoginPage lp=new LoginPage(driver);
         
         
         int rc=ExcelData.getRowCount(file_path, "TC02");
         for(int i=1;i<=rc;i++)
         {
        	 String user = ExcelData.getData(file_path, "TC02", i, 0);
        	 String pass = ExcelData.getData(file_path, "TC02", i, 1);
        	 //enter username
        	 lp.enterUserName(user);
        	 //enter password
        	 lp.enterPassword(pass);
        	 //click on login
        	 lp.clickOnLogin();
        	 Thread.sleep(1000);
        	 //verify error message
        	 String aErrorMessage = lp.verifyErrorMessage();
        	 Reporter.log("Expected Error Message: "+eErrorMessage, true);
        	 Reporter.log("Actual Error Message: "+aErrorMessage, true);
        	 Assert.assertEquals(aErrorMessage, eErrorMessage);
        	 Reporter.log("Error Message is matching.............", true);
         }
         
        //verify login page
         lp.verifyPage(loginTitle);
    }
	
	
	
}
