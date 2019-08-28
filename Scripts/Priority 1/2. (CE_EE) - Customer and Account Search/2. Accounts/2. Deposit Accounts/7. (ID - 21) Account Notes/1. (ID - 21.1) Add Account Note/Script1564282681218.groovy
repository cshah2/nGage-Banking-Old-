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
import constants.common
import enums.Fields
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_SAVING_ACCOUNT
TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject accounts_notesTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/table_Notes')
TestObject customerOverview_notesTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Overview Tab/table_Notes')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(accData)

int expRowsCount = 1
//Set Data
String note = 'ACCOUNT NOTE - '+DateUtil.getCurrentDateTime('MMddyyyy_HHmmss', common.timezone)
String noteCreatedBy = 'Chintan Shah'

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Move to Notes tab'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))

'Go to Notes tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))

'Wait for Notes tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/table_Notes'), GlobalVariable.TIMEOUT)

'Get Current rows count'
int currentRowsCount = CustomKeywords.'actions.Table.getRecordsCount'(accounts_notesTable)

'Move to and click on Add Note icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/icon_AddNote'))

'Wait for Task drawer to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Add Account Notes/input_Note'), GlobalVariable.TIMEOUT)

'Enter notes details'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Add Account Notes/input_Note'), note)

'Move to and click on Submit button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Add Account Notes/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Add Account Notes/input_Note'), GlobalVariable.TIMEOUT)

'Wait for notes table to reload'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(accounts_notesTable, currentRowsCount+1, GlobalVariable.TIMEOUT)

//Verify Notes detail
rowNo = 1 //TODO: Record gets added to the top of the row if user logins in again.

'Verify Notes'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accounts_notesTable, rowNo, ColumnPos.NOTE_TEXT, note)

'Verify Address Label'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accounts_notesTable, rowNo, ColumnPos.NOTE_CREATED_BY, noteCreatedBy)

'Go back to search page'
WebUI.navigateToUrl(common.dashboardUrl)

'Wait for page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'), GlobalVariable.TIMEOUT)

'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Wait for Overview tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Overview Tab/Customer Person Detail Section/section_Body'), GlobalVariable.TIMEOUT)

'Move to Notes table'
CustomKeywords.'actions.Common.moveToElement'(customerOverview_notesTable)

'Verify Notes'
CustomKeywords.'actions.Table.verifyCellValueEquals'(customerOverview_notesTable, rowNo, ColumnPos.NOTE_TEXT, note)

'Verify Address Label'
CustomKeywords.'actions.Table.verifyCellValueEquals'(customerOverview_notesTable, rowNo, ColumnPos.NOTE_CREATED_BY, noteCreatedBy)