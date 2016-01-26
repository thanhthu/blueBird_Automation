package blueBird.BBPages.Pages;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.PageObject.Pages.*;

public class CreateNewAccountPage extends PageBase{

	// Create a 4 credit limits string
    public String creditLimit4Random;
    public String creditLimit3 = "000";
    // Credit Limit String
    public String creditLimitTotal;
    // Create a value to handle the length of Strings
    public int i = 0;
    
    // Constructor stub
	public CreateNewAccountPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}	
	
	// Get Element controls on the page   
    // Get Account header
    public WebElement getAccountHeader(){
    	return getWebElement("//div[@id='head-nav']/div/div[2]/ul[1]/li[2]/a");
    }
    // Get Account button
    public WebElement getAccountButton(){
    	return getWebElement("//a[@href='/accounts/new']");
    }
    // Get Account ID text box
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
    
    // Build a function to check the creation of multiple accounts    
    public void verifyCreateListAccount(String[] listStringAccounts) throws InterruptedException{
    		
    	// Click on the Account header
        getAccountHeader().click();
        getAccountButton().click();
        // Wait For Page To Load
        webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Enter the value to text boxes
        for (i=0;i<listStringAccounts.length;i++)
        {
        	
        	getAccountID().clear();	
        	getAccountID().sendKeys(listStringAccounts[i]);
        	// Wait For Page To Reload
        	webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            // Generate a 4 random number
        	PageBase pageBase = new PageBase(webdriver);
            creditLimit4Random = pageBase.generatePIN();
            // Combine the String
            creditLimitTotal = creditLimit4Random + creditLimit3;
            
            getAccountCreditBudget().clear();
            getAccountCreditBudget().sendKeys(creditLimitTotal);
            
            // Wait For Page To Reload
           // webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            Thread.sleep(3000);
            getBillingCycle().click();
            getSaveButton().click();
            Thread.sleep(3000);        
          // Check new URL
          // Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
             if (getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/")){
            		System.out.println("Account created successfully for "+ listStringAccounts[i]);
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		//Click on the Account header again
                    getAccountHeader().click();
                    getAccountButton().click();
                    Thread.sleep(3000);
            	} else {
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		System.out.println("Account is not created successfully for "+ listStringAccounts[i]);
            		Thread.sleep(3000);
            	}                
            
        }
    }

    // Build a function to check the creation of single account  
    	public void verifyCreateSingleAccount(String account) throws InterruptedException{
    	
    		// Click on the Account header
    		getAccountHeader().click();
    		getAccountButton().click();
    		// Wait For Page To Load
    		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    		// Enter the value to text boxes
        	getAccountID().clear();	
        	getAccountID().sendKeys(account);
        	// Wait For Page To Reload
        	webdriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
            // Generate a 4 random numbers
        	PageBase pageBase = new PageBase(webdriver);
            creditLimit4Random = pageBase.generatePIN();
            // Combine the String
            creditLimitTotal = creditLimit4Random + creditLimit3;            
            getAccountCreditBudget().clear();
            getAccountCreditBudget().sendKeys(creditLimitTotal);
            
            // Click on the billing cycle
            getBillingCycle().click();
            getSaveButton().click();
            Thread.sleep(3000);
            //webdriver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
           
          // Check new URL
          // Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
             if (getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/")){
            		System.out.println("Account created successfully for "+ account);
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		//Click on the Account header again
                    getAccountHeader().click();
                    getAccountButton().click();
                    Thread.sleep(3000);
            	} else {
            		//Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		System.out.println("Account is not created successfully");
            		Thread.sleep(3000);
            	}                
            
        }    

	
}


    
    
