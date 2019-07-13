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
import constants.common
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

int expRowsCount = 1

Map<Fields, String> custData = new HashMap<Fields, String>()
custData.put(Fields.CUST_FIRST_NAME, FirstName)
custData.put(Fields.CUST_LAST_NAME, LastName)
custData.put(Fields.CUST_TAX_ID, TaxID)
custData.put(Fields.CUST_NAME_VIEW, FirstName+' '+LastName)

Map<Fields, String> accData = new HashMap<Fields, String>()
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
	accData.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezone))
}

accData.put(Fields.DOC_VERSION, DocVersion1)
accData.put(Fields.DOC_TYPE2, DocType2)
accData.put(Fields.DOC_SIGNED_BY2, DocSignedBy2)
if(StringUtils.isNotBlank(DocSignedDate2)) {
	accData.put(Fields.DOC_SIGNED_DATE2, DocSignedDate2)
}
else {
	accData.put(Fields.DOC_SIGNED_DATE2, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezone))
}

accData.put(Fields.DOC_VERSION2, DocVersion2)

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

'Fill form'
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