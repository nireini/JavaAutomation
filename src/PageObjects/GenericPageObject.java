package PageObjects;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import Selenium.IEWebDriver;

public class GenericPageObject {

	public GenericWebDriver webDriver;
	
	public GenericPageObject(GenericWebDriver webDriver) {
		
    	this.webDriver = webDriver;
    	
	}

}
