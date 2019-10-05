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

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> docData = Data.CUSTOMER_001_DOCUMENT1
Map<Fields, String> docEditData = Data.CUSTOMER_001_DOCUMENT1_EDIT
println "Customer001 = "+custData.toMapString()
println "Customer001 Document = "+docData.toMapString()
println "Customer001 Document Edit = "+docEditData.toMapString()

//Mark this test as failed if required customer and document is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(docData)

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

int rowNo = rowCount

'Click on last document in the table'
CustomKeywords.'actions.Table.clickCell'(docTable, rowNo, ColumnPos.DOCUMENT_ICON, WebTable.DOCUMENT)

'Switch to window'
WebUI.switchToWindowIndex(1)
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentTitle'), GlobalVariable.TIMEOUT)

//Verify document details
'Verify Document Title'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentTitle'), docData.get(Fields.DOCUMENT_TITLE))

'Verify Document class'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentClass'), docData.get(Fields.DOCUMENT_CLASS))

'Verify Document type'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentType'), docData.get(Fields.DOCUMENT_TYPE))

'Verify Document status'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_Status'), docData.get(Fields.DOCUMENT_STATUS))

'Verify Customer ID'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_CustomerId'), custData.get(Fields.CUST_CUSTOMER_ID))

'Verify Received Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_ReceivedDate'), docData.get(Fields.DOCUMENT_RECEIVED_DATE))

'Verify Start Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_StartDate'), docData.get(Fields.DOCUMENT_START_DATE))

'Verify End Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_EndDate'), docData.get(Fields.DOCUMENT_END_DATE))

'Verify Description'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_Description'), docData.get(Fields.DOCUMENT_DESCRIPTION))

'Move to Edit icon'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Document Details Page/View Section/btn_Edit'))

'Click on Edit icon'
WebUI.click(findTestObject('Dashboard Page/Document Details Page/View Section/btn_Edit'))

'Wait for Task drawer to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Verify DocClass field is read only'
WebUI.verifyElementNotClickable(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/select_DocClass'))

'Select doc type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/select_DocType'), docEditData.get(Fields.DOCUMENT_TYPE), false)

'Enter start date'
CustomKeywords.'actions.JavaScript.setText'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/input_StartDate'), docEditData.get(Fields.DOCUMENT_START_DATE))

'Enter end date'
CustomKeywords.'actions.JavaScript.setText'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/input_EndDate'), docEditData.get(Fields.DOCUMENT_END_DATE))

'Enter received date'
CustomKeywords.'actions.JavaScript.setText'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/input_ReceivedDate'), docEditData.get(Fields.DOCUMENT_RECEIVED_DATE))

'Select status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/select_Status'), docEditData.get(Fields.DOCUMENT_STATUS), false)

'Enter description'
WebUI.setText(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/input_Description'), docEditData.get(Fields.DOCUMENT_DESCRIPTION))

'Move to submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/btn_Submit'))

'Click on submit button'
WebUI.click(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/btn_Submit'))

'Wait for Task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Document Details Page/Task Drawer/Edit Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Wait for page values to refresh'
WebUI.delay(5) //TODO: Need to add proper wait condition 
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentClass'), GlobalVariable.TIMEOUT)

//Verify updated document details
'Verify Document Title'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentTitle'), docEditData.get(Fields.DOCUMENT_TITLE))

'Verify Document class'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentClass'), docEditData.get(Fields.DOCUMENT_CLASS))

'Verify Document type'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_DocumentType'), docEditData.get(Fields.DOCUMENT_TYPE))

'Verify Document status'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_Status'), docEditData.get(Fields.DOCUMENT_STATUS))

'Verify Customer ID'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_CustomerId'), custData.get(Fields.CUST_CUSTOMER_ID))

'Verify Received Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_ReceivedDate'), docEditData.get(Fields.DOCUMENT_RECEIVED_DATE))

'Verify Start Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_StartDate'), docEditData.get(Fields.DOCUMENT_START_DATE))

'Verify End Date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_EndDate'), docEditData.get(Fields.DOCUMENT_END_DATE))

'Verify Description'
WebUI.verifyElementText(findTestObject('Dashboard Page/Document Details Page/View Section/lbl_Description'), docEditData.get(Fields.DOCUMENT_DESCRIPTION))

'Close window'
WebUI.closeWindowIndex(1)

'Switch to parent window'
WebUI.switchToWindowIndex(0)

'Refresh web page'
WebUI.refresh()
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))

'Go to Documents tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))

'Wait for documents tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Doc Class value'
CustomKeywords.'actions.Table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_CLASS, docEditData.get(Fields.DOCUMENT_CLASS), WebTable.DOCUMENT)

'Verify Doc Type value'
CustomKeywords.'actions.Table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_TYPE, docEditData.get(Fields.DOCUMENT_TYPE), WebTable.DOCUMENT)

'Verify Doc description value'
CustomKeywords.'actions.Table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_DESCRIPTION, docEditData.get(Fields.DOCUMENT_DESCRIPTION), WebTable.DOCUMENT)

'Verify Customer ID value'
CustomKeywords.'actions.Table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_CUSTOMER_ID, custData.get(Fields.CUST_CUSTOMER_ID), WebTable.DOCUMENT)

'Verify Status value'
CustomKeywords.'actions.Table.verifyCellValueEquals'(docTable, rowNo, ColumnPos.DOCUMENT_STATUS, docEditData.get(Fields.DOCUMENT_STATUS), WebTable.DOCUMENT)

'Set data flag'
docEditData.put(Fields.IS_CREATED, 'true')