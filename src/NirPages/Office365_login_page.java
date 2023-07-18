package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class Office365_login_page extends PageObjects.GenericPageObject{

	public Office365_login_page(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}

	private static final String USERNAME_ID = "i0116";
	
	private static final String PASSWORD_ID = "i0118";
	
	private static final String NEXT_BUTTON_ID = "idSIButton9";
	
    public void enterUserName(String username)
    {
        webDriver.getElementBy(ByTypes.id, USERNAME_ID, 30, true).sendKeys(username);
    }

    public void enterPassword(String password)
    {
        webDriver.getElementBy(ByTypes.id, PASSWORD_ID, 20, true).sendKeys(password);
    }
    
    public void Click_NEXT_Button(){

        webDriver.getElementBy(ByTypes.id, NEXT_BUTTON_ID, 20, true).click();
    }

}
