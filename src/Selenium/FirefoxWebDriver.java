package Selenium;

import TestObjects.TestLog;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class FirefoxWebDriver extends GenericWebDriver {
	
	public void init(String remoteUrl,TestLog testLog) throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Users\\Nir_Eini\\Desktop\\selenium\\geckodriver.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();


		capabilities.setCapability("marionette", true);


		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

	}

}
