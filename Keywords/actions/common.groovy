package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import internal.GlobalVariable
import static constants.common.*

public class common {

	//Open browser if not already opened
	private void openBrowser() {
		try {
			DriverFactory.getWebDriver()
		}
		catch(Exception e) {
			WebUI.openBrowser('')
		}
	}

	@Keyword
	def login() {

		//Open browser if not already opened
		openBrowser()

		//Delete all cookies
		WebUI.deleteAllCookies()

		//'Navigate to login page url'
		WebUI.navigateToUrl(loginUrl)

		//Check if User is on Login page or not
		if(WebUI.getUrl().contains('Login.aspx')) {

			//Verify login page is loaded
			WebUI.verifyElementVisible(findTestObject('Login Page/lbl_Heading'))

			//Enter username
			WebUI.sendKeys(findTestObject('Login Page/input_UserName'), username)

			//Enter password
			WebUI.sendKeys(findTestObject('Login Page/input_Password'), password)

			//Click on Login button
			WebUI.click(findTestObject('Login Page/btn_Login'))
		}

		//Verify user is on dashboard page
		WebUI.verifyMatch(WebUI.getUrl(), dashboardUrl, false)
	}
}
