package NirPages;

import Selenium.GenericWebDriver;

public class MailinatorGetQuoteMail extends PageObjects.GenericPageObject{

	public MailinatorGetQuoteMail(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String MAILILANTOR_IFRAME_ID = "html_msg_body";
	
	private static final String Thank_you_for_your_quote_request_XPATH = "//h1[text()=\"Thank you for your quote request\"]";
	
//	public void Check_Header_is_located_In_Iframe()
//	{
//		try
//		{
//			webDriver.switchToFrameAndWaitForElement_By_Xpath(Thank_you_for_your_quote_request_XPATH, MAILILANTOR_IFRAME_ID);
//		} catch (Exception e)
//		{
//			e.printStackTrace();
//		}
//	}
}
