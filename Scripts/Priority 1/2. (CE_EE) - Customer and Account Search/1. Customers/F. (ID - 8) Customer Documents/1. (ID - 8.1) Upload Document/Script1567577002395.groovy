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
import enums.WebTable
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> docData = Data.CUSTOMER_001_DOCUMENT1
println "Customer001 = "+custData.toMapString()
println "Customer001 Document = "+docData.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

//Set Data
TestObject docTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/table_Documents')

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Go to Documents tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))

'Wait for documents tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)

'Get current document count'
int rowCount = CustomKeywords.'actions.Table.getRecordsCount'(docTable, WebTable.DOCUMENT)
println "Current rows count = "+rowCount

'Move to Add new document icon'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/icon_AddNewDocument'))

'Click on Add new document icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/icon_AddNewDocument'))

'Fill document details in task drawer'
CustomKeywords.'actions.Common.documentFormFill'(docData)

'Move to submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/btn_Submit'))

'Click on submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Wait for documents table to refresh'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(docTable, rowCount+1, GlobalVariable.TIMEOUT, WebTable.DOCUMENT)

//Verify document information in table
int rowNo = 1 //TODO: Document gets added to the top row instead of bottom (unlink other tabs)

'Verify document details in table'
CustomKeywords.'actions.Common.verifyDocumentDetailsInTable'(docData, custData, rowNo)

'Set data flag'
docData.put(Fields.IS_CREATED, 'true')