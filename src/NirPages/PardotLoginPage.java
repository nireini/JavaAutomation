package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class PardotLoginPage extends PageObjects.GenericPageObject
{

	public PardotLoginPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String LOGINWITHSALESFORCE_ID= "logInWithSalesforceButton";
	
	private static final String USERNAME_ID= "username";
	
    private static final String PASSWORD_ID = "password";
	
	private static final String LOGIN_BUTTON_ID = "Login";
	
    public void clickLOGIN_WITH_SALESFORCE() {
    	
    	webDriver.getElementBy(ByTypes.id, LOGINWITHSALESFORCE_ID, 10, true).click();
    }
	
    public void enterUsername(String username) {
		
		webDriver.getElementBy(ByTypes.id, USERNAME_ID, 20, true).sendKeys(username);
	}
	
    public void enterPassword(String password) {
		
		webDriver.getElementBy(ByTypes.id, PASSWORD_ID, 20, true).sendKeys(password);
	}
    
    public void clickSignInButton() {
    	
    	webDriver.getElementBy(ByTypes.id, LOGIN_BUTTON_ID, 10, true).click();
    }

}
