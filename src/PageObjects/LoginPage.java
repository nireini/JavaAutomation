package PageObjects;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;

public class LoginPage extends GenericPageObject {

	public LoginPage(GenericWebDriver webDriver, FirefoxWebDriver firefoxWebDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static final String SUBMIT_BUTTON = "//button[@class='btn btn-primary']";

	private static final String USERNAME_XPATH = "//input[@id='username']";

	private static final String PASSWORD_XPATH = "//input[@id='password']";

	

	public void enterUserName(String userName) {
		webDriver.getElementBy(ByTypes.xpath, USERNAME_XPATH).sendKeys(userName);
	}

	public void enterPassword(String password) throws Exception {
		webDriver.getElementByXpath(PASSWORD_XPATH).sendKeys(password);
	}

	public void clickOnSubmit() throws Exception {
		webDriver.getElementByXpath(SUBMIT_BUTTON).click();
	}

}
