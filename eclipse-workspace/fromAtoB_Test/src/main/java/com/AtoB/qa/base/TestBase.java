package com.AtoB.qa.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.AtoB.qa.util.AtoBUtil;

public class TestBase {
	
 
	public static Properties prop;
	public static WebDriver driver;
	 
	
	public TestBase()
	{
	try {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir")
				+  "/src/main/java/com/AtoB/qa/config/config.properties");
		prop.load(ip);		 
		
		} catch(FileNotFoundException e) {
		e.printStackTrace();
		}catch (IOException e) {
		e.printStackTrace();
		}

	 
	}
	
	public WebDriver  initialization() {
	 

	String browserName = prop.getProperty("browser");
   
	if(browserName.equalsIgnoreCase("FireFox"))
			{
     driver = new FirefoxDriver(); 	
			}
	else if(browserName.equals("chrome"))
			{
		driver = new ChromeDriver();
			}
	
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(AtoBUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(AtoBUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get(prop.getProperty("url"));
	return driver;
	}
	
}
