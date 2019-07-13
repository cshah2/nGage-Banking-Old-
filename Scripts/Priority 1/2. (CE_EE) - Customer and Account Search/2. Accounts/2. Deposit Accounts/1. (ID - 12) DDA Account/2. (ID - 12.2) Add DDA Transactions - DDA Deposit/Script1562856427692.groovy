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
import enums.ErrorType
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable

//Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_DDA_ACCOUNT
Map<Fields, String> txnData = Data.CUSTOMER_001_DDA_ACCOUNT_TXN1
TestObject tabOverview_txnTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Transactions Section/table_Transactions')
TestObject tabTransaction_txnTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Tab/Transactions Section/table_Transactions')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(accData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

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

int rowNo = 1
'Verify data in transaction table in overview tab'
CustomKeywords.'actions.Common.verifyTransactionDetailsInTable'(txnData, tabOverview_txnTable, rowNo)

'Click on Transactions tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Transactions'))

'Wait for transactions tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabTransaction_txnTable, GlobalVariable.TIMEOUT)

'Verify data in transaction table in transaction tab'
CustomKeywords.'actions.Common.verifyTransactionDetailsInTable'(txnData, tabTransaction_txnTable, rowNo)

'Set Flag'
txnData.put(Fields.IS_CREATED, 'true')

'Expand Transaction Information section'
CustomKeywords.'actions.Common.openTransactionInformationSection'(tabTransaction_txnTable, 1)

'Verify data in Transaction Information section'
CustomKeywords.'actions.Common.verifyTransactionInformationInAccordion'(accData, txnData)
