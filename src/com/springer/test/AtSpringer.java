package com.springer.test;

// JUnit Assert framework can be used for verification

import org.openqa.selenium.By.ByName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.seleniumemulation.WaitForPageToLoad;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.asserts.Assertion;

import com.thoughtworks.twist.core.execution.TwistScenarioDataStore;

public class AtSpringer {

	private WebDriver browser;

	@Autowired
	private TwistScenarioDataStore scenarioStore;

	public AtSpringer(WebDriver browser) {
		this.browser = browser;
	}

	public void openURL(String URL) throws Exception {
		browser.get(URL);
	}

	public void enterSearchString(String searchString) throws Exception {
		 WebElement element = browser.findElement(By.name("searchTerm"));
		 element.sendKeys(searchString);
	}

	public void clickSearchButton() throws Exception {
		browser.findElement(By.className("search-submit")).click();
		
	}

	public void verifySearchResultIs(String expectedResult) throws Exception {
		Boolean isAsExpected = browser.findElement(By.className("facet-count")).getText().equals(expectedResult);
		if(isAsExpected){
			System.out.println("Search result is as expected!");
		}
		else
		{
			System.out.println("Search result is NOT as expected!");
			
		}
	}

}

