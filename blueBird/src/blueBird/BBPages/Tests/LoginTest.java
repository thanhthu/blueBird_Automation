package blueBird.BBPages.Tests;

import org.testng.annotations.Test;


import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import blueBird.BBPages.Pages.*;
import blueBird.BBPages.Tests.*;
import blueBird.PageObject.Tests.*;
import blueBird.PageObject.Pages.*;

public class LoginTest extends TestBase {
	
	// Test the BB Admin Account
	@Test (priority = 1)
	public void validLoginBBAdmin(){
	LoginPage loginPage = new LoginPage(webdriver);
	
	DashBoardPage dashBoardPageAdminBB = loginPage.loginAs("bb_admin@ecv.com","abc12345");
	dashBoardPageAdminBB.verifyAdminBBAccount();
	dashBoardPageAdminBB.logOutBBAdmin();
	}
	
	// Test the Corporate Account
	@Test (priority = 2)
	public void validLoginCorporate(){
	LoginPage loginPage = new LoginPage(webdriver);
	
	DashBoardPage dashBoardPageCorporate = loginPage.loginAs("coporate_admin@ecv.com","abc12345");
	dashBoardPageCorporate.verifyCorporateAccount();
	dashBoardPageCorporate.logOutCorporate();
	}
	
	// Test the Agent Account 
	@Test (priority = 3)
	public void validLoginAgent(){
	LoginPage loginPage = new LoginPage(webdriver);
	
	DashBoardPage dashBoardPageAgent = loginPage.loginAs("agent@ecv.com","abc12345");
	dashBoardPageAgent.verifyAgentAccount();
	dashBoardPageAgent.logOutAgent();
	}
}
