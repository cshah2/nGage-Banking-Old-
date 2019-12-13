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
import utils.DateUtil
import utils.StringUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData1 = Data.ACCOUNT_001
Map<Fields, String> accData2 = Data.ACCOUNT_002
StringUtil.printMap(custData)
StringUtil.printMap(accData1)
StringUtil.printMap(accData2)

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(accData1)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Load customer profile'
WebUI.navigateToUrl(custData.get(Fields.URL))

'Wait for Customer details page to load'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

'Verify Customer name is displayed correctly'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))

//Verify Account created previously is displayed in the list
'Click on Accounts tab'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Accounts', false)

int expRowsCount = 1
'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), expRowsCount, RegexOperator.EQUALS)

int rowNo = 1
'Verify Account details in table'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyAccountsDataInTable'(accData1, rowNo)

//Add new account
'Click on Create Account icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'))

'Wait for Create accounts page to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), GlobalVariable.TIMEOUT)

'Add account information'
CustomKeywords.'pages.accounts.CreateAccountPage.fillAccountDetails'(accData2)

'Wait for Customer details page to load'
CustomKeywords.'actions.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify Customer Details on Summary Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDetailsSummarySection'(custData)

'Verify customer details page URL'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), 'CustomerMainFlow.CustomerDetail.aspx', RegexOperator.CONTAINS)

'Set data flag'
Data.ACCOUNT_002.put(Fields.IS_CREATED, 'true')

//Verify second account details are displayed in the accounts tab
'Click on Accounts tab'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Accounts', false)

expRowsCount = 2
'Verify accounts list table contains only 2 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), expRowsCount, RegexOperator.EQUALS)

rowNo = 2
'Verify Account details in table'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyAccountsDataInTable'(accData2, rowNo)