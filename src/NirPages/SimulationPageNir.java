package NirPages;


import NirTests.helpMethod;
import Selenium.GenericWebDriver;
import enums.ByTypes;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * Created by CoderZ-Testing on 07/06/2017.
 */
public class SimulationPageNir extends PageObjects.GenericPageObject {

    public SimulationPageNir(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static final String PLAY_BUTTON_ID = "run_simulation";

    private static final String NEXT_MISSION_XPATH= "//coderz-button[@click=\"ok()\"]/div/button/span";
    
    private static final String NEXT_MISSION_XPATHBYTEXT= "//coderz-button[@click=\"ok()\"]/div/button/span/span[text()=\"Next Activity\"]";

    private static final String START_BUTTON_XPATH= "//button[@ng-click=\"launch_mission()\"]/span";

    private static final String SIMULATION_MENU_BUTTON_XPATH = "//button[@ng-click=\"$mdOpenMenu($event)\"]/span";

    private static final String SIMULATION_MENU_BUTTON_CSS="span.ng-binding.ng-scope";

    private static final String SIMULATION_MENU_NEXT_BUTTON_XPATH = "//button[@ng-click=\"next_mission()\"]/div[1]/p";

    private static final String SOLUTION_BUTTON= "//button[@ng-click=\"open_solution()\"]/div/p";

    private static final String OK_BUTTON= "//button[@ng-click=\"dialog.hide()\"]/span";

    private static final String ELEMENTABOVESIMULATION_ID = "controls-toolbar1";

    private static final String Dashboard_id="main-header";

    private static final String Congratulations= "//md-dialog/md-dialog-content/h2[text()='Congratulations!']";

    private static final String BLOCKLYFRAME= "//*[@id=\"blockly_iframe\"]";

    private static final String PROGRAMSTARTcss= "#start_main_0";

    private static final String OPENSOLUTIONBUTTON="//button[@ng-click=\"open_solution()\"]/div/p";

    private static final String HUDBUTTON="toggle_hud";
    
    private static final String SAVEPROJECTBUTTON_XPATH = "//button[@ng-click=\"isLoaded()?$mdOpenMenu($event):return\"]/md-icon";
    
    private static final String SAVEASPROJECTBUTTON_XPATH = "//div[@aria-hidden=\"false\"]/md-menu-content/md-menu-item/button[@ng-click=\"saveAsOpen()\"]/div/p[@class=\"ng-binding flex\"][text()=\"Save as...\"]";
    
    private static final String SAVEASINPUTFIELD_XPATH = "//input[@ng-model=\"newProjectName\"]";
    
    private static final String SAVEBUTTONSUBMIT_XPATH = "//coderz-button[@click=\"submit()\"]/div/button/span";

    private static final String ReadyToCompeteButton_XPATH = "//coderz-button[@click=\"matchmaking.compete()\"]/div/button/span";

    private static final String FeedbackMessage_XPATH = "//div[text()=\"How was it?\"]";
    
    private static final String FeedbackMessageSkipButton_XPATH = "//div[@ng-click=\"cancel()\"]";

    private static final String SmileyImage_Xpath = "//div[@class=\"images-container layout-row\"]/div[5]/span[@layout=\"column\"]/img";

    private static final String FeedbackSubmitButton_XPATH = "//coderz-button[@click=\"ok()\"]/div/button/span[text()=\"SUBMIT\"]";
    
    private static final String NextPackButton_XPATH= "//coderz-button[@click=\"ok()\"]/div/button/span/span[text()=\"Next Pack\"]";
    
    private static final String ExportButton_XPATH= "//button[@aria-label=\"Export Blockly\"]/md-icon";
    
    public void clickSmileyImage(){

        webDriver.getElementBy(ByTypes.xpath, SmileyImage_Xpath, 20, true).click();
    }
    
    public void ClickFeedbackSubmitButton(){

        webDriver.getElementBy(ByTypes.xpath, FeedbackSubmitButton_XPATH, 20, true).click();
    }
    
    public void ClickNextPackButton(){

    	if(webDriver.getElementBy(ByTypes.xpath, NextPackButton_XPATH, 20, false)!=null) {
    		
    		webDriver.getElementBy(ByTypes.xpath, NextPackButton_XPATH, 20, false).click();
    	}
    }
    
    /**********************************************************************************/
    /**********************************************************************************/
        
    /**********************************************************************************
    **Checks if Next Pack Button Is Displayed
    **********************************************************************************/
    
    public Boolean CheckNextPackButtonIsDisplayed() throws InterruptedException{

        Boolean NextPackButtonIsDisplayed = webDriver.CheckIfElementIsDisplayed2(ByTypes.xpath, NextPackButton_XPATH);
        
        System.out.println("NextPackButtonIsDisplayed + value + " + NextPackButtonIsDisplayed);
        
        return NextPackButtonIsDisplayed;

    }
    
    public void clickPlayButton(){

        webDriver.getElementBy(ByTypes.id, PLAY_BUTTON_ID, 20, true).click();
    }

    public void clickNextMission(){
    	
    	if(webDriver.getElementBy(ByTypes.xpath, NEXT_MISSION_XPATHBYTEXT, 10, false)!=null) {
    		
    		webDriver.getElementBy(ByTypes.xpath, NEXT_MISSION_XPATHBYTEXT, 20, false).click();
    	}
    	
        
    }
    
    public void clickNextMissionMandatory(){

        webDriver.getElementBy(ByTypes.xpath, NEXT_MISSION_XPATHBYTEXT, 20, true).click();

    }
    
    /**********************************************************************************/
    /**********************************************************************************/
        
    /**********************************************************************************
    **Checks if Next Mission Button Is Displayed
    **********************************************************************************/
    public Boolean CheckkNextMissionButtonIsDisplayed() throws InterruptedException{

        Boolean NextMissionButtonIsDisplayed = webDriver.CheckIfElementIsDisplayed2(ByTypes.xpath, NEXT_MISSION_XPATHBYTEXT);
        
        System.out.println("NextMissionButtonIsDisplayed + value + " + NextMissionButtonIsDisplayed);
        
        return NextMissionButtonIsDisplayed;

    }

    public void clickStartButton(){

        webDriver.getElementBy(ByTypes.xpath, START_BUTTON_XPATH, 30,true).click();
    }



    public void clickMenuNextMissionButton(){

        webDriver.getElementBy(ByTypes.xpath,SIMULATION_MENU_NEXT_BUTTON_XPATH, 10,true).click();
    }

    public void waitTillElementAboveSimulationIsLoaded(){

        webDriver.getElementBy(ByTypes.id, ELEMENTABOVESIMULATION_ID, 200, true);
        
    }
    
    public void waitTillElementAboveSimulationIsLoaded2(){

        webDriver.getElementBy(ByTypes.id, ELEMENTABOVESIMULATION_ID, 200, true);
    }

    public void clickOnDashboardWithOffset(){

        WebElement element = webDriver.getElementBy(ByTypes.id, Dashboard_id, 10, true);

        webDriver.clickOnElemenmtWithOffset(element, 300 ,0);

    }

    public void writeImport(){

        String str="import";

        webDriver.RobotWrite();



    }

    public String XMLContent(String missionName) throws IOException {



        String XMLString = helpMethod.readFile((System.getProperty("user.dir") + "\\files\\xml\\" + missionName));

        return XMLString;


    }




    public void typeXmlContentToAlert(String XMLString){

        webDriver.typeAlert(XMLString);
    }

    public void alertAccept(){

        webDriver.acceptAlert();
    }

//    public Boolean checkIFAlertPresent(){
//
//        return webDriver.checkWeatherAlertIsPresent();
//
//
//    }


    public String removeLastChar(String str){

        String newStr="";

        return newStr = webDriver.method(str);
    }

    public void clickMenuButton(){

        webDriver.getElementBy(ByTypes.css, SIMULATION_MENU_BUTTON_CSS, 60, true).click();

    }

    public void clickSolutionButton(){

        webDriver.getElementBy(ByTypes.xpath, SOLUTION_BUTTON, 10, true).click();
    }

    public void clickOKButton(){

        webDriver.getElementBy(ByTypes.xpath, OK_BUTTON, 10, true).click();
    }



    public void waitForMissionTextEnd(){

        webDriver.getElementBy(ByTypes.xpath, Congratulations, 60, true);

    }

    public void waitForHUDButton(){

        webDriver.getElementBy(ByTypes.id, HUDBUTTON, 60, true);

    }

    public void closeTour(){

        ((JavascriptExecutor) webDriver).executeScript("window.tourService.end()");
    }

    public void selectBlocklyFrame() throws Exception
    {
        webDriver.switchToFrameAndWaitForElement(PROGRAMSTARTcss, BLOCKLYFRAME);
    }
    
    
    // clicking save button in simulation pgae
    public void clickSimulationPageSAVEPROJECTBUTTON(){

        webDriver.getElementBy(ByTypes.xpath, SAVEPROJECTBUTTON_XPATH, 20, true).click();
    }
    
    public void clickSAVEASPROJECTBUTTON(){

        webDriver.getElementBy(ByTypes.xpath, SAVEASPROJECTBUTTON_XPATH, 20, true).click();
    }
    
    public void EnterProjectName(String ProjectName){

        webDriver.getElementBy(ByTypes.xpath, SAVEASINPUTFIELD_XPATH, 20, true).sendKeys(ProjectName);
    }
    
    //clicking save button after entering the project's name 
    public void clickSAVEBUTTONAfterEnteringProjectName(){

        webDriver.getElementBy(ByTypes.xpath, SAVEBUTTONSUBMIT_XPATH, 20, true).click();
    }
    
    public void clickReadyToCompeteButton() {
    	
    	webDriver.getElementBy(ByTypes.xpath, ReadyToCompeteButton_XPATH, 20, true).click();
    }
    
    public void clickReadyToCompeteButton2() {
    	
    	webDriver.getElementBy(ByTypes.xpath, ReadyToCompeteButton_XPATH, 20, true).click();
    }
    
    public void waitUntilOpponentFoundText() {
    	
    	String OpponentFoundText = "Opponent found!";
    	
    	webDriver.CheckIfTextExistOnPage(OpponentFoundText);
    }
    
    public void waitUntilOpponentFoundText2() {
    	
    	String OpponentFoundText = "Opponent found!";
    	
    	webDriver.CheckIfTextExistOnPage(OpponentFoundText);
    }
    
    public Boolean checkFeedbackMessageIsDisplayed() throws InterruptedException{

    	Boolean FeedbackMessageIsDisplayed = webDriver.CheckIfElementIsDisplayed2(ByTypes.xpath, FeedbackMessage_XPATH);
    	
    	System.out.println("FeedbackMessageIsDisplayed + value + " + FeedbackMessageIsDisplayed);
    	
    	return FeedbackMessageIsDisplayed;
    }
    
    public void clickSkipFeedbackMessage(){

        webDriver.getElementBy(ByTypes.xpath, FeedbackMessageSkipButton_XPATH, 20, true);
    }
    
    public void ClickExportButton() 
    {
    	webDriver.getElementBy(ByTypes.xpath, ExportButton_XPATH, 20, true).click();
    }
    
    



}
