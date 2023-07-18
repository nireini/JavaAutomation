package YoutubePages;

import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;
import org.openqa.selenium.WebElement;

/**
 * Created by CoderZ-Testing on 14/05/2018.
 */
public class YoutubeSearchPage extends PageObjects.GenericPageObject {

    public YoutubeSearchPage(GenericWebDriver webDriver) {
		super(webDriver);
		// TODO Auto-generated constructor stub
	}

	private static final String SEARCHSLOTID="search";

    private static final String SEARCHBUTTONID="search-icon-legacy";

    private static final String THIRDSONGONTHELISTXPATH = "//div[@id=\"contents\"]/ytd-video-renderer[3]";

    private static final String PAUSEBUTTONXPATH = "//button[@class=\"ytp-play-button ytp-button\"]";

    private static final String YOUTUBEMENUBUTTONID = "guide-icon";

    private static final String LIBRARYBUTTONXPATH = "//yt-formatted-string[@id=\"guide-section-title\"]/a[@href=\"/channel/UCPGQiwjwWtqKLYiOx1nqruA/playlists\"]";

    private static final String LIKEDVIDEOSBUTTONXPATH = "//a[@title=\"Liked videos\"]";

    private static final String FIRSTSONGONLIKEDVIDEOSXPATH = "//div[@id=\"contents\"]/ytd-playlist-video-list-renderer/div/ytd-playlist-video-renderer[1]";

    private static final String SECONDSONGONLIKEDVIDEOSWHENVIDEOISPLAYINGXPATH = "//div/ytd-playlist-panel-video-renderer[2]/a/div/div[@id=\"thumbnail-container\"]";

    private static final String FIFTHSONGONLIKEDVIDEOWHENVIDEOISPLAYINGXPATH = "//div/ytd-playlist-panel-video-renderer[5]/a/div/div[@id=\"thumbnail-container\"]";

    private static final String FifthSongXPATH = "//span[@title=\"Martin Luther King, Jr. I Have A Dream Speech\"]";

    private static final String FirstVideoXPATH = "//span[@title=\"Boot Camp 2 Carly Rose Sonenclar vs Beatrice Miller THE X FACTOR USA 2012  HD\"]";

    private static final String VIDEOPLAYINGHEADXPATH = "//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]/yt-formatted-string";


   

    public void EnterSongName(String songName){
        webDriver.getElementBy(ByTypes.id, SEARCHSLOTID, 10, true).sendKeys(songName);

    }

    public void ClickSearch(){
        webDriver.getElementBy(ByTypes.id, SEARCHBUTTONID, 10, true).click();
    }

    public void ClickThirdSongOnTheList(){
        webDriver.getElementBy(ByTypes.xpath, THIRDSONGONTHELISTXPATH, 10, true).click();
    }

    public Boolean CheckThatSongIsBeingPlayed(){

        return webDriver.getElementBy(ByTypes.xpath, PAUSEBUTTONXPATH, 10, true).isDisplayed();
    }

    public void ClickYouTubeMenuButton(){

        webDriver.getElementBy(ByTypes.id, YOUTUBEMENUBUTTONID, 10, true).click();
    }

    public void ClickOnLibraryButton(){

        webDriver.getElementBy(ByTypes.xpath, LIBRARYBUTTONXPATH, 10, true).click();
    }

    public void ClickOnLikedVideosButton(){
        webDriver.getElementBy(ByTypes.xpath, LIKEDVIDEOSBUTTONXPATH, 10, true).click();
    }

    public void ClickONFirstVideoOnLikedVideos(){

        webDriver.getElementBy(ByTypes.xpath, FIRSTSONGONLIKEDVIDEOSXPATH, 10, true).click();
    }

    public void ClickOnSencondLikedVideoWhenVideoIsPlaying(){

        webDriver.getElementBy(ByTypes.xpath, SECONDSONGONLIKEDVIDEOSWHENVIDEOISPLAYINGXPATH, 10,true).click();
    }

    public void ClickOnFifthLikedVideoWhenVideoIsPlaying(){

        webDriver.getElementBy(ByTypes.xpath, FIFTHSONGONLIKEDVIDEOWHENVIDEOISPLAYINGXPATH, 10,true).click();
    }

    public String GetFifthSongText() {

        WebElement element = webDriver.getElementBy(ByTypes.xpath, "//span[@title=\"Martin Luther King, Jr. I Have A Dream Speech\"]");

        if (element != null) {
            return element.getText();
        } else {
            return null;
        }

    }

    public String GetFirstSongText(){

        WebElement element = webDriver.getElementBy(ByTypes.xpath, "//span[@title=\"Boot Camp 2 Carly Rose Sonenclar vs Beatrice Miller THE X FACTOR USA 2012  HD\"]");

        if (element != null) {
            return element.getText();
        } else{
            return null;
        }
    }

    public String GetVideoPlayingHeadText(){

        WebElement element = webDriver.getElementBy(ByTypes.xpath, "//h1[@class=\"title style-scope ytd-video-primary-info-renderer\"]/yt-formatted-string");

        if (element != null) {
            return element.getText();
        } else{
            return null;
        }
    }








}
