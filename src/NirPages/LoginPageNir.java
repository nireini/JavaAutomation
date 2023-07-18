package NirPages;


import Selenium.GenericWebDriver;
import enums.ByTypes;


public class LoginPageNir extends NirPages.GenericPageObject {
	

public LoginPageNir(GenericWebDriver webDriver) {
		super(webDriver);
		
	}

private static final String SUBMIT_BUTTON = "//coderz-button[@click=\"login()\"]/div/button/span";

private static final String USERNAME_XPATH = "//coderz-input[@id=\"login_username\"]/div/div/div[2]/input";
private static final String PASSWORD_XPATH = "//coderz-input[@id=\"login_password\"]/div/div/div[2]/input";

private static final String LOGINBUTTON_XPATH="//coderz-button[@click=\"login()\"]/div/button/span";

private static final String RegisterWITHCLASSCODEXPATH = "//div[text()='Register with your class code']";

private static final String CLASSCODEBOX_XPATH = "ng-model=\"classcode\"";

private static final String SupportLink_Link = "support";

private static final String LicenseExpiredText_XPATH = "//h2[text()=\"License expired\"]";

private static final String ForgotYourPassword_XPATH = "//a[@ng-click=\"forgot()\"]";

private static final String ForgetPasswordEmailField_XPATH = "//coderz-input[@value=\"email\"]/div/div/div[@class=\"layout-row\"]/input";

private static final String RequestPasswordButton_XPATH = "//coderz-button[@click=\"forgot()\"]/div/button/span";

private static final String EmailSentSuccessFullyMessageResetPassword_XPATH = "//div[text()=\"Success\"]";




    public void enterUserName(String username){

        webDriver.getElementBy(ByTypes.xpath, USERNAME_XPATH, 30, true).sendKeys(username);
    }
    
    public void enterUserName2(String username){

        webDriver.getElementBy(ByTypes.xpath, USERNAME_XPATH, 30, true).sendKeys(username);
    }

    public void enterPassword(String password){

        webDriver.getElementBy(ByTypes.xpath, PASSWORD_XPATH, 10, true).sendKeys(password);
    }
    
    public void enterPassword2(String password){

        webDriver.getElementBy(ByTypes.xpath, PASSWORD_XPATH, 10, true).sendKeys(password);
    }

    public void ClickOnLoginButton(){

        webDriver.getElementBy(ByTypes.xpath, SUBMIT_BUTTON, 10, true).click();
    }
    
    public void ClickOnLoginButton2(){

        webDriver.getElementBy(ByTypes.xpath, SUBMIT_BUTTON, 10, true).click();
    }
    
    public void waitForLicenseExpiredText() {
    	
    	webDriver.getElementBy(ByTypes.xpath, LicenseExpiredText_XPATH, 10, true);
    }
    
    public void ClickOnSupportLink(){

        webDriver.getElementBy(ByTypes.link, SupportLink_Link, 10, true).click();
    }

    public void ClickForgotYourPasswordLink() {
    	webDriver.getElementBy(ByTypes.xpath, ForgotYourPassword_XPATH, 20, true).click();
    }
    
    public void enterEmailToResetPassword(String username) {
    	webDriver.getElementBy(ByTypes.xpath, ForgetPasswordEmailField_XPATH, 10, true).sendKeys(username);
    }
    
    public void ClickOnRequestPasswordButton() {
    	webDriver.getElementBy(ByTypes.xpath, RequestPasswordButton_XPATH, 10, true).click();
    }
    
    public void waitForEmailSentSuccessMessage() {
    	webDriver.getElementBy(ByTypes.xpath, EmailSentSuccessFullyMessageResetPassword_XPATH, 20, true);
    }

}
