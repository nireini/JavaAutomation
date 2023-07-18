package Selenium;

import Services.Utils.fileUtils;


import TestObjects.TestLog;
import enums.ByTypes;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

import javax.imageio.ImageIO;

//import static org.testng.Assert.assertEquals;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeOptions;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GenericWebDriver {

	RemoteWebDriver webdriver;

	TestLog testLog;

	// remote url=address of node/grid
	public void init(String remoteUrl, TestLog testLog) throws Exception 
	{
		//ChromeOptions capabilities = new ChromeOptions();
	    
	    /*
	     *  set capability to download files
	     */
		String downloadFilepath = "C:\\Utility\\OP_Resources\\ChromeDownload";
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.prompt_for_download", "false");
		chromePrefs.put("download.default_directory", downloadFilepath);
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		
		LoggingPreferences loggingPreferences = new LoggingPreferences();

		loggingPreferences.enable(LogType.DRIVER, Level.ALL);
		
		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

		this.testLog = testLog;
		
		webdriver.manage().window().maximize();
		webdriver.setFileDetector(new LocalFileDetector());
	}
	
	public void testSendMail()
	{
		List<String>mail=generateEmails(100);
	}

	public List<String> generateEmails(int size) 
	{
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < size; i++) 
		{
			list.add(RandomStringUtils.randomAlphabetic(10) + "@mailinator.com");
		}
		return list;
	}
	
	/**********************************************************************************/

	/**********************************************************************************/
	        
	/**********************************************************************************/
	/**********************************************************************************    
	**get text from element by xpath
	**********************************************************************************/
	public String GetTextFromElementByXPATH(String ELEMENT_XPATH)
	{
		WebElement Element = null;
		
		String ElementText = "";
		
		try 
		{
			Element = getElementBy(ByTypes.xpath, ELEMENT_XPATH);
			
			ElementText = Element.getText();
			
			
		} catch (Exception e) 
		{
			printScreen("Failed getting element from text");

			e.printStackTrace();
		}
		
		return ElementText;
	}
	
	public void copyStringToClipboardPastePressEnter(String StringToCopy) throws AWTException 
	{
		Toolkit toolkit = Toolkit.getDefaultToolkit();

		Clipboard clipboard = toolkit.getSystemClipboard();

		StringSelection strSel = new StringSelection(StringToCopy);

		clipboard.setContents(strSel, null);

		Robot robot = new Robot();

		robot.keyPress(KeyEvent.VK_CONTROL);

		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);

		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);

		robot.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public String generateEmail() {
		
		String email = "";

	    email = RandomStringUtils.randomAlphabetic(10) + "@mailinator.com";
	    
		return email;
	}
	
	
	
	public void waitForLoad() {
        ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(webdriver, 30);
        wait.until(pageLoadCondition);
    }


	public LogEntries geWeBrowserLogs() {
		return webdriver.manage().logs().get(LogType.BROWSER);
	}

	// navigates to a url
	public void openUrl(String url) {
		webdriver.get(url);
	}

	public void quit() {
		webdriver.quit();
	}
	
	public void close()
	{
		webdriver.close();
	}
	
	public void refresh() {
		webdriver.navigate().refresh();
	}
	
	public void maximize()
	{
		webdriver.manage().window().maximize();
	}
	
	public void go_back_to_previous_page() 
	{
		webdriver.navigate().back();
	}

	public WebElement getElementByXpath(String xpath) throws Exception {
		return getElementBy(ByTypes.xpath, xpath);
	}

	public void hoverOnElement(WebElement element) {
		Actions action = new Actions(webdriver);
		action.moveToElement(element).perform();

	}
	
	public void scrollDown(String downToScroll)
	{
		JavascriptExecutor js = (JavascriptExecutor) webdriver;  
		
		js.executeScript("window.scrollBy(0," + downToScroll + ")");
	}

	public List<String> getComboBoxValues(String xpath) throws Exception {
		// get thr combobox element
		WebElement comboBoxElement = getElementBy(ByTypes.xpath, xpath);

		// create a combobox element from the webElement
		Select select = new Select(comboBoxElement);

		// creeate a list of webElements from the combobox values
		List<WebElement> comboValues = select.getOptions();

		// creates a list of strings that will hold the text
		List<String> listStr = new ArrayList<String>();

		// iterates over the WebElements list and gets the text from each
		// webElement

		// the same as: (int i=0;i<comboValues.size();i++)
		for (WebElement element : comboValues) {
			listStr.add(element.getText());
		}
		// return the list of strings
		return listStr;
	}

	
	/*
	 * select combo box by text value
	 */
	public void selectComboBoxOptions(String optionVale, String xpath) throws Exception {

		try {
			WebElement comboBox = getElementBy(ByTypes.xpath, xpath);

			Select select = new Select(comboBox);

			select.selectByVisibleText(optionVale);
			
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");

			e.printStackTrace();
		}

	}
	
	/*
	 * select combo box by text value
	 */
	public void selectComboBoxOptions_ById(String optionVale, String id) throws Exception {

		try 
		{
			WebElement comboBox = getElementBy(ByTypes.id, id);

			Select select = new Select(comboBox);

			select.selectByVisibleText(optionVale);
			
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");

			e.printStackTrace();
		}

	}
	
	/*
	 * select combo box by value
	 */
	public void selectComboBoxOptionsByValue(String optionVale, String xpath) throws Exception {

		try {
			WebElement comboBox = getElementBy(ByTypes.xpath, xpath);

			Select select = new Select(comboBox);

			select.selectByValue(optionVale);
			
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");

			e.printStackTrace();
		}

	}
	
	public void selectComboBoxOptionsByValue_ID(String optionVale, String id) throws Exception {

		try {
			WebElement comboBox = getElementBy(ByTypes.id, id);

			Select select = new Select(comboBox);

			select.selectByValue(optionVale);
			
		} catch (Exception e) {
			printScreen("SelectingFromComboBoxFailed");

			e.printStackTrace();
		}

	}

	public WebElement getElementBy(ByTypes type, String value) {
		return getElementBy(type, value, 10);
	}

	public WebElement getElementBy(ByTypes type, String value, int timeout) {
		return getElementBy(type, value, timeout, false);
	}

	public void typeInAlert(String text) {
		try {
			Alert alert = webdriver.switchTo().alert();

			alert.sendKeys(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void CheckIfUnityIsLoaded() {
		
		boolean isRobotLoaded = false;
		
		JavascriptExecutor js = (JavascriptExecutor) webdriver;  
		
		
		if(!(isRobotLoaded)) {
			
			webdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			isRobotLoaded = (boolean) js.executeScript("return window.runnerService.isLoaded()");
		}
	}
	
	public void executeJavaScript(String script) {
		
		JavascriptExecutor js = (JavascriptExecutor) webdriver;  
		js.executeScript(script);
	}
	
	public String get_Attribute_For_Element_By_Xpath(String value,String attribute, int timeout)
	{
		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);
		
		WebElement element = null;
		
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
		
		String Attribute_Value = element.getAttribute(attribute);
		
		return Attribute_Value;
	}

	public WebElement getElementBy(ByTypes type, String value, int timeout, boolean mandatory) 
	{
		testLog.addStep("Looking for element :" + value);

		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		WebElement element = null;
		
		Boolean isPresent = false;

		try {
			switch (type) {
			
			case xpath:
				if(!mandatory) {
					
					Thread.sleep(5000);
					
					isPresent = webdriver.findElements(By.xpath(value)).size() > 0;
					
					if(isPresent) {
						
						System.out.println("Element was found");
						
						element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
					}else {
						System.out.println("Element was not found");
						return null;
					}
				}else {
					System.out.println("Mandatory Element was found");
					element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				}
				
				break;
			case className:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				break;

			case id:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;

			case link:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				break;

			case name:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
				
			case css:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				break;
			default:
				break;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//printScreen("ElementNotFound_" + value);
			printScreen("");
			
			e.printStackTrace();

			if (mandatory == true) {
				testLog.setTestStatus(false);
				Assert.fail("Failed due to an exception in getting element");
			}
		}
		
		

		testLog.addAction("Element found");

		if (element == null && mandatory == true) {

			testLog.addAction("");
			Assert.fail("Mandatory element " + value + " was not found");
		}
		 
		return element;
	}
	
	public Boolean CheckIfElementIsDisplayed(ByTypes type, String value, int timeout) {
		
		testLog.addStep("Looking for element :" + value);

		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		WebElement element = null;

		try {
			switch (type) {
			case xpath:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));
				break;
			case className:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(value)));
				break;

			case id:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(value)));
				break;

			case link:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(value)));
				break;

			case name:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(value)));
				break;
				
			case css:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(value)));
				break;
			default:
				break;
			}
			
			return true;
			
		}catch (Exception e){
			
            printScreen("");
			
			e.printStackTrace();

			if (element == null) {

				testLog.addAction("");
				return false;
			}else {
				return true;
			}
		}
	}
	
	
	
	public Boolean CheckIfElementIsDisplayed2(ByTypes type, String value) throws InterruptedException {
		
		Thread.sleep(10000);
		
		Boolean isPresent = webdriver.findElements(By.xpath(value)).size() > 0;
		
		return isPresent;
	}

	public List<WebElement> getElementsByXpath(String xpath) {
		WebDriverWait wait = new WebDriverWait(webdriver, 10, 1000);

		List<WebElement> list = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

		return list;

	}
	
	protected void checkElementPresence(final By by,final String errorMsg){
		  new WebDriverWaitWithMessage(webdriver,10).failWith(errorMsg).until(new ExpectedCondition<Boolean>(){
		    @Override public Boolean apply(    WebDriver webDriver){
		      try {
		        return webdriver.findElement(by).isDisplayed();
		      }
		 catch (      NoSuchElementException ignored) {
		        return false;
		      }
		catch (      StaleElementReferenceException ignored) {
		        return false;
		      }
		    }
		  }
		);
	}

	public String printScreen(String prefix) {
		File screenshot = null;

		String newPath = null;

		try {
			WebDriver augmentedDriver = new Augmenter().augment(webdriver);
			screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			newPath = System.getProperty("user.dir") + "\\files\\scr\\" + prefix + screenshot.getName();
			fileUtils.copyFile(screenshot, newPath);

		} catch (WebDriverException e) {

			System.out.println(e.getStackTrace());

		}

		return newPath;
	}

	public void addCookie(String name, String value) {
		Cookie cookie = new Cookie(name, value);
		webdriver.manage().addCookie(cookie);
	}

	public boolean isCookiesExist(String name, String value) {
		Cookie cookie = webdriver.manage().getCookieNamed(name);

		if (cookie != null) {
			if (cookie.getValue().equals(value)) {
				return true;
			} else
				return false;
		} else
			return false;
	}
	
	

	public void swithcToFrameAndSendKeys(String xpathExpression, String keys, boolean clear, String frameId)
			throws Exception {
		String currentWindow = webdriver.getWindowHandle();
		webdriver.switchTo().frame(frameId);

		WebElement element = webdriver.findElement(By.xpath(xpathExpression));

		element.click();
		if (clear == true) {
			element.clear();
		}

		element.sendKeys(keys);
		webdriver.switchTo().window(currentWindow);
	}

	public void dragAndDrop(String xpathFrom, String xpathTo) {

		Actions actions = new Actions(webdriver);

		WebElement elementFrom = getElementBy(ByTypes.xpath, xpathFrom);

		WebDriverWait wait = new WebDriverWait(webdriver, 10);

		// actions.dragAndDrop(elementFrom,
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathTo))))
		// .build().perform();

		actions.clickAndHold(elementFrom).moveByOffset(-300, -300).pause(1000).release().perform();

	}

	public void setImplicitWait() {
		// tells the webdriver to always wait until an element is loaded in the
		// DOM

		// unlike Explicit wait (Using the webDriverWait) it cannot use special
		// conditions

		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void setImplicitWaitFrom() {
		// tells the webdriver to always wait until an element is loaded in the
		// DOM

		// unlike Explicit wait (Using the webDriverWait) it cannot use special
		// conditions

		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public Screenshot getScreenshot(WebElement element, String ignoreXpath) {
		Screenshot shot = new AShot().takeScreenshot(webdriver, element);

		return shot;
	}

	public void takeAshot(WebElement element, String name) throws IOException {
		Screenshot shot = null;

		shot = new AShot().takeScreenshot(webdriver, element);

		File output = new File(System.getProperty("user.dir") + "/files/baseLine/" + name + ".png");
		ImageIO.write(shot.getImage(), "png", output);

	}

	public void clickOnElemenmtWithOffset(WebElement element, int x, int y) {
		Actions build = new Actions(webdriver);

		build.moveToElement(element, x, y).click().build().perform();
	}

	public void maximizeWindow() throws Exception{

		webdriver.manage().window().maximize();
	}

	public void RobotWrite() {

		try {
			Robot robot = new Robot();

			// Creates the delay of 5 sec so that you can open notepad before
			// Robot start writing
			robot.delay(5000);
			robot.keyPress(KeyEvent.VK_I);
			robot.keyPress(KeyEvent.VK_M);
			robot.keyPress(KeyEvent.VK_P);
			robot.keyPress(KeyEvent.VK_O);
			robot.keyPress(KeyEvent.VK_R);
			robot.keyPress(KeyEvent.VK_T);


		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void RobotWrite_KEEP_FILE() {

		try 
		{
			Robot robot = new Robot();

			// Creates the delay of 5 sec so that you can open notepad before
			// Robot start writing
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_J);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_J);
			
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			
			robot.keyPress(KeyEvent.VK_RIGHT);
			robot.keyRelease(KeyEvent.VK_RIGHT);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void SwitchToAlert()
	{
		Alert alert = webdriver.switchTo().alert();
	}
	
	public void typeAlert(String text) {
		try {
			Alert alert = webdriver.switchTo().alert();

			alert.sendKeys(text);

			acceptAlert();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void acceptAlert(){

		Alert alert = webdriver.switchTo().alert();



		alert.accept();
	}

	public String method(String str) {
		if (str != null && str.length() > 0 && str.charAt(str.length() - 1) == 'x') {
			str = str.substring(0, str.length() - 1);
		}
		return str;
	}
	
	/**********************************************************************************
	 **
	 * Switch to Frame xpath and check if Element_xpath is located in the frame
	 **********************************************************************************/
	public void switchToFrameAndWaitForElement_By_Xpath(String element_value, String frameXPATH) throws Exception
	{
		String currentWindow = webdriver.getWindowHandle();
		
		int timeout = 10;
		
		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		webdriver.switchTo().defaultContent();
		
		try 
		{
			//webdriver.switchTo().frame(frameXPATH);
			webdriver.switchTo().frame(0);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element_value)));
			
			webdriver.switchTo().window(currentWindow);
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}
	}
	
	/**********************************************************************************
	 **
	 * Switch to Frame by xpath and check if Element_id is located in the frame 
	 **********************************************************************************/
	public void switchToFrameAndWaitForElement_By_ID(String element_value_By_ID, String frameXPATH) throws Exception
	{
		String currentWindow = webdriver.getWindowHandle();
		
		int timeout = 10;
		
		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		webdriver.switchTo().defaultContent();
		
		try 
		{
			//webdriver.switchTo().frame(frameXPATH);
			webdriver.switchTo().frame(0);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(element_value_By_ID)));
			
			
			webdriver.switchTo().window(currentWindow);
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}
	}
	
	public void switchToFrameAndCheckInnerTextInElement(String element_value, String frameXPATH, String ExpectedInnerText) throws Exception
	{
		WebElement element = null;
		
		String ElementInnerText = "";
		
		String currentWindow = webdriver.getWindowHandle();
		
		int timeout = 10;
		
		WebDriverWait wait = new WebDriverWait(webdriver, timeout, 1000);

		webdriver.switchTo().defaultContent();
		
		try 
		{
			webdriver.switchTo().frame(frameXPATH);
			
			JavascriptExecutor jse = (JavascriptExecutor)webdriver;
			
			jse.executeScript("window.scrollBy(0, 550)");
			
			Thread.sleep(2000);
			
			element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element_value)));
			
			ElementInnerText = element.getText();
			
			System.out.println("Receipt total price is " + ElementInnerText); 
			
			//assertEquals(ElementInnerText, ExpectedInnerText);
			
			webdriver.switchTo().window(currentWindow);
			
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}
	}


	public void switchToFrameAndWaitForElement(String elementCSS, String frameXPATH) throws Exception
	{

		String currentWindow = webdriver.getWindowHandle();

		webdriver.switchTo().defaultContent();
		
		try 
		{
			webdriver.switchTo().frame(frameXPATH);
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}

		webdriver.findElement(By.cssSelector(elementCSS));

		webdriver.switchTo().window(currentWindow);
	}
	
	public void switchToFrameAndClickElement(String element_XPATH, String frameID) throws Exception
	{

		String currentWindow = webdriver.getWindowHandle();

        webdriver.switchTo().defaultContent();
		
		try 
		{
			webdriver.switchTo().frame(frameID);
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}

		WebElement Element = getElementBy(ByTypes.xpath, element_XPATH);
		
		openInNewTabAndSwitch(Element);
	}
	
	public String switchToFrameAndGetTextFromElement(String element_XPATH, String frameID) throws Exception
	{

		String currentWindow = webdriver.getWindowHandle();

        webdriver.switchTo().defaultContent();
		
		try 
		{
			webdriver.switchTo().frame(frameID);
		}catch(NoSuchFrameException e)
		{
			throw new Exception(e.getMessage(), e);
		}

		WebElement Element = getElementBy(ByTypes.xpath, element_XPATH);
		
		String Element_text = Element.getText();
		
		webdriver.switchTo(). parentFrame();
		
		return Element_text;
	}
	
	public void openInNewTabAndSwitch(WebElement linkElement) 
	{
	    String parentTab = webdriver.getWindowHandle();
	    Actions newTab = new Actions(webdriver);
	    newTab.keyDown(Keys.CONTROL).click(linkElement).keyUp(Keys.CONTROL).build().perform();
	    WebDriverWait wait = new WebDriverWait(webdriver,5);
	    wait.until(ExpectedConditions.numberOfWindowsToBe(2));
	    Set<String> windowSet = webdriver.getWindowHandles();
	    for(String tab:windowSet)
	    {
	        if(!parentTab.equalsIgnoreCase(tab))
	        {
	        	webdriver.switchTo().window(tab);
	            //do your work in the newly opened TAB
	        }
	    }
	}

	public void delay(long time) throws InterruptedException {

		webdriver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void switchToWindowByIndex(int index) {
		
		
		ArrayList<String> tabs2 = new ArrayList<String> (webdriver.getWindowHandles());
		webdriver.switchTo().window(tabs2.get(index));
		
		
		}
	
	public void CheckIfTextExistOnPage(String TextThatShouldBeDisplayedOnPage) {
		
		webdriver.getPageSource().contains(TextThatShouldBeDisplayedOnPage);
	}
	

    
    
}


