package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class ResetYourPasswordPage extends NirPages.GenericPageObject{

	public ResetYourPasswordPage(GenericWebDriver webDriver) {
		super(webDriver);
		
	}
	
	private static final String PASSWORD_XPATH = "//div[@id=\"set-password\"]/coderz-input[@value=\"password\"]/div/div/div[@class=\"layout-row\"]/input";
	
	private static final String PASSWORDCONFIRM_XPATH = "//coderz-input[@value=\"confirmPassword\"]/div/div/div[@class=\"layout-row\"]/input";
	
	private static final String SetNewPasswordButton_XPATH = "//coderz-button[@click=\"submit()\"]/div/button/span";
	
	private static final String SuccessText_XPATH = "//div[@class=\"ok-title ng-binding\"][text()=\"Success :)\"]";
	
	public void enterPassword(String password){

        webDriver.getElementBy(ByTypes.xpath, PASSWORD_XPATH, 20, true).sendKeys(password);
    }
	
	public void enterConfirmPassword(String password){

        webDriver.getElementBy(ByTypes.xpath, PASSWORDCONFIRM_XPATH, 20, true).sendKeys(password);
    }
	
	public void ClickOnSetNewPasswordButton(){

        webDriver.getElementBy(ByTypes.xpath, SetNewPasswordButton_XPATH, 10, true).click();
    }
	
	public void WaitForSuccessText(){

        webDriver.getElementBy(ByTypes.xpath, SuccessText_XPATH, 10, true);
    }
	
	

}
