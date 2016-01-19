package blueBird.BBPages.Pages;

import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.PageObject.Pages.*;

public class CreateNewAccountPage extends PageBase{

	
	// Create sapID list
    //private static String []sapIDlist = {"0000000231","0000001372","0000001374","0000006653","0000000865","0000000044","0000008181","0000001524","0000000299","0000000475","0000000491","0000001216"};
    public String []sapIDlist = {"0000000231","0000000865"};
 // Create a 4 credit limits string
    public String creditLimit4Random;
    public String creditLimit3 = "000";
    // Credit Limit String
    public String creditLimitTotal;
    
	public CreateNewAccountPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	public String generatePIN() 
	  {

	       //generate a 4 digit integer 1000 <10000
	       int randomPIN = (int)(Math.random()*9000)+1000;

	       //Store integer in a string
	       return String.valueOf(randomPIN);
	       
	       
	   }
	
	// Get Element on the page
    
    // Get Account header
    public WebElement getAccountHeader(){
    	return getWebElement("//div[@id='head-nav']/div/div[2]/ul[1]/li[2]/a");
    }
    // Get Account button
    public WebElement getAccountButton(){
    	return getWebElement("//a[@href='/accounts/new']");
    }
    // Get Account ID textbox
    public WebElement getAccountID(){
    	return getWebElement("//input[@id='account_account_code']");
    }
    //Get Account Credit budget
    public WebElement getAccountCreditBudget(){
    	return getWebElement("//input[@id='account_bb_budget']");
    }
    
    // Get Billing Cycle
    public WebElement getBillingCycle(){
    	return getWebElement("//input[@id='account_billing_cycle_once_a_week']");
    }
    
    // Get Save button
    public WebElement getSaveButton(){
    	return getWebElement("//input[@value='Save']");
    }
    
    // Build a function to check the creation of the new account
    
    public void verifyCreateAccount(){
    	
    	// Click on the Account header
        getAccountHeader().click();
        getAccountButton().click();
        // Wait For Page To Load
        webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Enter the value
        for (int i = 0; i < 2; i++)
        {
        	getAccountID().clear();	
        	getAccountID().sendKeys(sapIDlist[i]);

        	// Wait For Page To Reload
        	webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            // Generate a 4 random number
            creditLimit4Random = generatePIN();
            // Combine the String
            creditLimitTotal = creditLimit4Random + creditLimit3;
            
            getAccountCreditBudget().clear();
            getAccountCreditBudget().sendKeys(creditLimitTotal);
            
            // Wait For Page To Reload
            webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            getBillingCycle().click();
            webdriver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
            getSaveButton().click();
            webdriver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
           
          // Check new URL
          // Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
             if (getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/")){
            		System.out.println("Account created successfully for "+ sapIDlist[i]);
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		//Click on the Account header again
                    getAccountHeader().click();
                    getAccountButton().click();
            	    webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            	} else {
            		//Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		System.out.println("Account is not created successfully");
            		webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            	}                
            
        }
    }
    }


    
    
