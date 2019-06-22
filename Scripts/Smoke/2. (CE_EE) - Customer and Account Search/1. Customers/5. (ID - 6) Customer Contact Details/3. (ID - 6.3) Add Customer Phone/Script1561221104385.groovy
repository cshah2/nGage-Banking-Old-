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
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> custDataPhone2 = Data.CUSTOMER_001_PHONE2
println "Customer001 = "+custData.toMapString()
println "Customer001 Phone 2 = "+custDataPhone2.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)

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
WebUI.delay(3) //TODO: Need to find correct wait condition.
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
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, RegexOperator.EQUALS)

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

'Click on Contact Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))

'Wait for contact details section to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Phones table contains only one row'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), 1, RegexOperator.EQUALS)

//Verify Primary Phone Details
int rowNo = 1 

'Verify Phone Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), rowNo, ColumnPos.CT_PHONE_TYPE, custData.get(Fields.CT_PHONE_TYPE))

'Verify Phone Number'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), rowNo, ColumnPos.CT_PHONE_NUMBER, custData.get(Fields.CT_PHONE_NUMBER))

'Move to add new phones button'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/icon_AddNewPhone'))

'Click on Add new phone icon'
CustomKeywords.'actions.javaScript.click'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/icon_AddNewPhone'))

'Wait for Add Phones task drawer to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/input_PhoneLabel'), GlobalVariable.TIMEOUT)

'Enter phone number'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/input_PhoneNumber'), custDataPhone2.get(Fields.CT_PHONE_NUMBER))

'Select phone type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/select_PhoneType'), custDataPhone2.get(Fields.CT_PHONE_TYPE), false)

'Enter phone label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/input_PhoneLabel'), custDataPhone2.get(Fields.CT_PHONE_LABEL))

'Scroll to submit button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'utils.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Phones/input_PhoneNumber'), GlobalVariable.TIMEOUT)

'Wait for phones to get added in table'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.table.waitUntilRecordsCountEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), 2, GlobalVariable.TIMEOUT)

//Verify phones details of second row
rowNo = 2 

'Verify Phone Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), rowNo, ColumnPos.CT_PHONE_TYPE, custDataPhone2.get(Fields.CT_PHONE_TYPE))

'Verify Phone Label'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), rowNo, ColumnPos.CT_PHONE_LABEL, custDataPhone2.get(Fields.CT_PHONE_LABEL))

'Verify Phone Number'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones'), rowNo, ColumnPos.CT_PHONE_NUMBER, custDataPhone2.get(Fields.CT_PHONE_NUMBER))

'Set data flag'
custDataPhone2.put(Fields.IS_CREATED, 'true')