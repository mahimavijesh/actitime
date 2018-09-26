package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generics.BasePage;
import com.actitime.generics.GenericUtils;

public class EnterTimeTrackPage extends BasePage
{
	//Declaration
    @FindBy(id="logoutLink")
    private WebElement logoutBTN;
    @FindBy(xpath="//div[contains(@class,'support_icon')]")
    private WebElement help;
    @FindBy(xpath="//a[.='About your actiTIME']")
    private WebElement aboutYourActitime;
    @FindBy(xpath="//span[contains(.,'build')]")
    private WebElement build;
	//Initialization
	public EnterTimeTrackPage(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
		
	}
	//Utilization
	public void clickOnLogout()
	{
		logoutBTN.click();
	}
	public void clickOnHelp()
	{
		help.click();
	}
	public void clickOnAboutYourActitime()
	{
		aboutYourActitime.click();
	}
	public String verifyBuild()
	{
		verifyElement(build);
		String aBuild=build.getText();
		return aBuild;
	}

}
