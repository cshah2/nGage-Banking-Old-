import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils

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

int expRowsCount = 1

Map<Fields, String> accData = new HashMap<Fields, String>()
accData = new HashMap<Fields, String>()
accData.put(Fields.ACC_TITLE, AccTitle)
accData.put(Fields.ACC_OWNERSHIP, AccOwnership)
accData.put(Fields.ACC_DESCRIPTION, AccDescription)
accData.put(Fields.ACC_GROUP, AccGroup)
accData.put(Fields.ACC_NUMBER, AccNumber)
if(StringUtils.isNotBlank(Brokered) && "Yes".equalsIgnoreCase(Brokered)) {
	accData.put(Fields.ACC_BROKERED, Brokered)
}
accData.put(Fields.ACC_TIMEZONE, Timezone)
accData.put(Fields.ACC_STATEMENT_FREQUENCY, StatementFrequency)
accData.put(Fields.ACC_PRODUCT_TYPE, ProductType)
accData.put(Fields.ACC_POSITION_NAME, PositionName)
accData.put(Fields.ACC_CURRENCY_CODE, CurrencyCode)
accData.put(Fields.ACC_VERTICAL, Vertical)
accData.put(Fields.ACC_DEPT_ID, DepartmentID)
accData.put(Fields.ACC_CREDIT_LIMIT, CreditLimit)
accData.put(Fields.ACC_INTEREST_RATE, InterestRate)
accData.put(Fields.DOC_TYPE, DocType1)
accData.put(Fields.DOC_SIGNED_BY, DocSignedBy1)
if(StringUtils.isNotBlank(DocSignedDate1)) {
	accData.put(Fields.DOC_SIGNED_DATE, DocSignedDate1)
}
else {
	accData.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
}

accData.put(Fields.DOC_VERSION, DocVersion1)
accData.put(Fields.DOC_TYPE2, DocType2)
accData.put(Fields.DOC_SIGNED_BY2, DocSignedBy2)
if(StringUtils.isNotBlank(DocSignedDate2)) {
	accData.put(Fields.DOC_SIGNED_DATE2, DocSignedDate2)
}
else {
	accData.put(Fields.DOC_SIGNED_DATE2, DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
}

accData.put(Fields.DOC_VERSION2, DocVersion2)

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
CustomKeywords.'utils.WaitFor.ajaxComplete'()
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in last name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), LastName)

'Enter Search Criteria in First name field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), FirstName)

'Enter Search Criteria in tax id field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_TaxID'), TaxID)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'))

'Wait for table to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), GlobalVariable.TIMEOUT)

'Click on Last name link in a first row of search result table'
CustomKeywords.'actions.table.clickCell'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), 1, ColumnPos.CUST_LAST_NAME)

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Click on Accounts tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

'Wait for Create Account icon to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)

//Add new account
'Click on Create Account icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

//'Enter account title'
//if(StringUtils.isNotBlank(AccTitle)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), AccTitle)
//}
//
//'Select account ownership'
//WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Ownership'), AccOwnership, false)
//
//'Enter account description'
//WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountDescription'), AccDescription)
//
//'Select Account group'
//WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_AccountGroup'), AccGroup, false)
//
//'Wait for Product section to be visible'
//CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), GlobalVariable.TIMEOUT)
//
//'Enter account number'
//WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), AccNumber)
//
//'Select checkbox Brokered'
//if("Yes".equalsIgnoreCase(Brokered)) {
//	WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/checkbox_Brokered'))
//}
//
//'Select timezone'
//if(StringUtils.isNotBlank(Timezone)) {
//	WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Timezone'), Timezone, false)
//}
//
//'Select statement frequency'
//if(StringUtils.isNotBlank(StatementFrequency)) {
//	WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_StatementFrequency'), StatementFrequency, false)
//}
//
//'Select Product Type'
//WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), ProductType, false)
//
//'Wait for Position name field to have a value'
//CustomKeywords.'utils.WaitFor.textNotEmpty'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), GlobalVariable.TIMEOUT)
//
//'EnterPosition Name'
//if(StringUtils.isNotBlank(PositionName)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), PositionName)
//}
//
//'Enter currency code'
//if(StringUtils.isNotBlank(CurrencyCode)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CurrencyCode'), CurrencyCode)
//}
//
//'Enter vertical'
//if(StringUtils.isNotBlank(Vertical)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Vertical'), Vertical)
//}
//
//'Enter Dept ID'
//if(StringUtils.isNotBlank(DepartmentID)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_DeptId'), DepartmentID)
//}
//
//'Enter Credit limit'
//if(StringUtils.isNotBlank(CreditLimit)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CreditLimit'), CreditLimit)
//}
//
//'Enter Interest Rate'
//if(StringUtils.isNotBlank(InterestRate)) {
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_InterestRate'), InterestRate)
//}
//
//'Select Document 1'
//WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType1'), DocType1, false)
//
//'Enter signde by'
//WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1'), DocSignedBy1)
//
//'Enter signed date'
//if(StringUtils.isNotBlank(DocSignedDate1)) {
//	CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), DocSignedDate1)
//}
//else {
//	CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
//}
//
//'Enter vesion'
//WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1'), DocVersion1)
//	
//if(StringUtils.isNotBlank(DocType2)) {
//	
//	'Scroll to Add another document link'
//	WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'), GlobalVariable.TIMEOUT)
//	
//	'Click on Add another document link'
//	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'))
//	
//	'Wait for new document section to be visible'
//	CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), GlobalVariable.TIMEOUT)
//	
//	'Select Document 2'
//	WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), DocType2, false)
//	
//	'Enter signde by'
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy2'), DocSignedBy2)
//	
//	'Enter signed date'
//	if(StringUtils.isNotBlank(DocSignedDate2)) {
//		CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate2'), DocSignedDate2)
//	}
//	else {
//		CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate2'), DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
//	}
//	
//	'Enter vesion'
//	WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version2'), DocVersion2)
//}
'Fill form'
CustomKeywords.'actions.common.accountFormFill'(accData)

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