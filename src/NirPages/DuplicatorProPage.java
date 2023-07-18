package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class DuplicatorProPage extends PageObjects.GenericPageObject{

	public DuplicatorProPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}

	private static  final String Duplicator_Pro_DIV_XPATH = "//a[@href=\"admin.php?page=duplicator-pro\"]/div[@class=\"wp-menu-name\"]";
	
	private static  final String CREATE_NEW_BUTTON_ID = "dup-pro-create-new";
	
	private static  final String NEXT_BUTTON_ID = "button-next";
	
	private static  final String Continue_with_the_build_process_CHECKBOX_ID = "dup-scan-warning-continue-checkbox";
	
	private static  final String BUILD_BUTTON_ID = "dup-build-button";
	
	private static  final String TOPPEST_DOWNLOAD_BUTTON_XPATH = "//table[@class=\"widefat dpro-pktbl striped\"]/tbody/tr[1]/td[7]/nav[1]/button";
	
	private static  final String ARCHIVE_ZIP_BUTTON_XPATH = "//table[@class=\"widefat dpro-pktbl striped\"]/tbody/tr[1]/td[7]/nav[1]/nav/div[3]";
	
    public void Click_Duplicator_Pro()
    {
        webDriver.getElementBy(ByTypes.xpath, Duplicator_Pro_DIV_XPATH, 30, true).click();
    }
    
    public void Click_CREATE_NEW_BUTTON()
    {
        webDriver.getElementBy(ByTypes.id, CREATE_NEW_BUTTON_ID, 30, true).click();
    }
    
    public void Click_NEXT_BUTTON()
    {
        webDriver.getElementBy(ByTypes.id, NEXT_BUTTON_ID, 30, true).click();
    }
    
    public void Check_Continue_with_the_build_process_CHECKBOX()
    {
        webDriver.getElementBy(ByTypes.id, Continue_with_the_build_process_CHECKBOX_ID, 30, true).click();
    }
    
    public void Click_BUILD_BUTTON()
    {
        webDriver.getElementBy(ByTypes.id, BUILD_BUTTON_ID, 30, true).click();
    }
    
    public void Click_TOPPEST_DOWNLOAD_BUTTON() throws InterruptedException
    {
    	Thread.sleep(5000);
    	
        webDriver.getElementBy(ByTypes.xpath, TOPPEST_DOWNLOAD_BUTTON_XPATH, 200, true).click();
    }
    
    public String Get_ONCLICK_Attribute(String attribute) 
    {
    	return webDriver.get_Attribute_For_Element_By_Xpath(ARCHIVE_ZIP_BUTTON_XPATH, attribute, 20);
    }
}
