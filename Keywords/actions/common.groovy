package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import enums.Fields
import enums.RegexOperator
import enums.WebTable
import internal.GlobalVariable
import utils.RegexUtil

import static constants.common.*

import org.apache.commons.lang3.StringUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.interactions.Actions

public class common {

	TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')
	TestObject phoneTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones')
	TestObject emailTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails')
	TestObject documentTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/table_Documents')
	
	//Open browser if not already opened
	private void openBrowser() {
		try {
			DriverFactory.getWebDriver()
		}
		catch(Exception e) {
			WebUI.openBrowser(null)
		}
	}

	@Keyword
	def login() {

		TestObject usernameField 	= findTestObject('Login Page/input_UserName')
		TestObject passwordField	= findTestObject('Login Page/input_Password')
		TestObject loginButton 		= findTestObject('Login Page/btn_Login')
		TestObject loginPageHeader 	= findTestObject('Login Page/lbl_Heading')
		int loginAttempt = 1
		boolean isLoginSuccess = false
		
		while (loginAttempt <= 3) {
			openBrowser()
			WebUI.deleteAllCookies()
			WebUI.navigateToUrl(loginUrl)
			String currentUrl = WebUI.getUrl()
	
			//Check if User is on Login page or not
			if(currentUrl.contains('Login.aspx') || currentUrl.contains('NoPermission.aspx')) {
	
				WebUI.delay(2)
				WebUI.verifyElementVisible(loginPageHeader)
				WebUI.setText(usernameField, username)
				WebUI.setText(passwordField, password)
				WebUI.click(loginButton)
				WebUI.verifyMatch(WebUI.getUrl(), dashboardUrl, false)
				isLoginSuccess = true
				break
			}
			else if(currentUrl.equalsIgnoreCase(dashboardUrl)){
				isLoginSuccess = true
				break
			}
			else {
				println "Unable to perform login step. Current URL is "+currentUrl
				loginAttempt++
				WebUI.closeBrowser()
				continue
			}
		}
		if(!isLoginSuccess) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Unable to login into portal exception occurred')
		}
	}

	@Keyword
	def moveToElement(TestObject to) {

		WebElement e = WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
		new javaScript().scrollToElement(to)

		Actions asDriver = new Actions(DriverFactory.getWebDriver())
		asDriver.moveToElement(e).build().perform()
		WebUI.delay(1)
	}

	@Keyword
	def moveToElement(WebElement e) {

		new javaScript().scrollToElement(e)

		Actions asDriver = new Actions(DriverFactory.getWebDriver())
		asDriver.moveToElement(e).build().perform()
		WebUI.delay(1)
	}

	@Keyword
	def verifyElementTextContains(TestObject to, String expectedText) {

		WebUI.verifyMatch(WebUI.getText(to).trim(), RegexUtil.formRegexString(expectedText, RegexOperator.CONTAINS), true)
	}

	@Keyword
	def verifyUrlContains(String expectedText) {

		WebUI.verifyMatch(WebUI.getUrl().trim(), RegexUtil.formRegexString(expectedText, RegexOperator.CONTAINS), true)
	}

	@Keyword
	def shouldFailTest(Map<Fields, String> map) {

		boolean shouldFail = false
		if(map.get(Fields.IS_CREATED).equalsIgnoreCase('false')) {
			shouldFail = true
		}

		if(shouldFail) {
			KeywordUtil.markFailedAndStop('Cannot execute test cases as required data is not created.')
		}
	}

	private boolean isValidData(Map<Fields, String> data, Fields field) {
		if(data.containsKey(field) && StringUtils.isNotBlank(data.get(field))) {
			return true
		}
		else {
			return false
		}
	}

	@Keyword
	def customerFormFill(Map<Fields, String> custData) {

		//Enter First name
		if(isValidData(custData, Fields.CUST_FIRST_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))
		}

		//Enter Middle name
		if(isValidData(custData, Fields.CUST_MIDDLE_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName'), custData.get(Fields.CUST_MIDDLE_NAME))
		}

		//Enter Last name
		if(isValidData(custData, Fields.CUST_LAST_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName'), custData.get(Fields.CUST_LAST_NAME))
		}

		//Enter Date of birth
		if(isValidData(custData, Fields.CUST_DOB)) {
			new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB'), custData.get(Fields.CUST_DOB))
		}

		//Enter Tax ID
		if(isValidData(custData, Fields.CUST_TAX_ID)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID'), custData.get(Fields.CUST_TAX_ID))
		}

		//Select Country of residency
		if(isValidData(custData, Fields.CUST_COUNTRY_OF_RESIDENCE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_CountryOfResidence'), custData.get(Fields.CUST_COUNTRY_OF_RESIDENCE), false)
		}

		//Select Residency status
		if(isValidData(custData, Fields.CUST_RESIDENCY_STATUS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_ResidencyStatus'), custData.get(Fields.CUST_RESIDENCY_STATUS), false)
		}

		//Select Marital status
		if(isValidData(custData, Fields.CUST_MARITAL_STATUS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_MaritalStatus'), custData.get(Fields.CUST_MARITAL_STATUS), false)
		}

		//Scroll to next button
		WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'), GlobalVariable.TIMEOUT)

		//Click on Next button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'))

		//Wait for Location information fields to be visible
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), GlobalVariable.TIMEOUT)

		//Enter Street'
		if(isValidData(custData, Fields.ADDR_STREET)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), custData.get(Fields.ADDR_STREET))
		}

		//Enter City
		if(isValidData(custData, Fields.ADDR_CITY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_City'), custData.get(Fields.ADDR_CITY))
		}

		//Select Country
		if(isValidData(custData, Fields.ADDR_COUNTY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_Country'), custData.get(Fields.ADDR_COUNTY), false)
		}

		//Select State/Region
		if(isValidData(custData, Fields.ADDR_STATE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_StateOrRegion'), custData.get(Fields.ADDR_STATE), false)
		}

		//Enter Zip/Postal Code
		if(isValidData(custData, Fields.ADDR_ZIPCODE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_ZipOrPostalCode'), custData.get(Fields.ADDR_ZIPCODE))
		}

		//Select Address Type
		if(isValidData(custData, Fields.ADDR_ADDRESS_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_AddressType'), custData.get(Fields.ADDR_ADDRESS_TYPE), false)
		}

		//Enter Address Label
		if(isValidData(custData, Fields.ADDR_ADDRESS_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLabel'), custData.get(Fields.ADDR_ADDRESS_LABEL))
		}

		//Scroll to next button
		WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'), GlobalVariable.TIMEOUT)

		//Click on Next button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'))

		//Wait for Contact information fields to be visible
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), GlobalVariable.TIMEOUT)

		//Enter Phone number
		if(isValidData(custData, Fields.CT_PHONE_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))
		}

		//Select Phone type
		if(isValidData(custData, Fields.CT_PHONE_NUMBER)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType'), custData.get(Fields.CT_PHONE_TYPE), false)
		}

		//Enter Email
		if(isValidData(custData, Fields.CT_EMAIL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email'), custData.get(Fields.CT_EMAIL))
		}

		//Select Email type
		if(isValidData(custData, Fields.CT_EMAIL_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType'), custData.get(Fields.CT_EMAIL_TYPE), false)
		}

		//Select Preferred language
		if(isValidData(custData, Fields.CT_PREFERRED_LANGUAGE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredLanguage'), custData.get(Fields.CT_PREFERRED_LANGUAGE), false)
		}

		//Select Preferred contact method
		if(isValidData(custData, Fields.CT_PREFERRED_CONTACT_METHOD)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod'), custData.get(Fields.CT_PREFERRED_CONTACT_METHOD), false)
		}
	}

	@Keyword
	def accountFormFill(Map<Fields, String> accData) {

		//Enter account title
		if(isValidData(accData, Fields.ACC_TITLE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), accData.get(Fields.ACC_TITLE))
		}

		//Select account ownership
		if(isValidData(accData, Fields.ACC_OWNERSHIP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Ownership'), accData.get(Fields.ACC_OWNERSHIP), false)
		}

		//Enter account description
		if(isValidData(accData, Fields.ACC_DESCRIPTION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountDescription'), accData.get(Fields.ACC_DESCRIPTION))
		}

		//Select Account group
		if(isValidData(accData, Fields.ACC_GROUP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_AccountGroup'), accData.get(Fields.ACC_GROUP), false)
		}

		//Wait for Product section to be visible
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'),GlobalVariable.TIMEOUT)

		//Enter account number
		if(isValidData(accData, Fields.ACC_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))
		}

		//Select timezone
		if(isValidData(accData, Fields.ACC_TIMEZONE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Timezone'), accData.get(Fields.ACC_TIMEZONE), false)
		}

		//'Select statement frequency'
		if(isValidData(accData, Fields.ACC_STATEMENT_FREQUENCY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_StatementFrequency'), accData.get(Fields.ACC_STATEMENT_FREQUENCY), false)
		}

		//Select Product Type
		if(isValidData(accData, Fields.ACC_PRODUCT_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), accData.get(Fields.ACC_PRODUCT_TYPE), false)
		}

		//Wait for position name field to load text
		new utils.WaitFor().textNotEmpty(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), GlobalVariable.TIMEOUT)
		WebUI.delay(2)

		//Enter Position name
		if(isValidData(accData, Fields.ACC_POSITION_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), accData.get(Fields.ACC_POSITION_NAME))
		}

		//Enter Currency code
		if(isValidData(accData, Fields.ACC_CURRENCY_CODE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Currency'), accData.get(Fields.ACC_CURRENCY_CODE), false)
		}

		//Enter Vertical
		if(isValidData(accData, Fields.ACC_VERTICAL)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Vertical'), accData.get(Fields.ACC_VERTICAL), false)
		}

		//Enter Department ID
		if(isValidData(accData, Fields.ACC_DEPT_ID)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_DeptId'), accData.get(Fields.ACC_DEPT_ID), false)
		}

		//Enter Credit Limit
		if(isValidData(accData, Fields.ACC_CREDIT_LIMIT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CreditLimit'), accData.get(Fields.ACC_CREDIT_LIMIT))
		}

		//Enter Interest rate
		if(isValidData(accData, Fields.ACC_INTEREST_RATE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_InterestRate'), accData.get(Fields.ACC_INTEREST_RATE))
		}

		//Select Document 1 - Terms and Conditions
		if(isValidData(accData, Fields.DOC_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType1'), accData.get(Fields.DOC_TYPE), false)
		}

		//Enter signed by
		if(isValidData(accData, Fields.DOC_SIGNED_BY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1'), accData.get(Fields.DOC_SIGNED_BY))
		}

		//Enter signed date
		if(isValidData(accData, Fields.DOC_SIGNED_DATE)) {
			new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), accData.get(Fields.DOC_SIGNED_DATE))
		}

		//Enter version
		if(isValidData(accData, Fields.DOC_VERSION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1'), accData.get(Fields.DOC_VERSION))
		}

		//Enter document 2 details if present
		if(isValidData(accData, Fields.DOC_TYPE2)) {

			//Scroll to Add another document link
			WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'), GlobalVariable.TIMEOUT)

			//Click on Add another document link
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'))

			//Wait for new document section to be visible
			new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), GlobalVariable.TIMEOUT)

			//Select Document 2
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), accData.get(Fields.DOC_TYPE2), false)

			//Enter signed by 2
			if(isValidData(accData, Fields.DOC_SIGNED_BY2)) {
				WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy2'), accData.get(Fields.DOC_SIGNED_BY2))
			}

			//Enter signed date 2
			if(isValidData(accData, Fields.DOC_SIGNED_DATE2)) {
				new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate2'), accData.get(Fields.DOC_SIGNED_DATE2))
			}

			//Enter vesion 2
			if(isValidData(accData, Fields.DOC_VERSION2)) {
				WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version2'), accData.get(Fields.DOC_VERSION2))
			}
		}
	}

	@Keyword
	def searchCustomer(Map<Fields, String> custData) {

		//Click on Search All drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

		//Click on Customer option
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

		//Wait for Search button to be visible
		WebUI.delay(3) //TODO: Need to find correct wait condition.
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'), GlobalVariable.TIMEOUT)

		//Enter Search Criteria in last name field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), custData.get(Fields.CUST_LAST_NAME))

		//Enter Search Criteria in First name field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

		//Enter Search Criteria in Tax ID field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_TaxID'), custData.get(Fields.CUST_TAX_ID))

		//Click on Search button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'))

		TestObject resultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

		//Wait for table to be visible
		new utils.WaitFor().elementVisible(resultTable, GlobalVariable.TIMEOUT)

		//Verify result table contains atleast 1 record
		new actions.table().verifyRecordsCount(resultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

		int rowNo = 1

		//Verify column values are matching - last name
		new actions.table().verifyCellValueEquals(resultTable, rowNo, ColumnPos.CUST_LAST_NAME, custData.get(Fields.CUST_LAST_NAME))

		//Verify column values are matching - first name
		new actions.table().verifyCellValueEquals(resultTable, rowNo, ColumnPos.CUST_FIRST_NAME, custData.get(Fields.CUST_FIRST_NAME))
	}

	@Keyword
	def searchCustomerAndOpen(Map<Fields, String> custData, int rowNo = 1) {

		searchCustomer(custData)

		TestObject resultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

		//Click on Last name link in a first row of search result table
		new actions.table().clickCell(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), rowNo, ColumnPos.CUST_LAST_NAME)

		//Wait for Customer details page to load
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

		//Verify Customer name is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))
	}

	@Keyword
	def searchAccount(Map<Fields, String> accData) {

		//Click on Search All drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

		//Click on Accounts option
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

		//Wait for Account Type drop down to be visible
		WebUI.delay(3) //TODO: Need to look for wait conditon
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)

		//Click on accounts type drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT)

		if('Banking'.equalsIgnoreCase(accData.get(Fields.ACC_GROUP))) {
			//Click on Banking option
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Banking'))
		}
		else {
			//Click on Multi- Position option
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_MultiPosition'))
		}

		//Wait for Account number input field to be visible
		WebUI.delay(3) //TODO: Need to look for wait conditon
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)

		//Enter Search Criteria in account number field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

		//Click on Search button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

		//Wait for Account title to be visible
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

		//Verify Account title contains correct account number
		new actions.common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), accData.get(Fields.ACC_NUMBER))
	}

	@Keyword
	def addressFormFill(Map<Fields, String> addressData) {

		'Wait for Add address task drawer to load'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

		'Enter street'
		if(isValidData(addressData, Fields.ADDR_STREET)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), addressData.get(Fields.ADDR_STREET))
		}

		'Enter city'
		if(isValidData(addressData, Fields.ADDR_CITY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_City'), addressData.get(Fields.ADDR_CITY))
		}

		'Select state'
		if(isValidData(addressData, Fields.ADDR_STATE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_State'), addressData.get(Fields.ADDR_STATE), false)
		}

		'Enter Zipcode'
		if(isValidData(addressData, Fields.ADDR_ZIPCODE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Zipcode'), addressData.get(Fields.ADDR_ZIPCODE))
		}

		'Select country'
		if(isValidData(addressData, Fields.ADDR_COUNTY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_Country'), addressData.get(Fields.ADDR_COUNTY), false)
		}

		'Select address type'
		if(isValidData(addressData, Fields.ADDR_ADDRESS_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_AddressType'), addressData.get(Fields.ADDR_ADDRESS_TYPE), false)
		}

		'Enter address label'
		if(isValidData(addressData, Fields.ADDR_ADDRESS_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLabel'), addressData.get(Fields.ADDR_ADDRESS_LABEL))
		}
	}

	@Keyword
	def verifyAddressDetailsInTable(Map<Fields, String> addressData, int rowNo) {

		'Verify Address Type'
		if(isValidData(addressData, Fields.ADDR_ADDRESS_TYPE)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressData.get(Fields.ADDR_ADDRESS_TYPE))
		}

		'Verify Address Label'
		if(isValidData(addressData, Fields.ADDR_ADDRESS_LABEL)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_LABEL, addressData.get(Fields.ADDR_ADDRESS_LABEL))
		}

		'Verify Address Street'
		if(isValidData(addressData, Fields.ADDR_STREET)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_STREET, addressData.get(Fields.ADDR_STREET))
		}

		'Verify Address City'
		if(isValidData(addressData, Fields.ADDR_CITY)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_CITY, addressData.get(Fields.ADDR_CITY))
		}

		'Verify Address Country'
		if(isValidData(addressData, Fields.ADDR_COUNTY)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_COUNTY, addressData.get(Fields.ADDR_COUNTY))
		}

		'Verify Address State'
		if(isValidData(addressData, Fields.ADDR_STATE)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_STATE, addressData.get(Fields.ADDR_STATE))
		}

		'Verify Address Zipcode'
		if(isValidData(addressData, Fields.ADDR_ZIPCODE)) {
			new actions.table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ZIPCODE, addressData.get(Fields.ADDR_ZIPCODE))
		}
	}

	@Keyword
	def phoneFormFill(Map<Fields, String> phoneData) {

		'Wait for Add Phones task drawer to load'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneLabel'), GlobalVariable.TIMEOUT)

		'Enter phone number'
		if(isValidData(phoneData, Fields.CT_PHONE_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneNumber'), phoneData.get(Fields.CT_PHONE_NUMBER))
		}

		'Select phone type'
		if(isValidData(phoneData, Fields.CT_PHONE_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/select_PhoneType'), phoneData.get(Fields.CT_PHONE_TYPE), false)
		}

		'Enter phone label'
		if(isValidData(phoneData, Fields.CT_PHONE_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneLabel'), phoneData.get(Fields.CT_PHONE_LABEL))
		}
	}

	@Keyword
	def verifyPhoneDetailsInTable(Map<Fields, String> phoneData, int rowNo) {

		'Verify Phone Type'
		if(isValidData(phoneData, Fields.CT_PHONE_TYPE)) {
			new actions.table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_TYPE, phoneData.get(Fields.CT_PHONE_TYPE))
		}

		'Verify Phone Label'
		if(isValidData(phoneData, Fields.CT_PHONE_LABEL)) {
			new actions.table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_LABEL, phoneData.get(Fields.CT_PHONE_LABEL))
		}

		'Verify Phone Number'
		if(isValidData(phoneData, Fields.CT_PHONE_NUMBER)) {
			new actions.table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_NUMBER, phoneData.get(Fields.CT_PHONE_NUMBER))
		}
	}

	@Keyword
	def emailFormFill(Map<Fields, String> emailData) {

		'Wait for Add email task drawer to load'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), GlobalVariable.TIMEOUT)

		'Enter Email'
		if(isValidData(emailData, Fields.CT_EMAIL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), emailData.get(Fields.CT_EMAIL))
		}

		'Select Email type'
		if(isValidData(emailData, Fields.CT_EMAIL_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/select_EmailType'), emailData.get(Fields.CT_EMAIL_TYPE), false)
		}

		'Enter Email label'
		if(isValidData(emailData, Fields.CT_EMAIL_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_EmailLabel'), emailData.get(Fields.CT_EMAIL_LABEL))
		}
	}

	@Keyword
	def verifyEmailDetailsInTable(Map<Fields, String> emailData, int rowNo) {

		'Verify Email Type'
		if(isValidData(emailData, Fields.CT_EMAIL_TYPE)) {
			new actions.table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_TYPE, emailData.get(Fields.CT_EMAIL_TYPE))
		}

		'Verify Email Label'
		if(isValidData(emailData, Fields.CT_EMAIL_LABEL)) {
			new actions.table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_LABEL, emailData.get(Fields.CT_EMAIL_LABEL))
		}

		'Verify Email'
		if(isValidData(emailData, Fields.CT_EMAIL)) {
			new actions.table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL, emailData.get(Fields.CT_EMAIL))
		}
	}

	@Keyword
	def documentFormFill(Map<Fields, String> documentData) {

		'Wait for Task drawer to load'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

		'Upload file'
		//CustomKeywords.'actions.File.upload'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), docData.get(Fields.DOCUMENT_FILEPATH))
		new actions.File().uploadAutoIt(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), documentData.get(Fields.DOCUMENT_FILEPATH))

		'Wait for Uploaded file name to be visible'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/lbl_FileNameAfterUpload'), GlobalVariable.TIMEOUT)

		'Select doc class'
		if(isValidData(documentData, Fields.DOCUMENT_CLASS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), documentData.get(Fields.DOCUMENT_CLASS), false)
		}

		'Wait for doc type field to be editable'
		new utils.WaitFor().elementClickable(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), GlobalVariable.TIMEOUT)

		'Select doc type'
		if(isValidData(documentData, Fields.DOCUMENT_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), documentData.get(Fields.DOCUMENT_TYPE), false)
		}

		'Enter start date'
		if(isValidData(documentData, Fields.DOCUMENT_START_DATE)) {
			new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_StartDate'), documentData.get(Fields.DOCUMENT_START_DATE))
		}

		'Enter end date'
		if(isValidData(documentData, Fields.DOCUMENT_END_DATE)) {
			new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_EndDate'), documentData.get(Fields.DOCUMENT_END_DATE))
		}

		'Enter received date'
		if(isValidData(documentData, Fields.DOCUMENT_RECEIVED_DATE)) {
			new actions.javaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_ReceivedDate'), documentData.get(Fields.DOCUMENT_RECEIVED_DATE))
		}

		'Select status'
		if(isValidData(documentData, Fields.DOCUMENT_STATUS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_Status'), documentData.get(Fields.DOCUMENT_STATUS), false)
		}

		'Enter description'
		if(isValidData(documentData, Fields.DOCUMENT_DESCRIPTION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_Description'), documentData.get(Fields.DOCUMENT_DESCRIPTION))
		}
	}

	@Keyword
	def verifyDocumentDetailsInTable(Map<Fields, String> documentData, Map<Fields, String> customerData, int rowNo) {

		'Verify Doc Class value'
		new actions.table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_CLASS, documentData.get(Fields.DOCUMENT_CLASS), WebTable.DOCUMENT)

		'Verify Doc Type value'
		new actions.table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_TYPE, documentData.get(Fields.DOCUMENT_TYPE), WebTable.DOCUMENT)

		'Verify Doc description value'
		new actions.table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_DESCRIPTION, documentData.get(Fields.DOCUMENT_DESCRIPTION), WebTable.DOCUMENT)

		'Verify Customer ID value'
		new actions.table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_CUSTOMER_ID, customerData.get(Fields.CUST_CUSTOMER_ID), WebTable.DOCUMENT)

		'Verify Status value'
		new actions.table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_STATUS, documentData.get(Fields.DOCUMENT_STATUS), WebTable.DOCUMENT)

	}

	@Keyword
	def selectTaskFromTaskList(String taskName) {

		'Scroll to Tasks button'
		moveToElement(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_Tasks'))

		'Select Tasks button'
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_Tasks'))

		'Wait for task drawer to load'
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/section_TaskLists'), GlobalVariable.TIMEOUT)

		TestObject taskItem = findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_TaskItem', , ['taskName' : taskName])

		'Scroll to Task Item'
		moveToElement(taskItem)

		'Click on Task Item'
		WebUI.click(taskItem)
	}
}
