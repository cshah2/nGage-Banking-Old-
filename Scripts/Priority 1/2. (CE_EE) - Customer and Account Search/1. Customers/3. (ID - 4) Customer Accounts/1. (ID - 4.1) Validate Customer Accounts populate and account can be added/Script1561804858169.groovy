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
import utils.DateUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData1 = Data.ACCOUNT_001
Map<Fields, String> accData2 = Data.ACCOUNT_002
println "Customer002 = "+custData.toMapString()
println "Account001 = "+accData1.toMapString()
println "Account002 = "+accData2.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)
CustomKeywords.'actions.common.shouldFailTest'(accData1)

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.common.searchCustomerAndOpen'(custData)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

//Verify Account created previously is displayed in the list
'Verify accounts list table is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'))

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, RegexOperator.EQUALS)

'Verify Correct account number is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_NUMBER, accData1.get(Fields.ACC_NUMBER))

'Verify Correct account title is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_TITLE, accData1.get(Fields.ACC_TITLE))

'Verify Correct account open date is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_OPEN_DATE, accData1.get(Fields.ACC_OPEN_DATE))

'Verify Correct account description is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_DESCRIPTION, accData1.get(Fields.ACC_DESCRIPTION))

'Verify Correct account ledger balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_LEDGER_BALANCE, accData1.get(Fields.ACC_LEDGER_BALANCE))

'Verify Correct account availble balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_AVAILABLE_BALANCE, accData1.get(Fields.ACC_AVAILABLE_BALANCE))

//Add new account
'Click on Create Account icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Fill up accounts page'
CustomKeywords.'actions.common.accountFormFill'(accData2)

'Scroll to OK button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on OK button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

'Wait for Customer details page to load'
CustomKeywords.'utils.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for accounts list table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), GlobalVariable.TIMEOUT)

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, RegexOperator.EQUALS)

'Verify Correct account number is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_NUMBER, accData2.get(Fields.ACC_NUMBER))

'Verify Correct account title is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_TITLE, accData2.get(Fields.ACC_TITLE))

'Verify Correct account open date is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_OPEN_DATE, accData2.get(Fields.ACC_OPEN_DATE))

'Verify Correct account description is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_DESCRIPTION, accData2.get(Fields.ACC_DESCRIPTION))

'Verify Correct account ledger balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_LEDGER_BALANCE, accData2.get(Fields.ACC_LEDGER_BALANCE))

'Verify Correct account availble balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 2, ColumnPos.ACC_AVAILABLE_BALANCE, accData2.get(Fields.ACC_AVAILABLE_BALANCE))

'Set data flag'
Data.ACCOUNT_002.put(Fields.IS_CREATED, 'true')