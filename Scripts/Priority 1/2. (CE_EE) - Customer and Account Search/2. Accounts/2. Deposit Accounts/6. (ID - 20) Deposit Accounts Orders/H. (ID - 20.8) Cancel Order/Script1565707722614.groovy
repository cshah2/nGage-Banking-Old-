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
import internal.GlobalVariable as GlobalVariable

Map<Fields, String> custData = Data.CUSTOMER_001
Map<Fields, String> accDataFrom = Data.CUSTOMER_001_ORDER_FROM_ACC01
Map<Fields, String> accDataTo = Data.CUSTOMER_001_ORDER_TO_ACC01
Map<Fields, String> orderData = Data.CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_EDIT
Map<Fields, String> orderDataCancel = Data.CUSTOMER_001_ORDER_FROM_ACC01_ORDER06_CANCEL

TestObject accTable = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')
TestObject tabOrders_orderTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Orders Tab/Orders Section/table_Orders')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(orderData)

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Open From Account'
CustomKeywords.'actions.Common.searchAccount'(accDataFrom)

//Perform Purchase Order operation
'Click on Orders tab'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Orders'))

'Wait for Orders tab to load'
CustomKeywords.'actions.WaitFor.elementVisible'(tabOrders_orderTable, GlobalVariable.TIMEOUT)

int orderTableRowNo = 6
'Verify Order data in table'
CustomKeywords.'actions.Common.verifyOrderDetailsInTable'(orderData, orderTableRowNo)

String option = 'Cancel Order'
'Click on More icon and select Cancel Order option'
CustomKeywords.'actions.Table.clickMoreButtonAndSelectOption'(tabOrders_orderTable, orderTableRowNo, ColumnPos.ORDER_MORE_ICON, option)

'Verify details on cancel Orde form'
CustomKeywords.'actions.Common.cancelOrderFormFill'(orderDataCancel)

'Click on Submit button on Task drawer'
CustomKeywords.'actions.Common.moveToElementAndClick'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/btn_Submit'))

'Wait for task drawer to close'
CustomKeywords.'actions.WaitFor.elementNotPresent'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/lbl_OrderType'), GlobalVariable.TIMEOUT)

'Wait for order table to refresh'
CustomKeywords.'actions.Table.waitUntilCellValueEquals'(tabOrders_orderTable, orderTableRowNo, ColumnPos.ORDER_STATUS, orderDataCancel.get(Fields.ORDER_STATUS), GlobalVariable.TIMEOUT)

'Verify Order data in table'
CustomKeywords.'actions.Common.verifyOrderDetailsInTable'(orderDataCancel, orderTableRowNo)

'Set Order flag as True'
orderDataCancel.put(Fields.IS_CREATED, 'true')