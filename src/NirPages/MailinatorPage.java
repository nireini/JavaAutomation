package NirPages;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.junit.Assert;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class MailinatorPage extends PageObjects.GenericPageObject{

	public MailinatorPage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String EMAILINPUT_ID = "addOverlay";

    private static  final String GOBUTTON_ID = "go-to-public";
    
    private static  final String TopFrom_MailMailinaitorTEXT_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[1]/td[2]";
    private static  final String MiddleFrom_MailMailinaitorTEXT_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[2]/td[2]";
    private static  final String BottomFrom_MailMailinaitorTEXT_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[3]/td[2]";
    
    private static  final String TopMailMailinaitor_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[1]/td[3]";
    
    private static  final String Second_from_Top_MailMailinaitor_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[2]/td[3]";
    
    private static  final String Third_from_top_MailMailinaitor_XPATH = "//table[@class=\"table-striped jambo_table\"]/tbody/tr[3]/td[3]";
    
    private static  final String THREEDOTSBUTTON_XPATH = "//div/div[3]/div/div[@role=\"button\"]/img";
    
    private static  final String FirstName_In_Email_template_XPATH = "//tbody/tr[3]/td[1]/table[1]/tbody[1]/tr[1]/td[1]/table[1]/tbody[1]/tr[1]/td[1]";
    
    private static  final String THISLINK_XPATH = "//a[text()=\"this link\"]";
    
    private static  final String MAILILANTOR_IFRAME_ID = "html_msg_body";
    
    
    
    public void Enter_EMAILINPUT(String EMAILINPUT)
	{
        webDriver.getElementBy(ByTypes.id, EMAILINPUT_ID, 10, true).sendKeys(EMAILINPUT);
    }
    
    public void Click_GOBUTTON(){

        webDriver.getElementBy(ByTypes.id, GOBUTTON_ID, 20, true).click();
    }
    
    public void Wait_for_Second_from_Top_MailMailinaitor_XPATH()
    {
        webDriver.getElementBy(ByTypes.xpath, Second_from_Top_MailMailinaitor_XPATH, 20, true);
    }
    
    public void Wait_for_Third_from_Top_MailMailinaitor_XPATH()
    {
        webDriver.getElementBy(ByTypes.xpath, Third_from_top_MailMailinaitor_XPATH, 20, true);
    }
    
    public void Click_Third_from_Top_Mail_Mailinaitor_XPATH()
    {
        webDriver.getElementBy(ByTypes.xpath, Third_from_top_MailMailinaitor_XPATH, 60, true).click();
    }
    
    public void Click_Second_from_Top_Mail_Mailinaitor_XPATH()
    {
        webDriver.getElementBy(ByTypes.xpath, Second_from_Top_MailMailinaitor_XPATH, 60, true).click();
    }
    
    public void Click_TopMail_Mailinaitor(){

        webDriver.getElementBy(ByTypes.xpath, TopMailMailinaitor_XPATH, 20, true).click();
    }

    public Boolean CheckIfThreeDotsButtonDisplayed() throws InterruptedException
    {
        Boolean ThreeDotsAreDisplayed = webDriver.CheckIfElementIsDisplayed2(ByTypes.xpath, THREEDOTSBUTTON_XPATH);
        
        return ThreeDotsAreDisplayed;
    }
    
    public void Click_THREE_DOTS() 
    {
    	webDriver.getElementBy(ByTypes.xpath, THREEDOTSBUTTON_XPATH, 20, true).click();
    }
    
    public void CheckFirstNameIsDisplayed_in_email_template(String firstName) throws Exception 
    {
    	String first_name_in_template = webDriver.switchToFrameAndGetTextFromElement(FirstName_In_Email_template_XPATH, MAILILANTOR_IFRAME_ID);
    	
    	System.out.println("first_name_in_template - " + first_name_in_template);
    	
    	first_name_in_template = first_name_in_template.substring(0, 17);
    	
    	System.out.println("first_name_in_template - " + first_name_in_template);
        
    	Assert.assertEquals(first_name_in_template, firstName);
    }
    
    public void Click_THIS_LINK() throws Exception
    {
    	webDriver.switchToFrameAndClickElement(ByTypes.xpath, THISLINK_XPATH, MAILILANTOR_IFRAME_ID, false, 1);
    }
    
    public int ClickTheCorrectEmail() 
    {
    	String TopEmailFromText = "";
    	String MiddleEmailFromText = "";
    	String BottomEmailFromText = "";
    	
    	int ActivationEmailLocation = 1;
    	
    	TopEmailFromText = webDriver.GetTextFromElementByXPATH(TopFrom_MailMailinaitorTEXT_XPATH);
    		
    	if(TopEmailFromText.contains("noreply@gocoderz.com")) 
    	{
    		System.out.println("clicking top email");
    		
    		webDriver.getElementBy(ByTypes.xpath, TopMailMailinaitor_XPATH, 20, true).click();
    		
    		ActivationEmailLocation = 1;
    	}else 
    	{
    		MiddleEmailFromText = webDriver.GetTextFromElementByXPATH(MiddleFrom_MailMailinaitorTEXT_XPATH);
    		
    		if(MiddleEmailFromText.contains("noreply@gocoderz.com")) 
    		{
    			System.out.println("clicking middle email");
    			
    			webDriver.getElementBy(ByTypes.xpath, Second_from_Top_MailMailinaitor_XPATH, 20, true).click();
    			
    			ActivationEmailLocation = 2;
    		}else 
    		{
    			BottomEmailFromText = webDriver.GetTextFromElementByXPATH(BottomFrom_MailMailinaitorTEXT_XPATH);
    			
    			if(BottomEmailFromText.contains("noreply@gocoderz.com")) 
    			{
    				System.out.println("clicking bottom email");
    				
    				webDriver.getElementBy(ByTypes.xpath, Third_from_top_MailMailinaitor_XPATH, 20, true).click();
    				
    				ActivationEmailLocation = 3;
    			}
    		}
    	}
    	
    	return ActivationEmailLocation;
    }
    
 
}
