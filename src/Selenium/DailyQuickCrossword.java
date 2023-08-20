package Selenium;

import PageObjects.CrosswordPage;
import PageObjects.PickDatePage;
import org.testng.annotations.Test;

public class DailyQuickCrossword extends BasicTest{

    @Test
    public void FinishDailyQuickCrossword() throws Exception {

        String DailyQuickCrosswordURL = "https://www.gamelab.com/games/daily-quick-crossword";

        // get today current's date
        String CURRENT_DATE = date.getCurrentDate();

        int TimesToClickOnLeftArrow = 1;

        testlog.addStep("Open Daily Quick Crossword URL");

        testlog.addAction("Open Daily Quick Crossword URL");

        webdriver.openUrl(DailyQuickCrosswordURL);

        webdriver.maximize();

        testlog.addStep("Click on agree privacy button");

        testlog.addAction("Click on agree privacy button");

        privacyFrame.clickOnAgreeButton();

        testlog.addStep("Click on play button");

        testlog.addAction("Click on play button");

        playPageBeforeAdvertisementDisplayed.clickOnPlayButton();

        testlog.addStep("Select current day");

        testlog.addAction("Select current day");

        pickDatePage.clickOnCurrentDayWithDailyBonus();

        testlog.addStep("Check the date is today's date");

        testlog.addAction("Check the date is today's date");

        crosswordPage.CompareDateText(CURRENT_DATE);

        testlog.addStep("Click reveal button");

        testlog.addAction("Click reveal button");

        crosswordPage.clickOnRevealButton();

        testlog.addStep("Click reveal puzzle button");

        testlog.addAction("Click reveal puzzle button");

        crosswordPage.clickOnRevealPuzzleButton();

        testlog.addStep("Check Results title is displayed");

        resultsFrame.CheckResultsTitleIsDisplayed();

        testlog.addStep("Check SECTION COMPLETED WITHOUT HELP OR ERRORS is displayed");

        resultsFrame.Check_SECTION_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed();

        testlog.addStep("Check RESULT FOR COMPLETED WITHOUT HELP OR ERRORS is displayed");

        resultsFrame.Check_RESULT_FOR_COMPLETED_WITHOUT_HELP_OR_ERRORS_Is_Displayed();

        testlog.addStep("Check SECTION COMPLETION SCORE is displayed");

        resultsFrame.Check_SECTION_COMPLETION_SCORE_Is_Displayed();

        testlog.addStep("Check RESULT FOR COMPLETION SCORE is displayed");

        resultsFrame.Check_RESULT_FOR_COMPLETION_SCORE_Is_Displayed();

        testlog.addStep("Check SECTION TIME is displayed");

        resultsFrame.Check_SECTION_TIME_Is_Displayed();

        testlog.addStep("Check RESULT FOR PUZZLE TIME COMPLETION is displayed");

        resultsFrame.Check_RESULT_FOR_PUZZLE_TIME_COMPLETION_Is_Displayed();

        testlog.addStep("Check SECTION DAILY BONUS is displayed");

        resultsFrame.Check_SECTION_DAILY_BONUS_Is_Displayed();

        testlog.addStep("Check RESULT FOR DAILY BONUS is displayed");

        resultsFrame.Check_RESULT_FOR_DAILY_BONUS_Is_Displayed();

        testlog.addStep("Check SECTION PUZZLE SCORE is displayed");

        resultsFrame.Check_SECTION_PUZZLE_SCORE_Is_Displayed();

        testlog.addStep("Check RESULT FOR PUZZLE SCORE is displayed");

        resultsFrame.Check_RESULT_FOR_PUZZLE_SCORE_Is_Displayed();

        testlog.addStep("Check SECTION TOTAL SCORE is displayed");

        resultsFrame.Check_SECTION_TOTAL_SCORE_Is_Displayed();

        testlog.addStep("Check RESULT FOR TOTAL SCORE is displayed");

        resultsFrame.Check_RESULT_FOR_TOTAL_SCORE_Is_Displayed();

        testlog.addStep("Check SECTION ONE PUZZLE THIS MONTH is displayed");

        resultsFrame.Check_SECTION_ONE_PUZZLE_THIS_MONTH_Is_Displayed();

        testlog.addStep("Check Submit total score button is displayed");

        resultsFrame.CheckSubmitTotalScoreButtonIsDisplayed();

        testlog.addStep("Check REVIEW ANSWERS BUTTON is displayed");

        resultsFrame.Check_REVIEW_ANSWERS_BUTTON_Is_Displayed();
    }
}
