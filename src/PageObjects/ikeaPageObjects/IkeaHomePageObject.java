package PageObjects.ikeaPageObjects;

import PageObjects.GenericPageObject;
import Selenium.FirefoxWebDriver;
import Selenium.GenericWebDriver;
import enums.ByTypes;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class IkeaHomePageObject extends NirPages.GenericPageObject {

	

	

	public IkeaHomePageObject(GenericWebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void searchItem(String itemText) throws Exception {
		
		WebElement element = webDriver.getElementBy(ByTypes.xpath, "//div[@class='search_inner']//input", 10, true);

		webDriver.getElementBy(ByTypes.xpath, "//div[@class='search_inner']//input", 10, true);

		element.sendKeys(itemText);

		element.sendKeys(Keys.ENTER);

	}

	public String getPriceString() throws Exception {
		WebElement element = webDriver.getElementBy(ByTypes.xpath, "//div[@class='price ng-binding']");

		if (element != null) {
			return element.getText().replace(" ₪", "");
		} else
			return null;
	}

	public void addToWishList() {
		webDriver.getElementBy(ByTypes.xpath, "//div[contains(@class,'add_to_wishlist')]").click();

	}

	public void openWishlist() {
		webDriver.getElementBy(ByTypes.xpath, "//a[@href='/wishlist']").click();

	}

	public boolean CheckMKT(String mkt) {
		WebElement element = webDriver.getElementBy(ByTypes.xpath, "//span[text()='" + mkt + "']");
		if (element != null) {
			return true;
		} else
			return false;

	}

}
