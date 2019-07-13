package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.context.TestCaseContext
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

import constants.ColumnPos
import enums.ErrorType
import enums.Fields
import enums.RegexOperator
import enums.WebTable
import internal.GlobalVariable
import pages.AccountPage
import pages.CustomerPage
import pages.SearchPage
import pages.TaskDrawer
import utils.RegexUtil

import static constants.common.*

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

public class Common {

	//Open browser if not already opened
	private void openBrowser() {
		try {
			DriverFactory.getWebDriver()
		}
		catch(Exception e) {
			WebUI.openBrowser(null)
		}
	}

	@Keyword
	def login() {

		TestObject usernameField 	= findTestObject('Login Page/input_UserName')
		TestObject passwordField	= findTestObject('Login Page/input_Password')
		TestObject loginButton 		= findTestObject('Login Page/btn_Login')
		TestObject loginPageHeader 	= findTestObject('Login Page/lbl_Heading')
		int loginAttempt = 1
		boolean isLoginSuccess = false

		while (loginAttempt <= 3) {
			openBrowser()
			WebUI.deleteAllCookies()
			WebUI.navigateToUrl(loginUrl)
			String currentUrl = WebUI.getUrl()

			//Check if User is on Login page or not
			if(currentUrl.contains('Login.aspx') || currentUrl.contains('NoPermission.aspx')) {

				WebUI.delay(2)
				WebUI.verifyElementVisible(loginPageHeader)
				WebUI.setText(usernameField, username)
				WebUI.setText(passwordField, password)
				WebUI.click(loginButton)
				WebUI.verifyMatch(WebUI.getUrl(), dashboardUrl, false)
				isLoginSuccess = true
				break
			}
			else if(currentUrl.equalsIgnoreCase(dashboardUrl)){
				isLoginSuccess = true
				break
			}
			else {
				println "Unable to perform login step. Current URL is "+currentUrl
				loginAttempt++
				WebUI.closeBrowser()
				continue
			}
		}
		if(!isLoginSuccess) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to login into portal exception occurred')
		}
	}

	@Keyword
	def moveToElement(TestObject to) {

		WebUI.waitForElementPresent(to, GlobalVariable.TIMEOUT)
		new actions.JavaScript().scrollToElement(to)
		WebUI.delay(1)

		WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
		Actions asDriver = new Actions(DriverFactory.getWebDriver())
		asDriver.moveToElement(e).build().perform()
		WebUI.delay(1)
	}

	@Keyword
	def moveToElement(WebElement e) {

		new actions.JavaScript().scrollToElement(e)

		Actions asDriver = new Actions(DriverFactory.getWebDriver())
		asDriver.moveToElement(e).build().perform()
		WebUI.delay(1)
	}

	@Keyword
	def verifyElementTextContains(TestObject to, String expectedText) {

		WebUI.verifyMatch(WebUI.getText(to).trim(), RegexUtil.formRegexString(expectedText, RegexOperator.CONTAINS), true)
	}

	@Keyword
	def verifyMatch(TestObject to, String expText, RegexOperator operator) {
		String actualText = WebUI.getText(to).trim()
		println "Actual Text = "+actualText
		WebUI.verifyMatch(actualText, RegexUtil.formRegexString(expText, operator), true)
	}

	@Keyword
	def verifyUrlContains(String expectedText) {

		WebUI.verifyMatch(WebUI.getUrl().trim(), RegexUtil.formRegexString(expectedText, RegexOperator.CONTAINS), true)
	}

	@Keyword
	def shouldFailTest(Map<Fields, String> map) {

		boolean shouldFail = false
		if(map.get(Fields.IS_CREATED).equalsIgnoreCase('false')) {
			shouldFail = true
		}

		if(shouldFail) {
			KeywordUtil.markFailedAndStop('Cannot execute test cases as required data is not created.')
		}
	}

	//	private boolean isValidData(Map<Fields, String> data, Fields field) {
	//		if(data.containsKey(field) && StringUtils.isNotBlank(data.get(field))) {
	//			return true
	//		}
	//		else {
	//			return false
	//		}
	//	}

	@Keyword
	def customerFormFill(Map<Fields, String> custData) {
		CustomerPage.fillCustomerDetails(custData)
	}

	@Keyword
	def accountFormFill(Map<Fields, String> accData) {
		AccountPage.fillAccountDetails(accData)
	}

	@Keyword
	def searchCustomer(Map<Fields, String> custData) {
		SearchPage.searchCustomer(custData)
	}

	@Keyword
	def searchCustomerAndOpen(Map<Fields, String> custData, int rowNo = 1) {

		SearchPage.searchCustomer(custData)
		SearchPage.selectCustomer(custData, rowNo)
	}

	@Keyword
	def searchAccount(Map<Fields, String> accData) {
		SearchPage.searchAccount(accData)
	}

	@Keyword
	def addressFormFill(Map<Fields, String> addressData) {
		CustomerPage.fillAddressDetails(addressData)
	}

	@Keyword
	def verifyAddressDetailsInTable(Map<Fields, String> addressData, int rowNo) {
		CustomerPage.verifyAddressTable(addressData, rowNo)
	}

	@Keyword
	def phoneFormFill(Map<Fields, String> phoneData) {
		CustomerPage.fillPhoneDetails(phoneData)
	}

	@Keyword
	def verifyPhoneDetailsInTable(Map<Fields, String> phoneData, int rowNo) {
		CustomerPage.verifyPhoneTable(phoneData, rowNo)
	}

	@Keyword
	def emailFormFill(Map<Fields, String> emailData) {
		CustomerPage.fillEmailDetails(emailData)
	}

	@Keyword
	def verifyEmailDetailsInTable(Map<Fields, String> emailData, int rowNo) {
		CustomerPage.verifyEmailTable(emailData, rowNo)
	}

	@Keyword
	def documentFormFill(Map<Fields, String> documentData) {
		CustomerPage.fillDocumentDetails(documentData)
	}

	@Keyword
	def verifyDocumentDetailsInTable(Map<Fields, String> documentData, Map<Fields, String> customerData, int rowNo) {
		CustomerPage.verifyDocumentTable(documentData, customerData, rowNo)
	}

	@Keyword
	def selectTaskFromTaskList(String taskName) {
		TaskDrawer.selectTask(taskName)
	}

	@Keyword
	def transactionFormFill(Map<Fields, String> txnData) {
		AccountPage.fillTransactionDetails(txnData)
	}

	@Keyword
	def reviewTransactionDetails(Map<Fields, String> txnData) {
		AccountPage.reviewTransactionDetails(txnData)
	}

	//	@Keyword
	//	def verifyFloatingMessage(String message, ErrorType errorType) {
	//
	//		'Wait for Message Wrapper to load'
	//		new actions.WaitFor().elementVisible(findTestObject('Floating Message/lbl_MessageWrapper'), GlobalVariable.TIMEOUT)
	//
	//		'Wait for 2 seconds'
	//		WebUI.delay(2)
	//
	//		'Wait for Message to load'
	//		new actions.WaitFor().elementVisible(findTestObject('Floating Message/lbl_SuccessMessage'), GlobalVariable.TIMEOUT)
	//
	//		'Close Message'
	//		WebUI.click(findTestObject('Floating Message/btn_Close'))
	//	}

	@Keyword
	def verifyBalanceSummary(Map<Fields, String> txnData) {
		AccountPage.verifyBalanceSummary(txnData)
	}

	@Keyword
	def verifyTransactionDetailsInTable(Map<Fields, String> txnData, TestObject table, int rowNo) {
		AccountPage.verifyTransactionTable(txnData, table, rowNo)
	}

	@Keyword
	def openTransactionInformationSection(TestObject table, int rowNo) {
		AccountPage.expandTransactionInformation(table, rowNo)
	}

	@Keyword
	def verifyTransactionInformationInAccordion(Map<Fields, String> accData, Map<Fields, String> txnData) {
		AccountPage.verifyTransactionInformation(accData, txnData)
	}
	
	@Keyword
	def accountDetailDocFormFill(Map<Fields, String> accDetailDocument) {
		AccountPage.fillAccountDetailDoc(accDetailDocument)
	}
	
	@Keyword
	def verifyAccountDetailDocInTable(Map<Fields, String> accDetailDoc, int rowNo) {
		AccountPage.verifyAccountDetailDoc(accDetailDoc, rowNo)
	}
	
	
	
}