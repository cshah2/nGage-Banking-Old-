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

import constants.Data
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accData = Data.CUSTOMER_001_SAVING_ACCOUNT
TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(accData)

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Search Account and open account details page'
CustomKeywords.'actions.Common.searchAccount'(accData)

'Move to Notes tab'
CustomKeywords.'actions.Common.moveToElement'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))

'Go to Notes tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Notes'))

'Wait for Notes tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Notest Tab/Notes Section/table_Notes'), GlobalVariable.TIMEOUT)

'Select a task []'
String taskName = 'Post a Transaction'
CustomKeywords.'actions.Common.selectTaskFromTaskList'(taskName)

