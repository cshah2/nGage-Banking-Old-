package pages.consumer

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

public class ConsumerTaskDrawer {

	@Keyword
	def selectTask(String taskName) {
	}

	@Keyword
	def addAddressTask(Map<Fields, String> addressData) {

		TestObject e_AddressLine1 = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLine1')
		TestObject e_AddressLine2 = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLine2')
		TestObject e_AddressLine3 = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLine3')
		TestObject e_AddressLine4 = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLine4')
		TestObject e_City = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_City')
		TestObject e_State = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_State')
		TestObject e_Zipcode = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Zipcode')
		TestObject e_Country = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_Country')
		TestObject e_AddressType = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_AddressType')
		TestObject e_YearsAtAddress = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_YearsAtAddress')
		TestObject e_AddressLabel = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLabel')
		TestObject e_Premise = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Premise')
		TestObject e_VerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_VerifiedDate')
		TestObject e_SetValidToFromDates = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/link_SetValidToAndFromDates')
		TestObject e_ValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_ValidFromDate')
		TestObject e_ValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_ValidUntilDate')
		TestObject e_Submit = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/btn_Submit')

		'Wait for Add address task drawer to load'
		new actions.WaitFor().elementVisible(e_AddressLine1, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_AddressLine1, addressData, Fields.ADDR_LINE1)
		new actions.Common().setTextIfNotEmpty(e_AddressLine2, addressData, Fields.ADDR_LINE2)
		new actions.Common().setTextIfNotEmpty(e_AddressLine3, addressData, Fields.ADDR_LINE3)
		new actions.Common().setTextIfNotEmpty(e_AddressLine4, addressData, Fields.ADDR_LINE4)
		new actions.Common().setTextIfNotEmpty(e_City, addressData, Fields.ADDR_CITY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_State, addressData, Fields.ADDR_STATE)
		new actions.Common().setTextIfNotEmpty(e_Zipcode, addressData, Fields.ADDR_ZIPCODE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Country, addressData, Fields.ADDR_COUNTY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AddressType, addressData, Fields.ADDR_ADDRESS_TYPE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_YearsAtAddress, addressData, Fields.ADDR_YEARS_AT_ADDRESS)
		new actions.Common().setTextIfNotEmpty(e_AddressLabel, addressData, Fields.ADDR_ADDRESS_LABEL)
		new actions.Common().setTextIfNotEmpty(e_Premise, addressData, Fields.ADDR_PREMISE)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, addressData, Fields.ADDR_VERIFIED_DATE)

		if(StringUtil.isValidData(addressData, Fields.ADDR_VALID_FROM) || StringUtil.isValidData(addressData, Fields.ADDR_VALID_UNTIL)) {

			new actions.Common().moveToElementAndClick(e_SetValidToFromDates)
			//Wait for date fields to load
			new actions.WaitFor().elementVisible(e_ValidFrom, GlobalVariable.TIMEOUT)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidFrom, addressData, Fields.ADDR_VALID_FROM)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidUntil, addressData, Fields.ADDR_VALID_UNTIL)
		}

		new actions.Common().moveToElementAndClick(e_Submit)
	}
	
	@Keyword
	def addPhoneTask(Map<Fields, String> phoneData) {
		
		TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneNumber')
		TestObject e_PhoneType = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/select_PhoneType')
		TestObject e_PhoneLabel = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneLabel')
		TestObject e_VerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_VerifiedDate')
		TestObject e_SetValidToAndFromDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/link_SetValidToAndFromDates')
		TestObject e_ValidFromDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_ValidFromDate')
		TestObject e_ValidToDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_ValidUntilDate')
		TestObject e_Submit = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/btn_Submit')
		
		//Wait for task drawer to load
		new actions.WaitFor().elementVisible(e_PhoneNumber, GlobalVariable.TIMEOUT)
		
		new actions.Common().setTextIfNotEmpty(e_PhoneNumber, phoneData, Fields.CT_PHONE_NUMBER)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PhoneType, phoneData, Fields.CT_PHONE_TYPE)
		new actions.Common().setTextIfNotEmpty(e_PhoneLabel, phoneData, Fields.CT_PHONE_LABEL)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, phoneData, Fields.CT_PHONE_VERIFIED_DATE)
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_VALID_FROM) || StringUtil.isValidData(phoneData, Fields.CT_PHONE_VALID_UNTIL)) {
			
			new actions.Common().moveToElementAndClick(e_SetValidToAndFromDate)
			
			//Wait for date fields to load
			new actions.WaitFor().elementVisible(e_ValidFromDate, GlobalVariable.TIMEOUT)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidFromDate, phoneData, Fields.CT_PHONE_VALID_FROM)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidToDate, phoneData, Fields.CT_PHONE_VALID_UNTIL)
		}
		
		new actions.Common().moveToElementAndClick(e_Submit)
	}
	
	@Keyword
	def addEmailTask(Map<Fields, String> emailData) {
		
		TestObject e_EmailAddress = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email')
		TestObject e_EmailType = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/select_EmailType')
		TestObject e_EmailLabel = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_EmailLabel')
		TestObject e_VerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_VerifiedDate')
		TestObject e_SetValidToAndFromDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/link_SetValidToAndFromDates')
		TestObject e_ValidFromDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_ValidFromDate')
		TestObject e_ValidToDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_ValidUntilDate')
		TestObject e_Submit = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/btn_Submit')
		
		//Wait for task drawer to load
		new actions.WaitFor().elementVisible(e_EmailAddress, GlobalVariable.TIMEOUT)
		
		new actions.Common().setTextIfNotEmpty(e_EmailAddress, emailData, Fields.CT_EMAIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_EmailType, emailData, Fields.CT_EMAIL_TYPE)
		new actions.Common().setTextIfNotEmpty(e_EmailLabel, emailData, Fields.CT_EMAIL_LABEL)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, emailData, Fields.CT_EMAIL_VERIFIED_DATE)
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL_VALID_FROM) || StringUtil.isValidData(emailData, Fields.CT_EMAIL_VALID_UNTIL)) {
			
			new actions.Common().moveToElementAndClick(e_SetValidToAndFromDate)
			
			//Wait for date fields to load
			new actions.WaitFor().elementVisible(e_ValidFromDate, GlobalVariable.TIMEOUT)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidFromDate, emailData, Fields.CT_EMAIL_VALID_FROM)
			new actions.Common().setTextJQueryIfNotEmpty(e_ValidToDate, emailData, Fields.CT_EMAIL_VALID_UNTIL)
		}
		
		new actions.Common().moveToElementAndClick(e_Submit)
	}

}
