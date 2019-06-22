package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.Wait
import org.openqa.selenium.support.ui.WebDriverWait

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.SelectorMethod
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class WaitFor {

	private static WebDriver jsWaitDriver;
	private static WebDriverWait jsWait;
	private static JavascriptExecutor jsExec;


	private void setDriver () {
		jsWaitDriver = DriverFactory.getWebDriver();
		jsWait = new WebDriverWait(jsWaitDriver, GlobalVariable.TIMEOUT);
		jsExec = (JavascriptExecutor) jsWaitDriver;
	}

	private By getLocator(TestObject to) {

		String cssLocator = to.selectorCollection.get(SelectorMethod.CSS)
		String xpathLocator = to.selectorCollection.get(SelectorMethod.XPATH)
		if(StringUtils.isNotBlank(cssLocator)) {
			return By.cssSelector(cssLocator)
		}
		else if(StringUtils.isNotBlank(xpathLocator)) {
			return By.xpath(xpathLocator)
		}
		else {
			return null
		}
	}

	@Keyword
	def elementVisible(TestObject to, int timeout) {

		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)

		By locator = getLocator(to)
		try {
			if(locator != null)
				jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
			else {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Locator is neither XPATH or CSS')
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}
	
	@Keyword
	def elementVisible(By locator, int timeout) {

		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)

		try {
			if(locator != null)
				jsWait.until(ExpectedConditions.visibilityOfElementLocated(locator))
			else {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Locator is neither XPATH or CSS')
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}


	@Keyword
	def elementNotPresent(TestObject to, int timeout) {

		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)

		By locator = getLocator(to)
		try {
			if(locator != null)
				jsWait.until(ExpectedConditions.invisibilityOfElementLocated(locator))
			else {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Locator is neither XPATH or CSS')
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}

	@Keyword
	def textNotEmpty(TestObject to, int timeout) {

		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)


		By locator = getLocator(to)
		try {
			if(locator != null)
				jsWait.until(new ExpectedCondition<Boolean>() {
							public Boolean apply(WebDriver d){
								d.findElement(locator).getAttribute("value").length() != 0
							}
						})
			else {
				WebUI.takeScreenshot()
				KeywordUtil.markFailedAndStop('Locator is neither XPATH or CSS')
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}


	@Keyword
	def urlContains(String expUrlText, int timour) {
		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)

		try {
			jsWait.until(ExpectedConditions.urlContains(expUrlText))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}

	@Keyword
	def titleContains(String expTitleText, int timour) {
		setDriver()

		jsWait.pollingEvery(100, TimeUnit.MILLISECONDS)
		jsWait.ignoring(StaleElementReferenceException.class)

		try {
			jsWait.until(ExpectedConditions.titleContains(expTitleText))
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Exception occured while waiting for element'+e.toString())
		}
	}


	@Keyword
	def ajaxComplete() {

		setDriver();
		jsExec.executeScript("var callback = arguments[arguments.length - 1];"
				+ "var xhr = new XMLHttpRequest();" + "xhr.open('GET', '/Ajax_call', true);"
				+ "xhr.onreadystatechange = function() {" + "  if (xhr.readyState == 4) {"
				+ "    callback(xhr.responseText);" + "  }" + "};" + "xhr.send();");
	}
}
