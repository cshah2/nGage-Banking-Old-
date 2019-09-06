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
import utils.RegexUtil

Map<Fields, String> orgData = OrgData.ORG2
Map<Fields, String> accData = OrgData.ORG2_ACC1
println "Organization 2 = "+orgData.toMapString()
println "Organiztion 2 - Account 1 = "+accData.toMapString()

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Select Organization option on search page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Click on Create organization icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateOrganization'))

'Fill organization form'
CustomKeywords.'actions.Common.organizationFormFill'(orgData)

'Verify Organization Details on Summary Section'
CustomKeywords.'actions.Common.verifyOrganizationDetailsSummarySection'(orgData)

'Verify Page URL is of Account create page'
CustomKeywords.'actions.Common.verifyUrlContains'('AccountMainFlow.AccountCreate.aspx')

//Add account info
'Fill up accounts page'
CustomKeywords.'actions.Common.accountFormFill'(accData)

'Click on Submit button'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/btn_Submit'))

'Wait for Organization details page to load'
CustomKeywords.'actions.WaitFor.titleContains'('Customer Details', GlobalVariable.TIMEOUT)

'Wait for Page load'
WebUI.waitForPageLoad(GlobalVariable.TIMEOUT)

'Verify organization details page is loaded'
CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Set data flag'
orgData.put(Fields.IS_CREATED, 'true')

'Store Customer URL'
orgData.put(Fields.URL, WebUI.getUrl())

'Click on Accounts tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))

int rowNo = 1
int expRowsCount = 1

'Verify Account details in table'
CustomKeywords.'actions.Common.verifyAccountDetailsInTable'(accData, rowNo)

'Verify accounts list table contains only 1 record'
CustomKeywords.'actions.Table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'), expRowsCount, RegexOperator.EQUALS)

'Set data flags'
accData.put(Fields.IS_CREATED, 'true')