package blueBird.BBPages.Pages;

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

public class CreateNewDepartmentPage extends PageBase{
	

    public static String internalBudgetRandom = "";
    
	public CreateNewDepartmentPage(WebDriver webdriver) {
		super(webdriver);
		// TODO Auto-generated constructor stub
	}
	
	// Get Element on the page
	// Get Account header
    public WebElement getAccountHeader(){
    	return getWebElement("//div[@id='head-nav']/div/div[2]/ul[1]/li[2]/a");
    }
    // Get Account button
    public WebElement getDepartmentButton(){
    	return getWebElement("//a[@href='/departments/new']");
    }
	
	// Get Department Name textbox	
	public WebElement getDepartmentNameTextBox(){
		return getWebElement("//input[@id='department_name']");
	}
	// Get Account TextBox position
	public WebElement getAccountNamePosition(){
		return getWebElement("//div[contains(@id,'s2id') and contains(@id,'account')]");
	}
	// Get Account TextBox after clicking on Account position
	public WebElement getAccountNameTextBox(){
		//return getWebElement("//input[@id='s2id_autogen17_search']");
		return getWebElement("//input[contains(@class,'select2-input') and contains(@class,'select2-focused')]");
	}
	

	// Get Parent Department position
	public WebElement getParentDepartmentPosition(){	
		//Parent Department
		return getWebElement("//div[@title='Parent Department']");
	}
	
	// Get Parent Department TextBox after clicking on Parent Department position
	public WebElement getParentDepartmentTextBox(){
		return getWebElement("//input[contains(@class,'select2-input') and contains(@class,'select2-focused')]");
	}
	
	// Get Internal Budget TextBox
	public WebElement getInternalBudgetTextBox(){
		return getWebElement("//input[@id='department_max_budget']");
	}
	
	// Get Save button
	public WebElement getSaveButton(){
		return getWebElement("//input[@type='submit']");
	}
	// Get Save button
	public WebElement getCancelButton(){
		return getWebElement("//a[text()='Cancel']");
	}
	
	
	// Build a function to check the creation of the new department
    
    public void verifyCreateDepartment(String[] departmentNameslist, String[] accountCharactersList, String[] parentDepartmentCharactersList) throws InterruptedException{
    	
    	// Click on the Account header
        getAccountHeader().click();
        getDepartmentButton().click();
        // Wait For Page To Load
        webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        // Enter the value
        for (int i = 0; i < departmentNameslist.length; i++)
        {
        	// Input the department name
        	getDepartmentNameTextBox().clear();
        	getDepartmentNameTextBox().sendKeys(departmentNameslist[i]);
        	
        	// Input the 2 characters of accounts
        	getAccountNamePosition().click();
        	Thread.sleep(3000);
        	getAccountNameTextBox().clear();
        	getAccountNameTextBox().sendKeys(accountCharactersList[i]);
        	Thread.sleep(3000);
        	getAccountNameTextBox().sendKeys(Keys.ENTER);
        	// Click on the target account         	
        	
        	// Select Parent Department
        	getParentDepartmentPosition().click();
        	//Thread.sleep(3000);
        	getParentDepartmentTextBox().click();
        	getParentDepartmentTextBox().sendKeys(parentDepartmentCharactersList[i]);
        	Thread.sleep(3000);
        	getAccountNameTextBox().sendKeys(Keys.ENTER);
        	
            // Generate a 4 random number
        	PageBase pageBase = new PageBase(webdriver);
            internalBudgetRandom = pageBase.generatePIN();           
            
            // Input the internal budget
            getInternalBudgetTextBox().clear();
            getInternalBudgetTextBox().sendKeys(internalBudgetRandom);

            Thread.sleep(3000);
            // Click on Save button
            getSaveButton().click();

           
          // Check new URL
          // Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
             if (getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/departments/")){
            		System.out.println("Departement "+ departmentNameslist[i] +" is created successfully");
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/departments/"));
            		//Click on the Account header again
            		getAccountHeader().click();
                    getDepartmentButton().click();
                    Thread.sleep(3000);
            	} else {
            		//Assert.assertTrue(driver.getCurrentUrl().contains("http://ecv-uat.bluebirdgroup.com/accounts/"));
            		Assert.assertTrue(getCurrentURL().contains("http://ecv-uat.bluebirdgroup.com:8080/accounts/"));
            		System.out.println("Departement "+ departmentNameslist[i] + " is not created successfully");
            		Thread.sleep(3000);
            	}                
            
        }
    }
	
	
}
