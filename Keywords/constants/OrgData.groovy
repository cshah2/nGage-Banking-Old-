package constants

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
import utils.DateUtil
import utils.RandomUtil

public class OrgData {

	public static final Map<Fields, String> ORG1;
	static {
		ORG1 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		String orgName = "The "+parsedJson.get("results").get(0).get("name").get("first") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" Inc"
		String dbaName = parsedJson.get("results").get(0).get("name").get("title") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" & Sons "+RandomUtil.getRandomAlphabets(4)
		String establishedDate = DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat)

		ORG1.put(Fields.ORG_NAME, orgName)
		ORG1.put(Fields.ORG_DBA_NAME, dbaName)
		ORG1.put(Fields.ORG_ESTABLISHED_DATE, establishedDate)
		ORG1.put(Fields.ORG_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		ORG1.put(Fields.ORG_TAX_ID_MASKED, '*****'+ORG1.get(Fields.ORG_TAX_ID).substring(5))
		ORG1.put(Fields.ORG_TAX_ID_TYPE, 'SSN')

		//Organization Details
		String tradeName = parsedJson.get("results").get(0).get("name").get("title") + parsedJson.get("results").get(0).get("name").get("first") +" PLC"
		ORG1.put(Fields.ORG_DESCRIPTION, 'Organization 01 - Description')
		ORG1.put(Fields.ORG_DUN_BRADSTEET_NO, RandomUtil.getRandomNumeric(9))
		ORG1.put(Fields.ORG_CHK_PUBLICLY_HELD, 'true')
		ORG1.put(Fields.ORG_TRADE_NAME, tradeName)
		ORG1.put(Fields.ORG_CHK_INTERNATIONAL_COMPANY, 'true')
		ORG1.put(Fields.ORG_CHK_GOVERNMENT_OWNED, 'true')
		ORG1.put(Fields.ORG_CHK_SMALL_BUSINESS, 'true')
		ORG1.put(Fields.ORG_CHK_TAX_EXEMPT, 'true')
		ORG1.put(Fields.ORG_TAX_EXEMPT_TYPE, 'Religious')
		ORG1.put(Fields.ORG_REGISTRATION_COUNTRY, 'United States of America')
		ORG1.put(Fields.ORG_REGISTRATION_REGION, 'Pennsylvania')
		ORG1.put(Fields.ORG_WEBSITE_URL, 'https://www.savanainc.com')

		//Location Information
		ORG1.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
		ORG1.put(Fields.ADDR_CITY, 'Philadelphia')
		ORG1.put(Fields.ADDR_COUNTY, 'United States of America')
		ORG1.put(Fields.ADDR_STATE, 'Pennsylvania')
		ORG1.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		ORG1.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		ORG1.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		ORG1.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.ADDR_VIEW, ORG1.get(Fields.ADDR_STREET)+', '+ORG1.get(Fields.ADDR_CITY)+', PA '+ORG1.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		ORG1.put(Fields.CT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		ORG1.put(Fields.CT_PHONE_TYPE, 'Mobile')
		ORG1.put(Fields.CT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		ORG1.put(Fields.CT_EMAIL_TYPE, 'Personal')
		ORG1.put(Fields.CT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, common.dateFormat, common.timezoneUTC))
		ORG1.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')

		//Organization Due diligence
		ORG1.put(Fields.ORG_BUSINESS_STRUCTURE, 'LLC')
		ORG1.put(Fields.ORG_COUNTRY_OPERATIONS, 'United States of America')
		ORG1.put(Fields.ORG_COUNTRY_HEADQUARTERS, 'India')
		ORG1.put(Fields.ORG_INDUSTRY, 'Agriculature')
		ORG1.put(Fields.ORG_YEARS_OWNED, '3 Years')
		ORG1.put(Fields.ORG_EST_ANNUAL_REVENUE, 'Under 1 Million')
		ORG1.put(Fields.ORG_NUMBER_LOCATIONS, '1 to 10 Locations')
		ORG1.put(Fields.ORG_NUMBER_WIRE_TRANSACTIONS, '1 to 100 Wires')
		ORG1.put(Fields.ORG_AMOUNT_WIRE_TRANSACTIONS, 'Up to $100')
		ORG1.put(Fields.ORG_NUMBER_ACH_ORIGINATION, '1 to 100 ACH Originations')
		ORG1.put(Fields.ORG_AMOUNT_ACH_ORIGINATION, 'Up to $100')
		ORG1.put(Fields.ORG_NUMBER_MOBILE_DEPOSITS, '101 to 1000 Mobile Deposits')
		ORG1.put(Fields.ORG_AMOUNT_MOBILE_DEPOSITS, 'Up to $100')
		ORG1.put(Fields.ORG_NUMBER_REMOTE_DEPOSITS, 'More than 10000 Remote Deposits')
		ORG1.put(Fields.ORG_AMOUNT_REMOTE_DEPOSITS, 'Up to $100')
		ORG1.put(Fields.ORG_INTERMEDIATORY_SERVICES, 'Accounting')
		ORG1.put(Fields.ORG_PERCENT_REVENUE_CASH, '26 to 50 Percent')
		ORG1.put(Fields.ORG_CHK_NON_CASH_SERVICE, 'true')
		ORG1.put(Fields.ORG_CHK_CHARITY, 'true')
		ORG1.put(Fields.ORG_CHK_ATM_OPERATOR, 'true')
		ORG1.put(Fields.ORG_CHK_MARIJUANA_BUSINESS, 'true')
		ORG1.put(Fields.ORG_CHK_INTERNET_GAMBLING, 'true')
		ORG1.put(Fields.ORG_CHK_THIRD_PARTY_BENEFIT, 'true')
		ORG1.put(Fields.ORG_CHK_TRANSFER_CUSTOMERS, 'true')
		ORG1.put(Fields.ORG_CHK_VIRTUAL_CURRENCY, 'true')

		//Customer Information
		ORG1.put(Fields.ORG_CUSTOMER_ID, 'OID_'+RandomUtil.getRandomNumeric(6))
		ORG1.put(Fields.ORG_CUSTOMER_GROUP, 'Banking Customer')
		ORG1.put(Fields.ORG_CHK_ACCOUNT, 'false')

		//Script data
		ORG1.put(Fields.IS_CREATED, 'false')
		ORG1.put(Fields.URL, '')
	}

	public static final Map<Fields, String> ORG2;
	static {
		ORG2 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		String orgName = "The "+parsedJson.get("results").get(0).get("name").get("first") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" Inc"
		String dbaName = parsedJson.get("results").get(0).get("name").get("title") +' '+ parsedJson.get("results").get(0).get("name").get("last") +" & Sons "+RandomUtil.getRandomAlphabets(4)
		String establishedDate = DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat)

		ORG2.put(Fields.ORG_NAME, orgName)
		ORG2.put(Fields.ORG_DBA_NAME, dbaName)
		ORG2.put(Fields.ORG_ESTABLISHED_DATE, establishedDate)
		ORG2.put(Fields.ORG_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		ORG2.put(Fields.ORG_TAX_ID_MASKED, '*****'+ORG2.get(Fields.ORG_TAX_ID).substring(5))
		ORG2.put(Fields.ORG_TAX_ID_TYPE, 'SSN')

		//Organization Details
		String tradeName = parsedJson.get("results").get(0).get("name").get("title") + parsedJson.get("results").get(0).get("name").get("first") +" PLC"
		ORG2.put(Fields.ORG_DESCRIPTION, 'Organization 01 - Description')
		ORG2.put(Fields.ORG_REGISTRATION_REGION, 'Pennsylvania')

		//Location Information
		ORG2.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
		ORG2.put(Fields.ADDR_CITY, 'Philadelphia')
		ORG2.put(Fields.ADDR_COUNTY, 'United States of America')
		ORG2.put(Fields.ADDR_STATE, 'Pennsylvania')
		ORG2.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		ORG2.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		ORG2.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		ORG2.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezoneUTC))
		ORG2.put(Fields.ADDR_VIEW, ORG2.get(Fields.ADDR_STREET)+', '+ORG2.get(Fields.ADDR_CITY)+', PA '+ORG2.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		ORG2.put(Fields.CT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		ORG2.put(Fields.CT_PHONE_TYPE, 'Mobile')
		ORG2.put(Fields.CT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, common.dateFormat, common.timezoneUTC))
		ORG2.put(Fields.CT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, common.dateFormat, common.timezoneUTC))
		ORG2.put(Fields.CT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, common.dateFormat, common.timezoneUTC))
		ORG2.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		ORG2.put(Fields.CT_EMAIL_TYPE, 'Personal')
		ORG2.put(Fields.CT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezoneUTC))
		ORG2.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')

		//Organization Due diligence

		//Customer Information
		ORG2.put(Fields.ORG_CUSTOMER_ID, 'OID_'+RandomUtil.getRandomNumeric(6))
		ORG2.put(Fields.ORG_CUSTOMER_GROUP, 'Banking Customer')
		ORG2.put(Fields.ORG_CHK_ACCOUNT, 'true')

		//Script data
		ORG2.put(Fields.IS_CREATED, 'false')
		ORG2.put(Fields.URL, '')
	}

	public static final Map<Fields, String> ORG2_ACC1;
	static {
		ORG2_ACC1 = new HashMap<Fields, String>()
		ORG2_ACC1.put(Fields.ACC_TITLE, ORG2.get(Fields.ORG_NAME))
		ORG2_ACC1.put(Fields.ACC_OWNERSHIP, 'Primary')
		ORG2_ACC1.put(Fields.ACC_DESCRIPTION, 'CD account')
		ORG2_ACC1.put(Fields.ACC_GROUP, 'Banking')
		ORG2_ACC1.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyy", common.timezoneUTC)+'01'+RandomUtil.getRandomNumeric(4))
		//ORG2_ACC1.put(Fields.ACC_NUMBER, '')
		ORG2_ACC1.put(Fields.ACC_BROKERED, 'false')
		ORG2_ACC1.put(Fields.ACC_TIMEZONE, 'UTC')
		ORG2_ACC1.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		ORG2_ACC1.put(Fields.ACC_PRODUCT_TYPE, '6 Month Compounding-Business')
		ORG2_ACC1.put(Fields.ACC_POSITION_NAME, '6 Month Compounding-Business')
		ORG2_ACC1.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ORG2_ACC1.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ORG2_ACC1.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ORG2_ACC1.put(Fields.ACC_DEPT_ID, 'Department 350')
		ORG2_ACC1.put(Fields.ACC_DEPT_ID_VIEW, '350')
		ORG2_ACC1.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		ORG2_ACC1.put(Fields.DOC_TYPE, 'Terms and conditions')
		ORG2_ACC1.put(Fields.DOC_SIGNED_BY, ORG2.get(Fields.ORG_NAME))
		ORG2_ACC1.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezone))
		ORG2_ACC1.put(Fields.DOC_VERSION, '01')

		ORG2_ACC1.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		ORG2_ACC1.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		ORG2_ACC1.put(Fields.IS_CREATED, 'false')
	}
}
