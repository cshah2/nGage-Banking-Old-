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

import constants.ColumnPos
import constants.Data
import constants.common
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
import utils.RegexUtil

Map<Fields, String> accData = Data.ACCOUNT_001
println "Accounts001 = "+accData.toMapString()

//Mark this test as failed if required customer is not created
CustomKeywords.'actions.common.shouldFailTest'(accData)

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search Account'
CustomKeywords.'actions.common.searchAccount'(accData)

'Move to Overview tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Overview'))

'Click on Overview tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Overview'))

'Wait for Overview tab to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Holds Section/section_Body'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

'Move to Details tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait Details tab to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

'Move to Transaction tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Transactions'))

'Click on Transaction tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Transactions'))

'Wait for Transactions tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Tab/Transactions Section/section_Body'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

'Move to Interests tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Interest'))

'Click on Interest tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Interest'))

'Wait for Interest tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Interest Tab/Interest Posting and Withholding/section_Body'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

'Move to Holds tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Click on Holds tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Holds Tab/Holds Section/section_Body'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

'Move to Orders tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Click on Orders tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Wait for Orders tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Orders Tab/Orders Section/section_Body'), GlobalVariable.TIMEOUT)

'Wait for a second'
WebUI.delay(1)

if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	'Move to Notes tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))
	
	'Click on Notes tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))
	
	'Wait for Notes tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/section_Body'), GlobalVariable.TIMEOUT)

	'Wait for a second'
	WebUI.delay(1)
	
	'Move to Documents tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Documents'))

	'Click on Documents tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Documents'))
	
	'Wait for Documents tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)

	'Wait for a second'
	WebUI.delay(1)
	
	'Move to Cases tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Cases'))

	'Click on Cases tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Cases'))
	
	'Wait for Cases tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Cases Tab/Cases Section/tab_OpenCases'), GlobalVariable.TIMEOUT)
	
	'Wait for a second'
	WebUI.delay(1)
}