package pages.consumer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Map

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
import enums.RegexOperator
import internal.GlobalVariable
import utils.StringUtil

public class CreateConsumerPage {

	private void enterBasicInformation(Map<Fields, String> custData) {

		TestObject e_Prefix = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Prefix')
		TestObject e_FirstName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName')
		TestObject e_MiddleName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_MiddleName')
		TestObject e_LastName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_LastName')
		TestObject e_Suffix = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_Suffix')
		TestObject e_DateOfBirth = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_DOB')
		TestObject e_TaxID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxID')
		TestObject e_TaxIDType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_TaxIDType')
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
		new actions.Common().selectOptionByLabelIfNotEmpty(e_TaxIDType, custData, Fields.CUST_TAX_ID_TYPE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CountryOfResidency, custData, Fields.CUST_COUNTRY_OF_RESIDENCE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_ResidencyStatus, custData, Fields.CUST_RESIDENCY_STATUS)
	}

	private void enterCustomerDetails(Map<Fields, String> custData) {

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

	private void enterLocationInformation(Map<Fields, String> custData) {

		//TestObject e_Street = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_Street')
		TestObject e_AddressLine1 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLine1')
		TestObject e_AddressLine2 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLine2')
		TestObject e_ShowMoreLink = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/link_ShowMore')
		TestObject e_AddressLine3 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLine3')
		TestObject e_AddressLine4 = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Location Information/input_AddressLine4')
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
		new actions.WaitFor().elementVisible(e_AddressLine1, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_AddressLine1, custData, Fields.ADDR_LINE1)
		new actions.Common().setTextIfNotEmpty(e_AddressLine2, custData, Fields.ADDR_LINE2)

		//Click on Show more link to expand address field
		if(StringUtil.isValidData(custData, Fields.ADDR_LINE3) || StringUtil.isValidData(custData, Fields.ADDR_LINE4)) {
			WebUI.click(e_ShowMoreLink)
			//new actions.WaitFor().elementVisible(e_AddressLine3, GlobalVariable.TIMEOUT)
			new actions.WaitFor().elementClickable(e_AddressLine3, GlobalVariable.TIMEOUT)
			WebUI.delay(1)
			new actions.Common().setTextIfNotEmpty(e_AddressLine3, custData, Fields.ADDR_LINE3)
			new actions.Common().setTextIfNotEmpty(e_AddressLine4, custData, Fields.ADDR_LINE4)
		}

		new actions.Common().setTextIfNotEmpty(e_City, custData, Fields.ADDR_CITY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Country, custData, Fields.ADDR_COUNTY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_StateOrRegion, custData, Fields.ADDR_STATE)
		new actions.Common().setTextIfNotEmpty(e_ZipOrPostalCode, custData, Fields.ADDR_ZIPCODE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AddressType, custData, Fields.ADDR_ADDRESS_TYPE)
		new actions.Common().setTextIfNotEmpty(e_AddressLabel, custData, Fields.ADDR_ADDRESS_LABEL)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, custData, Fields.ADDR_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.ADDR_VALID_FROM) || StringUtil.isValidData(custData, Fields.ADDR_VALID_UNTIL)) {
			new actions.Common().moveToElementAndClick(e_AddressValidLink)
			//WebUI.click(e_AddressValidLink)
			new actions.WaitFor().elementVisible(e_ValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidFrom, custData, Fields.ADDR_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidUntil, custData, Fields.ADDR_VALID_UNTIL)
	}

	private void enterContactInfomration(Map<Fields, String> custData) {

		TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneNumber')
		TestObject e_PhoneType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PhoneType')
		TestObject e_PhoneVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneVerifiedDate')
		TestObject e_PhoneValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneValidFrom')
		TestObject e_PhoneValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_PhoneValidUntil')
		TestObject e_PhoneValidLink = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetPhoneDates')
		TestObject e_Email = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_Email')
		TestObject e_EmailType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_EmailType')
		TestObject e_EmailVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailVerifiedDate')
		TestObject e_EmailValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailValidFrom')
		TestObject e_EmailValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/input_EmailValidUntil')
		TestObject e_PreferredContact = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/select_PreferredContactMethod')
		TestObject e_EmailValidLink = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetEmailDates')

		//Wait for Contact information fields to be visible
		new actions.WaitFor().elementVisible(e_PhoneNumber, GlobalVariable.TIMEOUT)

		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneNumber, custData, Fields.CT_PHONE_NUMBER)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PhoneType, custData, Fields.CT_PHONE_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneVerifiedDate, custData, Fields.CT_PHONE_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.CT_PHONE_VALID_FROM) || StringUtil.isValidData(custData, Fields.CT_PHONE_VALID_UNTIL)) {
			new actions.Common().moveToElementAndClick(e_PhoneValidLink)
			new actions.WaitFor().elementVisible(e_PhoneValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidFrom, custData, Fields.CT_PHONE_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidUntil, custData, Fields.CT_PHONE_VALID_UNTIL)

		new actions.Common().setTextJQueryIfNotEmpty(e_Email, custData, Fields.CT_EMAIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_EmailType, custData, Fields.CT_EMAIL_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailVerifiedDate, custData, Fields.CT_EMAIL_VERIFIED_DATE)
		if(StringUtil.isValidData(custData, Fields.CT_EMAIL_VALID_FROM) || StringUtil.isValidData(custData, Fields.CT_EMAIL_VALID_UNTIL)) {
			new actions.Common().moveToElementAndClick(e_EmailValidLink)
			new actions.WaitFor().elementVisible(e_EmailValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidFrom, custData, Fields.CT_EMAIL_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidUntil, custData, Fields.CT_EMAIL_VALID_UNTIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PreferredContact, custData, Fields.CT_PREFERRED_CONTACT_METHOD)
	}

	private void enterCustomerDueDiligence(Map<Fields, String> custData) {

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

	private void enterEducationAndOccupationDetails(Map<Fields, String> custData) {

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

	private void enterCustomerInformation(Map<Fields, String> custData) {

		TestObject e_CustomerID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/input_CustomerId')
		TestObject e_CustomerGroup = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/select_PartyorCustomerGroup')
		TestObject e_CheckAccount = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/chkbox_CreateNewAccount')

		//Wait for Customer ID and Group field to load
		new actions.WaitFor().elementVisible(e_CustomerID, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_CustomerID, custData, Fields.CUST_CUSTOMER_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CustomerGroup, custData, Fields.CUST_CUSTOMER_GROUP)
		//new actions.WaitFor().elementVisible(e_CheckAccount, GlobalVariable.TIMEOUT)
		//new actions.Common().checkElementIfNotEmpty(e_CheckAccount, custData, Fields.CUST_CHK_ACCOUNT)
	}

	@Keyword
	def fillCustomerDetails(Map<Fields, String> custData) {

		TestObject e_next = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Common/btn_Next')
		TestObject e_Create = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Common/btn_Create')

		TestObject e_Dialog_Msg = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/Confirmation dialog/lbl_Message')
		TestObject e_Dialog_Yes = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/Confirmation dialog/btn_Yes')
		TestObject e_Dialog_No = findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/Confirmation dialog/btn_No')

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

		//handle pop-up dialog
		new actions.WaitFor().elementVisible(e_Dialog_Msg, GlobalVariable.TIMEOUT)
		WebUI.delay(2)
		new actions.WaitFor().elementVisible(e_Dialog_No, GlobalVariable.TIMEOUT)

		//Verify success message on dialog.
		new actions.Common().verifyElementTextMatches(e_Dialog_Msg, "Customer has been created", RegexOperator.CONTAINS)

		if(StringUtil.isValidData(custData, Fields.CUST_CHK_ACCOUNT) && 'true'.equalsIgnoreCase(custData.get(Fields.CUST_CHK_ACCOUNT))) {
			WebUI.click(e_Dialog_Yes)
		}
		else {
			WebUI.click(e_Dialog_No)
		}
	}
}
