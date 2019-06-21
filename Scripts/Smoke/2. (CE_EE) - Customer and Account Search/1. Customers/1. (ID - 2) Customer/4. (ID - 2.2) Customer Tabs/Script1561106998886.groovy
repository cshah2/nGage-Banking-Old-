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

//custData.put(Fields.CUST_FIRST_NAME, 'frederick')
//custData.put(Fields.CUST_LAST_NAME, 'rivera')
//custData.put(Fields.CT_PHONE_NUMBER, '+12551735641')
//custData.put(Fields.CUST_NAME_VIEW, 'frederick rivera')

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.common.login'()

//Search for customer
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Search button to be visible'
WebUI.delay(2) //TODO: Need to find correct wait condition.
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in last name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), custData.get(Fields.CUST_LAST_NAME))

'Enter Search Criteria in First name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

'Enter Search Criteria in phone number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), expRowsCount, RegexOperator.EQUALS)

'Verify column values are matching - last name'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, ColumnPos.CUST_LAST_NAME, custData.get(Fields.CUST_LAST_NAME))

'Verify column values are matching - first name'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, ColumnPos.CUST_FIRST_NAME, custData.get(Fields.CUST_FIRST_NAME))

'Verify column values are matching - phone number'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, ColumnPos.CUST_PHONE_NUMBER, custData.get(Fields.CT_PHONE_NUMBER))

'Click on Last name link in a first row of search result table'
CustomKeywords.'actions.table.clickCell'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, ColumnPos.CUST_LAST_NAME)

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))

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
	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Overview Tab/Customer Person Detail Section/section_Body'), GlobalVariable.TIMEOUT)
}
