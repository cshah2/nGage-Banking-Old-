package utils

import org.apache.commons.lang3.RandomStringUtils

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS

import groovy.json.JsonSlurper

public class RandomUtil {


	public static Map generateRandomCustomerData() {

		RequestObject request
		String url = 'https://api.randomuser.me/?nat=US'

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

		JsonSlurper slupper = new JsonSlurper()
		return slupper.parseText(res.getResponseBodyContent())
	}
	
	public static String getRandomAlphabets(int length) {
		return RandomStringUtils.randomAlphabetic(length)
	}
	
	public static String getRandomNumeric(int length) {
		return RandomStringUtils.randomNumeric(length)
	}

}
