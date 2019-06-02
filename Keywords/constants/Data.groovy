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
		CUSTOMER_001.put(Fields.CUST_TAX_ID, '9'+RandomStringUtils.randomNumeric(8))
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
	}
}
