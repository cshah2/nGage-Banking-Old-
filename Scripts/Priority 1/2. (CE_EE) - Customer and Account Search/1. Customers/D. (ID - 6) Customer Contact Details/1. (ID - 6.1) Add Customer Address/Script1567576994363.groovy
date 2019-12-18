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
Map<Fields, String> custDataAddress2 = Data.CUSTOMER_001_ADDRESS2
StringUtil.printMap(custData)
StringUtil.printMap(custDataAddress2)

TestObject addressTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses')

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

'Verify Address table contains only one row'
CustomKeywords.'actions.Table.verifyRecordsCount'(addressTable, 1, RegexOperator.EQUALS)

//Verify Primary Address details
int rowNo = 1 

'Verify Address details in table'
CustomKeywords.'pages.consumer.tabs.ContactDetailsTab.verifyConsumerAddressDataInTable'(custData, rowNo)

'Scroll to and click Add new address icon'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/icon_AddNewAddress'))

'Fill Address details'
CustomKeywords.'pages.consumer.ConsumerTaskDrawer.addAddressTask'(custDataAddress2)

'Wait for elements from task drawer to be not present'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Address/input_Street'), GlobalVariable.TIMEOUT)

'Wait for address to get added'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(addressTable, 2, GlobalVariable.TIMEOUT)

//Verify address details of second row
rowNo = 2
'Verify Address details in table'
CustomKeywords.'pages.consumer.tabs.ContactDetailsTab.verifyConsumerAddressDataInTable'(custDataAddress2, rowNo)

'Set data flag'
custDataAddress2.put(Fields.IS_CREATED, 'true')