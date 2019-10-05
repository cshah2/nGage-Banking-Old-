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
import enums.Fields
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> data = Data.CUSTOMER_001
println "Customer = "+data.toMapString()

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