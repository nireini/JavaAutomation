package YoutubePages;

import NirPages.GenericPageObject;
import Selenium.GenericWebDriver;
import enums.ByTypes;

/**
 * Created by CoderZ-Testing on 15/05/2018.
 */
public class YoutubeHomePage extends GenericPageObject {

    private static final String HOMEBUTTON = "//a[@title=\"Home\"]";

    private static final String TRENDINGBUTTON = "//a[@title=\"Trending\"]";

    private static final String HistoryBUTTON = "//a[@title=\"History\"]";

    private static final String MUSICBUTTON = "//a[@title=\"Music\"]";

    private static final String SportsBUTTON = "//a[@title=\"Sports\"]";

    private static final String GamingBUTTON = "//a[@title=\"Gaming\"]";

    private static final String NewsBUTTON = "//a[@title=\"News\"]";

    private static final String LiveBUTTON = "//a[@title=\"Live\"]";

    private static final String THREEHUNDREDSIXTYDEGREEBUTTON = "//a[@title=\"360° Video\"]";

    public YoutubeHomePage(GenericWebDriver driver) {
        super(driver);}


    public void CheckTrendingButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, TRENDINGBUTTON, 10, true).isDisplayed();
    }

    public void CheckHomeButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, HOMEBUTTON, 10, true).isDisplayed();
    }

    public void CheckHistoryButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, HistoryBUTTON, 10, true).isDisplayed();
    }

    public void CheckMusicButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, MUSICBUTTON, 10, true).isDisplayed();
    }

    public void CheckSportsButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, SportsBUTTON, 10, true).isDisplayed();
    }

    public void CheckGamingButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, GamingBUTTON, 10, true).isDisplayed();
    }

    public void CheckNewsButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, NewsBUTTON, 10, true).isDisplayed();
    }

    public void CheckLiveButtonIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, LiveBUTTON, 10, true).isDisplayed();
    }

    public void CheckTHREEHUNDREDSIXTYDEGREEBUTTONIsDisplayed() {
        webDriver.getElementBy(ByTypes.xpath, THREEHUNDREDSIXTYDEGREEBUTTON, 10, true).isDisplayed();
    }


}







