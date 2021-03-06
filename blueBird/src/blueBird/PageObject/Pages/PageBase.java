package blueBird.PageObject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageBase {

	protected WebDriver webdriver;
	
	public PageBase (WebDriver webdriver){
		this.webdriver = webdriver;
	}
	
	public WebElement getWebElement(String locator){
		return webdriver.findElement(By.xpath(locator));
	}
	
	public WebElement getMsgBody (String locator){
		return webdriver.findElement(By.cssSelector(locator));
	}
	
	public String getCurrentURL() {
		return webdriver.getCurrentUrl();
	}
	
	public String generatePIN() 
	  {

	       //generate a 4 digit integer 1000 <10000
	       int randomPIN = (int)(Math.random()*9000)+1000;

	       //Store integer in a string
	       return String.valueOf(randomPIN);
	       
	       
	   }

}
