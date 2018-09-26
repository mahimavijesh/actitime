package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class VerifyBuildTest extends BaseTest
{
     @Test(priority=4)
     public void testVerifyBuild() throws InterruptedException
     {

         String user = ExcelData.getData(file_path, "TC01", 1, 0);
         String pass = ExcelData.getData(file_path, "TC01", 1, 1);
         String loginTitle = ExcelData.getData(file_path,"TC01", 1, 2);
         String enterTimeTrackTitle = ExcelData.getData(file_path, "TC01", 1, 3);
      	 String eBuild = ExcelData.getData(file_path, "TC04", 1, 0);
      	
      	 LoginPage lp=new LoginPage(driver); 
      	 EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
      	 //verify login page
      	 lp.verifyPage(loginTitle);
      	 //enter username
      	 lp.enterUserName(user);
      	 //enter password
      	 lp.enterPassword(pass);
      	 //click on login
      	 lp.clickOnLogin();
      	 //verify enter time track page
      	 lp.verifyPage(enterTimeTrackTitle);
      	 Thread.sleep(1000);
      	 //click on help
      	 ep.clickOnHelp();
      	 Thread.sleep(1000);
      	 //click on about your actitime
      	 ep.clickOnAboutYourActitime();
      	 Thread.sleep(1000);
      	 //verify build
      	 String aBuild = ep.verifyBuild();
      	 Reporter.log("Expeceted Build: "+eBuild, true);
      	 Reporter.log("Actual Build: "+aBuild, true);
      	 Assert.assertEquals(aBuild, eBuild);
      	 Reporter.log("Build is matching: ", true);
      	 
     }
}
