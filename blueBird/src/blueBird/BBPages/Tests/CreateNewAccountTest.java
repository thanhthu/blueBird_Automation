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
	// private static String []sapIDlist = {"0000000231","0000001372","0000001374","0000006653","0000000865","0000000044","0000008181","0000001524","0000000299","0000000475","0000000491","0000001216"};
    // public String []sapIDlist = {"0000001524","0000000865"};
	
	// Test the BB Admin Account
		@Test (priority = 4)
		public void verifyCreateNewAccount() throws InterruptedException{
		LoginPage loginPage = new LoginPage(webdriver);
		
		DashBoardPage dashBoardPageAdminBB = loginPage.loginAs("bb_admin@ecv.com","abc12345");
		dashBoardPageAdminBB.verifyAdminBBAccount();
		
		CreateNewAccountPage createNewAccountPage = new CreateNewAccountPage(webdriver);
		createNewAccountPage.verifyCreateListAccount(new String[] {"0000000865","0000001524"});		
		
		}

}
