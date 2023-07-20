package com.olp.test;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.olp.common.GenericFunctions;
import com.olp.common.Utility;
import com.olp.pages.SP1_OLX_T453_Story;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SP1_OLX_T453 {
	public WebDriver driver;
	ChromeOptions options;
	GenericFunctions gf;
	SP1_OLX_T453_Story obj;
	Utility util;
	Properties prop;
	String mainOfficeUrl;
	String Company;
	String userNameMainOffice;
	String password;
	String gCCUrl;
	String userNameGCC;
	String oldVesselUrl;
	String newVesselUrl;
	String userNameVessel;
	String userNameAssessor1;
	String onboardPass;
	String path = ".\\Screenshots";
	String configpath = ".\\src\\main\\java\\com\\compass\\config\\config.properties";
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	WebDriverWait wait;
	String testMethodName;
	Boolean value;
	String descriptiveTestName;
	int i, j, k;
	String excelPath;


	@BeforeSuite
	public void initialConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("SP1_OLX_T453_OLP2L - Search for personnel - Advanced search - Additional search criteria selection/deselection.html");
		spark.config().setDocumentTitle("OLP Integration Test Execution Report");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Automation Test Report");
		//		extent.attachReporter(spark);
		extent.setSystemInfo("Test Type ", "Integration");
		extent.setSystemInfo("Environment", "Stage");
		extent.setSystemInfo("Author", "Ashish");
		extent.attachReporter(spark);
	}

	@BeforeTest
	public void setUp() throws IOException {

		prop = new Properties();
		FileInputStream ip = new FileInputStream(configpath);
		prop.load(ip);
		mainOfficeUrl = prop.getProperty("mainOfficeUrl");
		Company = prop.getProperty("Company");
		userNameMainOffice = prop.getProperty("userNameMainOffice");
		password = prop.getProperty("password");

		gCCUrl= prop.getProperty("gCCUrl");
		userNameGCC = prop.getProperty("userNameGCC");

		newVesselUrl = prop.getProperty("newVesselUrl");
		oldVesselUrl = prop.getProperty("oldVesselUrl");

		userNameVessel = prop.getProperty("userNameVessel");

		userNameAssessor1=prop.getProperty("userNameAssessor1");
	}

	@BeforeMethod
	public void setup(Method method) {
		testMethodName = method.getName();
		descriptiveTestName = method.getAnnotation(Test.class).testName();
		test = extent.createTest(descriptiveTestName);

	}


	@Test(priority = 1, testName = "TC01_Verify login to Vessel as Special User")
	public void loginToVessel() {
		try {
			WebDriverManager.chromedriver().setup();
			ChromeOptions dc = new ChromeOptions();
			dc.addArguments("--remote-allow-origins=*");
			dc.setAcceptInsecureCerts(true);
			driver = new ChromeDriver(dc);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));

			// ExtentTest test=extent.createTest("Check Login to OLP");

			wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			gf = new GenericFunctions(driver);
			obj = new SP1_OLX_T453_Story(driver);
			util = new Utility(driver);
			test.info("Test to check login functionality");
			gf.getUrl(newVesselUrl);
			gf.LoginToVessel(userNameVessel, password);
			gf.waitForPageLoad(1000);
			String currentURL=driver.getCurrentUrl();
			if (currentURL.contains("client")) {
				test.pass("Log in to Vessel as Special user sucessful");

			} else {
				test.fail("Log in to Vessel as Special User unsucessful");

			}
			//			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		}
		catch (Exception e) {
			test.fail(e);
		}
	}

	@Test(priority = 2, testName = "TC02_Click on Show Advance Search")
	public void navigateToShowAdvanceSearch() {
		try {
			i=obj.navigateToShowAdvanceSearch();

			if (i==1) {

				test.pass("Show advance search is expanded succsesfully");
				//test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
			}
			else {
				test.fail("show advance search is not expanded unsuccsesfull");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	
	@Test(priority = 3, testName = "TC03_select Personnel having results from in Additional search criteria combo")
	public void selectPersonnelhavingresultsfromInAdditionalsearchCriteria() {
		try {
			i=obj.selectPersonnelhavingresultsfrom();

			if (i==1) {

				test.pass("InstallationGroup combo and installation combo is present");
			}
			else {
				test.fail("InstallationGroup combo and installation combo is not present");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 4, testName = "TC04_select Additional search criteria with Personnel having results from Result is dispalyed")
	public void navigateToSearchPersonnelHavingResultsForm() {
		try {
			i=obj.navigateToSearchPersonnelhavingresultsfromresult();

			if (i==1) {

				test.pass("Select Personnel having results from Result is displayed sucessfully");
			}
			else {
				test.fail("Select Personnel having results from Result is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}

    
	@Test(priority = 5, testName = "TC05_Click On No Additional search criteria in Additional serach criteria combo")
	public void ClickOnNoadditionalsearchcriteria() {
		try {
			i=obj.selectNoAdditionalCriteriaInadditionalCriteriaSearch();

			if (i==1) {

				test.pass("Installation group combo and installation combo is not present");
			}
			else {
				test.fail("Installation group combo and installation combo present");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}

   
	@Test(priority = 6, testName = "TC06_Navigate To Search in Additional serach criteria with No Additional Search Criteria")
	public void navigateToSearchInNoAdditionalSearchCriteriat() {
		try {
			i=obj.navigateToSearchInNoAdditionalSearchCriteria();

			if (i==1) {
				test.pass("Result table is displayed succsesfully");
				
			}
			else {
				
				test.fail("result table is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 7, testName = "TC07_Select Promotion Query in Additional serach criteria Combo")
	public void selectPromotionQueryInAdditionalSearchCriteria() {
		try {
			i=obj.selectSearchPromotionQueryInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Requirements for Rank combo and Requirements for installation type combo is displayed");
				
			}
			else {
				
				test.fail("Requirements for Rank combo and Requirements for installation type combo is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 8, testName = "TC08_Navigate To Search With Promotion Query in Additional serach criteria Combo")
	public void navigateToSearchWithPromotionQueryInAdditionalSearchCriteria() {
		try {
			i=obj.navigateToSearchPromotionQueryInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Result Table is Displayed successful");
				
			}
			else {
				
				test.fail("Result Table not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 9, testName = "TC09_Select perfomance evaluation in Additional serach criteria Combo")
	public void selectperfomanceEvaluationInAdditionalSearchCriteria() {
		try {
			i=obj.selectperfomanceEvaluationInAdditionalSearchCriteriaCombo1stcheckbox();

			if (i==1) {
				test.pass("Two checkbox are displayed");
				
			}
			else {
				
				test.fail("Checkbox are not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 10, testName = "TC10_Select perfomance evaluation in Additional serach criteria Combo")
	public void navigateToSearchwithperfomanceEvaluationInAdditionalSearchCriteria() {
		try {
			i=obj.navigateToSearchWithperfomanceEvaluationInAdditionalSearchCriteriaCombo1stcheckbox();

			if (i==1) {
				test.pass("result table is displayed after clicking Show only personnel with performance evaluations that I have not given a remark to checkbox");
				
			}
			else {
				
				test.fail("result table is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	
	@Test(priority = 11, testName = "TC11_Select perfomance evaluation in Additional serach criteria Combo with 2nd checkbox")
	public void selectperfomanceEvaluationInAdditionalSearchCriteriawithcheckbox2() {
		try {
			i=obj.selectperfomanceEvaluationInAdditionalSearchCriteriaCombo2ndcheckbox();

			if (i==1) {
				test.pass("Show personnel with performance evaluations made in the period checkbox is clickable");
				
			}
			else {
				
				test.fail("Show personnel with performance evaluations made in the period checkbox is not clickable");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 12, testName = "TC12_Navigate to search perfomance evaluation in Additional serach criteria Combo with 2nd checkbox")
	public void navigateTosearchperfomanceEvaluationInAdditionalSearchCriteriawithcheckbox2() {
		try {
			i=obj.navigateToSearchWithperfomanceEvaluationInAdditionalSearchCriteriaCombo2ndcheckbox();

			if (i==1) {
				test.pass("No records found after clicking Show personnel with performance evaluations made in the period checkbox");
				
			}
			else {
				
				test.fail("Result table is displayed after clicking Show personnel with performance evaluations made in the period checkbox");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	
	@Test(priority = 13, testName = "TC13_Select personnel added between in Additional serach criteria Combo and in date rage select lastmonth")
	public void selectpersonneladdedbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.selectpersonelladdedbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Date Range combo is displayed");
				
			}
			else {
				
				test.fail("Date Range combo is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 14, testName = "TC14_Navigate To search personnel added between in Additional serach criteria Combo and in date rage select lastmonth")
	public void navigateToSearchpersonneladdedbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.navigateTosearchpersonelladdedbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Result table is displyed");
				
			}
			else {
				
				test.fail("Result Table  is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	
	@Test(priority = 15, testName = "TC15_Select personnel modified between in Additional serach criteria Combo and in date rage select lastmonth")
	public void selectpersonnelmodifiedbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.selectpersonellmodifiedbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Date Range combo is displayed");
				
			}
			else {
				
				test.fail("Date Range combo is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 16, testName = "TC16_Navigate To search personnel modified between in Additional serach criteria Combo and in date rage select lastmonth")
	public void navigateToSearchpersonnelmodifiedbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.navigateTosearchpersonellmodifiedbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Result table is displyed");
				
			}
			else {
				
				test.fail("Result Table  is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	
	@Test(priority = 17, testName = "TC17_Select Personnel with no results between in Additional serach criteria Combo and in date rage select lastmonth")
	public void selectPersonnelwithnoresultsbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.selectPersonnelwithnoresultsbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Date Range combo is displayed");
				
			}
			else {
				
				test.fail("Date Range combo is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	@Test(priority = 18, testName = "TC18_Navigate To search Personnel with no results between in Additional serach criteria Combo and in date rage select lastmonth")
	public void navigateToSearchPersonnelwithnoresultsbetweenInAdditionalSearchCriteria() {
		try {
			i=obj.navigateTosearchPersonnelwithnoresultsbetweenInAdditionalSearchCriteriaCombo();

			if (i==1) {
				test.pass("Result table is displyed");
				
			}
			else {
				
				test.fail("Result Table  is not displayed");
			}
			test.addScreenCaptureFromPath(util.getScreenShot(driver, testMethodName));
		} catch (Exception e) {
			test.fail(e);
		}
	}
	/*
	@AfterTest
	public void closeAll() {
		driver.quit();
	}
	*/
	@AfterSuite 
	public void tearDown() throws IOException { 
		extent.flush();
		Desktop.getDesktop().browse(new File("SP1_OLX_T453_OLP2L - Search for personnel - Advanced search - Additional search criteria selection/deselection.html").toURI()); }


}
