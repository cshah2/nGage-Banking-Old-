package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.Keys
import org.openqa.selenium.WebElement

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
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable

public class JavaScript {

	@Keyword
	def setText(TestObject to, String text) {

		WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)
		WebUI.executeJavaScript('arguments[0].value = "'+text+'"', list)
	}

	@Keyword
	def click(TestObject to) {

		WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)
		WebUI.executeJavaScript('arguments[0].click()', list)
	}

	@Keyword
	def click(WebElement e) {

		List<WebElement> list = new ArrayList<WebElement>()
		list.add(e)
		WebUI.executeJavaScript('arguments[0].click()', list)
	}


	@Keyword
	def scrollToElement(TestObject to) {
		try {
			WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
			List<WebElement> list = new ArrayList<WebElement>()
			list.add(e)
			WebUI.executeJavaScript('arguments[0].scrollIntoViewIfNeeded()', list)
		}
		catch(Exception e1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to scroll to element')
		}
	}

	@Keyword
	def scrollToElement(WebElement e) {
		try {
			//WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
			List<WebElement> list = new ArrayList<WebElement>()
			list.add(e)
			WebUI.executeJavaScript('arguments[0].scrollIntoViewIfNeeded()', list)
		}
		catch(Exception e1) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to scroll to element')
		}
	}
}