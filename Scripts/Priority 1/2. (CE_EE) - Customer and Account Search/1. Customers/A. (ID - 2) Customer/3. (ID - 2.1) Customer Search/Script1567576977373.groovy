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
import utils.StringUtil

Map<Fields, String> custData = Data.CUSTOMER_002
StringUtil.printMap(custData)
Map<Fields, String> searchCriteria
TestObject e_ResultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

String expCustomerGroup = custData.get(Fields.CUST_CUSTOMER_GROUP)
String expLastName = custData.get(Fields.CUST_LAST_NAME)
String expFirstName = custData.get(Fields.CUST_FIRST_NAME)
String expTaxId = custData.get(Fields.CUST_TAX_ID)
String expTaxIdMasked = custData.get(Fields.CUST_TAX_ID_MASKED)
String expPhoneNumber = custData.get(Fields.CT_PHONE_NUMBER)
String expEmail = custData.get(Fields.CT_EMAIL)
String expDOB = custData.get(Fields.CUST_DOB)
String expDOBMasked = custData.get(Fields.CUST_DOB_MASKED)
String expCustomerId = custData.get(Fields.CUST_CUSTOMER_ID)
String expUrl = custData.get(Fields.URL)

//Mark this test as failed if required customer is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Verify user is on search page'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), URL.SearchPage, RegexOperator.EQUALS)

'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

'Wait for search dialog to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/select_CustomerGroup'), GlobalVariable.TIMEOUT)

//Set Search criteria - Last name
searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CUST_LAST_NAME, expLastName)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_LAST_NAME, expLastName, RegexOperator.CONTAINS_IGNORE_CASE)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - First name
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CUST_FIRST_NAME, expFirstName)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_FIRST_NAME, expFirstName, RegexOperator.CONTAINS_IGNORE_CASE)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - Tax ID
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CUST_TAX_ID, expTaxId)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.EQUALS)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_TAX_ID, expTaxIdMasked, RegexOperator.EQUALS)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - Phone Number
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CT_PHONE_NUMBER, expPhoneNumber)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_PHONE_NUMBER, expPhoneNumber, RegexOperator.EQUALS)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - Email
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CT_EMAIL, expEmail)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_EMAIL, expEmail, RegexOperator.EQUALS)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - DOB
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CUST_DOB, expDOB)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Wait for result table to load'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result grid contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all records matching the filter criteria are listed in result table'
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_DOB, expDOBMasked, RegexOperator.EQUALS)
CustomKeywords.'actions.Table.verifyAllValuesInColumnMatches'(e_ResultTable, ColumnPos.CUST_CUSTOMER_GROUP, expCustomerGroup, RegexOperator.EQUALS)

//Set Search criteria - Customer ID
'Select Search type as Consumer'
CustomKeywords.'pages.SearchPage.selectSearchEntity'('Consumer')

searchCriteria = new HashMap<Fields, String>()
searchCriteria.put(Fields.CUST_CUSTOMER_GROUP, expCustomerGroup)
searchCriteria.put(Fields.CUST_CUSTOMER_ID, expCustomerId)

'Enter search criteria'
CustomKeywords.'pages.SearchPage.searchCustomer'(searchCriteria)

'Verify Customer Details on Summary Section'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.verifyConsumerDetailsSummarySection'(custData)

'Verify customer details page URL'
CustomKeywords.'actions.Common.verifyMatch'(WebUI.getUrl(), 'CustomerMainFlow.CustomerDetail.aspx', RegexOperator.CONTAINS)