package pages.consumer.tabs

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

import constants.ColumnPos
import enums.Fields
import internal.GlobalVariable
import utils.StringUtil

public class ContactDetailsTab {

	@Keyword
	def verifyConsumerAddressDataInTable(Map<Fields, String> addressData, int rowNo) {

		TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')
		'Verify Address Type'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_TYPE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressData.get(Fields.ADDR_ADDRESS_TYPE))
		}

		'Verify Address Label'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_LABEL)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_LABEL, addressData.get(Fields.ADDR_ADDRESS_LABEL))
		}

		'Verify Address Line 1'
		if(StringUtil.isValidData(addressData, Fields.ADDR_LINE1)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_LINE1, addressData.get(Fields.ADDR_LINE1))
		}

		'Verify Address Line 2'
		if(StringUtil.isValidData(addressData, Fields.ADDR_LINE2)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_LINE2, addressData.get(Fields.ADDR_LINE2))
		}


		'Verify Address City'
		if(StringUtil.isValidData(addressData, Fields.ADDR_CITY)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_CITY, addressData.get(Fields.ADDR_CITY))
		}

		'Verify Address State'
		if(StringUtil.isValidData(addressData, Fields.ADDR_STATE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_STATE, addressData.get(Fields.ADDR_STATE))
		}

		'Verify Address Zipcode'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ZIPCODE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ZIPCODE, addressData.get(Fields.ADDR_ZIPCODE))
		}

		'Verify Address Country'
		if(StringUtil.isValidData(addressData, Fields.ADDR_COUNTY)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_COUNTY, addressData.get(Fields.ADDR_COUNTY))
		}

		'Verify Address Valid from date'
		if(StringUtil.isValidData(addressData, Fields.ADDR_VALID_FROM)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_VALID_FROM, addressData.get(Fields.ADDR_VALID_FROM))
		}

		'Verify Address Valid until date'
		if(StringUtil.isValidData(addressData, Fields.ADDR_VALID_UNTIL)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_VALID_UNTIL, addressData.get(Fields.ADDR_VALID_UNTIL))
		}

		'Verify Address Verified date'
		if(StringUtil.isValidData(addressData, Fields.ADDR_VERIFIED_DATE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_VERIFIED_DATE, addressData.get(Fields.ADDR_VERIFIED_DATE))
		}
	}


	@Keyword
	def verifyConsumerPhoneDataInTable(Map<Fields, String> phoneData, int rowNo) {

		TestObject phoneTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones')

		'Scroll to the table'
		new actions.Common().moveToElement(phoneTable)

		'Verify Phone Type'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_TYPE)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_TYPE, phoneData.get(Fields.CT_PHONE_TYPE))
		}

		'Verify Phone Label'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_LABEL)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_LABEL, phoneData.get(Fields.CT_PHONE_LABEL))
		}

		'Verify Phone Number'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_NUMBER)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_NUMBER, phoneData.get(Fields.CT_PHONE_NUMBER))
		}

		'Verify Valid From Date'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_VALID_FROM)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_VALID_FROM, phoneData.get(Fields.CT_PHONE_VALID_FROM))
		}

		'Verify Valid To Date'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_VALID_UNTIL)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_VALID_UNTIL, phoneData.get(Fields.CT_PHONE_VALID_UNTIL))
		}

		'Verify Verified date'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_VERIFIED_DATE)) {
			new actions.Table().verifyCellValueEquals(phoneTable, rowNo, ColumnPos.CT_PHONE_VERIFIED_DATE, phoneData.get(Fields.CT_PHONE_VERIFIED_DATE))
		}
	}

	@Keyword
	def verifyConsumerEmailDataInTable(Map<Fields, String> emailData, int rowNo) {
		
		TestObject emailTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails')

		'Scroll to Emails table'
		WebUI.scrollToElement(emailTable, GlobalVariable.TIMEOUT)
		
		'Verify Email Type'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL_TYPE)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_TYPE, emailData.get(Fields.CT_EMAIL_TYPE))
		}

		'Verify Email Label'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL_LABEL)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_LABEL, emailData.get(Fields.CT_EMAIL_LABEL))
		}

		'Verify Email'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL, emailData.get(Fields.CT_EMAIL))
		}
		
		'Verify Valid From Date'
		if(StringUtil.isValidData(emailTable, Fields.CT_EMAIL_VALID_FROM)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_VALID_FROM, emailData.get(Fields.CT_EMAIL_VALID_FROM))
		}

		'Verify Valid To Date'
		if(StringUtil.isValidData(emailTable, Fields.CT_EMAIL_VALID_UNTIL)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_VALID_UNTIL, emailData.get(Fields.CT_EMAIL_VALID_UNTIL))
		}

		'Verify Verified date'
		if(StringUtil.isValidData(emailTable, Fields.CT_EMAIL_VERIFIED_DATE)) {
			new actions.Table().verifyCellValueEquals(emailTable, rowNo, ColumnPos.CT_EMAIL_VERIFIED_DATE, emailData.get(Fields.CT_EMAIL_VERIFIED_DATE))
		}
	}
}
