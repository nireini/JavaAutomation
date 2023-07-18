package Selenium;

import TestObjects.TestLog;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class IEWebDriver extends GenericWebDriver {

	public void init(String remoteUrl,TestLog testLog) throws Exception {

//		System.setProperty("webdriver.gecko.driver", "C:\Users\CoderZ-Testing\Downloads\IEDriverServer_x64_3.12.0\\IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();

		URL url = new URL(remoteUrl);

		webdriver = new RemoteWebDriver(url, capabilities);

	}

}
