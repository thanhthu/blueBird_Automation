package blueBird.PageObject.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.BBPages.Pages.DashBoardPage;
import blueBird.BBPages.Pages.FYPPage;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	// Get Username
	public WebElement getUsername (){
		return getWebElement("//input[@id='user_email']");
	}
	
	// Get Password
	public WebElement getPassword(){
		return getWebElement("//input[@id='user_password']");
	}
	
	// Get Sign In Button
	public WebElement getClickBtn(){
		return getWebElement("//button[@type='submit']");
	}
	
	// Get Forgot your password link
	public WebElement getForgotLink(){
		return getWebElement("//a[text()='Forgot your password?']");
	}
	
	
	public void enterUsername(String username){
		getUsername().sendKeys(username);
	}
	public void enterPassword(String password){
		getPassword().sendKeys(password);
	}
	
	public DashBoardPage clickSigninBtn(){
		getClickBtn().click();
		return new DashBoardPage(webdriver);
	}
	
	public FYPPage clickForgotLink(){
		getForgotLink().click();
		return new FYPPage(webdriver);
	}
	
	public DashBoardPage loginAs (String username, String password){
		enterUsername(username);
	    enterPassword(password);
	    return clickSigninBtn();				
	}

}
