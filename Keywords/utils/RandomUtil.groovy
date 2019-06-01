package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Map

import org.apache.commons.lang3.RandomStringUtils

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.common
import enums.Fields
import groovy.json.JsonSlurper
import internal.GlobalVariable

public class RandomUtil {

	private String generateRandomCharacter() {
	}
	
	private static RequestObject request
	private static String url = 'https://api.randomuser.me/?nat=US'

	private static ResponseObject getUser() {

		//Set URL
		request = new RequestObject('objectId')
		request.setRestUrl(url)

		//Set Method
		request.setRestRequestMethod('GET')

		//Do not set Header and Body

		//Call API
		ResponseObject res = WS.sendRequest(request)
		println "Response is "+res.getResponseText()

		//Verify response is success
		int statusCode = res.getStatusCode()
		if(!(statusCode == 200 || statusCode == 204)) {
			KeywordUtil.markFailedAndStop('call to patch single user api failed')
		}
		return res
	}

	public static void generateRandomCustomerData(Map<Fields, String> data) {
		
		ResponseObject res = getUser()

		JsonSlurper slupper = new JsonSlurper()
		Map parsedJson = slupper.parseText(res.getResponseBodyContent())

		data.put(Fields.CUST_FIRST_NAME, parsedJson.get("results").get(0).get("name").get("first"))
		data.put(Fields.CUST_MIDDLE_NAME, RandomStringUtils.randomAlphabetic(1))
		data.put(Fields.CUST_LAST_NAME, parsedJson.get("results").get(0).get("name").get("last"))
		data.put(Fields.CUST_DOB, DateUtil.convert(parsedJson.get("results").get(0).get("dob").get("date").subSequence(0, 10), 'yyyy-MM-dd', common.dateFormat))
		data.put(Fields.CUST_TAX_ID, '9'+RandomStringUtils.randomNumeric(8))
		data.put(Fields.CUST_COUNTRY_OF_RESIDENCE, 'United States of America')
		data.put(Fields.CUST_RESIDENCY_STATUS, 'Resident')
		data.put(Fields.CUST_MARITAL_STATUS, 'Single')
		data.put(Fields.CUST_NAME_VIEW, data.get(Fields.CUST_FIRST_NAME)+' '+data.get(Fields.CUST_LAST_NAME))
		
		data.put(Fields.ADDR_STREET, DateUtil.getCurrentDateTime('dd MMMMM', 'EST')+' Stree')
		data.put(Fields.ADDR_CITY, 'Philadelphia')
		data.put(Fields.ADDR_COUNTY, 'United States of America')
		data.put(Fields.ADDR_STATE, 'Pennsylvania')
		data.put(Fields.ADDR_ZIPCODE, '1'+RandomStringUtils.randomNumeric(4))
		data.put(Fields.ADDR_ADDRESS_TYPE, 'Residence')
		data.put(Fields.ADDR_ADDRESS_LABEL, 'HOME')
		data.put(Fields.ADDR_VIEW, data.get(Fields.ADDR_STREET)+', '+data.get(Fields.ADDR_CITY)+', PA '+data.get(Fields.ADDR_ZIPCODE))
		
		data.put(Fields.CT_PHONE_NUMBER, '+1'+RandomStringUtils.randomNumeric(10))
		data.put(Fields.CT_PHONE_TYPE, 'Mobile')
		data.put(Fields.CT_EMAIL, parsedJson.get("results").get(0).get("email"))
		data.put(Fields.CT_EMAIL_TYPE, 'Personal')
		data.put(Fields.CT_PREFERRED_LANGUAGE, 'English - United States')
		data.put(Fields.CT_PREFERRED_CONTACT_METHOD, 'Email')
		
		data.put(Fields.CUST_MEMBER_ID, 'MID_'+RandomStringUtils.randomNumeric(6))
		data.put(Fields.CUST_CUSTOMER_GROUP, 'Banking Customer')
	}

}
