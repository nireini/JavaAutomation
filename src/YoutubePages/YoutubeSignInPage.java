package YoutubePages;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;

/**
 * Created by CoderZ-Testing on 14/05/2018.
 */
public class YoutubeSignInPage extends PageObjects.GenericPageObject{

    public YoutubeSignInPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}






	private static final String SIGNINICON_ID = "text";




    

    public void ClickOnSignInButton(){

        webDriver.getElementBy(ByTypes.id, SIGNINICON_ID, 10, true).click();
    }




}
