package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class UserDetailsFillingPage extends PageObjects.GenericPageObject{

	public UserDetailsFillingPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String billing_first_name_ID = "billing_first_name";
	private static  final String billing_last_name_ID = "billing_last_name";
	private static  final String billing_email_ID = "billing_email";
	private static  final String billing_phone_ID = "mobile_number";
	
	private static  final String billing_company_ID = "billing_company";
	private static  final String SELECT_COUNTRY_ID = "select2-billing_country-container";
	private static  final String Country_Andora_XPATH = "//ul[@id=\"select2-billing_country-results\"]/li[1]";
	private static  final String select_state_ID = "select2-billing_state-container";
	
	private static  final String select_first_state_XPATH = "//ul[@id=\"select2-billing_state-results\"]/li[1]";
	private static  final String billing_address_ID = "billing_address_1";
	private static  final String billing_city_ID = "billing_city";
	private static  final String zip_code_ID = "zip_code";
	
	private static  final String terms_conditions_ID = "terms_conditions";
	private static  final String get_a_quote_button_ID = "place_order";
	private static  final String Thank_you_for_your_interest_message_XPATH = "//strong[text()=\"Thank you for your interest \"]";
	
	public void Enter_first_name(String first_name)
	{
        webDriver.getElementBy(ByTypes.id, billing_first_name_ID, 10, true).sendKeys(first_name);
    }
	
	public void Enter_billing_last_name(String last_name)
	{
        webDriver.getElementBy(ByTypes.id, billing_last_name_ID, 10, true).sendKeys(last_name);
    }
	
	public void Enter_billing_email(String email)
	{
        webDriver.getElementBy(ByTypes.id, billing_email_ID, 10, true).sendKeys(email);
    }
	
	public void Enter_billing_phone(String phone)
	{
        webDriver.getElementBy(ByTypes.id, billing_phone_ID, 10, true).sendKeys(phone);
    }
	
	public void Enter_billing_company(String billing_company)
	{
        webDriver.getElementBy(ByTypes.id, billing_company_ID, 10, true).sendKeys(billing_company);
    }
	
	public void Click_COUNTRY_selector()
	{
        webDriver.getElementBy(ByTypes.id, SELECT_COUNTRY_ID, 20, true).click();
    }
	
	public void Click_Country_Andora()
	{
        webDriver.getElementBy(ByTypes.xpath, Country_Andora_XPATH, 20, true).click();
    }
	
	public void Click_select_state()
	{
        webDriver.getElementBy(ByTypes.id, select_state_ID, 20, true).click();
    }
	
	public void Click_select_first_state()
	{
        webDriver.getElementBy(ByTypes.xpath, select_first_state_XPATH, 20, true).click();
    }
	
	public void ENTER_billing_address(String billing_address)
	{
        webDriver.getElementBy(ByTypes.id, billing_address_ID, 20, true).sendKeys(billing_address);
    }
	
	public void ENTER_billing_city(String billing_city)
	{
        webDriver.getElementBy(ByTypes.id, billing_city_ID, 20, true).sendKeys(billing_city);
    }
	
	public void ENTER_zip_code(String zip_code)
	{
        webDriver.getElementBy(ByTypes.id, zip_code_ID, 20, true).sendKeys(zip_code);
    }
	
	public void Click_terms_conditions()
	{
        webDriver.getElementBy(ByTypes.id, terms_conditions_ID, 20, true).click();
    }
	
	public void Click_get_a_quote_button()
	{
        webDriver.getElementBy(ByTypes.id, get_a_quote_button_ID, 20, true).click();
    }
	
	public void Wait_for_element_Thank_you_for_your_interest_message_XPATH()
	{
        webDriver.getElementBy(ByTypes.xpath, Thank_you_for_your_interest_message_XPATH, 80, true);
    }
}
