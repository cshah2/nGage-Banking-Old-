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

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> custDataEmail2 = Data.CUSTOMER_001_EMAIL2
println "Customer001 = "+custData.toMapString()
println "Customer001 Email 2 = "+custDataEmail2.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.common.searchCustomerAndOpen'(custData)

'Click on Contact Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))

'Wait for contact details section to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Phones table contains only one row'
CustomKeywords.'actions.table.verifyRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), 1, RegexOperator.EQUALS)

//Verify Primary Phone Details
int rowNo = 1 

'Verify Email Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), rowNo, ColumnPos.CT_EMAIL_TYPE, custData.get(Fields.CT_EMAIL_TYPE))

'Verify Email'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), rowNo, ColumnPos.CT_EMAIL, custData.get(Fields.CT_EMAIL))

'Move to add new phones button'
CustomKeywords.'actions.common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/icon_AddNewEmail'))

'Click on Add new email icon'
CustomKeywords.'actions.javaScript.click'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/icon_AddNewEmail'))

'Wait for Add email task drawer to load'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), GlobalVariable.TIMEOUT)

'Enter Email'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), custDataEmail2.get(Fields.CT_EMAIL))

'Select Email type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/select_EmailType'), custDataEmail2.get(Fields.CT_EMAIL_TYPE), false)

'Enter Email label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_EmailLabel'), custDataEmail2.get(Fields.CT_EMAIL_LABEL))

'Scroll to submit button'
WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/btn_Submit'), GlobalVariable.TIMEOUT)

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'utils.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Email/input_Email'), GlobalVariable.TIMEOUT)

'Wait for emails to get added in table'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.table.waitUntilRecordsCountEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), 2, GlobalVariable.TIMEOUT)

//Verify phones details of second row
rowNo = 2 

'Verify Email Type'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), rowNo, ColumnPos.CT_EMAIL_TYPE, custDataEmail2.get(Fields.CT_EMAIL_TYPE))

'Verify Email Label'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), rowNo, ColumnPos.CT_EMAIL_LABEL, custDataEmail2.get(Fields.CT_EMAIL_LABEL))

'Verify Email'
CustomKeywords.'actions.table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Email Section/table_Emails'), rowNo, ColumnPos.CT_EMAIL, custDataEmail2.get(Fields.CT_EMAIL))

'Set data flag'
custDataEmail2.put(Fields.IS_CREATED, 'true')