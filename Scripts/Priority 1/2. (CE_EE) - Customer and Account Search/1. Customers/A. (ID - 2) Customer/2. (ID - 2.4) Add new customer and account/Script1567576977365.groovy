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
import constants.URL
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.RegexUtil
import utils.StringUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData = Data.ACCOUNT_001
StringUtil.printMap(custData)
StringUtil.printMap(accData)

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
CustomKeywords.'pages.consumer.CreateConsumerPage.fillCustomerDetails'(custData)

'Verify Customer Details on Summary Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDetailsSummarySection'(custData)

'Verify Page URL is of Account create page'
CustomKeywords.'actions.Common.verifyUrlContains'('AccountMainFlow.AccountCreate.aspx')

'Add account information'
CustomKeywords.'pages.accounts.CreateAccountPage.fillAccountDetails'(accData)

'Wait for Customer details page to load'
CustomKeywords.'actions.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify Customer Details on Summary Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDetailsSummarySection'(custData)

'Verify customer details page URL'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), 'CustomerMainFlow.CustomerDetail.aspx', RegexOperator.CONTAINS)

'Set data flag'
Data.CUSTOMER_002.put(Fields.IS_CREATED, 'true')

'Store Customer URL'
Data.CUSTOMER_002.put(Fields.URL, WebUI.getUrl())

'Click on Accounts tab'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Accounts', false)

int expRowsCount = 1
int rowNo = 1

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), expRowsCount, RegexOperator.EQUALS)

'Verify Account details in table'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyAccountsDataInTable'(accData, rowNo)

'Set data flags'
Data.ACCOUNT_001.put(Fields.IS_CREATED, 'true')