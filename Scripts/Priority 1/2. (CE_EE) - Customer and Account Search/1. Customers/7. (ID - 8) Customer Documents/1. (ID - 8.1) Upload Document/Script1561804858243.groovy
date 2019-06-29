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
CustomKeywords.'actions.common.shouldFailTest'(custData)

//Set Data
TestObject docTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/table_Documents')

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.common.searchCustomerAndOpen'(custData)

'Go to Documents tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))

'Wait for documents tab to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)

'Get current document count'
int rowCount = CustomKeywords.'actions.table.getRecordsCount'(docTable, WebTable.DOCUMENT)
println "Current rows count = "+rowCount

'Move to Add new document icon'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/icon_AddNewDocument'))

'Click on Add new document icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/icon_AddNewDocument'))

'Wait for Task drawer to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Upload file'
//CustomKeywords.'actions.File.upload'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), docData.get(Fields.DOCUMENT_FILEPATH))
CustomKeywords.'actions.File.uploadAutoIt'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), docData.get(Fields.DOCUMENT_FILEPATH))

'Wait for Uploaded file name to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/lbl_FileNameAfterUpload'), GlobalVariable.TIMEOUT)

'Select doc class'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), docData.get(Fields.DOCUMENT_CLASS), false)

'Wait for doc type field to be editable'
CustomKeywords.'utils.WaitFor.elementClickable'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), GlobalVariable.TIMEOUT)

'Select doc type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), docData.get(Fields.DOCUMENT_TYPE), false)

'Enter start date'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_StartDate'), docData.get(Fields.DOCUMENT_START_DATE))

'Enter end date'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_EndDate'), docData.get(Fields.DOCUMENT_END_DATE))

'Enter received date'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_ReceivedDate'), docData.get(Fields.DOCUMENT_RECEIVED_DATE))

'Select status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_Status'), docData.get(Fields.DOCUMENT_STATUS), false)

'Enter description'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_Description'), docData.get(Fields.DOCUMENT_DESCRIPTION))

'Move to submit button'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/btn_Submit'))

'Click on submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'utils.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Wait for documents table to refresh'
CustomKeywords.'actions.table.waitUntilRecordsCountEquals'(docTable, rowCount+1, GlobalVariable.TIMEOUT, WebTable.DOCUMENT)

//Verify document information in table
int rowNo = rowCount+1
'Verify Doc Class value'
CustomKeywords.'actions.table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_CLASS, docData.get(Fields.DOCUMENT_CLASS), WebTable.DOCUMENT)

'Verify Doc Type value'
CustomKeywords.'actions.table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_TYPE, docData.get(Fields.DOCUMENT_TYPE), WebTable.DOCUMENT)

'Verify Doc description value'
CustomKeywords.'actions.table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_DESCRIPTION, docData.get(Fields.DOCUMENT_DESCRIPTION), WebTable.DOCUMENT)

'Verify Customer ID value'
CustomKeywords.'actions.table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_CUSTOMER_ID, custData.get(Fields.CUST_CUSTOMER_ID), WebTable.DOCUMENT)

'Verify Status value'
CustomKeywords.'actions.table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_STATUS, docData.get(Fields.DOCUMENT_STATUS), WebTable.DOCUMENT)

'Set data flag'
docData.put(Fields.IS_CREATED, 'true')