package blueBird.PageObject.Tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.junit.*;

public class TestBase {
	protected WebDriver webdriver;
	
	@BeforeTest	
	public void beforeSuite() {
		webdriver = new FirefoxDriver();
		webdriver.get("http://ecv-uat.bluebirdgroup.com:8080/users/sign_in");
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//webdriver.manage().window().maximize();	
	}

	@AfterTest
//	public void afterSuite() {
	// 
//		webdriver.quit();
//	}
		
	public String getCurrentTitle() {
		return webdriver.getTitle();
	}
	
}
