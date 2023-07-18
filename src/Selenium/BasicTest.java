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
import PageObjects.AddItemPageObject;
import PageObjects.LoginPage;
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

	public String env;
	
	public String fileName;

	public LoginPageNir loginPageNir;
	
	public GmailLoginPage gmailLoginPage;
	
	public GmailAllMailsDisplayedPage gmailAllMailsDisplayedPage;
	
	public ResetYourPasswordPage resetYourPasswordPage;

	public WelcomePage welcomePage;

	

	public SimulationPageNir simulationPageNir;
	
	public SubmitRequestPage submitRequestPage;
	

	
	public SelectProgramPage selectProgramPage;
	
	public UserDetailsFillingPage userDetailsFillingPage;
	
	public WordPressLoginPage wordPressLoginPage;
	
	public WordPressWooCommercePage wordPressWooCommercePage;
	
	public MailinatorPage mailinatorPage;
	

	
	public LicensesApplicationPage licensesApplicationPage;
	
	public MailinatorGetQuoteMail mailinatorGetQuoteMail;
	
	
	
	public PardotLoginPage pardotLoginPage;
	

	
	public RequestQuotePage requestQuotePage;
	
	public DuplicatorProPage duplicatorProPage;
	
	public Office365_login_page office365_login_page;
	
	public SharePoint_Upload_File_Section sharePoint_Upload_File_Section;
	
	public WordPressWooCommerceSettingsPaymentPaypalCheckout wordPressWooCommerceSettingsPaymentPaypalCheckout;
	
	public Microsoft_Sign_In_Page microsoft_Sign_In_Page;
	
	public Microsoft_Enter_Password_Page microsoft_Enter_Password_Page;
	
	

	public IConfigService configService;

	@BeforeMethod
	public void setup() throws Exception {

		configService = new ConfigFileImpl();
		
		if (System.getProperty("env") != null) {
			env = System.getProperty("env");
		} else {
			env = "play";
			fileName = "playCoderzLeagueRegistration";
		}
		
		testlog = new TestLog();

		reporter = new HtmlReporterImpl();
		
		try {
						
			webdriver = new GenericWebDriver();
			
			webdriver.init("http://localhost:4444/wd/hub", testlog);
			
			// IP For Docker machine 
			// webdriver.init("http://192.168.99.100:4444/wd/hub", testlog);
			
			loginPageNir = new LoginPageNir(webdriver);
			
			
			
			simulationPageNir = new SimulationPageNir(webdriver);
			
			gmailLoginPage = new GmailLoginPage(webdriver);
			
			gmailAllMailsDisplayedPage = new GmailAllMailsDisplayedPage(webdriver);
			
			resetYourPasswordPage = new ResetYourPasswordPage(webdriver);
			

			
			
			
			
			/**********************************************************************************/
		    /**********************************************************************************/
		        
		    /**********************************************************************************
		    **instances for coderz league registration
		    **********************************************************************************/
			selectProgramPage = new SelectProgramPage(webdriver);
			
			userDetailsFillingPage = new UserDetailsFillingPage(webdriver);
			
			wordPressLoginPage = new WordPressLoginPage(webdriver);
			
			wordPressWooCommercePage = new WordPressWooCommercePage(webdriver);
			
			mailinatorPage = new MailinatorPage(webdriver);
			
			mailinatorGetQuoteMail = new MailinatorGetQuoteMail(webdriver);
			

			
			licensesApplicationPage = new LicensesApplicationPage(webdriver);
			
			
			
			pardotLoginPage = new PardotLoginPage(webdriver);
			
			
			
			requestQuotePage = new RequestQuotePage(webdriver);
			
			duplicatorProPage = new DuplicatorProPage(webdriver);
			
			office365_login_page = new Office365_login_page(webdriver);
			
			sharePoint_Upload_File_Section = new SharePoint_Upload_File_Section(webdriver);
			
			wordPressWooCommerceSettingsPaymentPaypalCheckout = new WordPressWooCommerceSettingsPaymentPaypalCheckout(webdriver);
			
			microsoft_Sign_In_Page = new Microsoft_Sign_In_Page(webdriver);
			
			microsoft_Enter_Password_Page = new Microsoft_Enter_Password_Page(webdriver);
			
		
			
			
			
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
