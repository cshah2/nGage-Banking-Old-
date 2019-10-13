package com.common.keywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.concurrent.TimeUnit

import org.openqa.selenium.By
import org.openqa.selenium.NotFoundException
import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.WebDriverWait

import com.common.util.WaitUtil
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class Wait {

	WebDriverWait wait;

	/**
	 * Method to wait until element gets visible
	 * @param obj
	 * @param timeout
	 * @return
	 */
	@Keyword
	def elementVisible(TestObject obj, int timeout) {

		KeywordUtil.logInfo('KEYWORD START : Wait || elementVisible')

		wait = WaitUtil.getWebDriverWait(timeout)

		try {
			WebElement element = WebUiCommonHelper.findWebElement(obj, timeout)
			wait.until(ExpectedConditions.visibilityOf(element))
			KeywordUtil.markPassed('KEYWORD PASSED : Wait | forElementVisible')
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('KEYWORD FAILED : Wait | forElementVisible \n'+e.toString())
		}

		KeywordUtil.logInfo('KEYWORD START : Wait || elementVisible')
	}

	/**
	 * Method to wait until element gets present in DOM
	 * @param obj
	 * @param timeout
	 * @return
	 */
	@Keyword
	def elementPresent(TestObject obj, int timeout) {

		KeywordUtil.logInfo('KEYWORD START : Wait || elementPresent')

		wait = new Wait(timeout)
		try {
			By locator = WebUiCommonHelper.buildLocator(obj)
			wait.until(ExpectedConditions.presenceOfElementLocated(locator))
			KeywordUtil.markPassed('KEYWORD PASSED : Wait | forElementPresent')
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('KEYWORD FAILED : Wait | forElementPresent \n'+e.toString())
		}

		KeywordUtil.logInfo('KEYWORD END : Wait || elementPresent')
	}

	/**
	 * Method to wait until element gets removed from DOM
	 * @param obj
	 * @param timeout
	 * @return
	 */
	@Keyword
	def elementNotPresent(TestObject obj, int timeout) {

		KeywordUtil.logInfo('KEYWORD START : Wait || elementNotPresent')

		wait = new Wait(timeout)
		try {
			By locator = WebUiCommonHelper.buildLocator(obj)
			wait.until(ExpectedConditions.not(ExpectedConditions.presenceOfElementLocated(locator)))
			KeywordUtil.markPassed('KEYWORD PASSED : Wait | forElementNotPresent')
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('KEYWORD FAILED : Wait | forElementNotPresent \n'+e.toString())
		}

		KeywordUtil.logInfo('KEYWORD END : Wait || elementNotPresent')
	}

	/**
	 * Method to wait until element gets hidden
	 * @param obj
	 * @param timeout
	 * @return
	 */
	@Keyword
	def elementNotVisible(TestObject obj, int timeout) {

		KeywordUtil.logInfo('KEYWORD START : Wait || elementNotVisible')

		wait = new Wait(timeout)
		try {
			WebElement element = WebUiCommonHelper.findWebElement(obj, timeout)
			wait.until(ExpectedConditions.invisibilityOf(element))
			KeywordUtil.markPassed('KEYWORD PASSED : Wait | forElementNotPresent')
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('KEYWORD FAILED : Wait | forElementNotPresent \n'+e.toString())
		}

		KeywordUtil.logInfo('KEYWORD END : Wait || elementNotVisible')
	}
}
