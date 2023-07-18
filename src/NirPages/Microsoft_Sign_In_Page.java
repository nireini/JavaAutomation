package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class Microsoft_Sign_In_Page extends PageObjects.GenericPageObject{

	public Microsoft_Sign_In_Page(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String Email_Input_XPATH = "//input[@name=\"loginfmt\"]";
	
	private static final String NEXT_BUTTON_XPATH = "//input[@type=\"submit\"]";
	
    public void Enter_username_login(String email)
	{
        webDriver.getElementBy(ByTypes.xpath, Email_Input_XPATH, 10, true).sendKeys(email);
    }

    public void Click_NEXT_BUTTON()
    {
        webDriver.getElementBy(ByTypes.xpath, NEXT_BUTTON_XPATH, 20, true).click();
    }
}
