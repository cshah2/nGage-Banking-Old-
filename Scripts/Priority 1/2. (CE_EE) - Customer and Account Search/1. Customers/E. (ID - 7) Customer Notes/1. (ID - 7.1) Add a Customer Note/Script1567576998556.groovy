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
import constants.common
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.DateUtil

Map<Fields, String> custData = Data.CUSTOMER_001
println "Customer001 = "+custData.toMapString()

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)

//Set Data
String note = 'NOTE - '+DateUtil.getCurrentDateTime('MMddyyyy_HHmmss', common.timezone)
String noteCreatedBy = 'Chintan Shah'

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search customer and open Customer details page'
CustomKeywords.'actions.Common.searchCustomerAndOpen'(custData)

'Click on Notes tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Notes'))

'Wait for Notes section to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/section_Body'), GlobalVariable.TIMEOUT)

'Get Current rows count'
int currentRowsCount = CustomKeywords.'actions.Table.getRecordsCount'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/table_Notes'))

'Move to Add new note icon'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/icon_AddNote'))

'Click on Add new note icon'
CustomKeywords.'actions.JavaScript.click'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/icon_AddNote'))

'Wait for Add Notes task drawer to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Notes/input_Notes'), GlobalVariable.TIMEOUT)

'Enter Notes'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Notes/input_Notes'), note)

'Move to submit button'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Notes/btn_Submit'))

'Click on Submit button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Notes/btn_Submit'))

'Wait for elements from task drawer to be not present'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Notes/input_Notes'), GlobalVariable.TIMEOUT)

'Wait for Notes to get added'
//TODO: There is no success message displayed on completion of task.
CustomKeywords.'actions.Table.waitUntilRecordsCountEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/table_Notes'), currentRowsCount+1, GlobalVariable.TIMEOUT)

//Verify Notes detail
rowNo = 1 //TODO: Record gets added to the top of the row if user logins in again.

'Verify Notes'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/table_Notes'), rowNo, ColumnPos.NOTE_TEXT, note)

'Verify Address Label'
CustomKeywords.'actions.Table.verifyCellValueEquals'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/table_Notes'), rowNo, ColumnPos.NOTE_CREATED_BY, noteCreatedBy)