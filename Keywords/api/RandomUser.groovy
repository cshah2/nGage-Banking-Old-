package api

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
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import groovy.json.JsonSlurper
import internal.GlobalVariable

public class RandomUser {

	private static RequestObject request
	private static String url = 'https://api.randomuser.me/?nat=US'

	private ResponseObject getUser() {

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

	@Keyword
	def generateRandomCustomerData() {
		ResponseObject res = getUser()

		JsonSlurper slupper = new JsonSlurper()
		Map parsedJson = slupper.parseText(res.getResponseBodyContent())

		String firstName = parsedJson.get("results").get(0).get("name").get("first")
		String lastName = parsedJson.get("results").get(0).get("name").get("last")

		println "Firstname = "+firstName
		println "Lastname = "+lastName
	}
}
