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

Map<Fields, String> accData = Data.CUSTOMER_001_HOLD_ACCOUNT02
Map<Fields, String> holdData = Data.CUSTOMER_001_HOLD_ACCOUNT02_HOLD5
Map<Fields, String> editHoldData = Data.CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT
int rowNo = 1

TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject tabOverview_txnTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Transactions Section/table_Transactions')
TestObject tabOverview_holdTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Holds Section/table_Holds')
TestObject tabHolds_holdTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Holds Tab/Holds Section/table_Holds')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(accData)
CustomKeywords.'actions.Common.shouldFailTest'(holdData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Click on Holds tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabHolds_holdTable, GlobalVariable.TIMEOUT)

String action = 'Edit Hold'
'Click on More icon for any Hold and select Cancel Hold Option'
CustomKeywords.'actions.Table.clickMoreButtonAndSelectOption'(tabHolds_holdTable, rowNo, ColumnPos.HOLD_MORE_ICON, action)

'Verify hold details in task drawer'
CustomKeywords.'actions.Common.verifyHoldDetailsInTaskDrawer'(holdData)

'Update hold details in task drawer'
CustomKeywords.'actions.Common.holdFormFill'(editHoldData)

'Scroll to Submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/btn_Submit'))

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/btn_Submit'))

'Wait for Task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), GlobalVariable.TIMEOUT)

'Wait for hold details to get updated'
CustomKeywords.'actions.Table.waitUntilCellValueEquals'(tabHolds_holdTable, rowNo, ColumnPos.HOLD_TYPE, editHoldData.get(Fields.HOLD_TYPE), GlobalVariable.TIMEOUT)

'Refresh web page' //This is done to ensure no dynamic loading is pending
WebUI.refresh()
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify data in Balance summary section'
CustomKeywords.'actions.Common.verifyBalanceSummary'(editHoldData)

'Verify data in holds table in overview tab'
CustomKeywords.'actions.Common.verifyHoldDetailsInTable'(editHoldData, tabOverview_holdTable, rowNo)

'Click on Holds tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabHolds_holdTable, GlobalVariable.TIMEOUT)

'Verify data in Holds table in holds tab'
CustomKeywords.'actions.Common.verifyHoldDetailsInTable'(editHoldData, tabHolds_holdTable, rowNo)

'Set Flag'
editHoldData.put(Fields.IS_CREATED, 'true')