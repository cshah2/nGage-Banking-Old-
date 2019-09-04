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

import constants.OrgData
import enums.Fields
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> data = OrgData.ORG1
println "Organization = "+data.toMapString()

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Select Organization option on search page'
CustomKeywords.'actions.Common.searchPageSelectOrganization'()

'Click on Create organization icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateOrganization'))

'Fill organization form'
CustomKeywords.'actions.Common.organizationFormFill'(data)

//'Verify Organization Details on Summary Section'
//CustomKeywords.'actions.Common.verifyCustomerDetailsSummarySection'(data)

//'Verify customer details page URL'
//CustomKeywords.'actions.Common.verifyUrlContains'('CustomerMainFlow.CustomerDetail.aspx')

'Set data flag'
data.put(Fields.IS_CREATED, 'true')

'Set Customer Page URL'
data.put(Fields.URL, WebUI.getUrl())