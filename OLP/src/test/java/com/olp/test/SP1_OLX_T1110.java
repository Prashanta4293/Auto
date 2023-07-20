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
import com.olp.pages.SP1_OLX_T1110_Story;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SP1_OLX_T1110 {
	public WebDriver driver;
	ChromeOptions options;
	GenericFunctions gf;
	SP1_OLX_T1110_Story obj;
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
	String configpath = ".\\src\\main\\java\\com\\olp\\config\\config.properties";
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	WebDriverWait wait;
	String testMethodName;
	Boolean value;
	String descriptiveTestName;
	String title;
	String title1;
	int i, j, k;
	String excelPath;


	@BeforeSuite
	public void initialConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("OLP_OLX_T1110_OLP2L - Search for personnel - Advanced search - Additional search criteria selection/deselection.html");
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
		WebDriverManager.chromedriver().setup();
		ChromeOptions dc = new ChromeOptions();
		dc.addArguments("--remote-allow-origins=*");
		dc.setAcceptInsecureCerts(true);
		driver = new ChromeDriver(dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));


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
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		gf = new GenericFunctions(driver);
		obj = new SP1_OLX_T1110_Story(driver);
		util = new Utility(driver);
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
			test.info("Test to check login functionality");
			gf.getUrl(newVesselUrl);
			gf.waitForPageLoad(3000);
			title=gf.getTitle();
			System.out.println(title);
			value=gf.Assert(title, "Login - Ocean Learning Platform");
			if(value) {
				test.pass("Navigated to URL successfully");
				gf.LoginToVessel(userNameVessel,password);
				String currentURL=driver.getCurrentUrl();
				gf.waitForPageLoad(3000);
				if (currentURL.contains("personnel"))  {
					test.pass("Search for Personnel list is displayed");
				}
				else {
					test.fail("Login Failed");
				}
			}
			else {
				test.fail("Navigation to URL failed");
			}
		}catch(Exception e) {
			test.fail(e);
		}
	}

	@Test(priority = 2, testName = "TC02_Click on Show Advance Search",enabled=true)
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
	
	@Test(priority = 3, testName = "TC03_set pending proficiencies from 0 and ValueA",enabled=true)
	public void setPendingProficienciesFrom0AndValueA() {
		try {
			i=obj.setPendingProficienciesFrom0AndValueA();

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
	
	/*
	@AfterTest
	public void closeAll() {
		driver.quit();
	}
	*/
	@AfterSuite 
	public void tearDown() throws IOException { 
		extent.flush();
		Desktop.getDesktop().browse(new File("OLP_OLX_T1110_OLP2L - Search for personnel - Advanced search - Additional search criteria selection/deselection.html").toURI()); }


}
