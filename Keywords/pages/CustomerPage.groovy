package pages

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
import enums.WebTable
import internal.GlobalVariable
import utils.StringUtil

public class CustomerPage {

	static def fillCustomerDetails(Map<Fields, String> custData) {

		//Enter Prefix
		if(StringUtil.isValidData(custData, Fields.CUST_PREFIX)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Prefix'), custData.get(Fields.CUST_PREFIX))
		}

		//Enter First name
		if(StringUtil.isValidData(custData, Fields.CUST_FIRST_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))
		}

		//Enter Middle name
		if(StringUtil.isValidData(custData, Fields.CUST_MIDDLE_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName'), custData.get(Fields.CUST_MIDDLE_NAME))
		}

		//Enter Last name
		if(StringUtil.isValidData(custData, Fields.CUST_LAST_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName'), custData.get(Fields.CUST_LAST_NAME))
		}

		//Enter Suffix
		if(StringUtil.isValidData(custData, Fields.CUST_SUFFIX)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Suffix'), custData.get(Fields.CUST_SUFFIX))
		}

		//Enter Date of birth
		if(StringUtil.isValidData(custData, Fields.CUST_DOB)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB'), custData.get(Fields.CUST_DOB))
		}

		//Enter Tax ID
		if(StringUtil.isValidData(custData, Fields.CUST_TAX_ID)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID'), custData.get(Fields.CUST_TAX_ID))
		}

		//Select Country of residency
		if(StringUtil.isValidData(custData, Fields.CUST_COUNTRY_OF_RESIDENCE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_CountryOfResidence'), custData.get(Fields.CUST_COUNTRY_OF_RESIDENCE), false)
		}

		//Select Residency status
		if(StringUtil.isValidData(custData, Fields.CUST_RESIDENCY_STATUS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_ResidencyStatus'), custData.get(Fields.CUST_RESIDENCY_STATUS), false)
		}

		//		//Select Marital status
		//		if(StringUtil.isValidData(custData, Fields.CUST_MARITAL_STATUS)) {
		//			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_MaritalStatus'), custData.get(Fields.CUST_MARITAL_STATUS), false)
		//		}

		//Move to Next button
		new actions.Common().moveToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'))

		//Click on Next button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/btn_Next'))

		//Wait for Location information fields to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), GlobalVariable.TIMEOUT)

		//Enter Street'
		if(StringUtil.isValidData(custData, Fields.ADDR_STREET)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street'), custData.get(Fields.ADDR_STREET))
		}

		//Enter City
		if(StringUtil.isValidData(custData, Fields.ADDR_CITY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_City'), custData.get(Fields.ADDR_CITY))
		}

		//Select Country
		if(StringUtil.isValidData(custData, Fields.ADDR_COUNTY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_Country'), custData.get(Fields.ADDR_COUNTY), false)
		}

		//Select State/Region
		if(StringUtil.isValidData(custData, Fields.ADDR_STATE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_StateOrRegion'), custData.get(Fields.ADDR_STATE), false)
		}

		//Enter Zip/Postal Code
		if(StringUtil.isValidData(custData, Fields.ADDR_ZIPCODE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_ZipOrPostalCode'), custData.get(Fields.ADDR_ZIPCODE))
		}

		//Select Address Type
		if(StringUtil.isValidData(custData, Fields.ADDR_ADDRESS_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_AddressType'), custData.get(Fields.ADDR_ADDRESS_TYPE), false)
		}

		//Enter Address Label
		if(StringUtil.isValidData(custData, Fields.ADDR_ADDRESS_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLabel'), custData.get(Fields.ADDR_ADDRESS_LABEL))
		}

		//Scroll to next button
		new actions.Common().moveToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'))

		//Click on Next button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/btn_Next'))

		//Wait for Contact information fields to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), GlobalVariable.TIMEOUT)

		//Enter Phone number
		if(StringUtil.isValidData(custData, Fields.CT_PHONE_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber'), custData.get(Fields.CT_PHONE_NUMBER))
		}

		//Select Phone type
		if(StringUtil.isValidData(custData, Fields.CT_PHONE_NUMBER)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType'), custData.get(Fields.CT_PHONE_TYPE), false)
		}

		//Enter Email
		if(StringUtil.isValidData(custData, Fields.CT_EMAIL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email'), custData.get(Fields.CT_EMAIL))
		}

		//Select Email type
		if(StringUtil.isValidData(custData, Fields.CT_EMAIL_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType'), custData.get(Fields.CT_EMAIL_TYPE), false)
		}

		//Select Preferred language
		if(StringUtil.isValidData(custData, Fields.CT_PREFERRED_LANGUAGE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredLanguage'), custData.get(Fields.CT_PREFERRED_LANGUAGE), false)
		}

		//Select Preferred contact method
		if(StringUtil.isValidData(custData, Fields.CT_PREFERRED_CONTACT_METHOD)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod'), custData.get(Fields.CT_PREFERRED_CONTACT_METHOD), false)
		}
		
		//Click on Next button
		new actions.Common().moveToElementAndClick(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/btn_Next'))
		
		//Wait for Customer ID and Group field to load
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), GlobalVariable.TIMEOUT)

		//Enter Customer ID
		if(StringUtil.isValidData(custData, Fields.CUST_CUSTOMER_ID)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), custData.get(Fields.CUST_CUSTOMER_ID))
		}

		//Select Party or Customer Group
		if(StringUtil.isValidData(custData, Fields.CUST_CUSTOMER_GROUP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), custData.get(Fields.CUST_CUSTOMER_GROUP), false)
		}

		//Wait for Create new account checkbox to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

		//Click on Create Account checkbox
		if(StringUtil.isValidData(custData, Fields.CUST_CHK_ACCOUNT)) {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'))
		}
	}

	@Deprecated //Function no longer required as Page is not being shown
	static def verifyCustomerDetailsOnReviewPage(Map<Fields, String> data) {

		//Wait for review page to load
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_FirstName'), GlobalVariable.TIMEOUT)

		//Verify Prefix
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_Prefix'), data.get(Fields.CUST_PREFIX))

		//Verify First name
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_FirstName'), data.get(Fields.CUST_FIRST_NAME))

		//Verify Middle name'
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MiddleName'), data.get(Fields.CUST_MIDDLE_NAME))

		//Verify Last name
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_LastName'), data.get(Fields.CUST_LAST_NAME))

		//Verify Suffix
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_Suffix'), data.get(Fields.CUST_SUFFIX))

		//Verify DOB
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_DOB'), data.get(Fields.CUST_DOB))

		//Verify Tax ID
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_TaxID'), data.get(Fields.CUST_TAX_ID))

		//Verify Residency
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_CountryOfResidence'), data.get(Fields.CUST_COUNTRY_OF_RESIDENCE))

		//Verify Residencey Status
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_ResidencyStatus'), data.get(Fields.CUST_RESIDENCY_STATUS))

		//		//Verify Marital Status
		//		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Basic Information/lbl_MaritalStatus'), data.get(Fields.CUST_MARITAL_STATUS))

		//Verify Street
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Street'), data.get(Fields.ADDR_STREET))

		//Verify City
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_City'), data.get(Fields.ADDR_CITY))

		//Verify Country
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_Country'), data.get(Fields.ADDR_COUNTY))

		//Verify State/Region
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_StateOrRegion'), data.get(Fields.ADDR_STATE))

		//Verify Zip/Postal code
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_ZipOrPostalCode'), data.get(Fields.ADDR_ZIPCODE))

		//Verify Address Type
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressType'), data.get(Fields.ADDR_ADDRESS_TYPE))

		//Verify Address Label
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Location Information/lbl_AddressLabel'), data.get(Fields.ADDR_ADDRESS_LABEL))

		//Verify Phone Number
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneNumber'), data.get(Fields.CT_PHONE_NUMBER))

		//Verify Phone Type
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PhoneType'), data.get(Fields.CT_PHONE_TYPE))

		//Verify Email
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_Email'), data.get(Fields.CT_EMAIL))

		//Verify Email Type
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_EmailType'), data.get(Fields.CT_EMAIL_TYPE))

		//Verify Preferred Language
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredLanguage'), data.get(Fields.CT_PREFERRED_LANGUAGE))

		//Verify Preferred Contact Method
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Review Customer Page/Contact Information/lbl_PreferredContactMethod'), data.get(Fields.CT_PREFERRED_CONTACT_METHOD))
	}

	@Deprecated //Function no longer required as Steps are moved to Create customer function
	static def fillCustomerIdAndGroupDetails(Map<Fields, String> data) {

		//Wait for Customer ID and Group field to load
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), GlobalVariable.TIMEOUT)

		//Enter Customer ID
		if(StringUtil.isValidData(data, Fields.CUST_CUSTOMER_ID)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId'), data.get(Fields.CUST_CUSTOMER_ID))
		}

		//Select Party or Customer Group
		if(StringUtil.isValidData(data, Fields.CUST_CUSTOMER_GROUP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup'), data.get(Fields.CUST_CUSTOMER_GROUP), false)
		}

		//Wait for Create new account checkbox to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'), GlobalVariable.TIMEOUT)

		//Click on Create Account checkbox
		if(StringUtil.isValidData(data, Fields.CUST_CHK_ACCOUNT)) {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount'))
		}
	}

	static def verifyCustomerDetailsSummarySection(Map<Fields, String> data) {

		//Wait for Customer details page to load
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

		//Verify Customer name is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), data.get(Fields.CUST_NAME_VIEW))

		//Verify Customer phone is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), data.get(Fields.CT_PHONE_NUMBER))

		//Verify Customer email is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Email'), data.get(Fields.CT_EMAIL))

		//Verify Customer address is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Address'), data.get(Fields.ADDR_VIEW))
	}


	static def fillAddressDetails(Map<Fields, String> addressData) {

		'Wait for Add address task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

		'Enter street'
		if(StringUtil.isValidData(addressData, Fields.ADDR_STREET)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), addressData.get(Fields.ADDR_STREET))
		}

		'Enter city'
		if(StringUtil.isValidData(addressData, Fields.ADDR_CITY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_City'), addressData.get(Fields.ADDR_CITY))
		}

		'Select state'
		if(StringUtil.isValidData(addressData, Fields.ADDR_STATE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_State'), addressData.get(Fields.ADDR_STATE), false)
		}

		'Enter Zipcode'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ZIPCODE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Zipcode'), addressData.get(Fields.ADDR_ZIPCODE))
		}

		'Select country'
		if(StringUtil.isValidData(addressData, Fields.ADDR_COUNTY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_Country'), addressData.get(Fields.ADDR_COUNTY), false)
		}

		'Select address type'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/select_AddressType'), addressData.get(Fields.ADDR_ADDRESS_TYPE), false)
		}

		'Enter address label'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_AddressLabel'), addressData.get(Fields.ADDR_ADDRESS_LABEL))
		}
	}

	static def verifyAddressTable(Map<Fields, String> addressData, int rowNo) {

		TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')
		'Verify Address Type'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_TYPE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_TYPE, addressData.get(Fields.ADDR_ADDRESS_TYPE))
		}

		'Verify Address Label'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ADDRESS_LABEL)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ADDRESS_LABEL, addressData.get(Fields.ADDR_ADDRESS_LABEL))
		}

		'Verify Address Street'
		if(StringUtil.isValidData(addressData, Fields.ADDR_STREET)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_STREET, addressData.get(Fields.ADDR_STREET))
		}

		'Verify Address City'
		if(StringUtil.isValidData(addressData, Fields.ADDR_CITY)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_CITY, addressData.get(Fields.ADDR_CITY))
		}

		'Verify Address Country'
		if(StringUtil.isValidData(addressData, Fields.ADDR_COUNTY)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_COUNTY, addressData.get(Fields.ADDR_COUNTY))
		}

		'Verify Address State'
		if(StringUtil.isValidData(addressData, Fields.ADDR_STATE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_STATE, addressData.get(Fields.ADDR_STATE))
		}

		'Verify Address Zipcode'
		if(StringUtil.isValidData(addressData, Fields.ADDR_ZIPCODE)) {
			new actions.Table().verifyCellValueEquals(addressTable, rowNo, ColumnPos.ADDR_ZIPCODE, addressData.get(Fields.ADDR_ZIPCODE))
		}
	}

	static def fillPhoneDetails(Map<Fields, String> phoneData) {

		'Wait for Add Phones task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneLabel'), GlobalVariable.TIMEOUT)

		'Enter phone number'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneNumber'), phoneData.get(Fields.CT_PHONE_NUMBER))
		}

		'Select phone type'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/select_PhoneType'), phoneData.get(Fields.CT_PHONE_TYPE), false)
		}

		'Enter phone label'
		if(StringUtil.isValidData(phoneData, Fields.CT_PHONE_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneLabel'), phoneData.get(Fields.CT_PHONE_LABEL))
		}
	}

	static def verifyPhoneTable(Map<Fields, String> phoneData, int rowNo) {

		TestObject phoneTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones')

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

	}

	static def fillEmailDetails(Map<Fields, String> emailData) {

		'Wait for Add email task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), GlobalVariable.TIMEOUT)

		'Enter Email'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), emailData.get(Fields.CT_EMAIL))
		}

		'Select Email type'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/select_EmailType'), emailData.get(Fields.CT_EMAIL_TYPE), false)
		}

		'Enter Email label'
		if(StringUtil.isValidData(emailData, Fields.CT_EMAIL_LABEL)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_EmailLabel'), emailData.get(Fields.CT_EMAIL_LABEL))
		}
	}

	static def verifyEmailTable(Map<Fields, String> emailData, int rowNo) {

		TestObject emailTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails')

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
	}

	static def fillDocumentDetails(Map<Fields, String> documentData) {

		'Wait for Task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), GlobalVariable.TIMEOUT)

		'Upload file'
		//CustomKeywords.'actions.File.upload'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), docData.get(Fields.DOCUMENT_FILEPATH))
		new actions.File().uploadAutoIt(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), documentData.get(Fields.DOCUMENT_FILEPATH))

		'Wait for Uploaded file name to be visible'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/lbl_FileNameAfterUpload'), GlobalVariable.TIMEOUT)

		'Select doc class'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_CLASS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass'), documentData.get(Fields.DOCUMENT_CLASS), false)
		}

		'Wait for doc type field to be editable'
		new actions.WaitFor().elementClickable(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), GlobalVariable.TIMEOUT)

		'Select doc type'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType'), documentData.get(Fields.DOCUMENT_TYPE), false)
		}

		'Enter start date'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_START_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_StartDate'), documentData.get(Fields.DOCUMENT_START_DATE))
		}

		'Enter end date'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_END_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_EndDate'), documentData.get(Fields.DOCUMENT_END_DATE))
		}

		'Enter received date'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_RECEIVED_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_ReceivedDate'), documentData.get(Fields.DOCUMENT_RECEIVED_DATE))
		}

		'Select status'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_STATUS)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_Status'), documentData.get(Fields.DOCUMENT_STATUS), false)
		}

		'Enter description'
		if(StringUtil.isValidData(documentData, Fields.DOCUMENT_DESCRIPTION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_Description'), documentData.get(Fields.DOCUMENT_DESCRIPTION))
		}
	}

	static def verifyDocumentTable(Map<Fields, String> documentData, Map<Fields, String> custData, int rowNo) {

		TestObject documentTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/table_Documents')

		'Verify Doc Class value'
		new actions.Table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_CLASS, documentData.get(Fields.DOCUMENT_CLASS), WebTable.DOCUMENT)

		'Verify Doc Type value'
		new actions.Table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_TYPE, documentData.get(Fields.DOCUMENT_TYPE), WebTable.DOCUMENT)

		'Verify Doc description value'
		new actions.Table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_DESCRIPTION, documentData.get(Fields.DOCUMENT_DESCRIPTION), WebTable.DOCUMENT)

		'Verify Customer ID value'
		new actions.Table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_CUSTOMER_ID, custData.get(Fields.CUST_CUSTOMER_ID), WebTable.DOCUMENT)

		'Verify Status value'
		new actions.Table().verifyCellValueEquals(documentTable, rowNo, ColumnPos.DOCUMENT_STATUS, documentData.get(Fields.DOCUMENT_STATUS), WebTable.DOCUMENT)

	}

	static def verifyAccountsTable(Map<Fields, String> accData, int rowNo) {

		TestObject table = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')

		//'Wait for table to be visible'
		new actions.WaitFor().elementVisible(table, GlobalVariable.TIMEOUT)

		//Verify Correct account number is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

		//Verify Correct account title is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_TITLE, accData.get(Fields.ACC_TITLE))

		//Verify Correct account open date is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_OPEN_DATE, accData.get(Fields.ACC_OPEN_DATE))

		//Verify Correct account description is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_DESCRIPTION, accData.get(Fields.ACC_DESCRIPTION))

		//Verify Correct account ledger balance is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_LEDGER_BALANCE, accData.get(Fields.ACC_LEDGER_BALANCE))

		//Verify Correct account availble balance is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_AVAILABLE_BALANCE, accData.get(Fields.ACC_AVAILABLE_BALANCE))
	}
}
