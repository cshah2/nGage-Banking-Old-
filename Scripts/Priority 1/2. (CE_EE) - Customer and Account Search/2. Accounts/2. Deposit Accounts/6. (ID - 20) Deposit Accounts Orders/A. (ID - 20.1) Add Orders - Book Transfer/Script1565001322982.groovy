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
Map<Fields, String> accDataFrom = Data.CUSTOMER_001_ORDER_FROM_ACC01
Map<Fields, String> accDataTo = Data.CUSTOMER_001_ORDER_TO_ACC01
Map<Fields, String> txnData = Data.CUSTOMER_001_ORDER_FROM_ACC01_TXN1
Map<Fields, String> orderData = Data.CUSTOMER_001_ORDER_FROM_ACC01_ORDER01
Map<Fields, String> accBalanceFrom = Data.CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL
Map<Fields, String> accBalanceTo = Data.CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL

TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject tabOverview_txnTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Transactions Section/table_Transactions')
TestObject tabOrders_orderTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Orders Tab/Orders Section/table_Orders')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

//Add From Account
'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Click on Create Account icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Fill up accounts page'
CustomKeywords.'actions.Common.accountFormFill'(accDataFrom)

'Click on OK button on Task drawer'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

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
CustomKeywords.'actions.Table.verifyAnyValueInColumnEquals'(accTable, ColumnPos.ACC_NUMBER, accDataFrom.get(Fields.ACC_NUMBER))

'Set data flag'
accDataFrom.put(Fields.IS_CREATED, 'true')

//Add From Account
'Click on Create Account icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Fill up accounts page'
CustomKeywords.'actions.Common.accountFormFill'(accDataTo)

'Click on OK button on Task drawer'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

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
CustomKeywords.'actions.Table.verifyAnyValueInColumnEquals'(accTable, ColumnPos.ACC_NUMBER, accDataTo.get(Fields.ACC_NUMBER))

'Set data flag'
accDataTo.put(Fields.IS_CREATED, 'true')

//Perform Deposit Transaction of 10000 in FROM Account

'Go back to search page'
WebUI.navigateToUrl(common.dashboardUrl)

'Wait for page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'), GlobalVariable.TIMEOUT)

'Search From Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accDataFrom)

'Select a task [POST TRANSACTION]'
String taskNameTxn = 'Post a Transaction'
CustomKeywords.'actions.Common.selectTaskFromTaskList'(taskNameTxn)

'Fill Transaction form'
CustomKeywords.'actions.Common.transactionFormFill'(txnData)

'Click on Submit button in task drawer'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/btn_Submit'))

'Wait for review page to load'
CustomKeywords.'actions.Common.reviewTransactionDetails'(txnData)

'Click on Confirm button in task drawer'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/btn_Confirm'))

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

//Perform Book Order operation
'Click on Orders tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Wait for Orders tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabOrders_orderTable, GlobalVariable.TIMEOUT)

'Select a task [Add Order]'
String taskNameOrder = 'Add Order'
CustomKeywords.'actions.Common.selectTaskFromTaskList'(taskNameOrder)

'Fill order details'
CustomKeywords.'actions.Common.orderFormFill'(orderData, accDataFrom, accDataTo)

'Click on Submit button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/btn_Submit'))

'Verify data on order review page'
CustomKeywords.'actions.Common.reviewOrderDetails'(orderData, accDataFrom, accDataTo)

'Click on Confirm button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/btn_Confirm'))

'Wait for Task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderType'), GlobalVariable.TIMEOUT)

int expOrderRowsCount = 1
'Wait for Order table to get refreshed'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(tabOrders_orderTable, expOrderRowsCount, GlobalVariable.TIMEOUT)

int orderTableRowNo = 1
'Verify Order data in table'
CustomKeywords.'actions.Common.verifyOrderDetailsInTable'(orderData, accDataFrom, accDataTo, orderTableRowNo)

'Set Order flag as True'
orderData.put(Fields.IS_CREATED, 'true')

'Go to Overview tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Overview'))

'Wait for Overview tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_LedgerBalance'), GlobalVariable.TIMEOUT)

'Verify Balance Summary'
CustomKeywords.'actions.Common.verifyBalanceSummary'(accBalanceFrom)

int expTxnRowNo = 1
'Verify Transaction details in table'
CustomKeywords.'actions.Common.verifyTransactionDetailsInTable'(accBalanceFrom, tabOverview_txnTable, expTxnRowNo)

'Go back to search page'
WebUI.navigateToUrl(common.dashboardUrl)

'Wait for page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'), GlobalVariable.TIMEOUT)

'Search From Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accDataTo)

'Wait for Overview tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_LedgerBalance'), GlobalVariable.TIMEOUT)

'Verify Balance Summary'
CustomKeywords.'actions.Common.verifyBalanceSummary'(accBalanceTo)

'Verify Transaction details in table'
CustomKeywords.'actions.Common.verifyTransactionDetailsInTable'(accBalanceTo, tabOverview_txnTable, expTxnRowNo)