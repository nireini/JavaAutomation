package YoutubePages;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;

/**
 * Created by CoderZ-Testing on 14/05/2018.
 */
public class EnterPasswordSignInPage extends PageObjects.GenericPageObject {

    public EnterPasswordSignInPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static final String ENTERPASSWORD_NAME = "password";

    private static final String NEXTBUTTONID = "passwordNext";

    

    public void EnterPassword(String password){

        webDriver.getElementBy(ByTypes.name, ENTERPASSWORD_NAME, 10, true).sendKeys(password);
    }

    public void ClickNextButton(){
        webDriver.getElementBy(ByTypes.id, NEXTBUTTONID, 10, true).click();
    }
}
