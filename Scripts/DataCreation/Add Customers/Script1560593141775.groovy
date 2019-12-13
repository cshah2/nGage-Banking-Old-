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
import pages.CustomerPage
import utils.DateUtil

Map<Fields, String> custData = new HashMap<Fields, String>()
//Basic Information
custData.put(Fields.CUST_FIRST_NAME, FirstName)
custData.put(Fields.CUST_LAST_NAME, LastName)
custData.put(Fields.CUST_DOB, DOB)
custData.put(Fields.CUST_TAX_ID, TaxID)
custData.put(Fields.CUST_COUNTRY_OF_RESIDENCE, CountryOfResidence)
custData.put(Fields.CUST_RESIDENCY_STATUS, ResidencyStatus)

//Consumer details
custData.put(Fields.CUST_MOTHERS_MAIDEN_NAME, MotherMaidenName)

//Location information
custData.put(Fields.ADDR_LINE1, AddressLine1)
custData.put(Fields.ADDR_CITY, City)
custData.put(Fields.ADDR_COUNTY, Country)
custData.put(Fields.ADDR_STATE, State)
custData.put(Fields.ADDR_ZIPCODE, Zipcode)

//Contact information
custData.put(Fields.CT_PHONE_NUMBER, PhoneNumber)
custData.put(Fields.CT_EMAIL, Email)

//Consumer Information
custData.put(Fields.CUST_CUSTOMER_ID, CustomerID)
custData.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')

//Create Account flag
custData.put(Fields.CUST_CHK_ACCOUNT, 'false')

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Navigate to create customer page'
WebUI.navigateToUrl(createCustomerUrl)

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Fill Form'
CustomKeywords.'actions.Common.customerFormFill'(custData)

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')