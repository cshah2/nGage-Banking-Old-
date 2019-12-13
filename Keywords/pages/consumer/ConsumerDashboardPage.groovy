package pages.consumer

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Map

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import enums.Fields
import internal.GlobalVariable

public class ConsumerDashboardPage {

	@Keyword
	def verifyConsumerDetailsSummarySection(Map<Fields, String> data) {

		//Wait for Customer details page to load
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)

		//Verify Customer name is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), data.get(Fields.CUST_NAME_VIEW))

		//Verify Customer phone is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_PhoneNumber'), data.get(Fields.CT_PHONE_NUMBER))

		//Verify Customer email is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Email'), data.get(Fields.CT_EMAIL))

		//Verify Customer address is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_Address'), data.get(Fields.ADDR_VIEW))
	}

	@Keyword
	def selectTab(String tabName, boolean isHidden) {

		TestObject e_tabName = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_Common',[('tabName'):tabName])
		TestObject e_MoreTab = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/tab_More')
		
		if(isHidden) {
			new actions.Common().moveToElementAndClick(e_MoreTab)
			WebUI.delay(2) //TODO:Need to add wait condition for hidden menus to be displayed.
		}
		new actions.Common().moveToElementAndClick(e_tabName)
		
		switch(tabName.toLowerCase()) {
			
			case "accounts":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/icon_CreateAccount'), GlobalVariable.TIMEOUT)
				break;
			case "profile":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Profile Tab/Customer Details Section/section_Body'), GlobalVariable.TIMEOUT)
				break;
			case "contact details":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Contact Details Tab/Customer Address Section/section_Body'), GlobalVariable.TIMEOUT)
				break;
			case "overview":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Overview Tab/Customer Person Detail Section/section_Body'), GlobalVariable.TIMEOUT)
				break;
			case "notes":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Notes Tab/Notes section/section_Body'), GlobalVariable.TIMEOUT)
				break;
			case "documents":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Documents Tab/Documents Section/section_Body'), GlobalVariable.TIMEOUT)
				break;
			case "cases":
				new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Cases Tab/Cases Section/section_Title'), GlobalVariable.TIMEOUT)
				break;
			default:
				break;
		}
	}
	
	@Keyword
	def verifyAccountsDataInTable(Map<Fields, String> accData, int rowNo) {

		TestObject table = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Accounts Tab/table_Accounts')

		//'Wait for table to be visible'
		new actions.WaitFor().elementVisible(table, GlobalVariable.TIMEOUT)

		//Verify Correct account number is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_NUMBER, accData.get(Fields.ACC_NUMBER))

		//Verify Correct account title is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_TITLE, accData.get(Fields.ACC_TITLE))

		//Verify Correct account open date is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_OPEN_DATE, accData.get(Fields.ACC_OPEN_DATE))

		//Verify Correct account description is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_DESCRIPTION, accData.get(Fields.ACC_DESCRIPTION))

		//Verify Correct account ledger balance is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_LEDGER_BALANCE, accData.get(Fields.ACC_LEDGER_BALANCE))

		//Verify Correct account availble balance is displayed in grid
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.ACC_AVAILABLE_BALANCE, accData.get(Fields.ACC_AVAILABLE_BALANCE))
	}
}
