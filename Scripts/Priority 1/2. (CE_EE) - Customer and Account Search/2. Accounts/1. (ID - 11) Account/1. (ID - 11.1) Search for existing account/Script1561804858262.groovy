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
CustomKeywords.'actions.Common.shouldFailTest'(accData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait Account Details section is visible'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

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

'Verify Departmnet ID' //TODO: Bug - Department ID value is Department 350 in selection, but in view mode it is shown as 350
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_DepartmentId'), accData.get(Fields.ACC_DEPT_ID_VIEW))

'Verify Currency Code'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Position Details Section/lbl_CurrencyCode'), accData.get(Fields.ACC_CURRENCY_CODE_VIEW))

//Verify Document section
'Verify document table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, RegexOperator.EQUALS)

'Verify Document Type value for first document'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_TYPE, accData.get(Fields.DOC_TYPE))

'Verify Document Signed by for first document'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_SIGNED_BY, accData.get(Fields.DOC_SIGNED_BY))

'Verify Document Signed date for first document'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_SIGNED_DATE, DateUtil.convert(accData.get(Fields.DOC_SIGNED_DATE), common.dateTimeFormat, common.dateFormat))

'Verify Document version for first document'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents'), 1, ColumnPos.DOC_VERSION, accData.get(Fields.DOC_VERSION))