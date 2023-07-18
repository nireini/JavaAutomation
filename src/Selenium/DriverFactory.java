package Selenium;

import enums.BrowserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by CoderZ-Testing on 16/05/2018.
 */
public class DriverFactory {

    public static WebDriver getDriver(BrowserType type) throws Exception{

        WebDriver driver = null;

        switch (type){

            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:

                driver = new ChromeDriver();
                break;
            case IE:
                driver = new InternetExplorerDriver();
                break;

        }

        return driver;
    }

    public static BrowserType getBrowserTypeByProperty(){

        BrowserType type = null;
      //  String browsername = PropertyManager.
//        for(BrowserType bType : BrowserType.values()){
//            if(bType.getBrowserName().equalsIgnoreCase(browsername)){
//               type = bType;
//               System.out.println("BROWSER = " + type.getBrowserName());
//            }

        return null;
    }


}


