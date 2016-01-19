package blueBird.PageObject.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.BBPages.Pages.DashBoardPage;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	public WebElement getUsername (){
		return getWebElement("//input[@id='user_email']");
	}
	
	public WebElement getPassword(){
		return getWebElement("//input[@id='user_password']");
	}
	
	public WebElement getClickBtn(){
		return getWebElement("//button[@type='submit']");
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
	
	public DashBoardPage loginAs (String username, String password){
		enterUsername(username);
	    enterPassword(password);
	    return clickSigninBtn();				
	}

}
