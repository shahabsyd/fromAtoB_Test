package com.AtoB.qa.Test;

 

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.AtoB.qa.base.TestBase;
import com.AtoB.qa.pages.HomePage;
import com.AtoB.qa.pages.LoginPage;
import com.AtoB.qa.pages.OrderPage;
import com.AtoB.qa.pages.SearchResultPage;
import com.AtoB.qa.util.AtoBUtil;

public class LoginPageTest extends TestBase{
		
	LoginPage loginpage;
	HomePage homepage;
	
	   
	public LoginPageTest()
	{
	super();	
	}

	@BeforeSuite
	public void setUp()
	{
	
	driver = initialization();
	homepage = new HomePage();
	loginpage = new LoginPage();
	loginpage = homepage.linktoSignInPage();
	

	}
	
	@Test(priority=1)
	public void loginPageTitle()
	{
	String Title = loginpage.validateLoginPageTitle();
	Assert.assertEquals(Title, "Log in");
	 
	}
	
	@Test(priority=2)
	public void loginTest() {
		
		loginpage.enterusername("syed.shahabuddin@fromatob.com");
		loginpage.enterpassword("India123!");
		loginpage.submitbtn();
		
	}
	
	
	
	@AfterSuite
	public void tearDown() {
		driver.close();
	}

}
