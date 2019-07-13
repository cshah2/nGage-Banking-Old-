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
import static constants.common.*;

'Login into portal'
CustomKeywords.'actions.Common.login'()

'Verify lightning bolt icon is visible'
WebUI.verifyElementVisible(findTestObject('Dashboard Page/Header Section/icon_LightningBolt'))

'Click on lightning bolt icon'
WebUI.click(findTestObject('Dashboard Page/Header Section/icon_LightningBolt'))

'Wait for dialog to be present'
CustomKeywords.'actions.WaitFor.elementVisible'(findTestObject('Dashboard Page/Header Section/Dialog LightningBolt/dialog'), GlobalVariable.TIMEOUT)

'Verify Finxact version value is not empty or blank'
WebUI.verifyMatch(WebUI.getText(findTestObject('Dashboard Page/Header Section/Dialog LightningBolt/lbl_Version')), '^(?!\\s*$).+', true)