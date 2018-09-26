package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generics.BaseTest;
import com.actitime.generics.ExcelData;
import com.actitime.pages.LoginPage;

public class VerifyVersionTest extends BaseTest
{
     @Test(priority=3)
     public void testVerifyVersionTest()
     {
    	 String loginTitle = ExcelData.getData(file_path,"TC01", 1, 2);
     	String eVersion = ExcelData.getData(file_path, "TC03", 1, 0);
     	
     	 LoginPage lp=new LoginPage(driver); 
     	 //verify login page
     	 lp.verifyPage(loginTitle);
     	 //verify version
     	 String aVersion = lp.verifyVersion();
     	 Reporter.log("Expected Version: "+eVersion, true);
     	 Reporter.log("Actual Version: "+aVersion, true);
     	 Assert.assertEquals(aVersion, eVersion);
     	 Reporter.log("Version is matching: ", true);
     }
}
