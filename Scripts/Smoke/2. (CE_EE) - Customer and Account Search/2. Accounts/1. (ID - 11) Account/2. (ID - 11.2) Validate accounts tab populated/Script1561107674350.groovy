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

//Search for - Account number
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Accounts option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

'Wait for Account Type drop down to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)
WebUI.delay(2) //TODO: Need to look for wait conditon

'Click on accounts type drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Banking option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Banking'))

'Wait for Account number input field to be visible'
WebUI.delay(3)
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in account number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

'Wait for Account title to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

'Verify Account title contains correct account number'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), accData.get(Fields.ACC_NUMBER))

'Move to Overview tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Overview'))

'Click on Overview tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Overview'))

'Wait for Overview tab to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Holds Section/section_Body'), GlobalVariable.TIMEOUT)

'Move to Details tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait Details tab to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

'Move to Transaction tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Transactions'))

'Click on Transaction tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Transactions'))

'Wait for Transactions tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Tab/Transactions Section/section_Body'), GlobalVariable.TIMEOUT)

'Move to Interests tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Interest'))

'Click on Interest tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Interest'))

'Wait for Interest tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Interest Tab/Interest Posting and Withholding/section_Body'), GlobalVariable.TIMEOUT)

'Move to Holds tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Click on Holds tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Holds Tab/Holds Section/section_Body'), GlobalVariable.TIMEOUT)

'Move to Orders tab'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Click on Orders tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Wait for Orders tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Orders Tab/Orders Section/section_Body'), GlobalVariable.TIMEOUT)

if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	'Move to Notes tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))
	
	'Click on Notes tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))
	
	'Wait for Notes tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/section_Body'), GlobalVariable.TIMEOUT)

	'Move to Documents tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Documents'))

	'Click on Documents tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Documents'))
	
	'Wait for Documents tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)

	'Move to Cases tab'
	CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Cases'))

	'Click on Cases tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Cases'))
	
	'Wait for Cases tab to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Cases Tab/Cases Section/tab_OpenCases'), GlobalVariable.TIMEOUT)
}