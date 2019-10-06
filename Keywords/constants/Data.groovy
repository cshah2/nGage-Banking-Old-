package constants

import java.text.NumberFormat

import org.apache.commons.lang3.RandomStringUtils

import com.kms.katalon.core.configuration.RunConfiguration

import enums.Fields
import utils.DateUtil
import utils.RandomUtil

public class Data {

	public static final Map<Fields, String> CUSTOMER_001;
	static {
		CUSTOMER_001 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		CUSTOMER_001.put(Fields.CUST_PREFIX, parsedJson.get("results").get(0).get("name").get("title"))
		CUSTOMER_001.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		CUSTOMER_001.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(1))
		CUSTOMER_001.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUSTOMER_001.put(Fields.CUST_NAME_VIEW, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001.put(Fields.CUST_SUFFIX, 'Jr.')
		CUSTOMER_001.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
		CUSTOMER_001.put(Fields.CUST_DOB_MASKED, '**/**/'+CUSTOMER_001.get(Fields.CUST_DOB).substring(6))
		CUSTOMER_001.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		CUSTOMER_001.put(Fields.CUST_TAX_ID_MASKED, '*****'+CUSTOMER_001.get(Fields.CUST_TAX_ID).substring(5))
		CUSTOMER_001.put(Fields.CUST_TAX_ID_TYPE, 'SSN')
		CUSTOMER_001.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUSTOMER_001.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')

		//Customer Details
		CUSTOMER_001.put(Fields.CUST_FAMILIAR_NAME, 'CHINOO')
		CUSTOMER_001.put(Fields.CUST_MAIDEN_NAME, 'SHAH')
		CUSTOMER_001.put(Fields.CUST_MARITAL_STATUS, 'Single')
		CUSTOMER_001.put(Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS, '8')
		CUSTOMER_001.put(Fields.CUST_MOTHERS_MAIDEN_NAME, 'JOSHI')
		CUSTOMER_001.put(Fields.CUST_PREFERRED_LANGUAGE, 'English - United States')
		CUSTOMER_001.put(Fields.CUST_ALTERNATE_LANGUAGE, 'Hindi - India')
		CUSTOMER_001.put(Fields.CUST_AGE_BRACKET, '21 - 30')

		//Location Information
		CUSTOMER_001.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
		CUSTOMER_001.put(Fields.ADDR_CITY, 'Philadelphia')
		CUSTOMER_001.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUSTOMER_001.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		CUSTOMER_001.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		CUSTOMER_001.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		CUSTOMER_001.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.ADDR_VIEW, CUSTOMER_001.get(Fields.ADDR_STREET)+', '+CUSTOMER_001.get(Fields.ADDR_CITY)+', PA '+CUSTOMER_001.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		CUSTOMER_001.put(Fields.CT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		CUSTOMER_001.put(Fields.CT_PHONE_TYPE, 'Mobile')
		CUSTOMER_001.put(Fields.CT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		CUSTOMER_001.put(Fields.CT_EMAIL_TYPE, 'Personal')
		CUSTOMER_001.put(Fields.CT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, common.dateFormat, common.timezoneUTC))
		CUSTOMER_001.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')

		//Customer Due diligence
		CUSTOMER_001.put(Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE, 'true')
		CUSTOMER_001.put(Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY, 'India')
		CUSTOMER_001.put(Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE, 'Family Member')

		//Education and Occupation details
		CUSTOMER_001.put(Fields.CUST_EMPLOYMENT_STATUS, 'Part-time')
		CUSTOMER_001.put(Fields.CUST_OCCUPATION, 'Computer and Mathmatical')
		CUSTOMER_001.put(Fields.CUST_MONTHLY_GROSS_INCOME, '30000')
		CUSTOMER_001.put(Fields.CUST_MILITARY_STATUS, 'Inactive')
		CUSTOMER_001.put(Fields.CUST_EDUCATION, 'High school or GED')
		CUSTOMER_001.put(Fields.CUST_STUDENT_TYPE, 'Full Time on campus')
		CUSTOMER_001.put(Fields.CUST_WEB_ADDRESS, 'http://www.savanainc.com')

		//Customer Information
		CUSTOMER_001.put(Fields.CUST_CUSTOMER_ID, 'CID_'+RandomUtil.getRandomNumeric(6))
		CUSTOMER_001.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')

		//Script data
		CUSTOMER_001.put(Fields.IS_CREATED, 'false')
		CUSTOMER_001.put(Fields.URL, '')
	}

	public static final Map<Fields, String> CUSTOMER_001_ADDRESS2;
	static {
		CUSTOMER_001_ADDRESS2 = new HashMap<Fields, String>()
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_CITY, 'Austin')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_STATE, 'Texas')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ZIPCODE, '2'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ADDRESS_TYPE, 'Work/Office')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ADDRESS_LABEL, 'OFFICE')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_VIEW, CUSTOMER_001_ADDRESS2.get(Fields.ADDR_STREET)+', '+CUSTOMER_001_ADDRESS2.get(Fields.ADDR_CITY)+', TX '+CUSTOMER_001_ADDRESS2.get(Fields.ADDR_ZIPCODE))
		CUSTOMER_001_ADDRESS2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ADDRESS2_EDIT;
	static {
		CUSTOMER_001_ADDRESS2_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street Change')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_CITY, 'Phoenix')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_STATE, 'Arizona')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_ZIPCODE, '3'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_ADDRESS_TYPE, 'Headquarter')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_ADDRESS_LABEL, 'Head Office')
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.ADDR_VIEW, CUSTOMER_001_ADDRESS2_EDIT.get(Fields.ADDR_STREET)+', '+CUSTOMER_001_ADDRESS2_EDIT.get(Fields.ADDR_CITY)+', AZ '+CUSTOMER_001_ADDRESS2_EDIT.get(Fields.ADDR_ZIPCODE))
		CUSTOMER_001_ADDRESS2_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_PHONE2;
	static {
		CUSTOMER_001_PHONE2 = new HashMap<Fields, String>()
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_TYPE, 'Home')
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_LABEL, 'HOME')
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_001_PHONE2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_PHONE2_EDIT;
	static {
		CUSTOMER_001_PHONE2_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_PHONE2_EDIT.put(Fields.CT_PHONE_TYPE, 'Mobile')
		CUSTOMER_001_PHONE2_EDIT.put(Fields.CT_PHONE_LABEL, 'PERSONAL')
		CUSTOMER_001_PHONE2_EDIT.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_001_PHONE2_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_EMAIL2;
	static {
		CUSTOMER_001_EMAIL2 = new HashMap<Fields, String>()
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL_TYPE, 'Personal')
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL_LABEL, 'SELF')
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL, 'my.emaila@exmaple.com')
		CUSTOMER_001_EMAIL2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_EMAIL2_EDIT;
	static {
		CUSTOMER_001_EMAIL2_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_EMAIL2_EDIT.put(Fields.CT_EMAIL_TYPE, 'Work')
		CUSTOMER_001_EMAIL2_EDIT.put(Fields.CT_EMAIL_LABEL, 'OFFICE')
		CUSTOMER_001_EMAIL2_EDIT.put(Fields.CT_EMAIL, 'my.emailb@exmaple.com')
		CUSTOMER_001_EMAIL2_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DOCUMENT1;
	static {
		CUSTOMER_001_DOCUMENT1 = new HashMap<Fields, String>()
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_FILEPATH, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\UploadFiles\\CustomerDocument-AddressUpdate.pdf')
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_CLASS, 'Customer Legal Documents')
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_TYPE, 'Affidavit')
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_START_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_END_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_RECEIVED_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_STATUS, 'New')
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_DESCRIPTION, 'This is customer legal document - affidavit')
		CUSTOMER_001_DOCUMENT1.put(Fields.DOCUMENT_TITLE, CUSTOMER_001_DOCUMENT1.get(Fields.DOCUMENT_TYPE)+' Cust # '+CUSTOMER_001.get(Fields.CUST_CUSTOMER_ID)+' - Recvd '+CUSTOMER_001_DOCUMENT1.get(Fields.DOCUMENT_RECEIVED_DATE))
		CUSTOMER_001_DOCUMENT1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DOCUMENT1_EDIT;
	static {
		CUSTOMER_001_DOCUMENT1_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_FILEPATH, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\UploadFiles\\CustomerDocument-AddressUpdate.pdf')
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_CLASS, 'Customer Legal Documents')
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_TYPE, 'Death Certificate')
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_START_DATE, DateUtil.getCurrentDateTimeMinusDays(3, common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_END_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_RECEIVED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_STATUS, 'In Review')
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_DESCRIPTION, 'This is customer legal document - affidavit Edit')
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.DOCUMENT_TITLE, CUSTOMER_001_DOCUMENT1_EDIT.get(Fields.DOCUMENT_TYPE)+' Cust # '+CUSTOMER_001.get(Fields.CUST_CUSTOMER_ID)+' - Recvd '+CUSTOMER_001_DOCUMENT1_EDIT.get(Fields.DOCUMENT_RECEIVED_DATE))
		CUSTOMER_001_DOCUMENT1_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DOCUMENT2;
	static {
		CUSTOMER_001_DOCUMENT2 = new HashMap<Fields, String>()
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_FILEPATH, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\UploadFiles\\CustomerDocument-AddressUpdate.pdf')
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_CLASS, 'Customer Notices')
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_TYPE, 'Notice of Change of Address')
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_START_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_END_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_RECEIVED_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_STATUS, 'New')
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_DESCRIPTION, 'This is customer notice for change of address')
		CUSTOMER_001_DOCUMENT2.put(Fields.DOCUMENT_TITLE, CUSTOMER_001_DOCUMENT2.get(Fields.DOCUMENT_TYPE)+' Cust # '+CUSTOMER_001.get(Fields.CUST_CUSTOMER_ID)+' - Recvd '+CUSTOMER_001_DOCUMENT2.get(Fields.DOCUMENT_RECEIVED_DATE))
		CUSTOMER_001_DOCUMENT2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DDA_ACCOUNT;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_DDA_ACCOUNT = new HashMap<Fields, String>()
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_DESCRIPTION, 'DDA Account')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings with Checking')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_POSITION_NAME, 'Personal Savings with Checking')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.DOC_SIGNED_DATE, currentDateTime)
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.DOC_SIGNED_DATE_VIEW, DateUtil.convert(currentDateTime, common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DDA_ACCOUNT_TXN1;
	static {
		CUSTOMER_001_DDA_ACCOUNT_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_CODE, 'DDA Deposit')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT, '5000')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT_VIEW, '5,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_COMMENT, 'Credit 5000')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE, '5,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '5,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_DDA_ACCOUNT_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_DDA_ACCOUNT_TXN2;
	static {
		CUSTOMER_001_DDA_ACCOUNT_TXN2 = new HashMap<Fields, String>()
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_CODE, 'DDA Withdrawal')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT, '2000')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT_VIEW, '2,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_COMMENT, 'Withdraw 2000')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE, '3,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE, '3,000.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_ID, '')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.TXN_TYPE, 'DEBIT')
		CUSTOMER_001_DDA_ACCOUNT_TXN2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_CD_ACCOUNT;
	static {
		CUSTOMER_001_CD_ACCOUNT = new HashMap<Fields, String>()
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_DESCRIPTION, 'CD Account')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_PRODUCT_TYPE, '6 Month Compounding-Business')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_POSITION_NAME, '6 Month Compounding-Business')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_CD_ACCOUNT.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_CD_ACCOUNT.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_CD_ACCOUNT.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_CD_ACCOUNT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_CD_ACCOUNT_TXN1;
	static {
		CUSTOMER_001_CD_ACCOUNT_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_CODE, 'CD Miscellaneous Credit')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT, '5000')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT_VIEW, '5,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_COMMENT, 'Credit 5000')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE, '5,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '5,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_CD_ACCOUNT_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_CD_ACCOUNT_TXN2;
	static {
		CUSTOMER_001_CD_ACCOUNT_TXN2 = new HashMap<Fields, String>()
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_CODE, 'CD Miscellaneous Debit')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT, '2000')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT_VIEW, '2,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_COMMENT, 'Withdraw 2000')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE, '3,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE, '3,000.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_ID, '')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.TXN_TYPE, 'DEBIT')
		CUSTOMER_001_CD_ACCOUNT_TXN2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACCOUNT;
	static {
		CUSTOMER_001_SAVING_ACCOUNT = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACCOUNT_TXN1;
	static {
		CUSTOMER_001_SAVING_ACCOUNT_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_CODE, 'Savings Miscellaneous Credit')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT, '5000')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_AMOUNT_VIEW, '5,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_COMMENT, 'Credit 5000')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.ACC_LEDGER_BALANCE, '5,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '5,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_SAVING_ACCOUNT_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACCOUNT_TXN2;
	static {
		CUSTOMER_001_SAVING_ACCOUNT_TXN2 = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_CODE, 'Savings Miscellaneous Debit')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT, '500')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_COMMENT, 'Withdraw 500')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.ACC_LEDGER_BALANCE, '4,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '5,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.ACC_AVAILABLE_BALANCE, '4,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_ID, '')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.TXN_TYPE, 'DEBIT')
		CUSTOMER_001_SAVING_ACCOUNT_TXN2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACCOUNT_TXN3;
	static {
		CUSTOMER_001_SAVING_ACCOUNT_TXN3 = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_CODE, 'Savings Deposit Cash')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_AMOUNT, '1000')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_AMOUNT_VIEW, '1,000.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_COMMENT, 'Deposit Cash 1000')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '4,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.ACC_LEDGER_BALANCE, '5,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '4,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.ACC_AVAILABLE_BALANCE, '5,500.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_ID, '')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_SAVING_ACCOUNT_TXN3.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezone)

		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2 = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2.put(Fields.DOC_TYPE, 'Electronic statement consent')
		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2.put(Fields.DOC_SIGNED_DATE, currentDateTime)
		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2.put(Fields.DOC_SIGNED_DATE_VIEW, DateUtil.convert(currentDateTime, common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_SAVING_ACCOUNT_ACC_DOC2.put(Fields.DOC_VERSION, '01')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACC_DOCUMENT1;
	static {
		CUSTOMER_001_SAVING_ACC_DOCUMENT1 = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_FILEPATH, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\UploadFiles\\AccountrDocument-Notices.pdf')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_CLASS, 'Account Notices')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_TYPE, 'Return Mail Notice')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_START_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_END_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_RECEIVED_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_STATUS, 'New')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_DESCRIPTION, 'This is account document - notice')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.DOCUMENT_TITLE, CUSTOMER_001_SAVING_ACC_DOCUMENT1.get(Fields.DOCUMENT_TYPE)+' Cust # '+CUSTOMER_001.get(Fields.CUST_CUSTOMER_ID)+' - Recvd '+CUSTOMER_001_DOCUMENT1.get(Fields.DOCUMENT_RECEIVED_DATE))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT;
	static {
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_FILEPATH, RunConfiguration.getProjectDir().replace('/', '\\')+'\\Data Files\\UploadFiles\\AccountrDocument-Notices.pdf')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_CLASS, 'Account Notices')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_TYPE, 'Account Declination')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_START_DATE, DateUtil.getCurrentDateTimeMinusDays(3, common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_END_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_RECEIVED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezone))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_STATUS, 'In Review')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_DESCRIPTION, 'This is account document - Declination')
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.DOCUMENT_TITLE, CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.get(Fields.DOCUMENT_TYPE)+' Cust # '+CUSTOMER_001.get(Fields.CUST_CUSTOMER_ID)+' - Recvd '+CUSTOMER_001_DOCUMENT1_EDIT.get(Fields.DOCUMENT_RECEIVED_DATE))
		CUSTOMER_001_SAVING_ACC_DOCUMENT1_EDIT.put(Fields.IS_CREATED, 'false')
	}


	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01;
	static {
		CUSTOMER_001_HOLD_ACCOUNT01 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_TXN1;
	static {
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_CODE, 'Savings Miscellaneous Credit')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_AMOUNT, '10000')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_AMOUNT_VIEW, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_COMMENT, 'Credit 10000')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_HOLD_ACCOUNT01_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD1;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_TYPE, 'Clearing')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_DURATION, 'One Business Day')
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_DURATION_VIEW, '1B')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_DURATION_VIEW, 'One Business Day')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_AMOUNT, '500')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_NOTE, 'Clearing Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_REASON, 'Reason 01')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.ACC_AVAILABLE_BALANCE, '9,500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.ACC_HOLD_BALANCE, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_PRE_AUTH, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_REG_CC, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD2;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_TYPE, 'PreAuth')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_DURATION, 'Six Months')
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_DURATION_VIEW, '6M')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_DURATION_VIEW, 'Six Months')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_AMOUNT, '400')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_AMOUNT_VIEW, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_NOTE, 'PreAuth Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_REASON, 'Reason 02')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.ACC_AVAILABLE_BALANCE, '9,100.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.ACC_HOLD_BALANCE, '900.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_REG_CC, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD3;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_TYPE, 'RegCC')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_DURATION, 'Eighteen Months')
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_DURATION_VIEW, '18M')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_DURATION_VIEW, 'Eighteen Months')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_AMOUNT, '300')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_AMOUNT_VIEW, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_NOTE, 'RegCC Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_REASON, 'Reason 03')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.ACC_AVAILABLE_BALANCE, '8,800.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.ACC_HOLD_BALANCE, '1,200.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD3.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD4;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_TYPE, 'Reserve')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_DURATION, 'Thirty-six Months')
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_DURATION_VIEW, '36M')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_DURATION_VIEW, 'Thirty-six Months')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_AMOUNT, '200')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_AMOUNT_VIEW, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_NOTE, 'Reserve Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_REASON, 'Reason 04')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.ACC_AVAILABLE_BALANCE, '8,600.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.ACC_HOLD_BALANCE, '1,400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD4.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD5;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_TYPE, 'Admin')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_DURATION, 'Three Business Days')
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_DURATION_VIEW, '3B')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_DURATION_VIEW, 'Three Business Days')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_AMOUNT, '100')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_AMOUNT_VIEW, '100.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_NOTE, 'Admin Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_REASON, 'Reason 05')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.ACC_AVAILABLE_BALANCE, '8,500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.ACC_HOLD_BALANCE, '1,500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.HOLD_ADMIN, '100.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL;
	static {
		String currentDateTime = DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_TYPE, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_TYPE))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_START_DATE, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_START_DATE))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_START_DATE_VIEW, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_START_DATE_VIEW))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_DURATION, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_DURATION))
		//CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_DURATION_VIEW, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_DURATION_VIEW))
		//TODO: Bug for Initial Duration - View
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_DURATION_VIEW, '3B')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_AMOUNT, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_AMOUNT))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_AMOUNT_VIEW, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_AMOUNT_VIEW))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_NOTE, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_NOTE))
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_REASON, CUSTOMER_001_HOLD_ACCOUNT01_HOLD5.get(Fields.HOLD_REASON))

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_CANCEL_NOTE, 'Cancel Admin Hold')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_CANCEL_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_CANCEL_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.get(Fields.HOLD_CANCEL_DATE), common.dateTimeFormat, common.dateFormat))

		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.ACC_AVAILABLE_BALANCE, '8,600.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.ACC_HOLD_BALANCE, '1,400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT01_HOLD5_CANCEL.put(Fields.IS_CREATED, 'false')
	}



	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02;
	static {
		CUSTOMER_001_HOLD_ACCOUNT02 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_TXN1;
	static {
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_CODE, 'Savings Miscellaneous Credit')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_AMOUNT, '10000')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_AMOUNT_VIEW, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_COMMENT, 'Credit 10000')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_HOLD_ACCOUNT02_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD1;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-2, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_TYPE, 'Clearing')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_DURATION, 'One Business Day')
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_DURATION_VIEW, '1B')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_DURATION_VIEW, 'One Business Day')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_AMOUNT, '500')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_NOTE, 'Clearing Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_REASON, 'Reason 01')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.ACC_HOLD_BALANCE, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_PRE_AUTH, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_REG_CC, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD2;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-2, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_TYPE, 'PreAuth')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_DURATION, 'Six Months')
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_DURATION_VIEW, '6M')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_DURATION_VIEW, 'Six Months')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_AMOUNT, '400')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_AMOUNT_VIEW, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_NOTE, 'PreAuth Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_REASON, 'Reason 02')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.ACC_HOLD_BALANCE, '900.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_REG_CC, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD3;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-2, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_TYPE, 'RegCC')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_DURATION, 'Eighteen Months')
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_DURATION_VIEW, '18M')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_DURATION_VIEW, 'Eighteen Months')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_AMOUNT, '300')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_AMOUNT_VIEW, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_NOTE, 'RegCC Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_REASON, 'Reason 03')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.ACC_HOLD_BALANCE, '1,200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_RESERVE, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD3.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD4;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-2, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_TYPE, 'Reserve')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_DURATION, 'Thirty-six Months')
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_DURATION_VIEW, '36M')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_DURATION_VIEW, 'Thirty-six Months')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_AMOUNT, '200')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_AMOUNT_VIEW, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_NOTE, 'Reserve Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_REASON, 'Reason 04')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.ACC_HOLD_BALANCE, '1,400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD4.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD5;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-2, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5 = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_TYPE, 'Admin')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_DURATION, 'Three Business Days')
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_DURATION_VIEW, '3B')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_DURATION_VIEW, 'Three Business Days')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_AMOUNT, '100')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_AMOUNT_VIEW, '100.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_NOTE, 'Admin Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_REASON, 'Reason 05')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.ACC_HOLD_BALANCE, '1,500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_CLEARING, '500.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.HOLD_ADMIN, '100.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT;
	static {
		String currentDateTime = DateUtil.getCurrentDateTimeMinusDays(-3, common.dateTimeFormat, common.timezoneUTC)

		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_TYPE, 'Clearing')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_START_DATE, currentDateTime)
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_START_DATE_VIEW, DateUtil.convert(CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.get(Fields.HOLD_START_DATE), common.dateTimeFormat, common.dateFormat))
		//CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_DURATION_VIEW, '3B')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_DURATION_VIEW, 'Three Business Days')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_AMOUNT, '700')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_AMOUNT_VIEW, '700.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_NOTE, 'Update Hold')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_REASON, 'Reason 06')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.ACC_HOLD_BALANCE, '2,100.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_PRE_AUTH, '400.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_REG_CC, '300.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_CLEARING, '1,200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_RESERVE, '200.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.HOLD_ADMIN, '0.00')
		CUSTOMER_001_HOLD_ACCOUNT02_HOLD5_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01;
	static {
		CUSTOMER_001_ORDER_FROM_ACC01 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_TO_ACC01;
	static {
		CUSTOMER_001_ORDER_TO_ACC01 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_TITLE, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_OWNERSHIP, 'Primary')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_DESCRIPTION, 'Savings Account')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_GROUP, 'Banking')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyyyy", common.timezoneUTC)+RandomUtil.getRandomNumeric(4))
		//CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_NUMBER, '')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_BROKERED, 'false')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_TIMEZONE, 'UTC')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_PRODUCT_TYPE, 'Personal Savings')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_POSITION_NAME, 'Personal Savings')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_VERTICAL, 'Vertical 01')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_DEPT_ID, 'Department 350')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_DEPT_ID_VIEW, '350')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.DOC_TYPE, 'Terms and conditions')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.DOC_SIGNED_BY, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.DOC_VERSION, '01')

		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		CUSTOMER_001_ORDER_TO_ACC01.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_TXN1;
	static {
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_CODE, 'Savings Miscellaneous Credit')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_AMOUNT, '10000')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_AMOUNT_VIEW, '10,000.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_COMMENT, 'Credit 10000')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.ACC_LEDGER_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.ACC_LEDGER_BALANCE, '10,000.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.ACC_AVAILABLE_BALANCE_BEFORE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.ACC_AVAILABLE_BALANCE, '10,000.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_ID, '')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.TXN_TYPE, 'CREDIT')
		CUSTOMER_001_ORDER_FROM_ACC01_TXN1.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER01;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_TYPE, 'Book transfer')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_INFO, 'Order 500')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_ORIGIN_SOURCE, 'Telephone')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SAME CUSTOMER TO ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP, 'Banking')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_TRANSFER_DATE_VIEW, 'Immediate')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_TRANSFER_AMOUNT, '500')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.ORDER_STATUS, 'Completed')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.TXN_CODE, 'Funds Transfer')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.TXN_COMMENT, 'Internal Transfer Out')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.TXN_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.ACC_LEDGER_BALANCE, '9,500.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.ACC_AVAILABLE_BALANCE, '9,500.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER01_BAL.put(Fields.TXN_TYPE, 'DEBIT')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL;
	static {
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.TXN_CODE, 'Funds Transfer')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.TXN_COMMENT, 'Internal Transfer In')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.TXN_AMOUNT_VIEW, '500.00')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.ACC_LEDGER_BALANCE, '500.00')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.ACC_AVAILABLE_BALANCE, '500.00')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_ORDER_TO_ACC01_ORDER01_BAL.put(Fields.TXN_TYPE, 'CREDIT')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER02;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_TYPE, 'Payment order')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_INFO, 'Order 400')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_ORIGIN_SOURCE, 'Prearranged')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SELF ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_ROUTING_NUMBER, '043000096')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_TRANSFER_DATE_VIEW, 'Immediate')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_TRANSFER_AMOUNT, '400')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '400.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.TXN_CODE, 'Transfer Out')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.TXN_COMMENT, 'ACH Transfer Out')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.TXN_AMOUNT_VIEW, '400.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.ACC_LEDGER_BALANCE, '9,100.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.ACC_AVAILABLE_BALANCE, '9,100.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER02_BAL.put(Fields.TXN_TYPE, 'DEBIT')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER03;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_TYPE, 'Collection order')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_INFO, 'Order 300')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_ORIGIN_SOURCE, 'Internet/mobile')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SELF ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_ROUTING_NUMBER, '043000096')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_TRANSFER_DATE_VIEW, 'Immediate')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_TRANSFER_AMOUNT, '300')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '300.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.TXN_CODE, 'Transfer In')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.TXN_COMMENT, 'ACH Transfer In')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.TXN_AMOUNT_VIEW, '300.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.ACC_LEDGER_BALANCE, '9,400.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.ACC_AVAILABLE_BALANCE, '9,1000.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.ACC_HOLD_BALANCE, '0.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER03_BAL.put(Fields.TXN_TYPE, 'CREDIT')
	}


	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER04;
	static {

		String orderDateTime = DateUtil.getCurrentDateTimeMinusDays(-3, common.dateTimeFormat, common.timezoneUTC)
		String orderDateView = DateUtil.convert(orderDateTime, common.dateTimeFormat, common.dateFormat)

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_TYPE, 'Book transfer')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_INFO, 'Order 450')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_ORIGIN_SOURCE, 'Telephone')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SAME CUSTOMER TO ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP, 'Banking')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_TRANSFER_DATE, orderDateTime)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_TRANSFER_DATE_VIEW, orderDateView)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_TRANSFER_AMOUNT, '450')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '450.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.ORDER_STATUS, 'Entered')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER04.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER05;
	static {

		String orderDateTime = DateUtil.getCurrentDateTimeMinusDays(-3, common.dateTimeFormat, common.timezoneUTC)
		String orderDateView = DateUtil.convert(orderDateTime, common.dateTimeFormat, common.dateFormat)

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_TYPE, 'Payment order')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_INFO, 'Order 350')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_ORIGIN_SOURCE, 'Prearranged')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SELF ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_ROUTING_NUMBER, '043000096')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_TRANSFER_DATE, orderDateTime)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_TRANSFER_DATE_VIEW, orderDateView)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_TRANSFER_AMOUNT, '350')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '350.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.ORDER_STATUS, 'Entered')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER05.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER06;
	static {

		String orderDateTime = DateUtil.getCurrentDateTimeMinusDays(-3, common.dateTimeFormat, common.timezoneUTC)
		String orderDateView = DateUtil.convert(orderDateTime, common.dateTimeFormat, common.dateFormat)

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06 = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_TYPE, 'Collection order')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_SOURCE, 'Bank operations')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_INFO, 'Order 250')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_ORIGIN_SOURCE, 'Internet/mobile')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, 'SELF ACCOUNT')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_ROUTING_NUMBER, '043000096')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE, 'Savings deposit account')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_TRANSFER_DATE, orderDateTime)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_TRANSFER_DATE_VIEW, orderDateView)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_TRANSFER_AMOUNT, '250')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '250.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.ORDER_STATUS, 'Entered')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT;
	static {

		String orderDateTime = DateUtil.getCurrentDateTimeMinusDays(-5, common.dateTimeFormat, common.timezoneUTC)
		String orderDateView = DateUtil.convert(orderDateTime, common.dateTimeFormat, common.dateFormat)

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_TYPE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_TYPE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_SOURCE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_SOURCE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_INFO, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_INFO))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_ORIGIN_SOURCE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_ORIGIN_SOURCE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_ROUTING_NUMBER, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_ROUTING_NUMBER))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_TRANSFER_DATE, orderDateTime)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_TRANSFER_DATE_VIEW, orderDateView)
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_TRANSFER_AMOUNT, '350')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, '350.00')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.ORDER_STATUS, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06.get(Fields.ORDER_STATUS))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL;
	static {

		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL = new HashMap<Fields, String>()
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_TYPE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_TYPE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_SOURCE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_SOURCE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_INFO, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_INFO))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_ORIGIN_SOURCE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_ORIGIN_SOURCE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_ROUTING_NUMBER, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_ROUTING_NUMBER))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_TRANSFER_DATE, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_TRANSFER_DATE))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_TRANSFER_DATE_VIEW, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_TRANSFER_DATE_VIEW))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_TRANSFER_AMOUNT, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_TRANSFER_AMOUNT))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_TRANSFER_AMOUNT_VIEW, CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT.get(Fields.ORDER_TRANSFER_AMOUNT_VIEW))
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.ORDER_STATUS, 'Canceled')
		CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL.put(Fields.IS_CREATED, 'false')
	}












	public static final Map<Fields, String> CUSTOMER_002;
	static {
		CUSTOMER_002 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		//Basic Information
		CUSTOMER_002.put(Fields.CUST_PREFIX, parsedJson.get("results").get(0).get("name").get("title"))
		CUSTOMER_002.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		CUSTOMER_002.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(1))
		CUSTOMER_002.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUSTOMER_002.put(Fields.CUST_SUFFIX, 'Jr.')
		CUSTOMER_002.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
		CUSTOMER_002.put(Fields.CUST_DOB_MASKED, '**/**/'+CUSTOMER_002.get(Fields.CUST_DOB).substring(6))
		CUSTOMER_002.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
		CUSTOMER_002.put(Fields.CUST_TAX_ID_MASKED, '*****'+CUSTOMER_002.get(Fields.CUST_TAX_ID).substring(5))
		CUSTOMER_002.put(Fields.CUST_TAX_ID_TYPE, 'SSN')
		CUSTOMER_002.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUSTOMER_002.put(Fields.CUST_RESIDENCY_STATUS, 'Non-Resident')
		CUSTOMER_002.put(Fields.CUST_MARITAL_STATUS, 'Married')
		CUSTOMER_002.put(Fields.CUST_NAME_VIEW, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))

		//Customer Details
		CUSTOMER_002.put(Fields.CUST_MOTHERS_MAIDEN_NAME, 'DOSHI')

		//Location Information
		CUSTOMER_002.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
		CUSTOMER_002.put(Fields.ADDR_CITY, 'Philadelphia')
		CUSTOMER_002.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_002.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUSTOMER_002.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
		CUSTOMER_002.put(Fields.ADDR_ADDRESS_TYPE, 'Work/Office')
		CUSTOMER_002.put(Fields.ADDR_ADDRESS_LABEL, 'OFFICE')
		CUSTOMER_002.put(Fields.ADDR_VIEW, CUSTOMER_002.get(Fields.ADDR_STREET)+', '+CUSTOMER_002.get(Fields.ADDR_CITY)+', PA '+CUSTOMER_002.get(Fields.ADDR_ZIPCODE))

		//Contact Information
		CUSTOMER_002.put(Fields.CT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
		CUSTOMER_002.put(Fields.CT_PHONE_TYPE, 'Work')
		CUSTOMER_002.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		CUSTOMER_002.put(Fields.CT_EMAIL_TYPE, 'Work')
		CUSTOMER_002.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Phone-Text')

		//Customer Due diligence

		//Education and Occupation details

		//Customer Information
		CUSTOMER_002.put(Fields.CUST_CUSTOMER_ID, 'CID_'+RandomUtil.getRandomNumeric(6))
		CUSTOMER_002.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')
		CUSTOMER_002.put(Fields.CUST_CHK_ACCOUNT, 'true')

		//Script Data
		CUSTOMER_002.put(Fields.IS_CREATED, 'false')
		CUSTOMER_002.put(Fields.URL, '')
	}

	public static final Map<Fields, String> ACCOUNT_001;
	static {
		ACCOUNT_001 = new HashMap<Fields, String>()
		ACCOUNT_001.put(Fields.ACC_TITLE, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_001.put(Fields.ACC_OWNERSHIP, 'Primary')
		ACCOUNT_001.put(Fields.ACC_DESCRIPTION, 'CD account')
		ACCOUNT_001.put(Fields.ACC_GROUP, 'Banking')
		ACCOUNT_001.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyy", common.timezoneUTC)+'01'+RandomUtil.getRandomNumeric(4))
		//ACCOUNT_001.put(Fields.ACC_NUMBER, '')
		ACCOUNT_001.put(Fields.ACC_BROKERED, 'false')
		ACCOUNT_001.put(Fields.ACC_TIMEZONE, 'UTC')
		ACCOUNT_001.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		ACCOUNT_001.put(Fields.ACC_PRODUCT_TYPE, '6 Month Compounding-Business')
		ACCOUNT_001.put(Fields.ACC_POSITION_NAME, '6 Month Compounding-Business')
		ACCOUNT_001.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ACCOUNT_001.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ACCOUNT_001.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ACCOUNT_001.put(Fields.ACC_DEPT_ID, 'Department 350')
		ACCOUNT_001.put(Fields.ACC_DEPT_ID_VIEW, '350')
		ACCOUNT_001.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		ACCOUNT_001.put(Fields.DOC_TYPE, 'Terms and conditions')
		ACCOUNT_001.put(Fields.DOC_SIGNED_BY, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_001.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		ACCOUNT_001.put(Fields.DOC_VERSION, '01')

		ACCOUNT_001.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		ACCOUNT_001.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		ACCOUNT_001.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> ACCOUNT_002;
	static {
		ACCOUNT_002 = new HashMap<Fields, String>()
		ACCOUNT_002.put(Fields.ACC_TITLE, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_002.put(Fields.ACC_OWNERSHIP, 'Primary')
		ACCOUNT_002.put(Fields.ACC_DESCRIPTION, 'Loan account')
		ACCOUNT_002.put(Fields.ACC_GROUP, 'Banking')
		ACCOUNT_002.put(Fields.ACC_NUMBER, DateUtil.getCurrentDateTimeMinusDays(0, "MMddyy", common.timezoneUTC)+'02'+RandomUtil.getRandomNumeric(4))
		//ACCOUNT_002.put(Fields.ACC_NUMBER, '')
		ACCOUNT_002.put(Fields.ACC_BROKERED, 'false')
		ACCOUNT_002.put(Fields.ACC_TIMEZONE, 'UTC')
		ACCOUNT_002.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		ACCOUNT_002.put(Fields.ACC_PRODUCT_TYPE, 'Mortgage Personal Loan')
		ACCOUNT_002.put(Fields.ACC_PRODUCT_NAME, 'MTG')
		ACCOUNT_002.put(Fields.ACC_POSITION_NAME, 'Mortgage Personal Loan')
		ACCOUNT_002.put(Fields.ACC_CURRENCY_CODE, 'US Dollar')
		ACCOUNT_002.put(Fields.ACC_CURRENCY_CODE_VIEW, 'USD')
		ACCOUNT_002.put(Fields.ACC_VERTICAL, 'Vertical 01')
		ACCOUNT_002.put(Fields.ACC_DEPT_ID, 'Department 350')
		ACCOUNT_002.put(Fields.ACC_DEPT_ID_VIEW, '350')
		ACCOUNT_002.put(Fields.ACC_CREDIT_LIMIT, '100000')
		//		ACCOUNT_002.put(Fields.ACC_INTEREST_RATE, '8') Field has been removed Date - 07 July 2019
		ACCOUNT_002.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC))
		ACCOUNT_002.put(Fields.DOC_TYPE, 'Terms and conditions')
		ACCOUNT_002.put(Fields.DOC_SIGNED_BY, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_002.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime(common.dateTimeFormat, common.timezoneUTC))
		ACCOUNT_002.put(Fields.DOC_VERSION, '01')

		ACCOUNT_002.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		ACCOUNT_002.put(Fields.ACC_AVAILABLE_BALANCE, '100,000.00')
		ACCOUNT_002.put(Fields.IS_CREATED, 'false')
	}

	//Existing Customer Data, To be used when not running test suite
	public static final Map<Fields, String> CUSTOMER_003;
	static {
		CUSTOMER_003 = new HashMap<Fields, String>()

		CUSTOMER_003.put(Fields.CUST_PREFIX, 'Mr.')
		CUSTOMER_003.put(Fields.CUST_FIRST_NAME, 'Scott')
		CUSTOMER_003.put(Fields.CUST_MIDDLE_NAME, '')
		CUSTOMER_003.put(Fields.CUST_LAST_NAME, 'Adkins')
		CUSTOMER_003.put(Fields.CUST_SUFFIX, 'Jr.')
		CUSTOMER_003.put(Fields.CUST_DOB, '06/03/2019')
		CUSTOMER_003.put(Fields.CUST_DOB_MASKED, '**/**/2019')
		CUSTOMER_003.put(Fields.CUST_TAX_ID, '3215478896')
		CUSTOMER_003.put(Fields.CUST_TAX_ID_MASKED, '******8896')
		CUSTOMER_003.put(Fields.CUST_TAX_ID_TYPE, 'SSN')
		CUSTOMER_003.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUSTOMER_003.put(Fields.CUST_RESIDENCY_STATUS, 'Unknown')
		CUSTOMER_003.put(Fields.CUST_MARITAL_STATUS, 'Unknown')
		CUSTOMER_003.put(Fields.CUST_NAME_VIEW, CUSTOMER_003.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_003.get(Fields.CUST_LAST_NAME))

		CUSTOMER_003.put(Fields.ADDR_STREET, '03 June street')
		CUSTOMER_003.put(Fields.ADDR_CITY, 'Nevada')
		CUSTOMER_003.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_003.put(Fields.ADDR_STATE, 'Nevada')
		CUSTOMER_003.put(Fields.ADDR_ZIPCODE, '40215')
		CUSTOMER_003.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		CUSTOMER_003.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		CUSTOMER_003.put(Fields.ADDR_VIEW, CUSTOMER_003.get(Fields.ADDR_STREET)+', '+CUSTOMER_003.get(Fields.ADDR_CITY)+', NV '+CUSTOMER_003.get(Fields.ADDR_ZIPCODE))

		CUSTOMER_003.put(Fields.CT_PHONE_NUMBER, '+919867045059')
		CUSTOMER_003.put(Fields.CT_PHONE_TYPE, 'Mobile')
		CUSTOMER_003.put(Fields.CT_EMAIL, 'sshetty@savanainc.com')
		CUSTOMER_003.put(Fields.CT_EMAIL_TYPE, 'Work')
		CUSTOMER_003.put(Fields.CT_PREFERRED_LANGUAGE, 'English - United States')
		CUSTOMER_003.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Unkwown')

		CUSTOMER_003.put(Fields.CUST_CUSTOMER_ID, '9632154897')
		CUSTOMER_003.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')
		CUSTOMER_003.put(Fields.URL, '')
	}
}