package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;


public class GmailAllMailsDisplayedPage extends NirPages.GenericPageObject{

	public GmailAllMailsDisplayedPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String GmailTopEmail_XPATH = "//table[@class=\"F cf zt\"]/tbody/tr[1]/td[6]";
	
	private static final String ResetPasswordLink_XPATH = "//a[@title=\"Reset my password\"]";
	
    private static final String ThreeDotsImage_XPATH = "//div/div[3]/div/div[@role=\"button\"]/img";
	
    public void ClickGmailTopEmail(){

        webDriver.getElementBy(ByTypes.xpath, GmailTopEmail_XPATH, 20, true).click();
    }
    
    public void ClickResetPasswordLink(){

        webDriver.getElementBy(ByTypes.xpath, ResetPasswordLink_XPATH, 20, true).click();
    }
    
    public Boolean CheckIfThreeDotsButtonDisplayed() throws InterruptedException{

        Boolean ThreeDotsAreDisplayed = webDriver.CheckIfElementIsDisplayed2(ByTypes.xpath, ThreeDotsImage_XPATH);
        
        return ThreeDotsAreDisplayed;
    }
    
    public void ClickThreeDots(){

        webDriver.getElementBy(ByTypes.xpath, ThreeDotsImage_XPATH, 20, true).click();
    }
    
    
}
