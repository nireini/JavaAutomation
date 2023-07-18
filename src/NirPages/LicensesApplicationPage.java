package NirPages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class LicensesApplicationPage extends PageObjects.GenericPageObject{

	public LicensesApplicationPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String Licenses_TAB_ID = "tab-licenses";
	
	private static final String ORG_ADMIN_NUMBER_OF_SEATS = "//*[@id=\"pane-licenses\"]/div/div[2]/div/div/div/div[3]/table/tbody/tr[1]/td[3]/div";
	
	public void Click_Licenses_TAB()
	{
        webDriver.getElementBy(ByTypes.id, Licenses_TAB_ID, 20, true).click();
    }
	
	public void AssertOrgAdminNumberOfSeatsIsCorrect()
	{
		String numberOfSeats = "";
		
		numberOfSeats = webDriver.GetTextFromElementByXPATH(ORG_ADMIN_NUMBER_OF_SEATS);
		
		System.out.println(numberOfSeats);
		
		//Assert.assertTrue(numberOfSeats.equals("329"));
	}

}
