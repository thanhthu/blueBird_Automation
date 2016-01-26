package blueBird.BBPages.Pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.PageObject.Pages.*;

public class FYPPage extends PageBase{

	public FYPPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	

	// Get Email Textbox	
	public WebElement getEmailTextBox(){
    	return getWebElement("//input[@id='user_email']");
    }
	// Get  Send me reset password instructions button
	public WebElement getSendButton(){
		return getWebElement("//button[@type='submit']");
	}
	// Get Login button
		public WebElement getLoginButton(){
			return getWebElement("//a[text()='Log in']");
		}
		
	// Get not found text
		public WebElement getNotFoundText(){
			return getWebElement("//span[text()='not found']");
		}
		
		public LoginPage getLoginPage(){
			getLoginButton().click();
			return new LoginPage(webdriver);
		}
		
}
