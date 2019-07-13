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
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_SAVING_ACCOUNT
TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

//Add new account
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

'Get row number for the newly created account from table'
int rowNow = CustomKeywords.'actions.Table.getRowNumber'(accTable, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

'Verify Correct account number is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

'Verify Correct account title is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_TITLE, accData.get(Fields.ACC_TITLE))

'Verify Correct account open date is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_OPEN_DATE, accData.get(Fields.ACC_OPEN_DATE))

'Verify Correct account description is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_DESCRIPTION, accData.get(Fields.ACC_DESCRIPTION))

'Verify Correct account ledger balance is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_LEDGER_BALANCE, accData.get(Fields.ACC_LEDGER_BALANCE))

'Verify Correct account availble balance is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(accTable, rowNow, ColumnPos.ACC_AVAILABLE_BALANCE, accData.get(Fields.ACC_AVAILABLE_BALANCE))