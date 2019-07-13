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

public class AccountPage {

	static def fillAccountDetails(Map<Fields, String> accData) {
		//Enter account title
		if(StringUtil.isValidData(accData, Fields.ACC_TITLE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountTitle'), accData.get(Fields.ACC_TITLE))
		}

		//Select account ownership
		if(StringUtil.isValidData(accData, Fields.ACC_OWNERSHIP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Ownership'), accData.get(Fields.ACC_OWNERSHIP), false)
		}

		//Enter account description
		if(StringUtil.isValidData(accData, Fields.ACC_DESCRIPTION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountDescription'), accData.get(Fields.ACC_DESCRIPTION))
		}

		//Select Account group
		if(StringUtil.isValidData(accData, Fields.ACC_GROUP)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_AccountGroup'), accData.get(Fields.ACC_GROUP), false)
		}

		//Wait for Product section to be visible
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'),GlobalVariable.TIMEOUT)

		//Enter account number
		if(StringUtil.isValidData(accData, Fields.ACC_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))
		}

		//Select timezone
		if(StringUtil.isValidData(accData, Fields.ACC_TIMEZONE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Timezone'), accData.get(Fields.ACC_TIMEZONE), false)
		}

		//'Select statement frequency'
		if(StringUtil.isValidData(accData, Fields.ACC_STATEMENT_FREQUENCY)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_StatementFrequency'), accData.get(Fields.ACC_STATEMENT_FREQUENCY), false)
		}

		//Select Product Type
		if(StringUtil.isValidData(accData, Fields.ACC_PRODUCT_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_ProductType'), accData.get(Fields.ACC_PRODUCT_TYPE), false)
		}

		//Wait for position name field to load text
		new actions.WaitFor().textNotEmpty(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), GlobalVariable.TIMEOUT)
		WebUI.delay(2)

		//Enter Position name
		if(StringUtil.isValidData(accData, Fields.ACC_POSITION_NAME)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_PositionName'), accData.get(Fields.ACC_POSITION_NAME))
		}

		//Enter Currency code
		if(StringUtil.isValidData(accData, Fields.ACC_CURRENCY_CODE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Currency'), accData.get(Fields.ACC_CURRENCY_CODE), false)
		}

		//Enter Vertical
		if(StringUtil.isValidData(accData, Fields.ACC_VERTICAL)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_Vertical'), accData.get(Fields.ACC_VERTICAL), false)
		}

		//Enter Department ID
		if(StringUtil.isValidData(accData, Fields.ACC_DEPT_ID)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/select_DeptId'), accData.get(Fields.ACC_DEPT_ID), false)
		}

		//Enter Credit Limit
		if(StringUtil.isValidData(accData, Fields.ACC_CREDIT_LIMIT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_CreditLimit'), accData.get(Fields.ACC_CREDIT_LIMIT))
		}

		//Enter Interest rate
		if(StringUtil.isValidData(accData, Fields.ACC_INTEREST_RATE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_InterestRate'), accData.get(Fields.ACC_INTEREST_RATE))
		}

		//Select Document 1 - Terms and Conditions
		if(StringUtil.isValidData(accData, Fields.DOC_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType1'), accData.get(Fields.DOC_TYPE), false)
		}

		//Enter signed by
		if(StringUtil.isValidData(accData, Fields.DOC_SIGNED_BY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy1'), accData.get(Fields.DOC_SIGNED_BY))
		}

		//Enter signed date
		if(StringUtil.isValidData(accData, Fields.DOC_SIGNED_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate1'), accData.get(Fields.DOC_SIGNED_DATE))
		}

		//Enter version
		if(StringUtil.isValidData(accData, Fields.DOC_VERSION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version1'), accData.get(Fields.DOC_VERSION))
		}

		//Enter document 2 details if present
		if(StringUtil.isValidData(accData, Fields.DOC_TYPE2)) {

			//Scroll to Add another document link
			WebUI.scrollToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'), GlobalVariable.TIMEOUT)

			//Click on Add another document link
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/icon_AddAnotherDocument'))

			//Wait for new document section to be visible
			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), GlobalVariable.TIMEOUT)

			//Select Document 2
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/select_DocumentType2'), accData.get(Fields.DOC_TYPE2), false)

			//Enter signed by 2
			if(StringUtil.isValidData(accData, Fields.DOC_SIGNED_BY2)) {
				WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedBy2'), accData.get(Fields.DOC_SIGNED_BY2))
			}

			//Enter signed date 2
			if(StringUtil.isValidData(accData, Fields.DOC_SIGNED_DATE2)) {
				new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_SignedDate2'), accData.get(Fields.DOC_SIGNED_DATE2))
			}

			//Enter vesion 2
			if(StringUtil.isValidData(accData, Fields.DOC_VERSION2)) {
				WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/Documents/input_Version2'), accData.get(Fields.DOC_VERSION2))
			}
		}
	}

	static def fillTransactionDetails(Map<Fields, String> txnData) {

		'Wait for drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/select_TransactionCode'), GlobalVariable.TIMEOUT)

		'Select transaction type'
		WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/select_TransactionCode'), txnData.get(Fields.TXN_CODE), false)

		'Wait for amount field to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/input_Amount'), GlobalVariable.TIMEOUT)

		'Enter amount'
		if(StringUtil.isValidData(txnData, Fields.TXN_AMOUNT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/input_Amount'), txnData.get(Fields.TXN_AMOUNT))
		}

		'Enter comments'
		if(StringUtil.isValidData(txnData, Fields.TXN_COMMENT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Post Transaction/input_Comment'), txnData.get(Fields.TXN_COMMENT))
		}
	}

	static def reviewTransactionDetails(Map<Fields, String> txnData) {

		'Wait for drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_TransactionCode'), GlobalVariable.TIMEOUT)

		'Verify Transaction code value'
		String txnCode = txnData.get(Fields.TXN_CODE)
		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_TransactionCode'), txnData.get(Fields.TXN_CODE), RegexOperator.ENDS_WITH)

		'Verify Transaction Amount'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_TransactionAmount'), txnData.get(Fields.TXN_AMOUNT_VIEW))

		'Verify Ledger balance before'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_LedgerBalanceBefore'), txnData.get(Fields.ACC_LEDGER_BALANCE_BEFORE))

		'Verify Ledger balance after'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_LedgerBalanceAfter'), txnData.get(Fields.ACC_LEDGER_BALANCE))

		'Verify Available balance before'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_AvailableBalanceBefore'), txnData.get(Fields.ACC_AVAILABLE_BALANCE_BEFORE))

		'Verify Available balance after'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Confirm Transaction/lbl_AvailableBalanceAfter'), txnData.get(Fields.ACC_AVAILABLE_BALANCE))
	}

	static def verifyBalanceSummary(Map<Fields, String> txnData) {

		'Verify ledger balance - balance summary section - overview tab'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_LedgerBalance'), txnData.get(Fields.ACC_LEDGER_BALANCE))

		'Verify hold balance - balance summary section - overview tab'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Holds'), txnData.get(Fields.ACC_HOLD_BALANCE))

		'Verify avaialble balance - balance summary section - overview tab'
		WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_AvailableBalance'), txnData.get(Fields.ACC_AVAILABLE_BALANCE))
	}

	static def verifyTransactionTable(Map<Fields, String> txnData, TestObject table, int rowNo) {

		'Verify transaction type - transaction table - overview tab'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.TXN_TYPE, txnData.get(Fields.TXN_CODE))

		'Verify Credit amount - transaction table - overview tab'
		if(StringUtil.isValidData(txnData, Fields.TXN_TYPE) && txnData.get(Fields.TXN_TYPE).equalsIgnoreCase('CREDIT')) {
			new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.TXN_CREDIT, txnData.get(Fields.TXN_AMOUNT_VIEW))
		}
		else if(StringUtil.isValidData(txnData, Fields.TXN_TYPE) && txnData.get(Fields.TXN_TYPE).equalsIgnoreCase('DEBIT')) {
			new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.TXN_DEBIT, txnData.get(Fields.TXN_AMOUNT_VIEW))
		}
		else {
			KeywordUtil.markFailedAndStop('Credit or Debit indicator not provided to verify transaction details')
		}

		'Verify Comment - transaction table - overview tab'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.TXN_COMMENT, txnData.get(Fields.TXN_COMMENT))
	}

	static def expandTransactionInformation(TestObject table, int rowNo) {

		'Move to cell'
		new actions.Table().moveToCell(table, rowNo, ColumnPos.TXN_EXPAND_ICON)

		'Verify Transaction Details'
		new actions.Table().clickCell(table, rowNo, ColumnPos.TXN_EXPAND_ICON)

		'Wait for section to load'
		TestObject accordionTranactionInfo = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/accordion',['accordionName' : 'Transaction Information'])
		new actions.WaitFor().elementVisible(accordionTranactionInfo, GlobalVariable.TIMEOUT)

		'Click on Accordion'
		WebUI.click(accordionTranactionInfo)

		'Wait for Transacion Information section to load'
		TestObject fieldAccountNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Account Number'])
		new actions.WaitFor().elementVisible(fieldAccountNumber, GlobalVariable.TIMEOUT)
	}

	static def verifyTransactionInformation(Map<Fields, String> accData, Map<Fields, String> txnData) {

		TestObject accNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Account Number'])
		TestObject txnAmount = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Amount'])
		TestObject accBalance = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Balance'])
		TestObject txnType = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Type'])
		TestObject accPositionNumber = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Transaction Details Section/Transaction Information/lbl_TransactionData', ['fieldName' : 'Position Account Number'])

		'Verify Account Number'
		WebUI.verifyElementText(accNumber, accData.get(Fields.ACC_NUMBER))

		'Verify Amount'
		WebUI.verifyElementText(txnAmount, txnData.get(Fields.TXN_AMOUNT_VIEW))

		'Verify Balance'
		WebUI.verifyElementText(accBalance, txnData.get(Fields.ACC_AVAILABLE_BALANCE))

		'Verify Transaction type'
		new actions.Common().verifyMatch(txnType, txnData.get(Fields.TXN_TYPE), RegexOperator.EQUALS_IGNORE_CASE)

		'Verify Account Position Number'
		WebUI.verifyElementText(accPositionNumber, accData.get(Fields.ACC_NUMBER))
	}
	
	static def fillAccountDetailDoc(Map<Fields, String> accDetailDoc) {
		
		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/select_DocumentType'), GlobalVariable.TIMEOUT)
		
		'Select Document Type'
		if(StringUtil.isValidData(accDetailDoc, Fields.DOC_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/select_DocumentType'), accDetailDoc.get(Fields.DOC_TYPE), false)
		}
		
		'Enter Signed By'
		if(StringUtil.isValidData(accDetailDoc, Fields.DOC_SIGNED_BY)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/input_SignedBy'), accDetailDoc.get(Fields.DOC_SIGNED_BY))
		}
		
		'Enter Version'
		if(StringUtil.isValidData(accDetailDoc, Fields.DOC_VERSION)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/input_Version'), accDetailDoc.get(Fields.DOC_VERSION))
		}
		
		'Enter Signed Date'
		if(StringUtil.isValidData(accDetailDoc, Fields.DOC_SIGNED_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Account Detail Documents/input_SignedDate'), accDetailDoc.get(Fields.DOC_SIGNED_DATE))
		}
	} 
	
	static def verifyAccountDetailDoc(Map<Fields, String> accDetailDoc, int rowNo) {
		
		TestObject table = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Details Tab/Document Section/table_Documents')
		
		'Move to Doc table in details tab'
		new actions.Table().moveToCell(table, rowNo, ColumnPos.DOC_TYPE)
		
		'Verify Doc Type'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.DOC_TYPE, accDetailDoc.get(Fields.DOC_TYPE))
		
		'Verify Doc Signed By'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.DOC_SIGNED_BY, accDetailDoc.get(Fields.DOC_SIGNED_BY))

		'Verify Doc Type'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.DOC_SIGNED_DATE, accDetailDoc.get(Fields.DOC_SIGNED_DATE_VIEW))

		'Verify Doc Type'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.DOC_VERSION, accDetailDoc.get(Fields.DOC_VERSION))
	}
}