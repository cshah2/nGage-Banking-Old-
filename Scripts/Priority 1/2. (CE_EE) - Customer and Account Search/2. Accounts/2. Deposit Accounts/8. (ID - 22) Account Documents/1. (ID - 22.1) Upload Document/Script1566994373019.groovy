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

import constants.Data
import enums.Fields
import enums.WebTable
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_SAVING_ACCOUNT
Map<Fields, String> docData = Data.CUSTOMER_001_DOCUMENT1
TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject accounts_DocTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Documents Tab/Documents Section/table_Documents')
TestObject customerOverview_DocTable = findTestObject('')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(accData)

int expRowsCount = 1
//Set Data

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Click on Documents tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Documents'))

'Wait for documents tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(accounts_DocTable, GlobalVariable.TIMEOUT)

'Get current document count'
int rowCount = CustomKeywords.'actions.Table.getRecordsCount'(accounts_DocTable, WebTable.DOCUMENT)

'Click on Add New document'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Documents Tab/Documents Section/icon_AddDocument'))

'Fill document details in task drawer'
CustomKeywords.'actions.Common.documentFormFill'(docData)

'Click on Submit button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

'Wait for documents table to refresh'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(accounts_DocTable, rowCount+1, GlobalVariable.TIMEOUT, WebTable.DOCUMENT)

//Verify document information in table
int rowNo = 1 //TODO: Document gets added to the top row instead of bottom (unlink other tabs)

'Verify document details in table'
CustomKeywords.'actions.Common.verifyDocumentDetailsInTable'(docData, custData, rowNo)

'Set data flag'
docData.put(Fields.IS_CREATED, 'true')
