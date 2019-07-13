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
import internal.GlobalVariable as GlobalVariable

//Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_DDA_ACCOUNT
Map<Fields, String> accDetailDoc = Data.CUSTOMER_001_DDA_ACCOUNT_ACC_DOC2
TestObject table = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(accData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Move to Details tab'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait for Details tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

'Get existing docs count in table'
int rowCount = CustomKeywords.'actions.Table.getRecordsCount'(table) 

'Move to Add Document icon'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/icon_AddNewDocument'))

'Click on Add Document icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/icon_AddNewDocument'))

'Add Doc details in Task'
CustomKeywords.'actions.Common.accountDetailDocFormFill'(accDetailDoc)

'Move to Submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/btn_Submit'))

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/select_DocumentType'), GlobalVariable.TIMEOUT)

'Wait for doc details to be updated in table'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(table, rowCount+1, GlobalVariable.TIMEOUT)

int rowNo = rowCount+1
'Verify Doc details in table'
CustomKeywords.'actions.Common.verifyAccountDetailDocInTable'(accDetailDoc, rowNo)