package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class WordPressLoginPage extends PageObjects.GenericPageObject{

	public WordPressLoginPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String username_login_ID = "user_login";

    private static  final String user_password_ID = "user_pass";
    
    private static  final String login_button_ID = "wp-submit";
    
    private static  final String enable_cookies_xpath = "//div[@id=\"login_error\"]/a";
    
    public void Enter_username_login(String username)
	{
        webDriver.getElementBy(ByTypes.id, username_login_ID, 10, true).sendKeys(username);
    }
    
    public void Enter_user_password(String password)
	{
        webDriver.getElementBy(ByTypes.id, user_password_ID, 10, true).sendKeys(password);
    }
    
    public void Click_login_button(){

        webDriver.getElementBy(ByTypes.id, login_button_ID, 20, true).click();
    }
    
    public void Click_enable_cookies(){

        webDriver.getElementBy(ByTypes.xpath, enable_cookies_xpath, 20, true).click();
    }

}
