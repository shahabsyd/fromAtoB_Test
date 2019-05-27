package com.AtoB.qa.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.AtoB.qa.base.TestBase;
import com.AtoB.qa.pages.HomePage;
import com.AtoB.qa.pages.LoginPage;
import com.AtoB.qa.pages.OrderPage;
import com.AtoB.qa.pages.SearchResultPage;
import com.AtoB.qa.util.AtoBUtil;

public class SearchResultPageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	OrderPage orderpage;
	SearchResultPage searchresultpage;
	  
    @BeforeTest
	public void setUp()
	{
	/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/chromedriver");
	driver = new ChromeDriver(); 
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(AtoBUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(AtoBUtil.IMPLICIT_WAIT,TimeUnit.SECONDS);
	driver.get("https://donald:vladimir@qa.frombat.net");
	*/
		
		
	driver = initialization();
	homepage = new HomePage();
	loginpage = new LoginPage();
	orderpage = new OrderPage();
	searchresultpage = new SearchResultPage();
	
	}
	@Test
	public void searchATrip1() throws Exception
	{
		
	homepage.enterDepartureCity("Berlin");
	Thread.sleep(1000);
    homepage.enterArrivalCity("aachen");
    
    

	Thread.sleep(1000);
	homepage.selectDepartureDate();
	homepage.searchBtn();
	String text = searchresultpage.ValidateSearchResultPage(); 
	Assert.assertEquals(text, "Berlin to Aachen");
	Thread.sleep(10000);
	searchresultpage.SelectBusFromFilters();
	searchresultpage.SelectFlightFromFilters();
	searchresultpage.SelectBlaBlaFromFilters();
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("div[class='best-results']>div:nth-child(2)>form>div>button[type='submit']")).click(); 

	searchresultpage.SelectFareOptions();
	searchresultpage.selectFareFromDropDown().selectByIndex(2); 
	String priceOnCTA = driver.findElement(By.xpath("//*[@id=\"Search\"]/div[2]/div/div[4]/div/div[2]/div[1]/div[2]/form/div[1]/button[1]/span[1]")).getText();
	Thread.sleep(2000);
	System.out.println(priceOnCTA);
	searchresultpage.SelectFare();
	String OutgoingFarePrice = driver.findElement(By.xpath("//*[@id=\"CheckoutSidebar\"]/div[3]/div[1]/div[1]/div[2]/div/div[2]")).getText();
	Assert.assertEquals(priceOnCTA, OutgoingFarePrice);
	if(priceOnCTA.trim().equals(OutgoingFarePrice.trim()))
	{
		System.out.println("price selected on search page is displaye don Booking Summary");
	}
	else
	System.out.println("the price is not same");
	
	
	}

	 
		

}
