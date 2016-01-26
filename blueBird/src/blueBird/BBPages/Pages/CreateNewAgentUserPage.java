/*package blueBird.BBPages.Pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.*;
import org.openqa.selenium.Keys;

import blueBird.PageObject.Pages.*;

public class CreateNewAgentUserPage extends PageBase{

	//public static String Email_Str = "";
	//public static String Email_Str = "";
	public CreateNewAgentUserPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	// Get elements on the page
	
	// Get User header
    public WebElement getUserHeader(){
    	return getWebElement("//div[@id='head-nav']/div/div[2]/ul[1]/li[3]/a");
    }
    // Get Account button
    public WebElement getCreateUserMenuButton(){
    	return getWebElement("//a[@href='/users/new/agent']");
    }    
    // Get Email Textbox
    public WebElement getEmailTextbox(){
    	return getWebElement("//input[@id='user_email']");
    }
    // Get First Name Textbox
    public WebElement getFirstNameTextbox(){
    	return getWebElement("//input[@id='user_first_name']");
    }
    // Get Last Name Textbox
    public WebElement getLastNameTextbox(){
    	return getWebElement("//input[@id='user_last_name']");
    }
    // Get Account TextBox position
 	public WebElement getAccountNamePosition(){
 		return getWebElement("//div[contains(@id,'s2id') and contains(@id,'account_ids')]");
 	}
    
 	// Get Account TextBox after clicking on Account position
 	public WebElement getAccountNameTextBox(){
 		//return getWebElement("//input[@id='s2id_autogen17_search']");
 		return getWebElement("//input[contains(@class,'select2-input') and contains(@class,'select2-focused')]");
 	}
 	
 	// Get Save button
 	public WebElement getSaveButton(){
 		return getWebElement("//input[@type='submit']");
 	}
 	
 	// Get Cancel button
 	public WebElement getCancelButton(){
 		return getWebElement("//a[text()='Cancel']");
 	}
    
 	public void verifyCreateNewAgentUser(){
 		// Click on the User header
 		getUserHeader().click();
 		getCreateUserMenuButton().click();
 		
 	}
    
    
}*/
