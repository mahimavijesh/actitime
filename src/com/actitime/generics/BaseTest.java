package com.actitime.generics;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class BaseTest implements AutoConstant
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(gecko_key, gecko_value);
	}
   @Parameters({"nodeUrl","browser","appUrl"})
   @BeforeMethod
   public void preCondition(String nodeUrl,String browser,String appUrl) throws MalformedURLException
   {
	  
	   URL url=new URL(nodeUrl);
	   DesiredCapabilities dc=new DesiredCapabilities();
	   dc.setBrowserName(browser);
	   driver=new RemoteWebDriver(url, dc);
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   driver.manage().deleteAllCookies();
	   driver.get(appUrl);
   }
   @AfterMethod
   public void postCondition(ITestResult res)
   {
	 if(res.getStatus()==2)  
	 {
		 GenericUtils.getScreenshot(driver, res.getName());
	 }
	 driver.close();
   }
}
