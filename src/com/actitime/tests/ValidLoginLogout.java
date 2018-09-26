package com.actitime.tests;

import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.EnterTimeTrackPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogout extends BaseTest
{
     @Test(priority=1)
     public void testValidLoginLogout()
     {
       String user = ExcelData.getData(file_path, "TC01", 1, 0);
       String pass = ExcelData.getData(file_path, "TC01", 1, 1);
       String loginTitle = ExcelData.getData(file_path,"TC01", 1, 2);
       String enterTimeTrackTitle = ExcelData.getData(file_path, "Tc01", 1, 3);
       
       LoginPage lp=new LoginPage(driver);
       EnterTimeTrackPage ep=new EnterTimeTrackPage(driver);
       
      //verify login page
       lp.verifyPage(loginTitle);
      //enter valid username
       lp.enterUserName(user);
      //enter valid password
       lp.enterPassword(pass);
      //click on login
       lp.clickOnLogin();
      //verify enter time track page
       lp.verifyPage(enterTimeTrackTitle);
      //click on logout
       ep.clickOnLogout();
      //verify login page 
       lp.verifyPage(loginTitle);
     }
}
