package NirPages;


import Selenium.GenericWebDriver;
import enums.ByTypes;


public class WelcomePage extends PageObjects.GenericPageObject{

	public WelcomePage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static final String MISSIONCENTER_ID= "missions";

    private static final String STARTNEWPROJECTBUTTON_CSS = "div.right-side > div.add-btn > button.big-btn-padding-color.ng-binding";

    private static final String WRITEPROJECTNAMEINPUT_XPATH = "//md-dialog[@id='new-project']/ng-include/div/form/div/input[@class=\"inputs_select_name ng-pristine ng-empty ng-invalid ng-invalid-required ng-touched\"]";

    private static final String NEXTBUTTON_XPATH = "//button[@ng-click='next()']";
    private static final String NEXTBUTTON_2_XPATH = "//md-dialog[@id='new-project']/ng-include/div/div/button[2]/div";

    private static final String BEGINCODINGBUTTON_CSS = "span.text.ng-scope";

    private static final String NEWC303_LINK = "newc318";


    public void clickMissionCenter(){

        webDriver.getElementBy(ByTypes.id, MISSIONCENTER_ID, 20, true).click();


    }
    
    public void waitForMissionCenterButton(){

        webDriver.getElementBy(ByTypes.id, MISSIONCENTER_ID, 60, true);


    }
    
    public void waitForMissionCenterButton2(){

        webDriver.getElementBy(ByTypes.id, MISSIONCENTER_ID, 60, true);


    }


    public void clickProjectNewc302(){

        webDriver.getElementBy(ByTypes.link, NEWC303_LINK, 5, true).click();

    }

    public void clickStartNewProject(){

        webDriver.getElementBy(ByTypes.css, STARTNEWPROJECTBUTTON_CSS, 10, true).click();
    }

    public void typeProjectName(String projectName){

        webDriver.getElementBy(ByTypes.xpath, WRITEPROJECTNAMEINPUT_XPATH, 10, true).sendKeys(projectName);
    }

    public void clickNextButton(){

        webDriver.getElementBy(ByTypes.xpath, NEXTBUTTON_XPATH, 10, true).click();
    }

    public void clickNextButton_2(){

        webDriver.getElementBy(ByTypes.xpath, NEXTBUTTON_2_XPATH, 10, true).click();
    }

    public void clickBeginCodingButton(){

        webDriver.getElementBy(ByTypes.css, BEGINCODINGBUTTON_CSS, 10, true).click();
    }
}
