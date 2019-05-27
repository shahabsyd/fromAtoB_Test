package com.AtoB.qa.pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import com.AtoB.qa.base.TestBase;

public class LoginPage extends TestBase{


	//Page Factory - OR:
	
	@FindBy(name= "user_account[email]")
	WebElement username;
	
	@FindBy(name = "user_account[password]")
    WebElement password;
	
	@FindBy(name = "commit")
	WebElement login;
	
	/*
	//initializing the Page Object
	 public LoginPage() {
		 
		 PageFactory.initElements(driver, this);
	 }*/	 
	 //method to get the title of the login page.
	 public String validateLoginPageTitle()
	 {
	 return driver.getTitle();	
	 }
 
	 //method to user login to platform. 
	 
	 public void enterusername(String username){	 
	 driver.findElement(By.name("user_account[email]")).sendKeys(username);
	 }

     public void enterpassword(String password) {
	 
	 driver.findElement(By.name("user_account[password]")).sendKeys(password);
     }
     
     public void submitbtn()
     {
	 driver.findElement(By.name("commit")).click();
     }

}
