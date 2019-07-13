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
CustomKeywords.'actions.Common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Create customer icon to be visible'
WebUI.delay(3) //TODO: Need to identify propert wait condition
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Fill form'
CustomKeywords.'actions.Common.customerFormFill'(custData)

'Scroll to Next button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'))

'Wait for review page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Verify First name'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

'Verify Middle name'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MiddleName'), custData.get(Fields.CUST_MIDDLE_NAME))

'Verify Last name'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_LastName'), custData.get(Fields.CUST_LAST_NAME))

'Verify DOB'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_DOB'), custData.get(Fields.CUST_DOB))

'Verify Tax ID'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_TaxID'), custData.get(Fields.CUST_TAX_ID))

'Verify Residency'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_CountryOfResidence'), custData.get(Fields.CUST_COUNTRY_OF_RESIDENCE))

'Verify Residencey Status'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lblt_ResidencyStatus'), custData.get(Fields.CUST_RESIDENCY_STATUS))

'Verify Marital Status'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MaritalStatus'), custData.get(Fields.CUST_MARITAL_STATUS))

'Verify Street'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Street'), custData.get(Fields.ADDR_STREET))

'Verify City'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_City'), custData.get(Fields.ADDR_CITY))

'Verify Country'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Country'), custData.get(Fields.ADDR_COUNTY))

'Verify State/Region'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_StateOrRegion'), custData.get(Fields.ADDR_STATE))

'Verify Zip/Postal code'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_ZipOrPostalCode'), custData.get(Fields.ADDR_ZIPCODE))

'Verify Address Type'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressType'), custData.get(Fields.ADDR_ADDRESS_TYPE))

'Verify Address Label'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressLabel'), custData.get(Fields.ADDR_ADDRESS_LABEL))

'Verify Phone Number'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))

'Verify Phone Type'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneType'), custData.get(Fields.CT_PHONE_TYPE))

'Verify Email'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_Email'), custData.get(Fields.CT_EMAIL))

'Verify Email Type'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_EmailType'), custData.get(Fields.CT_EMAIL_TYPE))

'Verify Preferred Language'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredLanguage'), custData.get(Fields.CT_PREFERRED_LANGUAGE))

'Verify Preferred Contact Method'
CustomKeywords.'actions.Common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredContactMethod'), custData.get(Fields.CT_PREFERRED_CONTACT_METHOD))

'Scroll to btn_Next element'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Wait for btn Next to be clickable'
WebUI.waitForElementClickable(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

//Submit application.
'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'))

'Wait for next page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), GlobalVariable.TIMEOUT)

'Enter Member ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), custData.get(Fields.CUST_CUSTOMER_ID))

'Select Party or Customer Group'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), custData.get(Fields.CUST_CUSTOMER_GROUP), false)

'Wait for Create new account checkbox to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

'Click on Create new account checkbox'
WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'))

'Click on Create button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/btn_Create'))

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify Add new account page is loaded'
CustomKeywords.'actions.Common.verifyUrlContains'('AccountMainFlow.AccountCreate.aspx')

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
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), GlobalVariable.TIMEOUT)

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, RegexOperator.EQUALS)

'Verify Correct account number is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

'Verify Correct account title is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_TITLE, accData.get(Fields.ACC_TITLE))

'Verify Correct account open date is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_OPEN_DATE, accData.get(Fields.ACC_OPEN_DATE))

'Verify Correct account description is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_DESCRIPTION, accData.get(Fields.ACC_DESCRIPTION))

'Verify Correct account ledger balance is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_LEDGER_BALANCE, accData.get(Fields.ACC_LEDGER_BALANCE))

'Verify Correct account availble balance is displayed in grid'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), 1, ColumnPos.ACC_AVAILABLE_BALANCE, accData.get(Fields.ACC_AVAILABLE_BALANCE))

'Set data flags'
Data.ACCOUNT_001.put(Fields.IS_CREATED, 'true')