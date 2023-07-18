package YoutubePages;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;

/**
 * Created by CoderZ-Testing on 14/05/2018.
 */
public class EnterEmailSignInPage extends PageObjects.GenericPageObject {

    public EnterEmailSignInPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static  final String EMAIL_ID = "identifierId";

    private static  final String NEXTBUTTON_ID = "identifierNext";

    

    public void EnterEmail(String Email){

        webDriver.getElementBy(ByTypes.id, EMAIL_ID, 10, true).sendKeys(Email);
    }

    public void ClickNextButton(){

        webDriver.getElementBy(ByTypes.id, NEXTBUTTON_ID, 10, true).click();
    }
}
