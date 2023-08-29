package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class Play_More_Page extends GenericPageObject{
    public Play_More_Page(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String PLAY_AGAIN_BUTTON_CSS = "button[data-element-description=\"game-end play-again-button\"]";

    public void clickOnPlayAgainButton() throws Exception {
        webDriver.getElementBy(ByTypes.css, PLAY_AGAIN_BUTTON_CSS, 10, true).click();
    }
}
