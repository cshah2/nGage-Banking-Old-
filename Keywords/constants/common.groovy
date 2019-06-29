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

import internal.GlobalVariable

public class common {

	public static String loginUrl = GlobalVariable.BASE_URL + '/nGageBanking/Login.aspx'
	public static String username = GlobalVariable.USERNAME
	public static String password = GlobalVariable.PASSWORD
	public static String dashboardName = 'Chintan Shah'
	public static String dashboardUrl = GlobalVariable.BASE_URL + '/nGageBanking_Customer/CustomerSearch.aspx'
	public static String createCustomerUrl = GlobalVariable.BASE_URL + '/nGageBanking_Customer/CustomerMainFlow.CustomerCreate.aspx?isOrg=False'
	public static String dateFormat = 'MM/dd/yyyy'
	public static String dateTimeFormat = 'MM/dd/yyyy HH:mm:ss'
	public static String timezone = 'America/New_York'
}
