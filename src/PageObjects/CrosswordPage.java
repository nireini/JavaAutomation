package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class CrosswordPage extends GenericPageObject{


    public CrosswordPage(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String GAMEIFRAME_ID = "game-canvas";

    private static final String DateOfPuzzle_CSS = "span.game_inlinePuzzleInfo__3UbfO";

    private static final String REVEAL_BUTTON_CSS = "section._2cce2lyM9ASVcbS1hdRuAG._1AGIG0RqUtmcCzoW6cNRBH.game_hud__3COkM._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(4) > div";

    private static final String REVEAL_PUZZLE_BUTTON_CSS = "section._2cce2lyM9ASVcbS1hdRuAG._1AGIG0RqUtmcCzoW6cNRBH.game_hud__3COkM._39wC1gQoLh7Dua95rb15b5._140yJY3xbL2XQ0uyfbmrHk._3EpPQDKCBPGUiusdrEq0pV > button:nth-child(4) > ul:nth-child(2) > li:nth-child(3)";

    public void CompareDateText(String ExpectedPuzzleDate) throws Exception {

        String searchText_1 = "Daily Quick Crossword: ";
        String searchText_2 = "By Michael Curl";

        String Date_In_Crossword  = webDriver.GetTextFromElementByCSS(DateOfPuzzle_CSS, GAMEIFRAME_ID);

        String Date_In_Crossword_fix = Date_In_Crossword.replace(searchText_1, "");
        Date_In_Crossword_fix = Date_In_Crossword_fix.replace(searchText_2, "");

        System.out.println("Fixed date String: " + Date_In_Crossword_fix);

        assertEquals(Date_In_Crossword_fix, ExpectedPuzzleDate);
    }

    public void clickOnRevealButton() throws Exception {
        webDriver.switchToFrameAndClickElement(ByTypes.css, REVEAL_BUTTON_CSS, GAMEIFRAME_ID, false, 1);
    }

    public void clickOnRevealPuzzleButton() throws Exception {
        webDriver.switchToFrameAndClickElement(ByTypes.css, REVEAL_PUZZLE_BUTTON_CSS, GAMEIFRAME_ID, false, 1);
    }


}
