package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class QuestionsSection extends GenericPageObject{
    public QuestionsSection(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String GAMEIFRAME_ID = "game-canvas";

    private static final String ul_Across_Questions = "section._2cce2lyM9ASVcbS1hdRuAG.game_cluesContainer__1O_1o._39wC1gQoLh7Dua95rb15b5._8qqS0kVOh5gmmODnXEkkD.TMjiZ1Izz36JskNfCF0-v._15Rnh46emuuBaoi_bjQn7B >section:nth-child(1) > ul";
    private static final String Across_First_Question_CSS = "section._2cce2lyM9ASVcbS1hdRuAG.game_cluesContainer__1O_1o._39wC1gQoLh7Dua95rb15b5._8qqS0kVOh5gmmODnXEkkD.TMjiZ1Izz36JskNfCF0-v._15Rnh46emuuBaoi_bjQn7B >section:nth-child(1) > ul > li:nth-child(1)";


    public void clickOnAcrossFirstQuestion() throws Exception {
        webDriver.switchToFrameAndClickElement(ByTypes.css, Across_First_Question_CSS, GAMEIFRAME_ID, false, 1);
    }

    public void clickOnAcrossAllQuestions() throws Exception {

        int numberOfAcrossQuestions = webDriver.CountingNumberOfLiElementsUsingCSS(ul_Across_Questions, GAMEIFRAME_ID);

//        for(int i=0; i < numberOfAcrossQuestions ; i++){
//            webDriver.getElementBy(ByTypes.css, "section._2cce2lyM9ASVcbS1hdRuAG.game_cluesContainer__1O_1o._39wC1gQoLh7Dua95rb15b5._8qqS0kVOh5gmmODnXEkkD.TMjiZ1Izz36JskNfCF0-v._15Rnh46emuuBaoi_bjQn7B >section:nth-child(1) > ul > li:nth-child(" + String.valueOf(i) +")").click();
//        }

    }

    public void AnsweringAllQuestionsAcross() throws Exception {



    }

}
