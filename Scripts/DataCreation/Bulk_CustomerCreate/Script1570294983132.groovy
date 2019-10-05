import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.Data
import constants.common
import enums.Fields
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil
import utils.RandomUtil

Map<Fields, String> data

for(int i = 0; i < 50; i++) {
	
data = new HashMap<Fields, String>()
Map parsedJson = RandomUtil.generateRandomCustomerData()

//Basic Information
data.put(Fields.CUST_PREFIX, parsedJson.get("results").get(0).get("name").get("title"))
data.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
data.put(Fields.CUST_MIDDLE_NAME, RandomUtil.getRandomAlphabets(1))
data.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
data.put(Fields.CUST_NAME_VIEW, data.get(Fields.CUST_FIRST_NAME)+' '+data.get(Fields.CUST_LAST_NAME))
data.put(Fields.CUST_SUFFIX, 'Jr.')
data.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
data.put(Fields.CUST_DOB_MASKED, '**/**/'+data.get(Fields.CUST_DOB).substring(6))
data.put(Fields.CUST_TAX_ID, '9'+RandomUtil.getRandomNumeric(8))
data.put(Fields.CUST_TAX_ID_MASKED, '*****'+data.get(Fields.CUST_TAX_ID).substring(5))
data.put(Fields.CUST_TAX_ID_TYPE, 'SSN')
data.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
data.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')

//Customer Details
data.put(Fields.CUST_FAMILIAR_NAME, 'CHINOO')
data.put(Fields.CUST_MAIDEN_NAME, 'SHAH')
data.put(Fields.CUST_MARITAL_STATUS, 'Single')
data.put(Fields.CUST_TOTAL_HOUSEHOLD_MEMBERS, '8')
data.put(Fields.CUST_MOTHERS_MAIDEN_NAME, 'JOSHI')
data.put(Fields.CUST_PREFERRED_LANGUAGE, 'English - United States')
data.put(Fields.CUST_ALTERNATE_LANGUAGE, 'Hindi - India')
data.put(Fields.CUST_AGE_BRACKET, '21 - 30')

//Location Information
data.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMM', common.timezone)+' Street')
data.put(Fields.ADDR_CITY, 'Philadelphia')
data.put(Fields.ADDR_COUNTY, 'United States of America')
data.put(Fields.ADDR_STATE, 'Pennsylvania')
data.put(Fields.ADDR_ZIPCODE, '1'+RandomUtil.getRandomNumeric(4))
data.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
data.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
data.put(Fields.ADDR_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(1, common.dateFormat, common.timezoneUTC))
data.put(Fields.ADDR_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(10, common.dateFormat, common.timezoneUTC))
data.put(Fields.ADDR_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-10, common.dateFormat, common.timezoneUTC))
data.put(Fields.ADDR_VIEW, data.get(Fields.ADDR_STREET)+', '+data.get(Fields.ADDR_CITY)+', PA '+data.get(Fields.ADDR_ZIPCODE))

//Contact Information
data.put(Fields.CT_PHONE_NUMBER, '+1'+RandomUtil.getRandomNumeric(10))
data.put(Fields.CT_PHONE_TYPE, 'Mobile')
data.put(Fields.CT_PHONE_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(0, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_PHONE_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(8, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_PHONE_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-8, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
data.put(Fields.CT_EMAIL_TYPE, 'Personal')
data.put(Fields.CT_EMAIL_VERIFIED_DATE, DateUtil.getCurrentDateTimeMinusDays(2, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_EMAIL_VALID_FROM, DateUtil.getCurrentDateTimeMinusDays(9, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_EMAIL_VALID_UNTIL, DateUtil.getCurrentDateTimeMinusDays(-9, common.dateFormat, common.timezoneUTC))
data.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')

//Customer Due diligence
data.put(Fields.CUST_CHK_SENIOR_POLITICAL_FIGURE, 'true')
data.put(Fields.CUST_SENIOR_POLITICAL_FIGURE_COUNTRY, 'India')
data.put(Fields.CUST_ASSOCIATE_SR_POLITICAL_FIGURE, 'Family Member')

//Education and Occupation details
data.put(Fields.CUST_EMPLOYMENT_STATUS, 'Part-time')
data.put(Fields.CUST_OCCUPATION, 'Computer and Mathmatical')
data.put(Fields.CUST_MONTHLY_GROSS_INCOME, '30000')
data.put(Fields.CUST_MILITARY_STATUS, 'Inactive')
data.put(Fields.CUST_EDUCATION, 'High school or GED')
data.put(Fields.CUST_STUDENT_TYPE, 'Full Time on campus')
data.put(Fields.CUST_WEB_ADDRESS, 'http://www.savanainc.com')

//Customer Information
data.put(Fields.CUST_CUSTOMER_ID, 'CID_'+RandomUtil.getRandomNumeric(6))
data.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')

//Script data
data.put(Fields.IS_CREATED, 'false')
data.put(Fields.URL, '')

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Create customer icon to be visible'
WebUI.delay(3) //TODO: Need to identify propert wait condition
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

'Fill customer form'
CustomKeywords.'actions.Common.customerFormFill'(data)

'Verify Customer Details on Summary Section'
CustomKeywords.'actions.Common.verifyCustomerDetailsSummarySection'(data)

'Verify customer details page URL'
CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Set data flag'
data.put(Fields.IS_CREATED, 'true')

'Set Customer Page URL'
data.put(Fields.URL, WebUI.getUrl())

}