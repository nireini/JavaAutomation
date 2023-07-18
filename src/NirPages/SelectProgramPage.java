package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class SelectProgramPage extends PageObjects.GenericPageObject{

	public SelectProgramPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String novice_team_plus_button_XPATH = "//div[@class=\"elementor-section-wrap\"]/section[2]/div/div/div/div/div/section/div/div/div[3]/div/div/div[1]/div/div/div/div[2]/input/following-sibling::button";
	
	private static  final String novice_class_plus_button_XPATH = "//div[@class=\"elementor-section-wrap\"]/section[2]/div/div/div/div/div/section/div/div/div[3]/div/div/div[2]/div/div/div/div[2]/input/following-sibling::button";
	
	private static  final String novice_school_plus_button_XPATH = "//div[@class=\"elementor-section-wrap\"]/section[2]/div/div/div/div/div/section/div/div/div[3]/div/div/div[3]/div/div/div/div[2]/input/following-sibling::button";
	
	private static  final String get_quote_button_XPATH = "//section[5]/div/div/div/div/div/section/div/div/div[1]/div/div/div/div/div/a[@href=\"/get-quote/\"]/span/span[text()=\"REQUEST A QUOTE\"]";
	
	public void ClickTeamNovicePlusButton()
	{
        webDriver.getElementBy(ByTypes.xpath, novice_team_plus_button_XPATH, 20, true).click();
    }
	
	public void Click_ClassNovicePlusButton()
	{
        webDriver.getElementBy(ByTypes.xpath, novice_class_plus_button_XPATH, 20, true).click();
    }
	
	public void Click_SchoolNovicePlusButton()
	{
        webDriver.getElementBy(ByTypes.xpath, novice_school_plus_button_XPATH, 20, true).click();
    }
	
	public void Click_get_quote_Button()
	{
        webDriver.getElementBy(ByTypes.xpath, get_quote_button_XPATH, 20, true).click();
    }
}
