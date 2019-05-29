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

'Login into portal'
CustomKeywords.'actions.common.login'()

'Click on Search All drop down'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

'Wait for Menus to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Menu'), GlobalVariable.TIMEOUT)

'Click on Customer option'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ddOption_Customer'))

'Wait for Create customer icon to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'), GlobalVariable.TIMEOUT)

'Click on Create customer icon'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateCustomer'))

'Wait for Create customer page to be visible'
WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_FirstName'), GlobalVariable.TIMEOUT)

'Enter First name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_FirstName'), 'Chintan')

'Enter Middle name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_MiddleName'), 'Deepak')

'Enter Last name'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_LastName'), 'Shah')

'Enter Date of birth'
CustomKeywords.'actions.javaScript.setText'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_DOB'), '1985-09-01')

'Enter Tax ID'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/input_TaxID'), '91178123')

'Select Country of residency'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/select_CountryOfResidence'), 'United States of America', false)

'Select Residency status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/select_ResidencyStatus'), 'Resident', false)

'Select Country of Citizenship'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/select_CountryOfCitizenship'), 'United States of America', false)

'Select Marital status'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/select_MaritalStatus'), 'Single', false)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Basic Information/btn_Next'))

'Wait for Location information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/input_Street'), GlobalVariable.TIMEOUT)

'Enter Street'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/input_Street'), '29 May Street')

'Enter City'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/input_City'), 'Philadelphia PA')

'Select Country'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/select_Country'), 'United States of America', false)

'Select State/Region'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/select_StateOrRegion'), 'Pennsylvania', false)

'Enter Zip/Postal Code'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/input_ZipOrPostalCode'), '15006')

'Select Address Type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/select_AddressType'), 'Residence', false)

'Enter Address Label'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/input_AddressLabel'), 'HOME')

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Location Information/btn_Next'))

'Wait for Contact information fields to be visible'
CustomKeywords.'utils.WaitFor.elementVisible'(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/input_PhoneNumber'), GlobalVariable.TIMEOUT)

'Enter Phone number'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/input_PhoneNumber'), '+17814484359')

'Select Phone type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/select_PhoneType'), 'Home', false)

'Enter Email'
WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/input_Email'), 'cshah@savanainc.com')

'Select Email type'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/select_EmailType'), 'Personal', false)

'Select Preferred language'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/select_PreferredLanguage'), 'English - United States', false)

'Select Preferred contact method'
WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/select_PreferredContactMethod'), 'Email', false)

'Click on Next button'
WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Customer/Contact Information/btn_Next'))

//Verify customer information review page.