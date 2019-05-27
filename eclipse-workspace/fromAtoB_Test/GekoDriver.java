package fromAtoB_Package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GekoDriver {

	public static void main(String[] args) {
	//System.out.println(System.getProperty("user.dir"));
	System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/geckodriver");	
    WebDriver driver = new FirefoxDriver();
    driver.manage().window().maximize();
    driver.get("https://www.fromatob.com");
	
	}
}
