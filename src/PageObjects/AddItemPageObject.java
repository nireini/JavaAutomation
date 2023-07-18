package PageObjects;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;

public class AddItemPageObject extends GenericPageObject {

	

	public AddItemPageObject(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	public void selectQTY(String value) throws Exception {
		webDriver.selectComboBoxOptions(value, "//select[@name='qty']");
		
		
	}
	
	public void selectCategory(String categoryValue) throws Exception{
		webDriver.selectComboBoxOptions(categoryValue, "//label[text()='Category']//following-sibling::select");
	}

}
