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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import constants.Data
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable as GlobalVariable
import utils.StringUtil

Map<Fields, String> custData = Data.CUSTOMER_002
Map<Fields, String> accData1 = Data.ACCOUNT_001
StringUtil.printMap(custData)
StringUtil.printMap(accData1)

TestObject e_OverviewTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Overview'])
TestObject e_AccountsTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Accounts'])
TestObject e_ProfileTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Profile'])
TestObject e_ContactDetailsTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Contact Details'])
TestObject e_NotesTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Notes'])
TestObject e_DocumentsTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Documents'])
TestObject e_CasesTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Cases'])
TestObject e_NotificationsTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):'Notifications'])
TestObject e_MoreTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_More')

//Mark this test as failed if required customer and account is not created
CustomKeywords.'actions.Common.shouldFailTest'(custData)
CustomKeywords.'actions.Common.shouldFailTest'(accData1)

int expRowsCount = 1

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Load customer profile'
WebUI.navigateToUrl(custData.get(Fields.URL))

//Verify Correct tabs are displayed in EE environment
'Verify accounts tab link is visible'
WebUI.verifyElementVisible(e_AccountsTab)

'Verify profile tab link is visible'
WebUI.verifyElementVisible(e_ProfileTab)

'Verify contact details tab link is visible'
WebUI.verifyElementVisible(e_ContactDetailsTab)


if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	
	'Verify overview tab link is visible'
	WebUI.verifyElementVisible(e_OverviewTab)
	
	'Verify notes tab link is visible'
	WebUI.verifyElementVisible(e_NotesTab)
	
	'Verify documents tab link is visible'
	WebUI.verifyElementVisible(e_DocumentsTab)
	
	'Verify cases tab link is visible'
	WebUI.verifyElementVisible(e_CasesTab)
	
	'Verify notification tab link is visible'
	WebUI.verifyElementVisible(e_NotificationsTab)
	
	'Verify more tab link is visible'
	WebUI.verifyElementVisible(e_MoreTab)
}
else if('CE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	
	'Verify overview tab link is not present'
	WebUI.verifyElementNotPresent(e_OverviewTab, GlobalVariable.TIMEOUT)
	
	'Verify notes tab link is not present'
	WebUI.verifyElementNotPresent(e_NotesTab, GlobalVariable.TIMEOUT)
	
	'Verify documents tab link is visible'
	WebUI.verifyElementNotPresent(e_DocumentsTab, GlobalVariable.TIMEOUT)
	
	'Verify cases tab link is visible'
	WebUI.verifyElementNotPresent(e_CasesTab, GlobalVariable.TIMEOUT)
	
	'Verify notification tab link is visible'
	WebUI.verifyElementNotPresent(e_NotificationsTab, GlobalVariable.TIMEOUT)

	'Verify more tab link is visible'
	WebUI.verifyElementNotPresent(e_MoreTab, GlobalVariable.TIMEOUT)
}
else {
	KeywordUtil.markFailedAndStop('Incorrect value provided in Global variable ENVIRONMENT')
}

//Click on Individual tabs and verify tabs are loaded

CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Accounts', false)
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Profile', false)
CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Contact Details', false)
if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
	CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Overview', false)
	CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Notes', false)
	CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Documents', false)
	CustomKeywords.'pages.consumer.ConsumerDashboardPage.selectTab'('Cases', false)
}
//
//
//'Click on Accounts tab'
//WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Accounts'))
//
//'Wait for Create Account icon to be visible'
//CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)
//
//'Verify accounts list table is visible'
//WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts'))
//
//'Click on Profile tab'
//WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Profile'))
//
//'Wait for element visible'
//
//
//'Verify first name value in Customer Details section'
//WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Profile Tab/Customer Details Section/lbl_FirstName'), custData.get(Fields.CUST_FIRST_NAME))
//
//'Click on contact details tab'
//WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_ContactDetails'))
//
//'Wait for Addresses section to be visible'
//
//
//'Verify Address table is visible'
//WebUI.verifyElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/table_Addresses'))
//
//if('EE'.equalsIgnoreCase(GlobalVariable.ENVIRONMENT)) {
//
//	'Click on Notes tab'
//	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Notes'))
//	
//	'Wait for Notes section to load'
//	
//	
//	'Click on documents tab'
//	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Documents'))
//
//	'Wait for Documents section to load'
//	
//	
//	'Click on cases tab'
//	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Cases'))
//
//	'Wait for Cases section to load'
//	
//	
//	'Click on Overview tab'
//	WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Overview'))
//
//	'Wait for Customer Person Details section to load in overview tab'
//	
//}
