package constants

import org.apache.commons.lang3.RandomStringUtils

import enums.Fields
import utils.DateUtil
import utils.RandomUtil

public class Data {

	public static final Map<Fields, String> CUSTOMER_001;
	static {
		CUSTOMER_001 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		CUSTOMER_001.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		CUSTOMER_001.put(Fields.CUST_MIDDLE_NAME, RandomStringUtils.randomAlphabetic(1))
		CUSTOMER_001.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUSTOMER_001.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
		CUSTOMER_001.put(Fields.CUST_DOB_MASKED, '**/**/'+CUSTOMER_001.get(Fields.CUST_DOB).substring(6))
		CUSTOMER_001.put(Fields.CUST_TAX_ID, '9'+RandomStringUtils.randomNumeric(8))
		CUSTOMER_001.put(Fields.CUST_TAX_ID_MASKED, '*****'+CUSTOMER_001.get(Fields.CUST_TAX_ID).substring(5))
		CUSTOMER_001.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUSTOMER_001.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')
		CUSTOMER_001.put(Fields.CUST_MARITAL_STATUS, 'Single')
		CUSTOMER_001.put(Fields.CUST_NAME_VIEW, CUSTOMER_001.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_001.get(Fields.CUST_LAST_NAME))

		CUSTOMER_001.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' Street')
		CUSTOMER_001.put(Fields.ADDR_CITY, 'Philadelphia')
		CUSTOMER_001.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUSTOMER_001.put(Fields.ADDR_ZIPCODE, '1'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_001.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		CUSTOMER_001.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		CUSTOMER_001.put(Fields.ADDR_VIEW, CUSTOMER_001.get(Fields.ADDR_STREET)+', '+CUSTOMER_001.get(Fields.ADDR_CITY)+', PA '+CUSTOMER_001.get(Fields.ADDR_ZIPCODE))

		CUSTOMER_001.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_001.put(Fields.CT_PHONE_TYPE, 'Mobile')
		CUSTOMER_001.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		CUSTOMER_001.put(Fields.CT_EMAIL_TYPE, 'Personal')
		CUSTOMER_001.put(Fields.CT_PREFERRED_LANGUAGE, 'English - United States')
		CUSTOMER_001.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')

		CUSTOMER_001.put(Fields.CUST_MEMBER_ID, 'MID_'+RandomStringUtils.randomNumeric(6))
		CUSTOMER_001.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')

		CUSTOMER_001.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ADDRESS2;
	static {
		CUSTOMER_001_ADDRESS2 = new HashMap<Fields, String>()
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' Street')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_CITY, 'Austin')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_STATE, 'Texas')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ZIPCODE, '2'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ADDRESS_TYPE, 'Work/Office')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_ADDRESS_LABEL, 'OFFICE')
		CUSTOMER_001_ADDRESS2.put(Fields.ADDR_VIEW, CUSTOMER_001_ADDRESS2.get(Fields.ADDR_STREET)+', '+CUSTOMER_001_ADDRESS2.get(Fields.ADDR_CITY)+', TX '+CUSTOMER_001_ADDRESS2.get(Fields.ADDR_ZIPCODE))
		CUSTOMER_001_ADDRESS2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_ADDRESS3;
	static {
		CUSTOMER_001_ADDRESS3 = new HashMap<Fields, String>()
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' Street Change')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_CITY, 'Phoenix')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_STATE, 'Arizona')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_ZIPCODE, '3'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_ADDRESS_TYPE, 'Headquarter')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_ADDRESS_LABEL, 'Head Office')
		CUSTOMER_001_ADDRESS3.put(Fields.ADDR_VIEW, CUSTOMER_001_ADDRESS3.get(Fields.ADDR_STREET)+', '+CUSTOMER_001_ADDRESS3.get(Fields.ADDR_CITY)+', AZ '+CUSTOMER_001_ADDRESS3.get(Fields.ADDR_ZIPCODE))
		CUSTOMER_001_ADDRESS3.put(Fields.IS_CREATED, 'false')
	}
	
	public static final Map<Fields, String> CUSTOMER_001_PHONE2;
	static {
		CUSTOMER_001_PHONE2 = new HashMap<Fields, String>()
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_TYPE, 'Home')
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_LABEL, 'HOME')
		CUSTOMER_001_PHONE2.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_001_PHONE2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_PHONE3;
	static {
		CUSTOMER_001_PHONE3 = new HashMap<Fields, String>()
		CUSTOMER_001_PHONE3.put(Fields.CT_PHONE_TYPE, 'Mobile')
		CUSTOMER_001_PHONE3.put(Fields.CT_PHONE_LABEL, 'PERSONAL')
		CUSTOMER_001_PHONE3.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_001_PHONE3.put(Fields.IS_CREATED, 'false')
	}
	
	public static final Map<Fields, String> CUSTOMER_001_EMAIL2;
	static {
		CUSTOMER_001_EMAIL2 = new HashMap<Fields, String>()
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL_TYPE, 'Personal')
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL_LABEL, 'SELF')
		CUSTOMER_001_EMAIL2.put(Fields.CT_EMAIL, 'my.emaila@exmaple.com')
		CUSTOMER_001_EMAIL2.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_001_EMAIL3;
	static {
		CUSTOMER_001_EMAIL3 = new HashMap<Fields, String>()
		CUSTOMER_001_EMAIL3.put(Fields.CT_EMAIL_TYPE, 'Work')
		CUSTOMER_001_EMAIL3.put(Fields.CT_EMAIL_LABEL, 'OFFICE')
		CUSTOMER_001_EMAIL3.put(Fields.CT_EMAIL, 'my.emailb@exmaple.com')
		CUSTOMER_001_EMAIL3.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> CUSTOMER_002;
	static {
		CUSTOMER_002 = new HashMap<Fields, String>()
		Map parsedJson = RandomUtil.generateRandomCustomerData()

		CUSTOMER_002.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		CUSTOMER_002.put(Fields.CUST_MIDDLE_NAME, RandomStringUtils.randomAlphabetic(1))
		CUSTOMER_002.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		CUSTOMER_002.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
		CUSTOMER_002.put(Fields.CUST_DOB_MASKED, '**/**/'+CUSTOMER_002.get(Fields.CUST_DOB).substring(6))
		CUSTOMER_002.put(Fields.CUST_TAX_ID, '9'+RandomStringUtils.randomNumeric(8))
		CUSTOMER_002.put(Fields.CUST_TAX_ID_MASKED, '*****'+CUSTOMER_002.get(Fields.CUST_TAX_ID).substring(5))
		CUSTOMER_002.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		CUSTOMER_002.put(Fields.CUST_RESIDENCY_STATUS, 'Non-Resident')
		CUSTOMER_002.put(Fields.CUST_MARITAL_STATUS, 'Married')
		CUSTOMER_002.put(Fields.CUST_NAME_VIEW, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))

		CUSTOMER_002.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' Street')
		CUSTOMER_002.put(Fields.ADDR_CITY, 'Philadelphia')
		CUSTOMER_002.put(Fields.ADDR_COUNTY, 'United States of America')
		CUSTOMER_002.put(Fields.ADDR_STATE, 'Pennsylvania')
		CUSTOMER_002.put(Fields.ADDR_ZIPCODE, '1'+RandomStringUtils.randomNumeric(4))
		CUSTOMER_002.put(Fields.ADDR_ADDRESS_TYPE, 'Work/Office')
		CUSTOMER_002.put(Fields.ADDR_ADDRESS_LABEL, 'OFFICE')
		CUSTOMER_002.put(Fields.ADDR_VIEW, CUSTOMER_002.get(Fields.ADDR_STREET)+', '+CUSTOMER_002.get(Fields.ADDR_CITY)+', PA '+CUSTOMER_002.get(Fields.ADDR_ZIPCODE))

		CUSTOMER_002.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		CUSTOMER_002.put(Fields.CT_PHONE_TYPE, 'Work')
		CUSTOMER_002.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		CUSTOMER_002.put(Fields.CT_EMAIL_TYPE, 'Work')
		CUSTOMER_002.put(Fields.CT_PREFERRED_LANGUAGE, 'English - United States')
		CUSTOMER_002.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Phone-Text')

		CUSTOMER_002.put(Fields.CUST_MEMBER_ID, 'MID_'+RandomStringUtils.randomNumeric(6))
		CUSTOMER_002.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')
		CUSTOMER_002.put(Fields.IS_CREATED, 'false')
	}

	public static final Map<Fields, String> ACCOUNT_001;
	static {
		ACCOUNT_001 = new HashMap<Fields, String>()
		ACCOUNT_001.put(Fields.ACC_TITLE, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_001.put(Fields.ACC_OWNERSHIP, 'Primary')
		ACCOUNT_001.put(Fields.ACC_DESCRIPTION, 'CD account')
		ACCOUNT_001.put(Fields.ACC_GROUP, 'Banking')
		ACCOUNT_001.put(Fields.ACC_NUMBER, '10'+RandomStringUtils.randomNumeric(10))
		ACCOUNT_001.put(Fields.ACC_BROKERED, 'false')
		ACCOUNT_001.put(Fields.ACC_TIMEZONE, 'UTC')
		ACCOUNT_001.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		ACCOUNT_001.put(Fields.ACC_PRODUCT_TYPE, '6 Month Compounding-Business')
		ACCOUNT_001.put(Fields.ACC_POSITION_NAME, '6 Month Compounding-Business')
		ACCOUNT_001.put(Fields.ACC_CURRENCY_CODE, 'USD')
		ACCOUNT_001.put(Fields.ACC_VERTICAL, '01')
		ACCOUNT_001.put(Fields.ACC_DEPT_ID, '350')
		ACCOUNT_001.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime('MM/dd/yyyy', 'EST'))
		ACCOUNT_001.put(Fields.DOC_TYPE, 'Terms and conditions')
		ACCOUNT_001.put(Fields.DOC_SIGNED_BY, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_001.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
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
		ACCOUNT_002.put(Fields.ACC_NUMBER, '11'+RandomStringUtils.randomNumeric(10))
		ACCOUNT_002.put(Fields.ACC_BROKERED, 'false')
		ACCOUNT_002.put(Fields.ACC_TIMEZONE, 'UTC')
		ACCOUNT_002.put(Fields.ACC_STATEMENT_FREQUENCY, 'Daily')
		ACCOUNT_002.put(Fields.ACC_PRODUCT_TYPE, 'Mortgage Personal Loan')
		ACCOUNT_002.put(Fields.ACC_PRODUCT_NAME, 'MTG')
		ACCOUNT_002.put(Fields.ACC_POSITION_NAME, 'Mortgage Personal Loan')
		ACCOUNT_002.put(Fields.ACC_CURRENCY_CODE, 'USD')
		ACCOUNT_002.put(Fields.ACC_VERTICAL, '01')
		ACCOUNT_002.put(Fields.ACC_DEPT_ID, '350')
		ACCOUNT_002.put(Fields.ACC_CREDIT_LIMIT, '100000')
		ACCOUNT_002.put(Fields.ACC_INTEREST_RATE, '8')
		ACCOUNT_002.put(Fields.ACC_OPEN_DATE, DateUtil.getCurrentDateTime('MM/dd/yyyy', 'EST'))
		ACCOUNT_002.put(Fields.DOC_TYPE, 'Terms and conditions')
		ACCOUNT_002.put(Fields.DOC_SIGNED_BY, CUSTOMER_002.get(Fields.CUST_FIRST_NAME)+' '+CUSTOMER_002.get(Fields.CUST_LAST_NAME))
		ACCOUNT_002.put(Fields.DOC_SIGNED_DATE, DateUtil.getCurrentDateTime('MM/dd/yyyy HH:mm:ss', 'EST'))
		ACCOUNT_002.put(Fields.DOC_VERSION, '01')

		ACCOUNT_002.put(Fields.ACC_LEDGER_BALANCE, '0.00')
		ACCOUNT_002.put(Fields.ACC_AVAILABLE_BALANCE, '0.00')
		ACCOUNT_002.put(Fields.IS_CREATED, 'false')
	}

	//Existing Customer Data, To be used when not running test suite
	public static final Map<Fields, String> CUSTOMER_003;
	static {
		CUSTOMER_003 = new HashMap<Fields, String>()

		CUSTOMER_003.put(Fields.CUST_FIRST_NAME, 'Scott')
		CUSTOMER_003.put(Fields.CUST_MIDDLE_NAME, '')
		CUSTOMER_003.put(Fields.CUST_LAST_NAME, 'Adkins')
		CUSTOMER_003.put(Fields.CUST_DOB, '06/03/2019')
		CUSTOMER_003.put(Fields.CUST_DOB_MASKED, '**/**/2019')
		CUSTOMER_003.put(Fields.CUST_TAX_ID, '3215478896')
		CUSTOMER_003.put(Fields.CUST_TAX_ID_MASKED, '******8896')
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

		CUSTOMER_003.put(Fields.CUST_MEMBER_ID, '9632154897')
		CUSTOMER_003.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')
	}

}
