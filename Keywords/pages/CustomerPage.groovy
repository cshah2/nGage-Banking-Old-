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

	private static void enterBasicInformation(Map<Fields, String> custData) {

		TestObject e_Prefix = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Prefix')
		TestObject e_FirstName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName')
		TestObject e_MiddleName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName')
		TestObject e_LastName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName')
		TestObject e_Suffix = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Suffix')
		TestObject e_DateOfBirth = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB')
		TestObject e_TaxID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID')
		TestObject e_CountryOfResidency = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_CountryOfResidence')
		TestObject e_ResidencyStatus = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/select_ResidencyStatus')
		
		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_Prefix, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_Prefix, custData, Fields.CUST_PREFIX)
		new actions.Common().setTextIfNotEmpty(e_FirstName, custData, Fields.CUST_FIRST_NAME)
		new actions.Common().setTextIfNotEmpty(e_MiddleName, custData, Fields.CUST_MIDDLE_NAME)
		new actions.Common().setTextIfNotEmpty(e_LastName, custData, Fields.CUST_LAST_NAME)
		new actions.Common().setTextIfNotEmpty(e_Suffix, custData, Fields.CUST_SUFFIX)
		new actions.Common().setTextJQueryIfNotEmpty(e_DateOfBirth, custData, Fields.CUST_DOB)
		new actions.Common().setTextIfNotEmpty(e_TaxID, custData, Fields.CUST_TAX_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CountryOfResidency, custData, Fields.CUST_COUNTRY_OF_RESIDENCE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_ResidencyStatus, custData, Fields.CUST_RESIDENCY_STATUS)
	}

	private static void enterCustomerDetails(Map<Fields, String> custData) {

		TestObject e_FamiliarName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/input_FamiliarName')
		TestObject e_MaidenName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/input_MaidenName')
		TestObject e_MaritalStatus = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/select_MaritalStatus')
		TestObject e_TotalHouseholdMembers = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/input_TotalHouseholdMembers')
		TestObject e_MothersMaidenName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/input_MothersMaidenName')
		TestObject e_PreferredLanguage = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/select_PreferredLanguage')
		TestObject e_AlternateLanguage = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/select_AlternateLanguage')
		TestObject e_AgeBracket = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Details/select_AgeBracket')

		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_FamiliarName, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_FamiliarName, custData, Fields.CUST_FAMILIAR_NAME)
		new actions.Common().setTextIfNotEmpty(e_MaidenName, custData, Fields.CUST_MAIDEN_NAME)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_MaritalStatus, custData, Fields.CUST_MARITAL_STATUS)
		new actions.Common().setTextIfNotEmpty(e_TotalHouseholdMembers, custData, Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS)
		new actions.Common().setTextIfNotEmpty(e_MothersMaidenName, custData, Fields.CUST_MOTHERS_MAIDEN_NAME)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PreferredLanguage, custData, Fields.CUST_PREFERRED_LANGUAGE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AlternateLanguage, custData, Fields.CUST_ALTERNATE_LANGUAGE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AgeBracket, custData, Fields.CUST_AGE_BRACKET)
	}

	private static void enterLocationInformation(Map<Fields, String> custData) {

		TestObject e_Street = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street')
		TestObject e_City = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_City')
		TestObject e_Country = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_Country')
		TestObject e_StateOrRegion = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_StateOrRegion')
		TestObject e_ZipOrPostalCode = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_ZipOrPostalCode')
		TestObject e_AddressType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/select_AddressType')
		TestObject e_AddressLabel = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLabel')
		TestObject e_VerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_VerifiedDate')
		TestObject e_AddressValidLink = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/link_SetAddressDates')
		TestObject e_ValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressValidFrom')
		TestObject e_ValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressValidUntil')

		//Wait for Location information fields to be visible
		new actions.WaitFor().elementVisible(e_Street, GlobalVariable.TIMEOUT)
		
		new actions.Common().setTextIfNotEmpty(e_Street, custData, Fields.ADDR_STREET)
		new actions.Common().setTextIfNotEmpty(e_City, custData, Fields.ADDR_CITY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Country, custData, Fields.ADDR_COUNTY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_StateOrRegion, custData, Fields.ADDR_STATE)
		new actions.Common().setTextIfNotEmpty(e_ZipOrPostalCode, custData, Fields.ADDR_ZIPCODE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AddressType, custData, Fields.ADDR_ADDRESS_TYPE)
		new actions.Common().setTextIfNotEmpty(e_AddressLabel, custData, Fields.ADDR_ADDRESS_LABEL)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, custData, Fields.ADDR_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.ADDR_VALID_FROM) || StringUtil.isValidData(custData, Fields.ADDR_VALID_UNTIL)) {
			WebUI.click(e_AddressValidLink)
			new actions.WaitFor().elementVisible(e_ValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidFrom, custData, Fields.ADDR_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidUntil, custData, Fields.ADDR_VALID_UNTIL)
	}

	private static void enterContactInfomration(Map<Fields, String> custData) {

		TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber')
		TestObject e_PhoneType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType')
		TestObject e_PhoneVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneVerifiedDate')
		TestObject e_PhoneValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneValidFrom')
		TestObject e_PhoneValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneValidUntil')
		TestObject e_Email = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email')
		TestObject e_EmailType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType')
		TestObject e_EmailVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailVerifiedDate')
		TestObject e_EmailValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailValidFrom')
		TestObject e_EmailValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailValidUntil')
		TestObject e_PreferredContact = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod')

		//Wait for Contact information fields to be visible
		new actions.WaitFor().elementVisible(e_PhoneNumber, GlobalVariable.TIMEOUT)
		
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneNumber, custData, Fields.CT_PHONE_NUMBER)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PhoneType, custData, Fields.CT_PHONE_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneVerifiedDate, custData, Fields.CT_PHONE_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.CT_PHONE_VALID_FROM) || StringUtil.isValidData(custData, Fields.CT_PHONE_VALID_UNTIL)) {
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetPhoneDates'))
			new actions.WaitFor().elementVisible(e_PhoneValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidFrom, custData, Fields.CT_PHONE_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidUntil, custData, Fields.CT_PHONE_VALID_UNTIL)

		new actions.Common().setTextJQueryIfNotEmpty(e_Email, custData, Fields.CT_EMAIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_EmailType, custData, Fields.CT_EMAIL_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailVerifiedDate, custData, Fields.CT_EMAIL_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.CT_EMAIL_VALID_FROM) || StringUtil.isValidData(custData, Fields.CT_EMAIL_VALID_UNTIL)) {
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetEmailDates'))
			new actions.WaitFor().elementVisible(e_EmailValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidFrom, custData, Fields.CT_EMAIL_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidUntil, custData, Fields.CT_EMAIL_VALID_UNTIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PreferredContact, custData, Fields.CT_PREFERRED_CONTACT_METHOD)
	}

	private static void enterCustomerDueDiligence(Map<Fields, String> custData) {

		TestObject e_SeniorPoliticalFigure = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Due Diligence/chkbox_SeniorPoliticalFigure')
		TestObject e_SeniorPoliticalFigureCountry = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Due Diligence/select_SeniorPoliticalFigureCountry')
		TestObject e_AssociateSrPoliticalFigure = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Due Diligence/select_AssociateSrPoliticalFigure')

		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_SeniorPoliticalFigure, GlobalVariable.TIMEOUT)

		if(StringUtil.isValidData(custData, Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE)) {
			new actions.Common().checkElementIfNotEmpty(e_SeniorPoliticalFigure, custData, Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE)
			new actions.WaitFor().elementVisible(e_SeniorPoliticalFigureCountry, GlobalVariable.TIMEOUT)
		}
		new actions.Common().selectOptionByLabelIfNotEmpty(e_SeniorPoliticalFigureCountry, custData, Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AssociateSrPoliticalFigure, custData, Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE)
	}

	private static void enterEducationAndOccupationDetails(Map<Fields, String> custData) {

		TestObject e_EmploymentStatus = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/select_EmploymentStatus')
		TestObject e_Occupation = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/select_Occupation')
		TestObject e_MonthlyGrossIncome = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/input_MonthlyGrossIncome')
		TestObject e_MilitaryStatus = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/select_MilitaryStatus')
		TestObject e_Education = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/select_Education')
		TestObject e_StudentType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/select_StudentType')
		TestObject e_WebAddress = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Education and Occupation Details/input_WebAddress')

		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_EmploymentStatus, GlobalVariable.TIMEOUT)

		new actions.Common().selectOptionByLabelIfNotEmpty(e_EmploymentStatus, custData, Fields.CUST_EMPLOYMENT_STATUS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Occupation, custData, Fields.CUST_OCCUPATION)
		new actions.Common().setTextIfNotEmpty(e_MonthlyGrossIncome, custData, Fields.CUST_MONTHLY_GROSS_INCOME)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_MilitaryStatus, custData, Fields.CUST_MILITARY_STATUS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Education, custData, Fields.CUST_EDUCATION)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_StudentType, custData, Fields.CUST_STUDENT_TYPE)
		new actions.Common().setTextIfNotEmpty(e_WebAddress, custData, Fields.CUST_WEB_ADDRESS)
	}

	private static void enterCustomerInformation(Map<Fields, String> custData) {

		TestObject e_CustomerID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId')
		TestObject e_CustomerGroup = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup')
		TestObject e_CheckAccount = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount')
		
		//Wait for Customer ID and Group field to load
		new actions.WaitFor().elementVisible(e_CustomerID, GlobalVariable.TIMEOUT)
		
		new actions.Common().setTextIfNotEmpty(e_CustomerID, custData, Fields.CUST_CUSTOMER_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CustomerGroup, custData, Fields.CUST_CUSTOMER_GROUP)
		new actions.WaitFor().elementVisible(e_CheckAccount, GlobalVariable.TIMEOUT)
		new actions.Common().checkElementIfNotEmpty(e_CheckAccount, custData, Fields.CUST_CHK_ACCOUNT)
	}

	static def fillCustomerDetails(Map<Fields, String> custData) {

		TestObject e_next = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Common/btn_Next')
		TestObject e_Create = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Common/btn_Create')

		enterBasicInformation(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterCustomerDetails(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterLocationInformation(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterContactInfomration(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterCustomerDueDiligence(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterEducationAndOccupationDetails(custData)
		new actions.Common().moveToElementAndClick(e_next)

		enterCustomerInformation(custData)
		new actions.Common().moveToElementAndClick(e_Create)
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