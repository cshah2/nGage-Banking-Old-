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
Map<Fields, String> custDataAddress2 = Data.CUSTOMER_001_ADDRESS2
println "Customer001 = "+custData.toMapString()
println "Customer001 Address 2 = "+custDataAddress2.toMapString()

TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.common.searchCustomerAndOpen'(custData)

'Click on Contact Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))

'Wait for contact details section to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Address table contains only one row'
CustomKeywords.'actions.table.verifyRecordsCount'(addressTable, 1, RegexOperator.EQUALS)

//Verify Primary Address details
int rowNo = 1 

'Verify Address details in table'
CustomKeywords.'actions.common.verifyAddressDetailsInTable'(custData, rowNo)

'Scroll to Add new address icon'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/icon_AddNewAddress'), GlobalVariable.TIMEOUT)

'Click on Add new addres icon'
//WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/icon_AddNewAddress'))
//TODO: Cannot perform scroll to element - Horizontal scroll does not work
CustomKeywords.'actions.javaScript.click'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/icon_AddNewAddress'))

'Fill Address details'
CustomKeywords.'actions.common.addressFormFill'(custDataAddress2)

'Scroll to submit button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'utils.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

'Wait for address to get added'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.table.waitUntilRecordsCountEquals'(addressTable, 2, GlobalVariable.TIMEOUT)

//Verify address details of second row
rowNo = 2
'Verify Address details in table'
CustomKeywords.'actions.common.verifyAddressDetailsInTable'(custDataAddress2, rowNo)

'Set data flag'
custDataAddress2.put(Fields.IS_CREATED, 'true')