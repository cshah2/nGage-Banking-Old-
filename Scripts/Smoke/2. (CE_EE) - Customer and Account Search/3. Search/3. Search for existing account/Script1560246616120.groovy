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
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
import utils.RegexUtil

Map<Fields, String> accData = Data.ACCOUNT_001
println "Accounts001 = "+accData.toMapString()

//Mark this test as failed if required customer is not created
CustomKeywords.'actions.common.shouldFailTest'(accData)

'Login into portal'
CustomKeywords.'actions.common.login'()

//Search for - Account number
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Accounts option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

'Wait for Account Type drop down to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)

'Click on account type drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Banking option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Banking'))

'Wait for Account number input field to be visible'
WebUI.delay(3)
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in account number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

'Wait for Account title to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

'Verify Account title contains correct account number'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), accData.get(Fields.ACC_NUMBER))

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait Account Details section is visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

//Verify Account Details section
'Verify Account number'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountNumber'), accData.get(Fields.ACC_NUMBER))

'Verify Account title'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountTitle'), accData.get(Fields.ACC_TITLE))

'Verify Account description'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountDescription'), accData.get(Fields.ACC_DESCRIPTION))

'Verify Account Open date'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_OpenDate'), accData.get(Fields.ACC_OPEN_DATE))

'Verify Account Statement Frequency'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_StatementFrequency'), accData.get(Fields.ACC_STATEMENT_FREQUENCY))

'Verify Account timezone'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_TimeZone'), accData.get(Fields.ACC_TIMEZONE))

//'Verify Routing number'
//WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_RoutingNumber'), routingNumber)

//Verify Position Details section
'Verify Account Ledger balance'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_LedgerBalance'), accData.get(Fields.ACC_LEDGER_BALANCE))

'Verify Account Available balance'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_AvailableBalance'), accData.get(Fields.ACC_AVAILABLE_BALANCE))

'Verify Account name'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_Name'), accData.get(Fields.ACC_POSITION_NAME))

'Verify Departmnet ID'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_DepartmentId'), accData.get(Fields.ACC_DEPT_ID))

'Verify Currency Code'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_CurrencyCode'), accData.get(Fields.ACC_CURRENCY_CODE))

//Verify Document section

'Verify document table contains only 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, RegexOperator.EQUALS)

'Verify Document Type value for first document'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_TYPE, accData.get(Fields.DOC_TYPE))

'Verify Document Signed by for first document'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_SIGNED_BY, accData.get(Fields.DOC_SIGNED_BY))

'Verify Document Signed date for first document'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_SIGNED_DATE, DateUtil.convert(accData.get(Fields.DOC_SIGNED_DATE), "MM/dd/yyyy HH:mm:ss", common.dateFormat))

'Verify Document version for first document'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_VERSION, accData.get(Fields.DOC_VERSION))