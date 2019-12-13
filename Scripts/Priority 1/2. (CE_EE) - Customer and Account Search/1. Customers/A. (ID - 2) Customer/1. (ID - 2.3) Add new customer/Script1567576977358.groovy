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

import utils.StringUtil
import constants.Data
import constants.URL
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import pages.SearchPage
import pages.consumer.CreateConsumerPage

//Data setup
Map<Fields, String> data = Data.CUSTOMER_001
StringUtil.printMap(data)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Verify user is on search page'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), URL.SearchPage, RegexOperator.EQUALS)

'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

'Click on Create customer icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateConsumer'))

'Wait for Create customer page to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Verify user is on create customer page'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), URL.ConsumerCreatePage, RegexOperator.EQUALS)

'Fill customer form'
CustomKeywords.'pages.consumer.CreateConsumerPage.fillCustomerDetails'(data)

'Verify Customer Details on Summary Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDetailsSummarySection'(data)

'Verify customer details page URL'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), 'CustomerMainFlow.CustomerDetail.aspx', RegexOperator.CONTAINS)

'Set data flag'
data.put(Fields.IS_CREATED, 'true')

'Set Customer Page URL'
data.put(Fields.URL, WebUI.getUrl())