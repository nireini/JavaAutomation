package NirPages;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class WordPressWooCommercePage extends PageObjects.GenericPageObject{

	public WordPressWooCommercePage(GenericWebDriver webDriver) 
	{
		super(webDriver);
	}
	
	private static  final String woocommerce_XPATH = "//li[@id=\"toplevel_page_woocommerce\"]/a";

    private static  final String orders_XPATH = "//a[@href=\"edit.php?post_type=shop_order\"]";
    
    private static  final String QUOTEREQUESTSPAN_XPATH = "//table[@class=\"wp-list-table widefat fixed striped table-view-list posts\"]/tbody/tr[1]/td[3]/mark/span";
    
    private static  final String select_quote_status_ID = "select2-order_status-container";

    private static  final String Completed_status_XPATH = "//li[text()=\"Completed\"]";
    
    private static  final String update_button_NAME = "save";

    private static  final String registered_successfully_message_XPATH = "//strong[text()=\"registered successfully\"]";
    
    private static  final String TOPREQUEST_CHECKBOX_XPATH = "//tbody[@id=\"the-list\"]/tr[1]/th[1]/input[@name=\"post[]\"]";
    
    private static  final String ACTIONS_SELECTOR_ID = "bulk-action-selector-top";
    
    private static  final String APPLYBUTTON_ID = "doaction";
    
    private static  final String MOVETO_TRASH_XPATH = "//div[@id=\"delete-action\"]/a";
    
    public void ClickWooCommerceButton()
    {
        webDriver.getElementBy(ByTypes.xpath, woocommerce_XPATH, 20, true).click();
    }
	
	public void Click_orders_Button()
	{
        webDriver.getElementBy(ByTypes.xpath, orders_XPATH, 20, true).click();
    }
	
	public void Click_TOP_QUOTE_REQUEST()
    {
        webDriver.getElementBy(ByTypes.xpath, QUOTEREQUESTSPAN_XPATH, 20, true).click();
    }
	
	public void Click_select_quote_status()
	{
        webDriver.getElementBy(ByTypes.id, select_quote_status_ID, 20, true).click();
    }
	
	public void Click_Completed_status()
    {
        webDriver.getElementBy(ByTypes.xpath, Completed_status_XPATH, 20, true).click();
    }
	
	public void Click_update_button()
	{
        webDriver.getElementBy(ByTypes.name, update_button_NAME, 20, true).click();
    }
	
	public void Wait_registered_successfully_message()
	{
        webDriver.getElementBy(ByTypes.xpath, registered_successfully_message_XPATH, 20, true);
    }
	
	public void Click_TOP_REQUEST_CHECKBOX()
	{
        webDriver.getElementBy(ByTypes.xpath, TOPREQUEST_CHECKBOX_XPATH, 20, true).click();
    }
	
	public void selectTrashValueFromActionsComboBox() throws Exception
	{
		webDriver.selectComboBoxOptionsByValue_ID("trash", ACTIONS_SELECTOR_ID);
	}
	
	public void Click_APPLY_BUTTON()
	{
        webDriver.getElementBy(ByTypes.id, APPLYBUTTON_ID, 20, true).click();
    }

	public void Click_MOVETO_TRASH()
    {
        webDriver.getElementBy(ByTypes.xpath, MOVETO_TRASH_XPATH, 20, true).click();
    }
}
