package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class RequestQuotePage extends PageObjects.GenericPageObject{

	public RequestQuotePage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static final String IFRAME_XPATH = "//iframe[@title=\"Request CoderZ Quote\"]";
	
    private static final String FIRST_NAME_ID = "141221_13566pi_141221_13566";

    private static final String LASTNAMEID = "141221_13568pi_141221_13568";

    private static final String EMAIL_ADDRESS_ID = "141221_13570pi_141221_13570";
    
    private static final String PHONE_ID = "141221_16789pi_141221_16789";

    private static final String Job_Title_ID = "141221_67446pi_141221_67446";
    
    private static final String Class_RADIO_ID = "141221_67448pi_141221_67448_440302_440302";
    
    private static final String School_Name_ID = "141221_13572pi_141221_13572";
    
    private static final String District_ID = "141221_67450pi_141221_67450";
    
    private static final String Country_ID = "141221_16605pi_141221_16605";
    
    private static final String State_ID = "141221_13582pi_141221_13582";
    
    private static final String fourth_grade_checkbox_ID = "141221_67452pi_141221_67452_440304";
    
    private static final String Estimated_number_of_students_ID = "141221_13586pi_141221_13586";
    
    private static final String Additional_Information_ID = "141221_13638pi_141221_13638";
    
    private static final String Coupon_Code_ID = "141221_70935pi_141221_70935";
    
    private static final String Request_Pricing_XPATH = "//input[@type=\"submit\"]";
    
    public void Check_FIRST_NAME() throws Exception{

        webDriver.switchToFrameAndWaitForElement_By_ID(FIRST_NAME_ID, IFRAME_XPATH);
    }
    
    public void Check_LAST_NAME() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(LASTNAMEID, IFRAME_XPATH);
    }
    
    public void Check_EMAIL_ADDRESS() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(EMAIL_ADDRESS_ID, IFRAME_XPATH);
    }
    
    public void Check_PHONE() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(PHONE_ID, IFRAME_XPATH);
    }
    
    public void Check_Job_Title() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Job_Title_ID, IFRAME_XPATH);
    }
    
    public void Check_Class_RADIO() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Class_RADIO_ID, IFRAME_XPATH);
    }
    
    
    public void Check_School_Name() throws Exception{

        webDriver.switchToFrameAndWaitForElement_By_ID(School_Name_ID, IFRAME_XPATH);
    }
    
    public void Check_District() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(District_ID, IFRAME_XPATH);
    }
    
    public void Check_Country() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Country_ID, IFRAME_XPATH);
    }
    
    public void Check_State() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(State_ID, IFRAME_XPATH);
    }
    
    public void Check_fourth_grade_checkbox() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(fourth_grade_checkbox_ID, IFRAME_XPATH);
    }
    
    public void Check_Estimated_number_of_students() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Estimated_number_of_students_ID, IFRAME_XPATH);
    }

    public void Check_Additional_Information() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Additional_Information_ID, IFRAME_XPATH);
    }
    
    public void Check_Coupon_Code() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement_By_ID(Coupon_Code_ID, IFRAME_XPATH);
    }
    
    public void Check_Request_Pricing() throws Exception
    {
    	webDriver.switchToFrameAndWaitForElement_By_Xpath(Request_Pricing_XPATH, IFRAME_XPATH);
    }

}
