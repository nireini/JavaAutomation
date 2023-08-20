package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class PickDatePage extends GenericPageObject{
    public PickDatePage(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String GAMEIFRAME_ID = "game-canvas";
    private static final String Current_Day_With_Daily_Bonus_XPATH = "//h4[text()=\"Daily Bonus\"]/../../..";

    public void clickOnCurrentDayWithDailyBonus() throws Exception {
        webDriver.switchToFrameAndClickElement(ByTypes.xpath, Current_Day_With_Daily_Bonus_XPATH, GAMEIFRAME_ID, true, 0);
    }











}
