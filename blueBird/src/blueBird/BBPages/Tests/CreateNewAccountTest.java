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

public class CreateNewAccountTest extends TestBase {
	
	// Test the BB Admin Account
		@Test (priority = 4)
		public void verifyCreateNewAccount(){
		LoginPage loginPage = new LoginPage(webdriver);
		
		DashBoardPage dashBoardPageAdminBB = loginPage.loginAs("bb_admin@ecv.com","abc12345");
		dashBoardPageAdminBB.verifyAdminBBAccount();
		
		CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(webdriver);
		createNewAccountPage.verifyCreateAccount();		
		
		}

}
