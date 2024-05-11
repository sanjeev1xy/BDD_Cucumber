package stepDefinitions;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import PageObjects.AddcustomerPage;
import PageObjects.LoginPage;

public class BaseClass 
{
	public WebDriver driver;
	public LoginPage lp;
	public AddcustomerPage acp;
	
	
	// Created for generating randome string for Uniquw email
	public static String randomestring()
	{
		String generatedString1=RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
		
	}
}
