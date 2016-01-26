package blueBird.BBPages.Tests;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import blueBird.BBPages.Pages.*;
import blueBird.PageObject.Tests.*;
import blueBird.PageObject.Pages.*;


public class FYPTest extends TestBase{
	

@Test (priority = 1)
  public void verifyFYPInvalidEmail(){
	  LoginPage loginPage = new LoginPage(webdriver);
	  blueBird.BBPages.Pages.FYPPage fYPPage = loginPage.clickForgotLink();
	  fYPPage.getEmailTextBox().clear();
	  fYPPage.getEmailTextBox().sendKeys("testonly@ecv.com");
	  fYPPage.getSendButton().click();
	  webdriver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
	  Assert.assertTrue(fYPPage.getNotFoundText().isDisplayed());
  }
  @Test (priority = 2)
  public void verifyLogInButton(){
	  LoginPage loginPage = new LoginPage(webdriver);
	  blueBird.BBPages.Pages.FYPPage fYPPage = new blueBird.BBPages.Pages.FYPPage(webdriver);
	  loginPage = fYPPage.getLoginPage();
	  Assert.assertTrue(loginPage.getUsername().isDisplayed());
  }
  
}
