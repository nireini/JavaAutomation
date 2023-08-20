package PageObjects;

import Selenium.GenericWebDriver;
import enums.ByTypes;

public class PrivacyFrame extends GenericPageObject{
    public PrivacyFrame(GenericWebDriver webDriver) {
        super(webDriver);
    }

    private static final String AGREE_BUTTON_XPATH = "//button[@mode=\"primary\"]";

    public void clickOnAgreeButton() throws Exception {
        webDriver.getElementBy(ByTypes.xpath, AGREE_BUTTON_XPATH).click();
    }
}
