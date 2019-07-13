package pages

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

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
import enums.RegexOperator
import internal.GlobalVariable

public class SearchPage {
	
	static def searchCustomer(Map<Fields, String> custData) {
		
		//Click on Search All drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

		//Click on Customer option
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Customer'))

		//Wait for Search button to be visible
		WebUI.delay(3) //TODO: Need to find correct wait condition.
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'), GlobalVariable.TIMEOUT)

		//Enter Search Criteria in last name field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_LastName'), custData.get(Fields.CUST_LAST_NAME))

		//Enter Search Criteria in First name field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_FirstName'), custData.get(Fields.CUST_FIRST_NAME))

		//Enter Search Criteria in Tax ID field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_TaxID'), custData.get(Fields.CUST_TAX_ID))

		//Click on Search button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Cust_Search'))

		TestObject resultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

		//Wait for table to be visible
		new utils.WaitFor().elementVisible(resultTable, GlobalVariable.TIMEOUT)

		//Verify result table contains atleast 1 record
		new actions.table().verifyRecordsCount(resultTable, 1, RegexOperator.GREATER_THAN_OR_EQUAL)

		int rowNo = 1

		//Verify column values are matching - last name
		new actions.table().verifyCellValueEquals(resultTable, rowNo, ColumnPos.CUST_LAST_NAME, custData.get(Fields.CUST_LAST_NAME))

		//Verify column values are matching - first name
		new actions.table().verifyCellValueEquals(resultTable, rowNo, ColumnPos.CUST_FIRST_NAME, custData.get(Fields.CUST_FIRST_NAME))
	}
	
	static def selectCustomer(Map<Fields, String> custData, int rowNo) {
		
		TestObject resultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')
		
		//Click on Last name link in a first row of search result table
		new actions.table().clickCell(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), rowNo, ColumnPos.CUST_LAST_NAME)
		
		//Wait for Customer details page to load
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT)
		
		//Verify Customer name is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))
	}
	
	static def searchAccount(Map<Fields, String> accData) {
		
		//Click on Search All drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT)

		//Click on Accounts option
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

		//Wait for Account Type drop down to be visible
		WebUI.delay(3) //TODO: Need to look for wait conditon
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)

		String currentAccType = WebUI.getText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType')).trim()

		String accType = accData.get(Fields.ACC_GROUP)
		if(!currentAccType.equalsIgnoreCase(accType)) {
			//Click on accounts type drop down
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

			//Wait for Menus to be visible
			WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT)

			if('Banking'.equalsIgnoreCase(accType)) {
				//Click on Banking option
				WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Banking'))
			}
			else {
				//Click on Multi- Position option
				WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_MultiPosition'))
			}

			//Wait for Account number input field to be visible
			WebUI.delay(3) //TODO: Need to look for wait conditon
			new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)
		}

		//Enter Search Criteria in account number field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

		//Click on Search button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

		//Wait for Account title to be visible
		new utils.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

		//Verify Account title contains correct account number
		new actions.common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), accData.get(Fields.ACC_NUMBER))
	}
}
