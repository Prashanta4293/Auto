package com.olp.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.olp.common.GenericFunctions;

public class SP1_OLX_T453_Story {
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
	WebElement showadvancesearch;
	
	@FindBy(xpath = "(//div[@class='sc-fnykZs kTqJUC'])[2]")
	WebElement advancesearchExpand;
	
	@FindBy(xpath = "//div[contains(@title,'Additional search criteria')]")
	WebElement additionalsearchcriteria;
	
	@FindBy(xpath = "//li[.='Personnel having results from']")
	WebElement personnelHavingResultsfrom;
	
	
	
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
	
	
	@FindBy(xpath = "//div[.='Search']")
	WebElement searchButton;
	
	


	
	public SP1_OLX_T453_Story(WebDriver driver)
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
		gf.highlightElement(showadvancesearch);
		gf.MouseHover(showadvancesearch);
     	gf.clickByJS(showadvancesearch, driver);
     	Thread.sleep(5000);
     	//gf.waitTillElementVisible(advancesearchExpand);
		
		//gf.highlightElement(advancesearchExpand);
		//gf.WindowScrollToTheElement(advancesearchExpand);
     	//gf.WindowScrollToTheElement(additionalsearchcriteria);
		gf.highlightElement(additionalsearchcriteria);
		value=gf.isDisplayed(additionalsearchcriteria);
		if(value) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	public int selectPersonnelhavingresultsfrom () throws InterruptedException  {
          gf.WindowScrollToTheElement(additionalsearchcriteria);
          gf.highlightElement(additionalsearchcriteria);
          gf.Click(additionalsearchcriteria);
          Thread.sleep(1000);
          gf.highlightElement(personnelHavingResultsfrom);
          gf.MouseHover(personnelHavingResultsfrom);
          gf.Click(personnelHavingResultsfrom);
          Thread.sleep(3000);
          gf.highlightElement(installationgroup);
          gf.Click(installationgroup);
          Thread.sleep(1000);
          gf.highlightElement(installationgroupbulkmanila);
          gf.Click(installationgroupbulkmanila);
          Thread.sleep(2000);
          gf.highlightElement(installation);
          gf.Click(installation);
          Thread.sleep(1000);
          gf.highlightElement(installationMVBunker);
          gf.Click(installationMVBunker);
         gf.highlightElement(advancesearchExpand);
         value=gf.isDisplayed(advancesearchExpand);
          
          if(value) {
        	  return 1;
          }
          else {
        	  return 0;
          }
		

	}
	public int navigateToSearchPersonnelhavingresultsfromresult () throws InterruptedException  {
		gf.WindowScrollToTheElement(searchButton);
		gf.highlightElement(searchButton);
		gf.Click(searchButton);
		Thread.sleep(2000);
		gf.WindowScrollToTheElement(resultTable);
		value=gf.isDisplayed(resultTable);
		gf.highlightElement(resultTable);
		if(value) {
			return 1;
		}
		else {
			return 0;
		}

	}

	
	
	
	
	
	
	
	public int selectNoAdditionalCriteriaInadditionalCriteriaSearch() throws InterruptedException {
		gf.WindowScrollToTheElement(additionalsearchcriteria);
		gf.highlightElement(additionalsearchcriteria);
		gf.Click(additionalsearchcriteria);
		gf.highlightElement(noAdditionalCriteria);
		gf.Click(noAdditionalCriteria);
		gf.WindowScrollToTheElement(searchButton);
		
		gf.highlightElement(advancesearchExpand);
		value=gf.isDisplayed(advancesearchExpand);

		if (value) return 1;
		else return 0;
	}
   
	public int navigateToSearchInNoAdditionalSearchCriteria() throws InterruptedException {
             gf.WindowScrollToTheElement(searchButton);
             gf.highlightElement(searchButton);
             gf.Click(searchButton);
             Thread.sleep(3000);
             gf.WindowScrollToTheElement(resultTable);
             Thread.sleep(3000);
             value=gf.isDisplayed(resultTable);
             gf.highlightElement(resultTable);
             if(value) {
            	 return 1;
             }
             else {
            	 return 0;
             }
		
	}
	
	public int selectSearchPromotionQueryInAdditionalSearchCriteriaCombo() throws InterruptedException {
		 gf.WindowScrollToTheElement(additionalsearchcriteria);
		 gf.highlightElement(additionalsearchcriteria);
		 gf.Click(additionalsearchcriteria);
		 Thread.sleep(1000);
		 gf.highlightElement(promotionQuery);
		 gf.Click(promotionQuery);
		 Thread.sleep(1000);
		 gf.highlightElement(requirementforRank);
		 gf.Click(requirementforRank);
		 Thread.sleep(1000);
		 gf.highlightElement(requirementforRankMA);
		 gf.Click(requirementforRankMA);
		 Thread.sleep(1000);
		 gf.highlightElement(requirementsforinstallationtype);
		 gf.clickByJS(requirementsforinstallationtype, driver);
		 gf.highlightElement(requirementsforinstallationtypeBC);
		 gf.Click(requirementsforinstallationtypeBC);
		 gf.highlightElement(advancesearchExpand);
		 value=gf.isDisplayed(advancesearchExpand);
		 if(value) {
			 return 1;
		 }
		 else {
			 return 0;
		 }
	}
		 public int navigateToSearchPromotionQueryInAdditionalSearchCriteriaCombo() throws InterruptedException {
			
			 gf.WindowScrollToTheElement(searchButton);
			 gf.highlightElement(rank);
			 gf.Click(rank);
			 Thread.sleep(1000);
			 gf.Click(rankAll);
			 Thread.sleep(1000);
			 gf.highlightElement(rankMA);
			 gf.clickByJS(rankMA, driver);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(resultTable);
			 value=gf.isDisplayed(resultTable);
			 gf.highlightElement(resultTable);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
	}
		 public int selectperfomanceEvaluationInAdditionalSearchCriteriaCombo1stcheckbox() throws InterruptedException {
			 gf.WindowScrollToTheElement(additionalsearchcriteria);
			 gf.highlightElement(additionalsearchcriteria);
			 gf.Click(additionalsearchcriteria);
			 Thread.sleep(1000);
			 gf.highlightElement(performanceEvaluations);
			 gf.Click(performanceEvaluations);
			 Thread.sleep(1000);
			 gf.highlightElement(performanceEvaluationscheckbox1);
			 gf.clickByJS(performanceEvaluationscheckbox1, driver);
			 Thread.sleep(1000);
			 
			 gf.highlightElement(advancesearchExpand);
			 value=gf.isDisplayed(advancesearchExpand);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
	
		 public int navigateToSearchWithperfomanceEvaluationInAdditionalSearchCriteriaCombo1stcheckbox() throws InterruptedException {
				
			 gf.WindowScrollToTheElement(searchButton);
			 Thread.sleep(2000);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(resultTable);
			 value=gf.isDisplayed(resultTable);
			 gf.highlightElement(resultTable);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
	}
	
		 public int selectperfomanceEvaluationInAdditionalSearchCriteriaCombo2ndcheckbox() throws InterruptedException {
			 gf.clickByJS(performanceEvaluationscheckbox1, driver);
			 gf.highlightElement(performanceEvaluationscheckbox2);
			 gf.clickByJS(performanceEvaluationscheckbox2, driver);
			 Thread.sleep(1000);
			 gf.highlightElement(advancesearchExpand);
			 value=gf.isDisplayed(advancesearchExpand);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
	
		 public int navigateToSearchWithperfomanceEvaluationInAdditionalSearchCriteriaCombo2ndcheckbox() throws InterruptedException {
				
			 gf.WindowScrollToTheElement(searchButton);
			 Thread.sleep(2000);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(norecordsfound);
			 value=gf.isDisplayed(norecordsfound);
			 gf.highlightElement(norecordsfound);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
	}
	
		 
		 public int selectpersonelladdedbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(additionalsearchcriteria);
			 gf.highlightElement(additionalsearchcriteria);
			 gf.Click(additionalsearchcriteria);
			 Thread.sleep(1000);
			 gf.highlightElement(personnelAddedBetween);
			 gf.Click(personnelAddedBetween);
			 Thread.sleep(1000);
			 gf.highlightElement(dateRange);
			 gf.Click(dateRange);
			 Thread.sleep(1000);
			 gf.highlightElement(lastmonth);
			 gf.Click(lastmonth);
			 Thread.sleep(2000);
			 gf.highlightElement(advancesearchExpand);
			 value=gf.isDisplayed(advancesearchExpand);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
		 public int navigateTosearchpersonelladdedbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(searchButton);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(resultTable);
			 gf.highlightElement(resultTable);
			 value=gf.isDisplayed(resultTable);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
		 
		 public int selectpersonellmodifiedbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(additionalsearchcriteria);
			 gf.highlightElement(additionalsearchcriteria);
			 gf.Click(additionalsearchcriteria);
			 Thread.sleep(1000);
			 gf.WindowScrollToTheElement(personnelmodifiedbetween);
			 gf.highlightElement(personnelmodifiedbetween);
			 gf.Click(personnelmodifiedbetween);
			 Thread.sleep(1000);
			 gf.highlightElement(dateRange);
			 gf.Click(dateRange);
			 Thread.sleep(2000);
			 gf.highlightElement(lastmonth);
			 gf.Click(lastmonth);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(searchButton);
			 gf.highlightElement(advancesearchExpand);
			 value=gf.isDisplayed(advancesearchExpand);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
		 public int navigateTosearchpersonellmodifiedbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(searchButton);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(resultTable);
			 gf.highlightElement(resultTable);
			 value=gf.isDisplayed(resultTable);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
		 
		 public int selectPersonnelwithnoresultsbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(additionalsearchcriteria);
			 gf.highlightElement(additionalsearchcriteria);
			 gf.Click(additionalsearchcriteria);
			 Thread.sleep(1000);
			 gf.WindowScrollToTheElement(personnelwithnoresultbetween);
			 gf.highlightElement(personnelwithnoresultbetween);
			 gf.Click(personnelwithnoresultbetween);
			 Thread.sleep(1000);
			 gf.highlightElement(dateRange);
			 gf.Click(dateRange);
			 Thread.sleep(2000);
			 gf.highlightElement(lastmonth);
			 gf.Click(lastmonth);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(searchButton);
			 gf.highlightElement(advancesearchExpand);
			 value=gf.isDisplayed(advancesearchExpand);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
		 public int navigateTosearchPersonnelwithnoresultsbetweenInAdditionalSearchCriteriaCombo() throws InterruptedException {
			 gf.WindowScrollToTheElement(searchButton);
			 gf.Click(searchButton);
			 Thread.sleep(2000);
			 gf.WindowScrollToTheElement(resultTable);
			 gf.highlightElement(resultTable);
			 value=gf.isDisplayed(resultTable);
			 if(value) {
				 return 1;
			 }
			 else {
				 return 0;
			 }
		}
}
