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
import utils.RegexUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData = Data.ACCOUNT_001
println "Customer002 = "+custData.toMapString()
println "Account001 = "+accData.toMapString()

'Login into portal'
CustomKeywords.'actions.common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Create customer icon to be visible'
WebUI.delay(2) //TODO: Need to identify propert wait condition
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Enter First name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

'Enter Middle name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName'), custData.get(Fields.CUST_MIDDLE_NAME))

'Enter Last name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName'), custData.get(Fields.CUST_LAST_NAME))

'Enter Date of birth'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB'), custData.get(Fields.CUST_DOB))

'Enter Tax ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID'), custData.get(Fields.CUST_TAX_ID))

'Select Country of residency'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_CountryOfResidence'), custData.get(Fields.CUST_COUNTRY_OF_RESIDENCE), false)

'Select Residency status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_ResidencyStatus'), custData.get(Fields.CUST_RESIDENCY_STATUS), false)

'Select Marital status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_MaritalStatus'), custData.get(Fields.CUST_MARITAL_STATUS), false)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'))

'Wait for Location information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), GlobalVariable.TIMEOUT)

'Enter Street'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), custData.get(Fields.ADDR_STREET))

'Enter City'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_City'), custData.get(Fields.ADDR_CITY))

'Select Country'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_Country'), custData.get(Fields.ADDR_COUNTY), false)

'Select State/Region'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_StateOrRegion'), custData.get(Fields.ADDR_STATE), false)

'Enter Zip/Postal Code'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_ZipOrPostalCode'), custData.get(Fields.ADDR_ZIPCODE))

'Select Address Type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_AddressType'), custData.get(Fields.ADDR_ADDRESS_TYPE), false)

'Enter Address Label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLabel'), custData.get(Fields.ADDR_ADDRESS_LABEL))

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'))

'Wait for Contact information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), GlobalVariable.TIMEOUT)

'Enter Phone number'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))

'Select Phone type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType'), custData.get(Fields.CT_PHONE_TYPE), false)

'Enter Email'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email'), custData.get(Fields.CT_EMAIL))

'Select Email type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType'), custData.get(Fields.CT_EMAIL_TYPE), false)

'Select Preferred language'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredLanguage'), custData.get(Fields.CT_PREFERRED_LANGUAGE), false)

'Select Preferred contact method'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod'), custData.get(Fields.CT_PREFERRED_CONTACT_METHOD), false)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'))

'Wait for review page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Verify First name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

'Verify Middle name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MiddleName'), custData.get(Fields.CUST_MIDDLE_NAME))

'Verify Last name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_LastName'), custData.get(Fields.CUST_LAST_NAME))

'Verify DOB'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_DOB'), custData.get(Fields.CUST_DOB))

'Verify Tax ID'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_TaxID'), custData.get(Fields.CUST_TAX_ID))

'Verify Residency' //TODO: Bug - Country is shown as 2 digit value
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_CountryOfResidence'), 'US')

'Verify Residencey Status'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lblt_ResidencyStatus'), custData.get(Fields.CUST_RESIDENCY_STATUS))

'Verify Marital Status'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MaritalStatus'), custData.get(Fields.CUST_MARITAL_STATUS))

'Verify Street'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Street'), custData.get(Fields.ADDR_STREET))

'Verify City'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_City'), custData.get(Fields.ADDR_CITY))

'Verify Country' //TODO: Bug - County is shown as 2 digit value
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Country'), 'US')

'Verify State/Region' //TODO: Bug - County is shown as 2 digit value
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_StateOrRegion'), 'PA')

'Verify Zip/Postal code'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_ZipOrPostalCode'), custData.get(Fields.ADDR_ZIPCODE))

'Verify Address Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressType'), custData.get(Fields.ADDR_ADDRESS_TYPE))

'Verify Address Label'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressLabel'), custData.get(Fields.ADDR_ADDRESS_LABEL))

'Verify Phone Number'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))

'Verify Phone Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneType'), custData.get(Fields.CT_PHONE_TYPE))

'Verify Email'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_Email'), custData.get(Fields.CT_EMAIL))

'Verify Email Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_EmailType'), custData.get(Fields.CT_EMAIL_TYPE))

'Verify Preferred Language'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredLanguage'), custData.get(Fields.CT_PREFERRED_LANGUAGE))

'Verify Preferred Contact Method'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredContactMethod'), custData.get(Fields.CT_PREFERRED_CONTACT_METHOD))

//Submit application.
'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'))

'Wait for next page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), GlobalVariable.TIMEOUT)

'Enter Member ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), custData.get(Fields.CUST_MEMBER_ID))

'Select Party or Customer Group'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), custData.get(Fields.CUST_CUSTOMER_GROUP), false)

'Wait for Create new account checkbox to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

'Click on Create new account checkbox'
WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'))

'Click on Create button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/btn_Create'))

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify Add new account page is loaded'
CustomKeywords.'actions.common.verifyUrlContains'('AccountMainFlow.AccountCreate.aspx')

'Set data flag'
Data.CUSTOMER_002.put(Fields.IS_CREATED, 'true')

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))

'Verify Customer phone is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))

'Verify Customer email is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Email'), custData.get(Fields.CT_EMAIL))

'Verify Customer address is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Address'), custData.get(Fields.ADDR_VIEW))

//Add account info
'Verify Default value present in account title'
WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), 'value', custData.get(Fields.CUST_NAME_VIEW), GlobalVariable.TIMEOUT)

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
WebUI.delay(2) //TODO: Need to wait for effective condition
WebUI.waitForJQueryLoad(GlobalVariable.TIMEOUT)

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
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1'), custData.get(Fields.CUST_NAME_VIEW))

'Enter signed date'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), accData.get(Fields.DOC_SIGNED_DATE))

'Enter vesion'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1'), accData.get(Fields.DOC_VERSION))

'Click on OK button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Ok'))

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
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, RegexOperator.EQUALS)

'Verify Correct account number is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

'Verify Correct account title is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_TITLE, accData.get(Fields.ACC_TITLE))

'Verify Correct account open date is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_OPEN_DATE, accData.get(Fields.ACC_OPEN_DATE))

'Verify Correct account description is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_DESCRIPTION, accData.get(Fields.ACC_DESCRIPTION))

'Verify Correct account ledger balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_LEDGER_BALANCE, accData.get(Fields.ACC_LEDGER_BALANCE))

'Verify Correct account availble balance is displayed in grid'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_AVAILABLE_BALANCE, accData.get(Fields.ACC_AVAILABLE_BALANCE))

'Set data flags'
Data.ACCOUNT_001.put(Fields.IS_CREATED, 'true')