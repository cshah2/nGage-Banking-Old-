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
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> data = Data.CUSTOMER_001
println "Customer = "+data.toMapString()

'Login into portal'
CustomKeywords.'actions.common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Create customer icon to be visible'
WebUI.delay(3) //TODO: Need to identify propert wait condition
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Fill form'
CustomKeywords.'actions.common.customerFormFill'(data)

'Scroll to Next button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'))

'Wait for review page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Verify First name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_FirstName'), data.get(Fields.CUST_FIRST_NAME))

'Verify Middle name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MiddleName'), data.get(Fields.CUST_MIDDLE_NAME))

'Verify Last name'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_LastName'), data.get(Fields.CUST_LAST_NAME))

'Verify DOB'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_DOB'), data.get(Fields.CUST_DOB))

'Verify Tax ID'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_TaxID'), data.get(Fields.CUST_TAX_ID))

'Verify Residency'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_CountryOfResidence'), data.get(Fields.CUST_COUNTRY_OF_RESIDENCE))

'Verify Residencey Status'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lblt_ResidencyStatus'), data.get(Fields.CUST_RESIDENCY_STATUS))

'Verify Marital Status'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MaritalStatus'), data.get(Fields.CUST_MARITAL_STATUS))

'Verify Street'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Street'), data.get(Fields.ADDR_STREET))

'Verify City'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_City'), data.get(Fields.ADDR_CITY))

'Verify Country'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Country'), data.get(Fields.ADDR_COUNTY))

'Verify State/Region'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_StateOrRegion'), data.get(Fields.ADDR_STATE))

'Verify Zip/Postal code'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_ZipOrPostalCode'), data.get(Fields.ADDR_ZIPCODE))

'Verify Address Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressType'), data.get(Fields.ADDR_ADDRESS_TYPE))

'Verify Address Label'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressLabel'), data.get(Fields.ADDR_ADDRESS_LABEL))

'Verify Phone Number'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneNumber'), data.get(Fields.CT_PHONE_NUMBER))

'Verify Phone Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneType'), data.get(Fields.CT_PHONE_TYPE))

'Verify Email'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_Email'), data.get(Fields.CT_EMAIL))

'Verify Email Type'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_EmailType'), data.get(Fields.CT_EMAIL_TYPE))

'Verify Preferred Language'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredLanguage'), data.get(Fields.CT_PREFERRED_LANGUAGE))

'Verify Preferred Contact Method'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredContactMethod'), data.get(Fields.CT_PREFERRED_CONTACT_METHOD))

'Scroll to btn_Next element'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Wait for btn Next to be clickable'
WebUI.waitForElementClickable(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

//Submit application.
'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'))

'Wait for next page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), GlobalVariable.TIMEOUT)

'Enter Member ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), data.get(Fields.CUST_MEMBER_ID))

'Select Party or Customer Group'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), data.get(Fields.CUST_CUSTOMER_GROUP), false)

'Wait for Create new account checkbox to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

'Click on Create button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/btn_Create'))

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), data.get(Fields.CUST_NAME_VIEW))

'Verify Customer phone is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), data.get(Fields.CT_PHONE_NUMBER))

'Verify Customer email is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Email'), data.get(Fields.CT_EMAIL))

'Verify Customer address is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Address'), data.get(Fields.ADDR_VIEW))