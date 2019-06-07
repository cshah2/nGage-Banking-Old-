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

String searchLastName = 'Adkins'
String searchFirstName = 'Scott'
String searchPhoneNumber = '+919867045059'
int colPos_LastName = 1
int colPos_FirstName = 2
int colPos_PhoneNumber = 7

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.common.login'()

//Search for - last name
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Customer'))

'Wait for Search button to be visible'
WebUI.delay(2) //TODO: Need to find correct wait condition.
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in last name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), searchLastName)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.table.verifyAllValuesInColumnEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), colPos_LastName, searchLastName)

'Click on Clear Filter button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_ClearFilters'))

//Search for - first name
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Customer'))

'Wait for Search button to be visible'
WebUI.delay(2) //TODO: Need to find correct wait condition.
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in First name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), searchFirstName)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.table.verifyAllValuesInColumnEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), colPos_FirstName, searchFirstName)

'Click on Clear Filter button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_ClearFilters'))

//Search for - phone number
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Customer'))

'Wait for Search button to be visible'
WebUI.delay(2) //TODO: Need to find correct wait condition.
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in phone number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_PhoneNumber'), searchPhoneNumber)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.table.verifyAllValuesInColumnEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), colPos_PhoneNumber, searchPhoneNumber)

'Click on Clear Filter button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_ClearFilters'))
