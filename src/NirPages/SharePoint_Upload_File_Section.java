package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class SharePoint_Upload_File_Section extends PageObjects.GenericPageObject{

	public SharePoint_Upload_File_Section(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String UPLOAD_BUTTON_XPATH = "//button[@name=\"Upload\"]/span[1]/span[1]/span[1]";
	
	private static final String FILES_XPATH = "//button[@name=\"Files\"]/div[1]/span[1]";
	
    public void Click_UPLOAD_BUTTON() throws Exception
    {
    	webDriver.getElementBy(ByTypes.xpath, UPLOAD_BUTTON_XPATH, 10, true).click();
    }
    
    public void Click_FILES() throws Exception
    {
    	webDriver.getElementBy(ByTypes.xpath, FILES_XPATH, 10, true).click();
    }

}
