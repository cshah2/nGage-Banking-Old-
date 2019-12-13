package pages.accounts

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import enums.Fields
import internal.GlobalVariable
import utils.StringUtil

public class CreateAccountPage {

	private void enterBasicInformation(Map<Fields, String> accData) {
		
		TestObject e_AccountTitle = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle')
		TestObject e_Ownership = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Ownership')
		TestObject e_AccountDescription = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountDescription')
		TestObject e_AccountGroup = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_AccountGroup')
		TestObject e_AccountNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber')
		TestObject e_Brokered = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/checkbox_Brokered')
		TestObject e_TimeZone = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Timezone')
		TestObject e_StatementFrequency = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_StatementFrequency')
		TestObject e_PaperStatement= findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/checkbox_PaperStatement')
		
		new actions.Common().setTextIfNotEmpty(e_AccountTitle, accData, Fields.ACC_TITLE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Ownership, accData, Fields.ACC_OWNERSHIP)
		new actions.Common().setTextIfNotEmpty(e_AccountDescription, accData, Fields.ACC_DESCRIPTION)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AccountGroup, accData, Fields.ACC_GROUP)
		WebUI.delay(2) //TODO: Need to wait for product type drop down
		if(!(boolean)GlobalVariable.AUTO_ACCOUNT_NO) {
			new actions.Common().setTextIfNotEmpty(e_AccountNumber, accData, Fields.ACC_NUMBER)
		}
		new actions.Common().checkElementIfNotEmpty(e_Brokered, accData, Fields.ACC_BROKERED)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_TimeZone, accData, Fields.ACC_TIMEZONE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_StatementFrequency, accData, Fields.ACC_STATEMENT_FREQUENCY)
		new actions.Common().checkElementIfNotEmpty(e_PaperStatement, accData, Fields.ACC_PAPER_STATEMENT)
	}
	
	private void enterProductInformation(Map<Fields, String> accData) {
		
		TestObject e_ProductType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType')
		TestObject e_PositionName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName')
		TestObject e_ProductCode = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_ProductName')
		TestObject e_Currency = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Currency')
		TestObject e_CreditLimit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CreditLimit')
		TestObject e_DepartmentId = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_DeptId')
		TestObject e_Vertical = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Vertical')
		TestObject e_AccountNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber')
		
		new actions.Common().selectOptionByLabelIfNotEmpty(e_ProductType, accData, Fields.ACC_PRODUCT_TYPE)
		WebUI.delay(2) //TODO: Need to wait for product information to be loaded
		new actions.Common().setTextIfNotEmpty(e_PositionName, accData, Fields.ACC_POSITION_NAME)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Currency, accData, Fields.ACC_CURRENCY_CODE)
		new actions.Common().setTextIfNotEmpty(e_CreditLimit, accData, Fields.ACC_CREDIT_LIMIT)
		new actions.Common().setTextIfNotEmpty(e_CreditLimit, accData, Fields.ACC_CREDIT_LIMIT)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_DepartmentId, accData, Fields.ACC_DEPT_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Vertical, accData, Fields.ACC_VERTICAL)
		
		if((boolean)GlobalVariable.AUTO_ACCOUNT_NO) {
			accData.replace(Fields.ACC_NUMBER, WebUI.getText(e_AccountNumber))
		}
	}
	
	private void enterDocumentDetails(Map<Fields, String> accData) {
		
		TestObject e_DocumentType1 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType1')
		TestObject e_SignedBy1 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1')
		TestObject e_SignedDate1 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1')
		TestObject e_Version1 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1')
		TestObject e_AddAdditionalDocument = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument')
		TestObject e_DocumentType2 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2')
		TestObject e_SignedBy2 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy2')
		TestObject e_SignedDate2 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate2')
		TestObject e_Version2 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version2')

		new actions.Common().selectOptionByLabelIfNotEmpty(e_DocumentType1, accData, Fields.DOC_TYPE)
		new actions.Common().setTextIfNotEmpty(e_SignedBy1, accData, Fields.DOC_SIGNED_BY)
		new actions.Common().setTextJQueryIfNotEmpty(e_SignedDate1, accData, Fields.DOC_SIGNED_DATE)
		new actions.Common().setTextIfNotEmpty(e_Version1, accData, Fields.DOC_VERSION)
		
		if(StringUtil.isValidData(accData, Fields.DOC_TYPE2)) {
			WebUI.click(e_AddAdditionalDocument)
			WebUI.delay(2) //TODO: Need to wait for product information to be loaded 
			new actions.Common().selectOptionByLabelIfNotEmpty(e_DocumentType1, accData, Fields.DOC_TYPE2)
			new actions.Common().setTextIfNotEmpty(e_SignedBy1, accData, Fields.DOC_SIGNED_BY2)
			new actions.Common().setTextJQueryIfNotEmpty(e_SignedDate1, accData, Fields.DOC_SIGNED_DATE2)
			new actions.Common().setTextIfNotEmpty(e_Version1, accData, Fields.DOC_VERSION2)
		}
	}
	
	
	@Keyword
	def fillAccountDetails(Map<Fields, String> accData) {
		
		TestObject e_Submit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit')
		
		enterBasicInformation(accData)
		enterProductInformation(accData)
		enterDocumentDetails(accData)
		
		new actions.Common().moveToElementAndClick(e_Submit)
	}
}
