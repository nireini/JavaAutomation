package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class PlayPageBeforeAdvertisementDisplayed extends GenericPageObject{
    public PlayPageBeforeAdvertisementDisplayed(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String PLAY_BUTTON_CSS = "div.ark-ad-button-text.ctaButtonText";

    public void clickOnPlayButton() throws Exception {
        webDriver.getElementBy(ByTypes.css, PLAY_BUTTON_CSS).click();
    }




}
