package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class ResultsFrame extends GenericPageObject{
    public ResultsFrame(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String GAMEIFRAME_ID = "game-canvas";
    private static final String TITLE_RESULTS_CSS = "h3._3zgsysvIVJUoGnTj1_uckR.title_title__1huCZ.gameEndPopup_title__1wufI";
    private static final String BUTTON_SUBMIT_TOTAL_SCORE_CSS = "section._2cce2lyM9ASVcbS1hdRuAG.game_subContainer__2Z9rk._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk > div > article > section > section > section._2cce2lyM9ASVcbS1hdRuAG.gameEndPopup_submitContainer__3c7bp._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk.lrDkyz8O__XunQqaHezep._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(2)";

    private static final String BUTTON_REVIEW_ANSWERS_CSS = "section._2cce2lyM9ASVcbS1hdRuAG.game_subContainer__2Z9rk._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk > div > article > section > section > section._2cce2lyM9ASVcbS1hdRuAG.gameEndPopup_submitContainer__3c7bp._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk.lrDkyz8O__XunQqaHezep._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(1)";

    private static final String SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(2) > h4";
    private static final String RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(2) > h2";
    private static final String SECTION_COMPLETION_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(3) > h4";

    private static final String RESULT_FOR_COMPLETION_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(3) > h2";
    private static final String SECTION_TIME_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(4) > h4";

    private static final String RESULT_FOR_PUZZLE_TIME_COMPLETION_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(4) > h2";
    private static final String SECTION_DAILY_BONUS_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(5) > h4";

    private static final String RESULT_FOR_DAILY_BONUS_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(5) > h2";
    private static final String SECTION_PUZZLE_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(6) > h4";

    private static final String RESULT_FOR_PUZZLE_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(6) > h2";
    private static final String SECTION_TOTAL_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > section:nth-child(1) > h4:nth-child(1)";

    private static final String RESULT_FOR_TOTAL_SCORE_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > h2";
    private static final String SECTION_ONE_PUZZLE_THIS_MONTH_CSS = "section._1WOLqIpDmSmsJGpFvS9fPR.gameEndPopup_window__Y44DQ > section:nth-child(2) > section:nth-child(8) > section:nth-child(1) > h4:nth-child(2)";


    public void ClickSubmitTotalScoreButton() throws Exception {
        webDriver.switchToFrameAndClickElement(ByTypes.css, BUTTON_SUBMIT_TOTAL_SCORE_CSS, GAMEIFRAME_ID, false, 1);
    }

    public void Check_REVIEW_ANSWERS_BUTTON_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(BUTTON_REVIEW_ANSWERS_CSS, GAMEIFRAME_ID);
    }

    public void CheckResultsTitleIsDisplayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(TITLE_RESULTS_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_COMPLETION_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_COMPLETION_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_COMPLETION_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_COMPLETION_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_TIME_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_TIME_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_PUZZLE_TIME_COMPLETION_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_PUZZLE_TIME_COMPLETION_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_DAILY_BONUS_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_DAILY_BONUS_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_DAILY_BONUS_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_DAILY_BONUS_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_PUZZLE_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_PUZZLE_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_PUZZLE_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_PUZZLE_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_TOTAL_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_TOTAL_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_RESULT_FOR_TOTAL_SCORE_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(RESULT_FOR_TOTAL_SCORE_CSS, GAMEIFRAME_ID);
    }

    public void Check_SECTION_ONE_PUZZLE_THIS_MONTH_Is_Displayed() throws Exception {
        webDriver.switchToFrameAndWaitForElement_By_CSS(SECTION_ONE_PUZZLE_THIS_MONTH_CSS, GAMEIFRAME_ID);
    }




}
