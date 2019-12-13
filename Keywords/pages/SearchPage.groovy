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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable
import utils.StringUtil

public class SearchPage {

	static String pageUrl = GlobalVariable.BASE_URL+"/nGageBanking_Customer/CustomerSearch.aspx"

	static def verifyPageIsLoaded() {
		String actPageUrl = WebUI.getUrl()
		new actions.Common().verifyMatch(actPageUrl, pageUrl, RegexOperator.CONTAINS)
	}

	@Keyword
	def searchCustomer(Map<Fields, String> custSearchData) {

		TestObject e_CustomerGroup = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/select_CustomerGroup')
		TestObject e_LastName = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_LastName')
		TestObject e_FirstName = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_FirstName')
		TestObject e_TaxId = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_TaxID')
		TestObject e_PhoneNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_PhoneNumber')
		TestObject e_Email = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_Email')
		TestObject e_DOB = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_DOB')
		TestObject e_CustomerId = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/ConsumerSearch/input_CustomerId')
		TestObject e_Search = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Search')

		new actions.Common().selectOptionByLabelIfNotEmpty(e_CustomerGroup, custSearchData, Fields.CUST_CUSTOMER_GROUP)

		WebUI.clearText(e_LastName)
		WebUI.clearText(e_FirstName)
		WebUI.clearText(e_TaxId)
		WebUI.clearText(e_PhoneNumber)
		WebUI.clearText(e_Email)
		WebUI.clearText(e_DOB)
		WebUI.clearText(e_CustomerId)

		new actions.Common().setTextIfNotEmpty(e_LastName, custSearchData, Fields.CUST_LAST_NAME)
		new actions.Common().setTextIfNotEmpty(e_FirstName, custSearchData, Fields.CUST_FIRST_NAME)
		new actions.Common().setTextIfNotEmpty(e_TaxId, custSearchData, Fields.CUST_TAX_ID)
		new actions.Common().setTextIfNotEmpty(e_PhoneNumber, custSearchData, Fields.CT_PHONE_NUMBER)
		new actions.Common().setTextIfNotEmpty(e_Email, custSearchData, Fields.CT_EMAIL)
		new actions.Common().setTextIfNotEmpty(e_DOB, custSearchData, Fields.CUST_DOB)
		new actions.Common().setTextIfNotEmpty(e_CustomerId, custSearchData, Fields.CUST_CUSTOMER_ID)

		new actions.Common().moveToElementAndClick(e_Search)
	}

	@Keyword
	def verifyCustomerDetailsInResultTable(Map<Fields, String> custData, int rowNo) {

		TestObject e_ResultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

	}


	static def selectCustomer(Map<Fields, String> custData, int rowNo) {

		TestObject resultTable = findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult')

		//Click on Last name link in a first row of search result table
		new actions.Table().clickCell(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/table_SearchResult'), rowNo, ColumnPos.CUST_LAST_NAME)

		//Wait for Customer details page to load
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

		//Verify Customer name is displayed correctly
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Summary Section/lbl_CustomerName'), custData.get(Fields.CUST_NAME_VIEW))
	}

	static def searchAccount(Map<Fields, String> accData) {

		//Click on Search All drop down
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		//Wait for Menus to be visible
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

		//Click on Accounts option
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Account'))

		//Wait for Account Type drop down to be visible
		WebUI.delay(3) //TODO: Need to look for wait conditon
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'), GlobalVariable.TIMEOUT)

		String currentAccType = WebUI.getText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType')).trim()

		String accType = accData.get(Fields.ACC_GROUP)
		if(!currentAccType.equalsIgnoreCase(accType)) {
			//Click on accounts type drop down
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType'))

			//Wait for Menus to be visible
			WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_AccountsType_Option_Menu'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

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
			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), GlobalVariable.TIMEOUT)
		}

		//Enter Search Criteria in account number field
		WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))

		//Click on Search button
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/btn_Acc_Search'))

		//Wait for Account title to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), GlobalVariable.TIMEOUT)

		//Verify Account title contains correct account number
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Summary Section/lbl_AccountTitle'), accData.get(Fields.ACC_NUMBER))
	}

	@Keyword
	static def selectSearchEntity(String entityType) {

		'Click on Search All drop down'
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search'))

		'Wait for Menus to be visible'
		WebUI.waitForElementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Menu'), GlobalVariable.TIMEOUT, FailureHandling.STOP_ON_FAILURE)

		if('Organization'.equalsIgnoreCase(entityType)) {

			'Click on Organization option'
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Organization'))

			'Wait for Create customer icon to be visible'
			WebUI.delay(3) //TODO: Need to identify propert wait condition
			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/input_OrganizationName'), GlobalVariable.TIMEOUT)
		}
		else if('Consumer'.equalsIgnoreCase(entityType)) {

			'Click on Customer option'
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/dd_Search_Option_Consumer'))

			'Wait for Create customer icon to be visible'
			WebUI.delay(3) //TODO: Need to identify propert wait condition
			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Search Page/icon_CreateConsumer'), GlobalVariable.TIMEOUT)
		}
		else if('Account'.equalsIgnoreCase(entityType)) {

		}
		else {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('Incorrect entity type provided for selection on search page : '+entityType)
		}
	}
}
