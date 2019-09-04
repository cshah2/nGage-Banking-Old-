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
Map<Fields, String> addressEdit = Data.CUSTOMER_001_ADDRESS2_EDIT
println "Customer001 = "+custData.toMapString()
println "Customer001 Address data = "+addressData.toMapString()
println "Customer001 Address Edit = "+addressEdit.toMapString()

TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(addressData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Click on Contact Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))

'Wait for contact details section to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Address table contains atleast one row'
CustomKeywords.'actions.Table.verifyRecordsCount'(addressTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

//Verify Address details for second row
int rowNo = 2 

'Verify Address Details'
CustomKeywords.'actions.Common.verifyAddressDetailsInTable'(addressData, rowNo)

'Click on More button and select Edit Address option'
CustomKeywords.'actions.Table.clickMoreButtonAndSelectOption'(addressTable, rowNo, ColumnPos.ADDR_MOREICON, 'Edit Address')

'Wait for Edit address task drawer to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

//Verify values from the selected row are loaded in fields
'Verify Street value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), 'value', addressData.get(Fields.ADDR_STREET), GlobalVariable.TIMEOUT)

'Verify city value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_City'), 'value', addressData.get(Fields.ADDR_CITY), GlobalVariable.TIMEOUT)

'Verify region selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_State'), addressData.get(Fields.ADDR_STATE), false, GlobalVariable.TIMEOUT)

'Verify zipcode value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Zipcode'), 'value', addressData.get(Fields.ADDR_ZIPCODE), GlobalVariable.TIMEOUT)

'Verify country selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_Country'), addressData.get(Fields.ADDR_COUNTY), false, GlobalVariable.TIMEOUT)

'Verify address type selected'
WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_AddressType'), addressData.get(Fields.ADDR_ADDRESS_TYPE), false, GlobalVariable.TIMEOUT)

'Verify address label value'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLabel'), 'value', addressData.get(Fields.ADDR_ADDRESS_LABEL), GlobalVariable.TIMEOUT)

//Enter updated values in field
'Fill address details in form'
CustomKeywords.'actions.Common.addressFormFill'(addressEdit)

'Scroll to submit button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

'Wait for cell value to get updated in a selected row'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.Table.waitUntilCellValueEquals'(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressEdit.get(Fields.ADDR_ADDRESS_TYPE), GlobalVariable.TIMEOUT)

'Verify updated values in address table'
CustomKeywords.'actions.Common.verifyAddressDetailsInTable'(addressEdit, rowNo)

'Set data flag'
addressEdit.put(Fields.IS_CREATED, 'true')