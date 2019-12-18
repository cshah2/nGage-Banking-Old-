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

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> custDataPhone2 = Data.CUSTOMER_001_PHONE2
StringUtil.printMap(custData)
StringUtil.printMap(custDataPhone2)

TestObject phoneTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/table_Phones')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Load customer profile'
WebUI.navigateToUrl(custData.get(Fields.URL))

'Click on Contact Details tab'
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Contact Details', false)

'Wait for contact details section to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)

'Verify Phones table contains only one row'
CustomKeywords.'actions.Table.verifyRecordsCount'(phoneTable, 1, RegexOperator.EQUALS)

//Verify Primary Phone Details
int rowNo = 1 
'Verify phone data in table'
CustomKeywords.'pages.consumer.tabs.ContactDetailsTab.verifyConsumerPhoneDataInTable'(custData, rowNo)

'Scroll to and click Add new phone icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Phone Section/icon_AddNewPhone'))

'Add phone details in form'
CustomKeywords.'pages.consumer.ConsumerTaskDrawer.addPhoneTask'(custDataPhone2)

'Wait for elements from task drawer to be not present'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Phones/input_PhoneNumber'), GlobalVariable.TIMEOUT)

'Wait for phones to get added in table'
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(phoneTable, 2, GlobalVariable.TIMEOUT)

//Verify phones details of second row
rowNo = 2 
'Verify phone details in a table'
CustomKeywords.'pages.consumer.tabs.ContactDetailsTab.verifyConsumerPhoneDataInTable'(custDataPhone2, rowNo)

'Set data flag'
custDataPhone2.put(Fields.IS_CREATED, 'true')