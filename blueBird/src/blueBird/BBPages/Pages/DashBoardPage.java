package blueBird.BBPages.Pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import blueBird.PageObject.Pages.*;

public class DashBoardPage extends PageBase{

    // Declare strings to store the values of header in page
    String BudgetText = "Budget";
    String AllocatedText = "Allocated";
    String SpentTMText = "Spent this Month";
    String PaperTransText = "Paper Transactions";
    String AccountsText = "# of Accounts";
    String DepartmentsText = "# of Departments";
    String BBCardsText = "# of BB Cards";
    String AgentsText = "# of Agents";
    String CorporatesText = "# of Corporate Admins";
    String EmployeesText = "# of Employees";
    
 // Make an array to store value of logout text
    String []logoutText = {"BB Admin","Coporate Admin","Agent 1"};
    
	public DashBoardPage(WebDriver webdriver) {
		super(webdriver);
	}

	// Get successful dashboard message
	
	public WebElement getSuccessLoginMsg(){
		  return getWebElement("//div[contains(@class, 'alert') and contains(@class, 'alert-success')]");
	}
	
	// Get elements to check the success of the login
    
	// Get BudgetText
    public WebElement getBudgetText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[1]/div/div[1]/h2");
	}
    // Get AllocatedText
    public WebElement getAllocatedText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[2]/div/div[1]/h2");
	}
    //Get SpentTMText
    public WebElement getSpentTMText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[3]/div/div[1]/h2");
	}
    //Get PaperTransText
    public WebElement getPaperTransText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[4]/div/div[1]/h2");
	}
    //Get AccountsText
    public WebElement getAccountsText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[5]/div/div[1]/h2");
	}
    //Get DepartmentsText
    public WebElement getDepartmentsText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[6]/div/div[1]/h2");
	}
    //Get BBCardsText
    public WebElement getBBCardsText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[7]/div/div[1]/h2");
	}
    //Get AgentsText
    public WebElement getAgentsText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[8]/div/div[1]/h2");
	}
    //Get CorporatesText
    public WebElement getCorporatesText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[9]/div/div[1]/h2");
	}
	//Get EmployeesText
    public WebElement getEmployeesText(){
		  return getWebElement("//div[@id='pcont']/div[2]/div/div[10]/div/div[1]/h2");
	}
    
    /************************/
    // Get all elements for Agent 1 Account
 // Get BudgetText
    public WebElement getBudgetAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[1]/div/div[1]/h2");
	}
    // Get AllocatedText
    public WebElement getAllocatedAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[2]/div/div[1]/h2");
	}
    //Get SpentTMText
    public WebElement getSpentTMAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[3]/div/div[1]/h2");
	}
    //Get PaperTransText
    public WebElement getPaperTransAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[4]/div/div[1]/h2");
	}

    //Get DepartmentsText
    public WebElement getDepartmentsAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[5]/div/div[1]/h2");
	}
    //Get BBCardsText
    public WebElement getBBCardsAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[6]/div/div[1]/h2");
	}

	//Get EmployeesText
    public WebElement getEmployeesAgentText(){
		  return getWebElement("//div[@id='pcont']/div/div[2]/div[7]/div/div[1]/h2");
	}
    
    
    //Get Sign Out BB Admin header
    public WebElement getSignOutHeaderBBAdmin(){
		  return getWebElement("//span[text()='BB Admin']");
	}
    //Get Sign Out Corporate header
    public WebElement getSignOutHeaderCorporate(){
		  return getWebElement("//span[text()='Coporate Admin']");
	}
    //Get Sign Out Agent header
    public WebElement getSignOutHeaderAgent(){
		  return getWebElement("//span[text()='Agent 1']");
	}
    
    //Get Sign Out button
    public WebElement getSignOutButton(){
		  return getWebElement("//a[text()='Sign out']");
	}
    
    
    //Build a function to check the existence of all required elements on the pages
    // Verify AdminBBAccount
    public void verifyAdminBBAccount(){
    	int j = 0 ;
    	// Budget
    	if (!getBudgetText().getText().toString().contains(BudgetText)){
    		j++;
    	}
    	
    	//Allocated
    	if (!getAllocatedText().getText().toString().contains(AllocatedText)){
    		j++;
    	}       	

    	//Spent this Month
    	if (!getSpentTMText().getText().toString().contains(SpentTMText)){
    		j++;
    	}

    	//Paper Transactions
    	if (!getPaperTransText().getText().toString().contains(PaperTransText)){
    		j++;
    	}      	

    	//# of Accounts
    	if (!getAccountsText().getText().toString().contains(AccountsText)){
    		j++;
    	}

    	//# of Departments
    	if (!getDepartmentsText().getText().toString().contains(DepartmentsText)){
    		j++;
    	}

    	//# of BB Cards 
    	if (!getBBCardsText().getText().toString().contains(BBCardsText)){
    		j++;
    	}

    	//# of Agents
    	if (!getAgentsText().getText().toString().contains(AgentsText)){
    		j++;
    	}

    	//# of Corporate Admins
    	if (!getCorporatesText().getText().toString().contains(CorporatesText)){
    		j++;
    	}

    	//# of Employees
    	if (!getEmployeesText().getText().toString().contains(EmployeesText)){
    		j++;
    	}
    	
    	Assert.assertTrue(j==0 && getSuccessLoginMsg().isDisplayed());		
    	
    }
   
    // Verify Corporate Account
    public void verifyCorporateAccount(){
    	int j = 0 ;
    	// Budget
    	if (!getBudgetText().getText().toString().contains(BudgetText)){
    		j++;
    	}
    	
    	//Allocated
    	if (!getAllocatedText().getText().toString().contains(AllocatedText)){
    		j++;
    	}       	

    	//Spent this Month
    	if (!getSpentTMText().getText().toString().contains(SpentTMText)){
    		j++;
    	}

    	//Paper Transactions
    	if (!getPaperTransText().getText().toString().contains(PaperTransText)){
    		j++;
    	}      	

    	//# of Departments
    	if (!getAccountsText().getText().toString().contains(DepartmentsText)){
    		j++;
    	}

    	//# of BB Cards 
    	if (!getDepartmentsText().getText().toString().contains(BBCardsText)){
    		j++;
    	}

    	//# of Corporate Admins
    	if (!getBBCardsText().getText().toString().contains(CorporatesText)){
    		j++;
    	}

    	//# of Employees
    	if (!getAgentsText().getText().toString().contains(EmployeesText)){
    		j++;
    	}
    	
    	Assert.assertTrue(j==0 && getSuccessLoginMsg().isDisplayed());		
    	
    }
    
 // Verify AgentAccount
    public void verifyAgentAccount(){
    	int j = 0 ;
    	// Budget
    	if (!getBudgetAgentText().getText().toString().contains(BudgetText)){
    		j++;
    	}
    	
    	//Allocated
    	if (!getAllocatedAgentText().getText().toString().contains(AllocatedText)){
    		j++;
    	}       	

    	//Spent this Month
    	if (!getSpentTMAgentText().getText().toString().contains(SpentTMText)){
    		j++;
    	}

    	//Paper Transactions
    	if (!getPaperTransAgentText().getText().toString().contains(PaperTransText)){
    		j++;
    	}      	


    	//# of Departments
    	if (!getDepartmentsAgentText().getText().toString().contains(DepartmentsText)){
    		j++;
    	}

    	//# of BB Cards 
    	if (!getBBCardsAgentText().getText().toString().contains(BBCardsText)){
    		j++;
    	}

    	//# of Employees
    	if (!getEmployeesAgentText().getText().toString().contains(EmployeesText)){
    		j++;
    	}
    	
    	Assert.assertTrue(j==0 && getSuccessLoginMsg().isDisplayed());		
    	
    }
    
    // Function log out for BB Admin
    
    public void logOutBBAdmin(){
    	getSignOutHeaderBBAdmin().click();
    	getSignOutButton().click();
    }
    
    // Function log out for Corporate
    
    public void logOutCorporate(){
    	getSignOutHeaderCorporate().click();
    	getSignOutButton().click();
    }
    
    // Function log out for Agent
    
    public void logOutAgent(){
    	getSignOutHeaderAgent().click();
    	getSignOutButton().click();
    }
    
}
