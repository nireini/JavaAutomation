package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class WordPressWooCommerceSettingsPaymentPaypalCheckout extends PageObjects.GenericPageObject{

	public WordPressWooCommerceSettingsPaymentPaypalCheckout(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String Environment_Drop_Down_xpath = "//span[@id=\"select2-woocommerce_ppec_paypal_environment-container\"][text()=\"Live\"]";

    public void Check_Value_In_Environment_Drop_Down()
	{
        webDriver.getElementBy(ByTypes.xpath, Environment_Drop_Down_xpath, 20, true);
    }
}
