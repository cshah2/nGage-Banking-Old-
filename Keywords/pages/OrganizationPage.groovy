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

import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable
import utils.StringUtil

public class OrganizationPage {

	private static void enterBasicInformation(Map<Fields, String> orgData) {

		TestObject e_OrgName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Basic Information/input_OrganizationName')
		TestObject e_DbaName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Basic Information/input_DBAName')
		TestObject e_EstablishedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Basic Information/input_EstablishedDate')
		TestObject e_TaxID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Basic Information/input_TaxID')
		TestObject e_TaxIDType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Basic Information/select_TaxIDType')


		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_OrgName, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_OrgName, orgData, Fields.ORG_NAME)
		new actions.Common().setTextIfNotEmpty(e_DbaName, orgData, Fields.ORG_DBA_NAME)
		new actions.Common().setTextIfNotEmpty(e_EstablishedDate, orgData, Fields.ORG_ESTABLISHED_DATE)
		new actions.Common().setTextIfNotEmpty(e_TaxID, orgData, Fields.ORG_TAX_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_TaxIDType, orgData, Fields.ORG_TAX_ID_TYPE)
	}

	private static void enterOrganizationDetails(Map<Fields, String> orgData) {

		TestObject e_Description = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/input_Description')
		TestObject e_DunAndBradSteetNo = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/input_DunAndBradsteetNumber')
		TestObject e_PubliclyHeld = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/chkbox_PubliclyHeld')
		TestObject e_TradeName = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/input_TradeName')
		TestObject e_InternationalCompany = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/chkbox_InternationalCompany')
		TestObject e_GovernmentOwned = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/chkbox_GovernmentOwned')
		TestObject e_SmallBusiness = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/chkbox_SmallBusiness')
		TestObject e_TaxExempt = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/chkbox_TaxExempt')
		TestObject e_TaxExemptType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/select_TaxExemptType')
		TestObject e_RegistrationCountry = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/select_RegistrationCountry')
		TestObject e_RegistrationRegion = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/select_RegistrationRegion')
		TestObject e_WebsiteURL = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Details/input_WebsiteURL')


		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_Description, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_Description, orgData, Fields.ORG_DESCRIPTION)
		new actions.Common().setTextIfNotEmpty(e_DunAndBradSteetNo, orgData, Fields.ORG_DUN_BRADSTEET_NO)
		if(StringUtil.isValidData(orgData, Fields.ORG_CHK_PUBLICLY_HELD) && 'true'.equalsIgnoreCase(orgData.get(Fields.ORG_CHK_PUBLICLY_HELD))) {
			new actions.Common().checkElementIfNotEmpty(e_PubliclyHeld, orgData, Fields.ORG_CHK_PUBLICLY_HELD)
			new actions.WaitFor().elementVisible(e_TradeName, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextIfNotEmpty(e_TradeName, orgData, Fields.ORG_TRADE_NAME)
		new actions.Common().checkElementIfNotEmpty(e_InternationalCompany, orgData, Fields.ORG_CHK_INTERNATIONAL_COMPANY)
		new actions.Common().checkElementIfNotEmpty(e_GovernmentOwned, orgData, Fields.ORG_CHK_GOVERNMENT_OWNED)
		new actions.Common().checkElementIfNotEmpty(e_SmallBusiness, orgData, Fields.ORG_CHK_SMALL_BUSINESS)
		if(StringUtil.isValidData(orgData, Fields.ORG_CHK_TAX_EXEMPT) && 'true'.equalsIgnoreCase(orgData.get(Fields.ORG_CHK_TAX_EXEMPT))) {
			new actions.Common().checkElementIfNotEmpty(e_TaxExempt, orgData, Fields.ORG_CHK_TAX_EXEMPT)
			new actions.WaitFor().elementVisible(e_TaxExemptType, GlobalVariable.TIMEOUT)
		}
		new actions.Common().selectOptionByLabelIfNotEmpty(e_TaxExemptType, orgData, Fields.ORG_TAX_EXEMPT_TYPE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_RegistrationCountry, orgData, Fields.ORG_REGISTRATION_COUNTRY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_RegistrationRegion, orgData, Fields.ORG_REGISTRATION_REGION)
		new actions.Common().setTextIfNotEmpty(e_WebsiteURL, orgData, Fields.ORG_WEBSITE_URL)
	}

	private static void enterLocationInformation(Map<Fields, String> orgData) {

		TestObject e_Street = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_Street')
		TestObject e_City = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_City')
		TestObject e_Country = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/select_Country')
		TestObject e_StateOrRegion = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/select_StateOrRegion')
		TestObject e_ZipOrPostalCode = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_ZipOrPostalCode')
		TestObject e_AddressType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/select_AddressType')
		TestObject e_AddressLabel = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_AddressLabel')
		TestObject e_VerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_VerifiedDate')
		TestObject e_AddressValidLink = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/link_SetAddressDates')
		TestObject e_ValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_AddressValidFrom')
		TestObject e_ValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Location Information/input_AddressValidUntil')

		//Wait for Location information fields to be visible
		new actions.WaitFor().elementVisible(e_Street, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_Street, orgData, Fields.ADDR_STREET)
		new actions.Common().setTextIfNotEmpty(e_City, orgData, Fields.ADDR_CITY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Country, orgData, Fields.ADDR_COUNTY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_StateOrRegion, orgData, Fields.ADDR_STATE)
		new actions.Common().setTextIfNotEmpty(e_ZipOrPostalCode, orgData, Fields.ADDR_ZIPCODE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AddressType, orgData, Fields.ADDR_ADDRESS_TYPE)
		new actions.Common().setTextIfNotEmpty(e_AddressLabel, orgData, Fields.ADDR_ADDRESS_LABEL)
		new actions.Common().setTextJQueryIfNotEmpty(e_VerifiedDate, orgData, Fields.ADDR_VERIFIED_DATE)
		if((StringUtil.isValidData(orgData, Fields.ADDR_VALID_FROM) && 'true'.equalsIgnoreCase(orgData.get(Fields.ADDR_VALID_FROM)))
			|| (StringUtil.isValidData(orgData, Fields.ADDR_VALID_UNTIL) && 'true'.equalsIgnoreCase(orgData.get(Fields.ADDR_VALID_UNTIL)))) {
			WebUI.click(e_AddressValidLink)
			new actions.WaitFor().elementVisible(e_ValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidFrom, orgData, Fields.ADDR_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_ValidUntil, orgData, Fields.ADDR_VALID_UNTIL)
	}

	private static void enterContactInfomration(Map<Fields, String> orgData) {

		TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_PhoneNumber')
		TestObject e_PhoneType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/select_PhoneType')
		TestObject e_PhoneVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_PhoneVerifiedDate')
		TestObject e_PhoneValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_PhoneValidFrom')
		TestObject e_PhoneValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_PhoneValidUntil')
		TestObject e_Email = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_Email')
		TestObject e_EmailType = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/select_EmailType')
		TestObject e_EmailVerifiedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_EmailVerifiedDate')
		TestObject e_EmailValidFrom = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_EmailValidFrom')
		TestObject e_EmailValidUntil = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/input_EmailValidUntil')
		TestObject e_PreferredContact = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Contact Information/select_PreferredContactMethod')

		//Wait for Contact information fields to be visible
		new actions.WaitFor().elementVisible(e_PhoneNumber, GlobalVariable.TIMEOUT)

		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneNumber, orgData, Fields.CT_PHONE_NUMBER)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PhoneType, orgData, Fields.CT_PHONE_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneVerifiedDate, orgData, Fields.CT_PHONE_VERIFIED_DATE)
		if((StringUtil.isValidData(orgData, Fields.CT_PHONE_VALID_FROM) && 'true'.equalsIgnoreCase(orgData.get(Fields.CT_PHONE_VALID_FROM)))
			|| (StringUtil.isValidData(orgData, Fields.CT_PHONE_VALID_UNTIL) && 'true'.equalsIgnoreCase(orgData.get(Fields.CT_PHONE_VALID_UNTIL)))) {
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetPhoneDates'))
			new actions.WaitFor().elementVisible(e_PhoneValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidFrom, orgData, Fields.CT_PHONE_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_PhoneValidUntil, orgData, Fields.CT_PHONE_VALID_UNTIL)

		new actions.Common().setTextJQueryIfNotEmpty(e_Email, orgData, Fields.CT_EMAIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_EmailType, orgData, Fields.CT_EMAIL_TYPE)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailVerifiedDate, orgData, Fields.CT_EMAIL_VERIFIED_DATE)
		if((StringUtil.isValidData(orgData, Fields.CT_EMAIL_VALID_FROM) && 'true'.equalsIgnoreCase(orgData.get(Fields.CT_EMAIL_VALID_FROM)))
			|| (StringUtil.isValidData(orgData, Fields.CT_EMAIL_VALID_UNTIL) && 'true'.equalsIgnoreCase(orgData.get(Fields.CT_EMAIL_VALID_UNTIL)))) {
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Contact Information/link_SetEmailDates'))
			new actions.WaitFor().elementVisible(e_EmailValidFrom, GlobalVariable.TIMEOUT)
		}
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidFrom, orgData, Fields.CT_EMAIL_VALID_FROM)
		new actions.Common().setTextJQueryIfNotEmpty(e_EmailValidUntil, orgData, Fields.CT_EMAIL_VALID_UNTIL)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PreferredContact, orgData, Fields.CT_PREFERRED_CONTACT_METHOD)
	}

	private static void enterOrganizationDueDiligence(Map<Fields, String> orgData) {

		TestObject e_BusinessStructure = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_BusinessStructure')
		TestObject e_CountryOperations = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_CountryOfOperations')
		TestObject e_CountryHeadquarters = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_CountryOfHeadquarters')
		TestObject e_Industry = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_Industry')
		TestObject e_YearsOwned = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_YearsOwned')
		TestObject e_EstAnnualRevenue = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_EstimatedAnnualRevenue')
		TestObject e_NumberOfLocations = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_NumberOfLocations')
		TestObject e_NumberWireTrxn = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_NumberOfWireTxnPM')
		TestObject e_AmountWireTrxn = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_AmountOfWireTxnPM')
		TestObject e_NumberAchOrigination = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_NumberOfAchPM')
		TestObject e_AmountAchOrigination = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_AmountOfAchPM')
		TestObject e_NumberMobileDeposit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_NumberOfMobileDepositPM')
		TestObject e_AmountMobileDeposit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_AmountOfMobileDepositPM')
		TestObject e_NumberRemoteDeposit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_NumberOfRemoteDepositPM')
		TestObject e_AmountRemoteDeposit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_AmountOfRemoteDepositPM')
		TestObject e_IntermediatoryService = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_IntermediatoryServices')
		TestObject e_PercentRevenueCash = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/select_PercentOfRevenueFromCash')
		TestObject e_NonCashSevice = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_NonCashServicePerformed')
		TestObject e_Charity = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_Charity')
		TestObject e_AtmOperator = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_AtmOperator')
		TestObject e_MarijuanaBusiness = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_MarijuanaBusiness')
		TestObject e_InternetGambling = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_InternetGambling')
		TestObject e_ThirdPartyBenefit = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_ThirdPartyBenefitTransaction')
		TestObject e_TransferCustomers = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_TransferForCustomers')
		TestObject e_VirtualCurrencyUsed = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Organization Due Diligence/chkbox_VirtualCurrencyUsed')

		//Wait for page elements to load
		new actions.WaitFor().elementVisible(e_BusinessStructure, GlobalVariable.TIMEOUT)

		new actions.Common().selectOptionByLabelIfNotEmpty(e_BusinessStructure, orgData, Fields.ORG_BUSINESS_STRUCTURE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CountryOperations, orgData, Fields.ORG_COUNTRY_OPERATIONS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CountryHeadquarters, orgData, Fields.ORG_COUNTRY_HEADQUARTERS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_Industry, orgData, Fields.ORG_INDUSTRY)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_YearsOwned, orgData, Fields.ORG_YEARS_OWNED)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_EstAnnualRevenue, orgData, Fields.ORG_EST_ANNUAL_REVENUE)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_NumberOfLocations, orgData, Fields.ORG_NUMBER_LOCATIONS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_NumberWireTrxn, orgData, Fields.ORG_NUMBER_WIRE_TRANSACTIONS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AmountWireTrxn, orgData, Fields.ORG_AMOUNT_WIRE_TRANSACTIONS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_NumberAchOrigination, orgData, Fields.ORG_NUMBER_ACH_ORIGINATION)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AmountAchOrigination, orgData, Fields.ORG_AMOUNT_ACH_ORIGINATION)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_NumberMobileDeposit, orgData, Fields.ORG_NUMBER_MOBILE_DEPOSITS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AmountMobileDeposit, orgData, Fields.ORG_AMOUNT_MOBILE_DEPOSITS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_NumberRemoteDeposit, orgData, Fields.ORG_NUMBER_REMOTE_DEPOSITS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_AmountRemoteDeposit, orgData, Fields.ORG_AMOUNT_REMOTE_DEPOSITS)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_IntermediatoryService, orgData, Fields.ORG_INTERMEDIATORY_SERVICES)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_PercentRevenueCash, orgData, Fields.ORG_PERCENT_REVENUE_CASH)
		new actions.Common().checkElementIfNotEmpty(e_NonCashSevice, orgData, Fields.ORG_CHK_NON_CASH_SERVICE)
		new actions.Common().checkElementIfNotEmpty(e_Charity, orgData, Fields.ORG_CHK_CHARITY)
		new actions.Common().checkElementIfNotEmpty(e_AtmOperator, orgData, Fields.ORG_CHK_ATM_OPERATOR)
		new actions.Common().checkElementIfNotEmpty(e_MarijuanaBusiness, orgData, Fields.ORG_CHK_MARIJUANA_BUSINESS)
		new actions.Common().checkElementIfNotEmpty(e_InternetGambling, orgData, Fields.ORG_CHK_INTERNET_GAMBLING)
		new actions.Common().checkElementIfNotEmpty(e_ThirdPartyBenefit, orgData, Fields.ORG_CHK_THIRD_PARTY_BENEFIT)
		new actions.Common().checkElementIfNotEmpty(e_TransferCustomers, orgData, Fields.ORG_CHK_TRANSFER_CUSTOMERS)
		new actions.Common().checkElementIfNotEmpty(e_VirtualCurrencyUsed, orgData, Fields.ORG_CHK_VIRTUAL_CURRENCY)
	}

	private static void enterCustomerInformation(Map<Fields, String> custData) {

		TestObject e_CustomerID = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/input_CustomerId')
		TestObject e_CustomerGroup = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/select_PartyorCustomerGroup')
		TestObject e_CheckAccount = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/chkbox_CreateNewAccount')

		//Wait for Customer ID and Group field to load
		new actions.WaitFor().elementVisible(e_CustomerID, GlobalVariable.TIMEOUT)

		new actions.Common().setTextIfNotEmpty(e_CustomerID, custData, Fields.ORG_CUSTOMER_ID)
		new actions.Common().selectOptionByLabelIfNotEmpty(e_CustomerGroup, custData, Fields.ORG_CUSTOMER_GROUP)
	}

	static def fillOrganizationDetails(Map<Fields, String> orgData) {

		TestObject e_next = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Common/btn_Next')
		TestObject e_Create = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Common/btn_Create')

		TestObject e_Dialog_Msg = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/Confirmation dialog/lbl_Message')
		TestObject e_Dialog_Yes = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/Confirmation dialog/btn_Yes')
		TestObject e_Dialog_No = findTestObject('Dashboard Page/Customer and Account Search Page/Create Organization Page/Customer Information/Confirmation dialog/btn_No')

		enterBasicInformation(orgData)
		new actions.Common().moveToElementAndClick(e_next)

		enterOrganizationDetails(orgData)
		new actions.Common().moveToElementAndClick(e_next)

		enterLocationInformation(orgData)
		new actions.Common().moveToElementAndClick(e_next)

		enterContactInfomration(orgData)
		new actions.Common().moveToElementAndClick(e_next)

		enterOrganizationDueDiligence(orgData)
		new actions.Common().moveToElementAndClick(e_next)

		enterCustomerInformation(orgData)
		new actions.Common().moveToElementAndClick(e_Create)

		//handle popup dialog
		new actions.WaitFor().elementVisible(e_Dialog_Msg, GlobalVariable.TIMEOUT)
		new actions.Common().verifyMatch(e_Dialog_Msg, 'Customer has been created', RegexOperator.CONTAINS)

		if(StringUtil.isValidData(orgData, Fields.ORG_CHK_ACCOUNT) && 'true'.equalsIgnoreCase(orgData.get(Fields.ORG_CHK_ACCOUNT))) {
			WebUI.click(e_Dialog_Yes)
		}
		else {
			WebUI.click(e_Dialog_No)
		}
	}

	static def verifyOrganizationDetailsSummarySection(Map<Fields, String> data) {

		TestObject e_OrgName = findTestObject('Dashboard Page/Customer and Account Search Page/Organization Details Page/Summary Section/lbl_OrganizationName')
		TestObject e_DbagName = findTestObject('Dashboard Page/Customer and Account Search Page/Organization Details Page/Summary Section/lbl_DbaName')
		TestObject e_TaxID = findTestObject('Dashboard Page/Customer and Account Search Page/Organization Details Page/Summary Section/lbl_TaxId')
		TestObject e_EstablishedDate= findTestObject('Dashboard Page/Customer and Account Search Page/Organization Details Page/Summary Section/lbl_EstablishedDate')
		TestObject e_Address = findTestObject('Dashboard Page/Customer and Account Search Page/Organization Details Page/Summary Section/lbl_Address')

		//Wait for Organization details page to load
		new actions.WaitFor().elementVisible(e_OrgName, GlobalVariable.TIMEOUT)

		//Verify Organization name is displayed correctly
		WebUI.verifyElementText(e_OrgName, data.get(Fields.ORG_NAME))

		//Verify Organization Dba Name is displayed correctly
		WebUI.verifyElementText(e_DbagName, data.get(Fields.ORG_DBA_NAME))

		//Verify Organization Tax ID is displayed correctly
		WebUI.verifyElementText(e_TaxID, data.get(Fields.ORG_TAX_ID_MASKED))

		//Verify Organization Established Date is displayed correctly
		WebUI.verifyElementText(e_EstablishedDate, data.get(Fields.ORG_ESTABLISHED_DATE))

		//Verify Organization Address is displayed correctly
		WebUI.verifyElementText(e_Address, data.get(Fields.ADDR_VIEW))
	}



}
