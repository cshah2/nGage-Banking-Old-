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

'Login into portal'
CustomKeywords.'actions.common.login'()

'Navigate to create customer page'
WebUI.navigateToUrl(createCustomerUrl)

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Enter First name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), FirstName)

'Enter Middle name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName'), MiddleName)

'Enter Last name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName'), LastName)

'Enter Date of birth'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB'), DOB)

'Enter Tax ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID'), TaxID)

'Select Country of residency'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_CountryOfResidence'), CountryOfResidence, false)

'Select Residency status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_ResidencyStatus'), ResidencyStatus, false)

'Select Marital status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_MaritalStatus'), MaritalStatus, false)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'))

'Wait for Location information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), GlobalVariable.TIMEOUT)

'Enter Street'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' '+Street)

'Enter City'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_City'), City)

'Select Country'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_Country'), Country, false)

'Select State/Region'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_StateOrRegion'), State, false)

'Enter Zip/Postal Code'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_ZipOrPostalCode'), Zipcode)

'Select Address Type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_AddressType'), AddType, false)

'Enter Address Label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLabel'), AddLabel)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'))

'Wait for Contact information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), GlobalVariable.TIMEOUT)

'Enter Phone number'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), PhoneNumber)

'Select Phone type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType'), PhoneType, false)

'Enter Email'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email'), Email)

'Select Email type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType'), EmailType, false)

'Select Preferred language'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredLanguage'), PreferredLanguage, false)

'Select Preferred contact method'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod'), PreferredContactMethod, false)

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
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), GlobalVariable.TIMEOUT)

'Enter Member ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_MemberId'), MemberID)

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
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), FirstName+' '+LastName)

'Verify Customer phone is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), PhoneNumber)