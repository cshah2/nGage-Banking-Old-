import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import static constants.common.*;

WebUI.openBrowser(null)

'Navigate to login page url'
WebUI.navigateToUrl(loginUrl)

'Verify login page is loaded'
WebUI.verifyElementVisible(findTestObject('Login Page/lbl_Heading'))

'Enter username'
WebUI.setText(findTestObject('Login Page/input_UserName'), username)

'Enter password'
WebUI.setText(findTestObject('Login Page/input_Password'), password)

'Click on Login button'
WebUI.click(findTestObject('Login Page/btn_Login'))

'Verify dashboard page is loaded - URL matches'
//WebUI.verifyMatch(WebUI.getUrl(), dashboardUrl, false)
CustomKeywords.'com.common.keywords.Verify.verifyStringMatches'(WebUI.getUrl(), dashboardUrl+'1', RegexOperator.EQUALS)

'Verify dashboard page is loaed - Correct username in header section'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Header Section/lbl_UserInfo_Name'))