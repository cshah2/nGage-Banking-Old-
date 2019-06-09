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

import constants.Data
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

String searchLastName = 'george'
String searchFirstName = 'clarence'
String searchPhoneNumber = '+11164796974'


Map<Fields, String> custData = Data.CUSTOMER_001
println "Customer = "+custData

Map<Fields, String> accData = Data.ACCOUNT_001
println "Account = "+accData

int colPos_LastName = 1
int colPos_FirstName = 2
int colPos_PhoneNumber = 7
int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.common.login'()

//Search for customer
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Search button to be visible'
WebUI.delay(2) //TODO: Need to find correct wait condition.
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in last name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), searchLastName)

'Enter Search Criteria in First name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), searchFirstName)

'Enter Search Criteria in phone number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_PhoneNumber'), searchPhoneNumber)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), expRowsCount, RegexOperator.EQUALS)

'Verify column values are matching - last name'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, colPos_LastName, searchLastName)

'Verify column values are matching - first name'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, colPos_FirstName, searchFirstName)

'Verify column values are matching - phone number'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, colPos_PhoneNumber, searchPhoneNumber)

'Click on Last name link in a first row of search result table'
CustomKeywords.'actions.table.clickCell'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, colPos_LastName)

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), searchFirstName+' '+searchLastName)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

'Click on Create Account icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Verify Default value present in account title'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), 'value', searchFirstName+' '+searchLastName, GlobalVariable.TIMEOUT)

'Enter account description'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountDescription'), accData.get(Fields.ACC_DESCRIPTION))

'Select Account group'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_AccountGroup'), accData.get(Fields.ACC_GROUP), false)

'Wait for Product section to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), GlobalVariable.TIMEOUT)

'Enter account number'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

'Select timezone'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Timezone'), accData.get(Fields.ACC_TIMEZONE), false)

'Select statement frequency'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_StatementFrequency'), accData.get(Fields.ACC_STATEMENT_FREQUENCY), false)

'Select Product Type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), accData.get(Fields.ACC_PRODUCT_TYPE), false)

'Wait for Javascript load'
WebUI.delay(1) //TODO: Need to wait for effective condition

'Verify Position Name'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), 'value', accData.get(Fields.ACC_POSITION_NAME), GlobalVariable.TIMEOUT)

'Verify currency code'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CurrencyCode'), 'value', accData.get(Fields.ACC_CURRENCY_CODE), GlobalVariable.TIMEOUT)

'Verify vertical'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_Vertical'), 'value', accData.get(Fields.ACC_VERTICAL), GlobalVariable.TIMEOUT)

'Verify Dept ID'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_DeptId'), 'value', accData.get(Fields.ACC_DEPT_ID), GlobalVariable.TIMEOUT)

'Select Document 1 - Terms and Conditions'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType1'), accData.get(Fields.DOC_TYPE), false)

'Enter signde by'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1'), searchFirstName+' '+searchLastName)

'Enter signed date'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), accData.get(Fields.DOC_SIGNED_DATE))

'Enter vesion'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1'), accData.get(Fields.DOC_VERSION))

'Click on OK button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Ok'))