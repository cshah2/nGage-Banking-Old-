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
Map<Fields, String> addressData = Data.CUSTOMER_001_ADDRESS2
Map<Fields, String> addressEdit = Data.CUSTOMER_001_ADDRESS3
println "Customer001 = "+custData.toMapString()
println "Customer001 Address data = "+addressData.toMapString()
println "Customer001 Address Edit = "+addressEdit.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)
CustomKeywords.'actions.common.shouldFailTest'(addressData)

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

'Verify Address table contains atleast one row'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), 1, RegexOperator.GREATER_THAN_OR_EQUAL)

//Verify Address details for second row
int rowNo = 2 

'Verify Address Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressData.get(Fields.ADDR_ADDRESS_TYPE))

'Verify Address Label'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ADDRESS_LABEL, addressData.get(Fields.ADDR_ADDRESS_LABEL))

'Verify Address Street'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_STREET, addressData.get(Fields.ADDR_STREET))

'Verify Address City'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_CITY, addressData.get(Fields.ADDR_CITY))

'Verify Address Country'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_COUNTY, addressData.get(Fields.ADDR_COUNTY))

'Verify Address State'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_STATE, addressData.get(Fields.ADDR_STATE))

'Verify Address Zipcode'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ZIPCODE, addressData.get(Fields.ADDR_ZIPCODE))

'Click on More button and select Edit Address option'
CustomKeywords.'actions.table.clickMoreButtonAndSelectOption'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_MOREICON, 'Edit Address')

'Wait for Edit address task drawer to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

//Verify values from the selected row are loaded in fields
'Verify Street value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Street'), 'value', addressData.get(Fields.ADDR_STREET), GlobalVariable.TIMEOUT)

'Verify city value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_City'), 'value', addressData.get(Fields.ADDR_CITY), GlobalVariable.TIMEOUT)

'Verify region selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_State'), addressData.get(Fields.ADDR_STATE), false, GlobalVariable.TIMEOUT)

'Verify zipcode value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Zipcode'), 'value', addressData.get(Fields.ADDR_ZIPCODE), GlobalVariable.TIMEOUT)

'Verify country selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_Country'), addressData.get(Fields.ADDR_COUNTY), false, GlobalVariable.TIMEOUT)

'Verify address type selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_AddressType'), addressData.get(Fields.ADDR_ADDRESS_TYPE), false, GlobalVariable.TIMEOUT)

'Verify address label value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_AddressLabel'), 'value', addressData.get(Fields.ADDR_ADDRESS_LABEL), GlobalVariable.TIMEOUT)

//Enter updated values in field
'Enter street'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Street'), addressEdit.get(Fields.ADDR_STREET))

'Enter city'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_City'), addressEdit.get(Fields.ADDR_CITY))

'Select state'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_State'), addressEdit.get(Fields.ADDR_STATE), false)

'Enter Zipcode'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Zipcode'), addressEdit.get(Fields.ADDR_ZIPCODE))

'Select country'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_Country'), addressEdit.get(Fields.ADDR_COUNTY), false)

'Select address type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/select_AddressType'), addressEdit.get(Fields.ADDR_ADDRESS_TYPE), false)

'Enter address label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_AddressLabel'), addressEdit.get(Fields.ADDR_ADDRESS_LABEL))

'Scroll to submit button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'utils.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

'Wait for cell value to get updated in a selected row'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.table.waitUntilCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressEdit.get(Fields.ADDR_ADDRESS_TYPE), GlobalVariable.TIMEOUT)

//Verify updated values in address table
'Verify Address Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressEdit.get(Fields.ADDR_ADDRESS_TYPE))

'Verify Address Label'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ADDRESS_LABEL, addressEdit.get(Fields.ADDR_ADDRESS_LABEL))

'Verify Address Street'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_STREET, addressEdit.get(Fields.ADDR_STREET))

'Verify Address City'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_CITY, addressEdit.get(Fields.ADDR_CITY))

'Verify Address Country'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_COUNTY, addressEdit.get(Fields.ADDR_COUNTY))

'Verify Address State'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_STATE, addressEdit.get(Fields.ADDR_STATE))

'Verify Address Zipcode'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'), rowNo, ColumnPos.ADDR_ZIPCODE, addressEdit.get(Fields.ADDR_ZIPCODE))

'Set data flag'
addressEdit.put(Fields.IS_CREATED, 'true')