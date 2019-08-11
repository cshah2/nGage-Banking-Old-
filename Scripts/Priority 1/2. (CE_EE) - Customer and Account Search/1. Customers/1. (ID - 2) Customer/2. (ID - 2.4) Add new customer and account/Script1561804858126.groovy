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

import constants.ColumnPos
import constants.Data
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.RegexUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData = Data.ACCOUNT_001
println "Customer002 = "+custData.toMapString()
println "Account001 = "+accData.toMapString()

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

'Wait for Create customer icon to be visible'
WebUI.delay(3) //TODO: Need to identify propert wait condition
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Fill customer form'
CustomKeywords.'actions.Common.customerFormFill'(custData)

'Click on Create button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer Page/Customer Information/btn_Create'))

'Verify Customer Details on Summary Section'
CustomKeywords.'actions.Common.verifyCustomerDetailsSummarySection'(custData)

'Verify Page URL is of Account create page'
CustomKeywords.'actions.Common.verifyUrlContains'('AccountMainFlow.AccountCreate.aspx')

//Add account info
'Fill up accounts page'
CustomKeywords.'actions.Common.accountFormFill'(accData)

'Click on Submit button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

'Wait for Customer details page to load'
CustomKeywords.'actions.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify customer details page is loaded'
CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Set data flag'
Data.CUSTOMER_002.put(Fields.IS_CREATED, 'true')

'Store Customer URL'
Data.CUSTOMER_002.put(Fields.URL, WebUI.getUrl())

'Click on Accounts tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

int rowNo = 1
int expRowsCount = 1
'Verify Account details in table'
CustomKeywords.'actions.Common.verifyAccountDetailsInTable'(accData, rowNo)

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), expRowsCount, RegexOperator.EQUALS)

'Set data flags'
Data.ACCOUNT_001.put(Fields.IS_CREATED, 'true')