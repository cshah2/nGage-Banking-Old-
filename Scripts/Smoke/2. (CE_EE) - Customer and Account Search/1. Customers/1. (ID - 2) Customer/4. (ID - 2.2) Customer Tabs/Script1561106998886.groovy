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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import constants.Data
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData1 = Data.ACCOUNT_001
println "Customer002 = "+custData.toMapString()
println "Account001 = "+accData1.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)
CustomKeywords.'actions.common.shouldFailTest'(accData1)

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.common.searchCustomerAndOpen'(custData)

//Verify Correct tabs are displayed in EE environment
'Verify accounts tab link is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Verify profile tab link is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Profile'))

'Verify contact details tab link is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))


if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	'Verify overview tab link is visible'
	WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Overview'))
	
	'Verify notes tab link is visible'
	WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Notes'))
	
	'Verify documents tab link is visible'
	WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))
	
	'Verify cases tab link is visible'
	WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Cases'))
}
else if('CE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	'Verify overview tab link is not present'
	WebUI.verifyElementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Overview'), GlobalVariable.TIMEOUT)
	
	'Verify notes tab link is not present'
	WebUI.verifyElementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Notes'), GlobalVariable.TIMEOUT)
	
	'Verify documents tab link is visible'
	WebUI.verifyElementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'), GlobalVariable.TIMEOUT)
	
	'Verify cases tab link is visible'
	WebUI.verifyElementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Cases'), GlobalVariable.TIMEOUT)
}
else {
	KeywordUtil.markFailedAndStop('Incorrect value provided in Global variable ENVIRONMENT')
}

//Click on Individual tabs
'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

'Verify accounts list table is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'))

'Click on Profile tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Profile'))

'Wait for element visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Profile Tab/Customer Details Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify first name value in Customer Details section'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Profile Tab/Customer Details Section/lbl_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

'Click on contact details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))

'Wait for Addresses section to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Address table is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'))

if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {

	'Click on Notes tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Notes'))
	
	'Wait for Notes section to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/section_Body'), GlobalVariable.TIMEOUT)
	
	'Click on documents tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))

	'Wait for Documents section to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)
	
	'Click on cases tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Cases'))

	'Wait for Cases section to load'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Cases Tab/Cases Section/section_Title'), GlobalVariable.TIMEOUT)
	
	'Click on Overview tab'
	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Overview'))

	'Wait for Customer Person Details section to load in overview tab'
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Overview Tab/Customer Person Detail Section/section_Body'), GlobalVariable.TIMEOUT)
}
