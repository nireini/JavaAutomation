package Selenium;

import Interfaces.myTestParams;

import NirPages.DuplicatorProPage;
import NirPages.EnterPasswordSignInPage;
import NirPages.GmailAllMailsDisplayedPage;
import NirPages.GmailLoginPage;

import NirPages.LicensesApplicationPage;
import NirPages.LoginPageNir;
import NirPages.MailinatorGetQuoteMail;
import NirPages.MailinatorPage;

import NirPages.Microsoft_Enter_Password_Page;
import NirPages.Microsoft_Sign_In_Page;

import NirPages.Office365_login_page;

import NirPages.RequestQuotePage;
import NirPages.ResetYourPasswordPage;
import NirPages.SelectProgramPage;
import NirPages.SharePoint_Upload_File_Section;
import NirPages.SimulationPageNir;
import NirPages.SubmitRequestPage;

import NirPages.UserDetailsFillingPage;
import NirPages.WelcomePage;
import NirPages.WordPressLoginPage;
import NirPages.WordPressWooCommercePage;
import NirPages.WordPressWooCommerceSettingsPaymentPaypalCheckout;
import NirPages.PardotLoginPage;
import PageObjects.*;
import Services.*;
import TestObjects.TestLog;

import java.util.List;


import org.junit.Assert;

import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;




public class BasicTest {
	
	
	public String sut_url;

	public String username;

	public String email;

	public String password;
	
	public String MicrosoftPassword;

	public long delayTime=20;

	@Rule
	public TestWatcher testWatcher = new TestWatcher() {

		@Override
		protected void succeeded(Description description) {

			if (testlog.hasFailures() == false) {
				Assert.fail("Test had some failures");

			}

			super.succeeded(description);
		}

		@Override
		protected void starting(Description description) {

			try {
				if (description.getAnnotation(myTestParams.class) != null) {
					myTestParams param = description.getAnnotation(myTestParams.class);
					
					System.out.println(param.testTimeOut());

					if (!param.browser().equals("")) {
						browser = param.browser();
					}
					
					
					if(param.url()!=null){
						sut_url=param.url();
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			super.starting(description);
		}

	};

	public GenericWebDriver webdriver;
	
	public GenericWebDriver firefoxWebdriver;

	LoginPage loginPage;

	AddItemPageObject addItem;

	// ********* test logging

	TestLog testlog;

	IReporter reporter;

	MongoDbService dbservice;

	String browser = null;

	Date date;

	public String env;
	
	public String fileName;

	public PrivacyFrame privacyFrame;

	public PlayPageBeforeAdvertisementDisplayed playPageBeforeAdvertisementDisplayed;

	public PickDatePage pickDatePage;

	public CrosswordPage crosswordPage;

	public ResultsFrame resultsFrame;

	public QuestionsSection questionsSection;
	
	

	public IConfigService configService;

	@BeforeMethod
	public void setup() throws Exception {

		configService = new ConfigFileImpl();
		
		if (System.getProperty("env") != null) {
			env = System.getProperty("env");
		} else {
			env = "play";
			fileName = "play";
		}


		date = new Date();

		testlog = new TestLog();

		reporter = new HtmlReporterImpl();
		
		try {
						
			webdriver = new GenericWebDriver();
			
			webdriver.init("http://localhost:4444/wd/hub", testlog);
			
			// IP For Docker machine 
			// webdriver.init("http://192.168.99.100:4444/wd/hub", testlog);
			


			privacyFrame = new PrivacyFrame(webdriver);

			playPageBeforeAdvertisementDisplayed = new PlayPageBeforeAdvertisementDisplayed(webdriver);

			pickDatePage = new PickDatePage(webdriver);

			crosswordPage = new CrosswordPage(webdriver);

			resultsFrame = new ResultsFrame(webdriver);

			questionsSection = new QuestionsSection(webdriver);
			
			/**********************************************************************************/
		    /**********************************************************************************/
		        
		    /**********************************************************************************
		    **loading configuration file for the test
		    **********************************************************************************/
			
			String grid=null;
			
			configService.load(env, fileName);

			sut_url = configService.getProperty("sut.url");

			configService.getProperty("username");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		//dbservice = new MongoDbService();
	}

	@AfterMethod
	public void tearDown() throws Exception 
	{
		 List<LogEntry> logs = webdriver.geWeBrowserLogs().getAll();
		
		 for (int i = 0; i < logs.size(); i++) 
		 {
		 System.out.println(logs.get(i).getLevel().toString() + " " +
		 logs.get(i).getMessage());
		 }
		
		 if (logs.size() == 0) 
		 {
		 System.out.println("No logs found");
		 }

		webdriver.quit();

		reporter.saveTestLog(testlog);
	}

}
