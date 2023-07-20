package com.olp.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.olp.common.GenericFunctions;

public class SP1_OLX_T1110_Story {
	
	public WebDriver driver;
	Boolean value;
	public GenericFunctions gf;
	String text;
	int c;

	@FindBy(xpath = "//p[.='Personnel']")
	WebElement personnel;
	
	@FindBy(xpath = "//p[.='Search for personnel']")
	WebElement searchForPersonnel;
	
	@FindBy(xpath = "//div[.='Show advanced search']")
	WebElement showAdvanceSearch;
	
	@FindBy(xpath = "//div[.='Hide advanced search']")
	WebElement hideAdvanceSearch;
	
	@FindBy(xpath = "(//div[@class='sc-fnykZs kTqJUC'])[2]")
	WebElement advancesearchExpand;
	
	@FindBy(xpath = "//input[@name=\"pendingProficienciesFrom\"]")
	WebElement fromTextField;
	
	@FindBy(xpath = "//input[@name=\"pendingProficienciesTo\"]")
	WebElement toTextField;
	
	@FindBy(xpath = "//div[@title=\"Rank: All\"]")
	WebElement rankCombo;
	
	@FindBy(xpath = "//div[.='MAS EX']/.//input[@type=\"checkbox\"]")
	WebElement Mas_ExComboOption;
	
	@FindBy(xpath = "//div[.='MAS']/.//input[@type=\"checkbox\"]")
	WebElement MasComboOption;
	
	@FindBy(xpath = "//button[.='Search']")
	WebElement searchButton;
	
	@FindBy(xpath="//div[.='ashish20_40']/..")
	WebElement traineeX;
	
	
	
	
	
	
	@FindBy(xpath = "//li[.='Bulk Manila']")
	WebElement installationgroupbulkmanila;
	
	@FindBy(xpath = "//div[@title='Installation group: All']")
	WebElement installationgroup;
	
	@FindBy(xpath = "(//div[@title='Installation'])[2]")
	WebElement installation;
	
	
	@FindBy(xpath = "//li[.='M/V Bunker']")
	WebElement installationMVBunker;
	
	@FindBy(xpath = "//div[@class='sc-PJClH kWnocW']")
	WebElement resultTable;
	
	@FindBy(xpath = "//li[.='No additional criteria']")
	WebElement noAdditionalCriteria;
	
	@FindBy(xpath = "//li[.='Promotion query']")
	WebElement promotionQuery;
	
	@FindBy(xpath = "//div[@title='Requirements for rank']")
	WebElement requirementforRank;
	
	@FindBy(xpath = "//div[@class='sc-cLFqLo fnhjWd']")
	WebElement requirementsforinstallationtype;
	
	@FindBy(xpath = "(//div[.='Master Assessor'])[2]")
	WebElement requirementforRankMA;
	
	@FindBy(xpath = "//li[.='Bulk CMS']")
	WebElement requirementsforinstallationtypeBC;
	
	@FindBy(xpath = "(//div[contains(@title,'Rank')])[1]")
	WebElement rank;
	
	@FindBy(xpath = "((//div[.='Rank Short'])[1]/../..//div[.='All'])[1]/..//input[@type='checkbox']")
	WebElement rankAll;
	
	@FindBy(xpath = "(//div[.='Master Assessor'])[1]/..//input[@type='checkbox']")
	WebElement rankMA;
	
	@FindBy(xpath = "//li[.='Perfomance evaluations']")
	WebElement performanceEvaluations;
	
	@FindBy(xpath = "//span[.='Show personnel with performance evaluations made in the period']/..//input[@type='checkbox']")
	WebElement performanceEvaluationscheckbox2;
	
	@FindBy(xpath = "//span[.='Show only personnel with performance evaluations that I have not given a remark to']/..//input[@type='checkbox']")
	WebElement performanceEvaluationscheckbox1;
	
	@FindBy(xpath = "(//div[.='No records found'])[1]")
	WebElement norecordsfound;
	
	@FindBy(xpath = "//li[.='Personnel added between']")
	WebElement personnelAddedBetween;
	
	@FindBy(xpath = "//div[@title='Date range']")
	WebElement dateRange;
	
	@FindBy(xpath = "//div[@class='sc-gHLcSH fjHmBY']//button[@type='button']//div[.='Last month']")
	WebElement lastmonth;
	
	@FindBy(xpath = "//li[.='Personnel modified between']")
	WebElement personnelmodifiedbetween;
	
	@FindBy(xpath = "//li[.='Personnel with no results between']")
	WebElement personnelwithnoresultbetween;
	
	
	
	
	



	

	
	



	
	public SP1_OLX_T1110_Story(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		gf=new GenericFunctions(driver);
	}

	public int navigateToShowAdvanceSearch() throws InterruptedException  {
		gf.MouseHover(personnel);
		gf.Wait(3000);
		gf.highlightElement(personnel);
		gf.Click(personnel);
		gf.highlightElement(searchForPersonnel);
		gf.Click(searchForPersonnel);
		gf.Wait(3000);
		gf.highlightElement(showAdvanceSearch);
		gf.MouseHover(showAdvanceSearch);
     	gf.clickByJS(showAdvanceSearch, driver);
     	Thread.sleep(5000);
        gf.highlightElement(advancesearchExpand);
        gf.scrollUpPage();;
		value=gf.isDisplayed(hideAdvanceSearch);
		if(value) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	public int setPendingProficienciesFrom0AndValueA() throws InterruptedException, AWTException {
		gf.highlightElement(fromTextField);
		toTextField.click();
		Robot r= new Robot();
		for(int i=1;i<=3;i++) {
			gf.Wait(3000);
			r.keyPress(KeyEvent.VK_BACK_SPACE);
		}
		r.keyRelease(KeyEvent.VK_BACK_SPACE);
		gf.Wait(3000);
		toTextField.sendKeys("40");
		gf.highlightElement(toTextField);
		gf.highlightElement(rankCombo);
		rankCombo.click();
		gf.Wait(3000);
		Mas_ExComboOption.click();
		gf.Wait(3000);
		MasComboOption.click();
		searchButton.click();
		gf.Wait(3000);
		//gf.scrollDownPage(driver);
		gf.highlightElement(traineeX);
		gf.WindowScrollToTheElement(traineeX);

		return 1;
		
	}

}
