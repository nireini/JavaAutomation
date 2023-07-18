package Selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import org.testng.*;

@RunWith(Suite.class)
@SuiteClasses({
	Selenium4Tests.class,
	ikeaTest.class
})
public class suiterunner {

}
