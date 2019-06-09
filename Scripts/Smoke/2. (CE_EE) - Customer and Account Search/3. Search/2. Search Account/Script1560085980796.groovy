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
import internal.GlobalVariable as GlobalVariable

String searchAccountNumber = '114454789561'
String accountTitle = 'Scott Adkins'
String accountDescription = 'Saving'
String routingNumber = '053112916'

'Login into portal'
CustomKeywords.'actions.common.login'()

//Search for - Account number
'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

'Wait for Account Type drop down to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)

'Click on account type drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT)

'Click on Banking option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Banking'))

'Wait for Account number input field to be visible'
WebUI.delay(2)
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)

'Enter Search Criteria in account number field'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), searchAccountNumber)

'Click on Search button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

'Wait for Account title to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

'Verify Account title contains correct account number'
CustomKeywords.'actions.common.verifyElementTextContains'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), searchAccountNumber)

'Click on Details tab'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/tab_Details'))

'Wait Account Details section is visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/section_AccountDetails'), GlobalVariable.TIMEOUT)

'Verify Account number'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountNumber'), searchAccountNumber)

'Verify Account title'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountTitle'), accountTitle)

'Verify Account description'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_AccountDescription'), accountDescription)

'Verify Routing number'
WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Account Details Section/lbl_RoutingNumber'), routingNumber)
