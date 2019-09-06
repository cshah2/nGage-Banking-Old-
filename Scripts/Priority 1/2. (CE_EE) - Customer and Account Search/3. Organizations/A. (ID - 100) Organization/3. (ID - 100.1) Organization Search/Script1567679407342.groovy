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
import constants.OrgData
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> orgData = OrgData.ORG1
println "Organization 1 = "+orgData.toMapString()

//Mark this test as failed if required customer is not created
CustomKeywords.'actions.Common.shouldFailTest'(orgData)

int expRowsCount = 1
int rowNo = 1

TestObject e_ResultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_OrgSearchResult')
TestObject e_OrgName = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_OrganizationName')
TestObject e_TaxId = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_TaxID')
TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_PhoneNumber')
TestObject e_DbaName = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_DBAName')
TestObject e_DunAndBradStreet = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_DunAndBradstreetId')
TestObject e_Country = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/select_Country')
TestObject e_Search = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search')
TestObject e_ClearFilter = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_ClearFilters')

'Login into portal'
CustomKeywords.'actions.Common.login'()

//Search for - Organization Name
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Enter Search Criteria organization name field'
WebUI.setText(e_OrgName, orgData.get(Fields.ORG_NAME))

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_NAME, orgData.get(Fields.ORG_NAME))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)

//Search for - Tax ID
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Enter Search Criteria in Tax ID field'
WebUI.setText(e_TaxId, orgData.get(Fields.ORG_TAX_ID))

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_TAX_ID, orgData.get(Fields.ORG_TAX_ID_MASKED))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)

//Search for - phone number
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Enter Search Criteria in Tax ID field'
WebUI.setText(e_PhoneNumber, orgData.get(Fields.CT_PHONE_NUMBER))

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_PHONE_NUMBER, orgData.get(Fields.CT_PHONE_NUMBER))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)

//Search for - Dba Name
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Enter Search Criteria in Tax ID field'
WebUI.setText(e_DbaName, orgData.get(Fields.ORG_DBA_NAME))

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_NAME, orgData.get(Fields.ORG_NAME))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)

//Search for - Dun & Bradstreet ID
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Enter Search Criteria in Tax ID field'
WebUI.setText(e_DunAndBradStreet, orgData.get(Fields.ORG_DUN_BRADSTEET_NO))

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.EQUALS)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_DUN_BRADSTREET, orgData.get(Fields.ORG_DUN_BRADSTEET_NO))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)

//Search for - Country
'Go to searh organiztion page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Select Search Criteria in Tax ID field'
WebUI.selectOptionByLabel(e_Country, orgData.get(Fields.ORG_REGISTRATION_COUNTRY), false)

'Click on Search button'
WebUI.click(e_Search)

'Wait for table to be visible'
CustomKeywords.'actions.WaitFor.elementVisible'(e_ResultTable, GlobalVariable.TIMEOUT)

'Verify result table contains atleast 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(e_ResultTable, expRowsCount, RegexOperator.GREATER_THAN_OR_EQUAL)

'Verify all values in column are matching the values'
CustomKeywords.'actions.Table.verifyAllValuesInColumnEquals'(e_ResultTable, ColumnPos.ORG_SEARCH_COUNTRY, orgData.get(Fields.ORG_REGISTRATION_COUNTRY))

'Click on Clear Filter button'
WebUI.click(e_ClearFilter)