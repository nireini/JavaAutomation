package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class GmailLoginPage extends PageObjects.GenericPageObject{

	public GmailLoginPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}

	private static final String GmailSignInButton_XPATH = "//body/div[2]/div[1]/div[4]/ul[2]/li[3]/a[@href=\"https://accounts.google.com/AccountChooser?service=mail&continue=https://mail.google.com/mail/\"]";
	
	private static final String EmailInput_ID = "identifierId";
	
	private static final String NextButton_ID = "identifierNext";
	
	private static final String PasswordInput_NAME = "password";
	
	private static final String GmailPasswordNextButton_ID = "passwordNext";
	
	public void enterUserName(String username){

        webDriver.getElementBy(ByTypes.id, EmailInput_ID, 60, true).sendKeys(username);
    }
	
	public void ClickNextButtonUsername(){

        webDriver.getElementBy(ByTypes.id, NextButton_ID, 20, true).click();
    }
	
	public void enterPassword(String password){

        webDriver.getElementBy(ByTypes.name, PasswordInput_NAME, 20, true).sendKeys(password);
    }
	
	public void ClickNextButtonPassword(){

        webDriver.getElementBy(ByTypes.id, GmailPasswordNextButton_ID, 20, true).click();
    }
	
	public void ClickSignInButton(){

        webDriver.getElementBy(ByTypes.xpath, GmailSignInButton_XPATH, 20, true).click();
    }
	
	
}
