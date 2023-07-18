package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class SubmitRequestPage extends PageObjects.GenericPageObject{

	public SubmitRequestPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	private static final String SUBMITREQUAESTHEADERXPATH = "//h1[text()=\"Submit a request\"]";
	
	private static final String INPUTCOMMITNAME = "commit";
	
	private static final String request_anonymous_requester_email_ID = "request_anonymous_requester_email";
	
	
	public void WaitTillSubmitRequestHeaderIsDisplayed(){

        webDriver.getElementBy(ByTypes.xpath, SUBMITREQUAESTHEADERXPATH, 30, true);
    }
	
	public void WaitTillInputCOMMITIsDisplayed(){

        webDriver.getElementBy(ByTypes.name, INPUTCOMMITNAME, 30, true);
    }
	
	public void WaitTillRequest_anonymous_requester_emailIsDisplayed(){

        webDriver.getElementBy(ByTypes.id, request_anonymous_requester_email_ID, 30, true);
    }
	
	

}
