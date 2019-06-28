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
import static constants.common.*

import enums.Fields
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

Map<Fields, String> custData = new HashMap<Fields, String>()
custData.put(Fields.CUST_FIRST_NAME, FirstName)
custData.put(Fields.CUST_MIDDLE_NAME, MiddleName)
custData.put(Fields.CUST_LAST_NAME, LastName)
custData.put(Fields.CUST_DOB, DOB)
custData.put(Fields.CUST_TAX_ID, TaxID)
custData.put(Fields.CUST_COUNTRY_OF_RESIDENCE, CountryOfResidence)
custData.put(Fields.CUST_RESIDENCY_STATUS, ResidencyStatus)
custData.put(Fields.CUST_MARITAL_STATUS, MaritalStatus)
custData.put(Fields.CUST_NAME_VIEW, FirstName+' '+LastName)
custData.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' '+Street)
custData.put(Fields.ADDR_CITY, City)
custData.put(Fields.ADDR_COUNTY, Country)
custData.put(Fields.ADDR_STATE, State)
custData.put(Fields.ADDR_ZIPCODE, Zipcode)
custData.put(Fields.ADDR_ADDRESS_TYPE, AddType)
custData.put(Fields.ADDR_ADDRESS_LABEL, AddLabel)
custData.put(Fields.CT_PHONE_NUMBER, PhoneNumber)
custData.put(Fields.CT_PHONE_TYPE, PhoneType)
custData.put(Fields.CT_EMAIL, Email)
custData.put(Fields.CT_EMAIL_TYPE, EmailType)
custData.put(Fields.CT_PREFERRED_LANGUAGE, PreferredLanguage)
custData.put(Fields.CT_PREFERRED_CONTACT_METHOD, PreferredContactMethod)

'Login into portal'
CustomKeywords.'actions.common.login'()

'Navigate to create customer page'
WebUI.navigateToUrl(createCustomerUrl)

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Fill Form'
CustomKeywords.'actions.common.customerFormFill'(custData)

'Scroll to next button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'))

'Wait for review page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Scroll to btn_Next element'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

'Wait for btn Next to be clickable'
WebUI.waitForElementClickable(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'), GlobalVariable.TIMEOUT)

//Submit application.
'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/btn_Next'))

'Wait for next page to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), GlobalVariable.TIMEOUT)

'Enter Member ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), MemberID)

'Select Party or Customer Group'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), CustomerGroup, false)

'Wait for Create new account checkbox to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

'Click on Create button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/btn_Create'))

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))

'Verify Customer phone is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))