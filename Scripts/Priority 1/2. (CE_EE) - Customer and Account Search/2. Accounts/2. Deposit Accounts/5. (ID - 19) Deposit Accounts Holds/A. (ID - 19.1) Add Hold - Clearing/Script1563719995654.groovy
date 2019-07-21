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

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_HOLD_ACCOUNT01
Map<Fields, String> txnData = Data.CUSTOMER_001_HOLD_ACCOUNT01_TXN1
Map<Fields, String> holdData = Data.CUSTOMER_001_HOLD_ACCOUNT01_HOLD1
TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject tabOverview_txnTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Transactions Section/table_Transactions')
TestObject tabOverview_holdTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Holds Section/table_Holds')
TestObject tabHolds_holdTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Holds Tab/Holds Section/table_Holds')


//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

//Add new account
'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

'Click on Create Account icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Fill up accounts page'
CustomKeywords.'actions.Common.accountFormFill'(accData)

'Scroll to OK button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on OK button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

'Wait for Customer details page to load'
CustomKeywords.'actions.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for accounts list table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(accTable, GlobalVariable.TIMEOUT)

'Verify newly created account is present in table'
CustomKeywords.'actions.Table.verifyAnyValueInColumnEquals'(accTable, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

'Set data flag'
accData.put(Fields.IS_CREATED, 'true')

//Perform Deposit Transaction of 10000

'Go back to search page'
WebUI.navigateToUrl(common.dashboardUrl)

'Wait for page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'), GlobalVariable.TIMEOUT)

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Select a task [POST TRANSACTION]'
String taskName = 'Post a Transaction'
CustomKeywords.'actions.Common.selectTaskFromTaskList'(taskName)

'Fill Transaction form'
CustomKeywords.'actions.Common.transactionFormFill'(txnData)

'Scroll to Submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/btn_Submit'))

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/btn_Submit'))

'Wait for review page to load'
CustomKeywords.'actions.Common.reviewTransactionDetails'(txnData)

'Move to confirm button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/btn_Confirm'))

'Click on confirm button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/btn_Confirm'))

int expRowCount = 1
'Wait for transaction table to reload'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(tabOverview_txnTable, expRowCount, GlobalVariable.TIMEOUT)

'Refresh web page' //This is done to ensure no dynamic loading is pending
WebUI.refresh()
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify data in Balance summary section'
CustomKeywords.'actions.Common.verifyBalanceSummary'(txnData)

'Set data flag'
txnData.put(Fields.IS_CREATED, 'true')

//Perform Deposit Transaction of 10000
'Go back to search page'
WebUI.navigateToUrl(common.dashboardUrl)

'Wait for page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'), GlobalVariable.TIMEOUT)

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Select a task [Add Hold]'
String holdTask = 'Add Hold'
CustomKeywords.'actions.Common.selectTaskFromTaskList'(holdTask)

'Fill up hold form'
CustomKeywords.'actions.Common.holdFormFill'(holdData)

'Scroll to Submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/btn_Submit'))

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/btn_Submit'))

'Wait for Task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), GlobalVariable.TIMEOUT)

'Wait for Holds table to reload'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(tabOverview_holdTable, expRowCount, GlobalVariable.TIMEOUT)

'Refresh web page' //This is done to ensure no dynamic loading is pending
WebUI.refresh()
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify data in Balance summary section'
CustomKeywords.'actions.Common.verifyBalanceSummary'(holdData)

int rowNo = 1
'Verify data in holds table in overview tab'
CustomKeywords.'actions.Common.verifyHoldDetailsInTable'(holdData, tabOverview_holdTable, rowNo)

'Click on Holds tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Holds'))

'Wait for Holds tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabHolds_holdTable, GlobalVariable.TIMEOUT)

'Verify data in Holds table in holds tab'
CustomKeywords.'actions.Common.verifyHoldDetailsInTable'(holdData, tabHolds_holdTable, rowNo)

'Set Flag'
holdData.put(Fields.IS_CREATED, 'true')

'Expand Hold information Section'
CustomKeywords.'actions.Common.openHoldInformationSection'(tabHolds_holdTable, 1)

'Verify data in Holds information section'
CustomKeywords.'actions.Common.verifyHoldDetailsInAccordion'(accData, holdData)