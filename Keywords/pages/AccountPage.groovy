package pages

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
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import constants.ColumnPos
import constants.common
import enums.Fields
import enums.RegexOperator
import internal.GlobalVariable
import utils.DateUtil
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
		WebUI.delay(2) //TODO: Need to add proper wait condition

		//Enter account number
		if(StringUtil.isValidData(accData, Fields.ACC_NUMBER)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), accData.get(Fields.ACC_NUMBER))
		}

		//		//Store account number value in a variable
		//		//WebUI.delay(2) //TODO: Wait for account number value to populate.
		//		new actions.WaitFor().attributeValueChange(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), "value", '')
		//		String accNumber = WebUI.getAttribute(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_AccountNumber'), 'value')
		//		println "Account Number is "+accNumber
		//		accData.put(Fields.ACC_NUMBER, accNumber)

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

		//		Field has been removed Date - 07 July 2019
		//		//Enter Interest rate
		//		if(StringUtil.isValidData(accData, Fields.ACC_INTEREST_RATE)) {
		//			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Create Account Page/input_InterestRate'), accData.get(Fields.ACC_INTEREST_RATE))
		//		}

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

		boolean isPreAuth = StringUtil.isValidData(txnData, Fields.HOLD_PRE_AUTH)
		boolean isRegCC = StringUtil.isValidData(txnData, Fields.HOLD_REG_CC)
		boolean isClearing = StringUtil.isValidData(txnData, Fields.HOLD_CLEARING)
		boolean isReserve = StringUtil.isValidData(txnData, Fields.HOLD_RESERVE)
		boolean isAdmin = StringUtil.isValidData(txnData, Fields.HOLD_ADMIN)

		if(isPreAuth || isRegCC || isClearing || isReserve || isAdmin) {

			'Click on Icon next to Holds'
			WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/icon_HoldsLink'))

			'Wait for section to load'
			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_PreAuth'), GlobalVariable.TIMEOUT)

			'Verify Pre-Auth value'
			if(isPreAuth) {
				WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_PreAuth'), txnData.get(Fields.HOLD_PRE_AUTH))
			}

			'Verify RegCC value'
			if(isRegCC) {
				WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_RegCC'), txnData.get(Fields.HOLD_REG_CC))
			}

			'Verify Clearing value'
			if(isClearing) {
				WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_Clearing'), txnData.get(Fields.HOLD_CLEARING))
			}

			'Verify Reserve value'
			if(isReserve) {
				WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_Reserve'), txnData.get(Fields.HOLD_RESERVE))
			}

			'Verify Reserve value'
			if(isAdmin) {
				WebUI.verifyElementText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Overview Tab/Balance Summary Section/lbl_Hold_Admin'), txnData.get(Fields.HOLD_ADMIN))
			}
		}
	}

	static def verifyTransactionTable(Map<Fields, String> txnData, TestObject table, int rowNo) {

		'Verify transaction type - transaction table'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.TXN_TYPE, txnData.get(Fields.TXN_CODE))

		'Verify Credit amount - transaction table'
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

		'Wait for 2 seconds'
		WebUI.delay(2)

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

	static def fillHoldDetails(Map<Fields, String> holdData) {

		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), GlobalVariable.TIMEOUT)

		if(StringUtil.isValidData(holdData, Fields.HOLD_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), holdData.get(Fields.HOLD_TYPE), false)
		}

		if(StringUtil.isValidData(holdData, Fields.HOLD_START_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_StartDate'), holdData.get(Fields.HOLD_START_DATE))
		}

		if(StringUtil.isValidData(holdData, Fields.HOLD_DURATION)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_Duration'), holdData.get(Fields.HOLD_DURATION), false)
		}

		if(StringUtil.isValidData(holdData, Fields.HOLD_AMOUNT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_HoldAmount'), holdData.get(Fields.HOLD_AMOUNT))
		}

		if(StringUtil.isValidData(holdData, Fields.HOLD_NOTE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_Note'), holdData.get(Fields.HOLD_NOTE))
		}

		if(StringUtil.isValidData(holdData, Fields.HOLD_REASON)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_Reason'), holdData.get(Fields.HOLD_REASON))
		}
	}

	static def expandHoldInformation(TestObject table, int rowNo) {

		'Move to cell'
		new actions.Table().moveToCell(table, rowNo, ColumnPos.HOLD_EXPAND_ICON)

		'Verify Transaction Details'
		new actions.Table().clickCell(table, rowNo, ColumnPos.HOLD_EXPAND_ICON)

		'Wait for Hold infomration section to load'
		TestObject fieldHoldAmount = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Hold Details Section/lbl_HoldData', ['fieldName' : 'HOLD AMOUNT'])
		new actions.WaitFor().elementVisible(fieldHoldAmount, GlobalVariable.TIMEOUT)

	}

	static def verifyHoldTable(Map<Fields, String> holdData, TestObject table, int rowNo) {

		'Verify Hold Type'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.HOLD_TYPE, holdData.get(Fields.HOLD_TYPE))

		'Verify Start Date'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.HOLD_START_DATE, holdData.get(Fields.HOLD_START_DATE_VIEW))

		'Verify Duration'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.HOLD_DURATION, holdData.get(Fields.HOLD_DURATION_VIEW))

		'Verify Amount'
		new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.HOLD_AMOUNT, holdData.get(Fields.HOLD_AMOUNT_VIEW))

		'Verify Cancel Date'
		if(StringUtil.isValidData(holdData, Fields.HOLD_CANCEL_DATE)) {
			new actions.Table().verifyCellValueEquals(table, rowNo, ColumnPos.HOLD_CANCEL_DATE, holdData.get(Fields.HOLD_CANCEL_DATE_VIEW))
		}
	}

	static def verifyHoldDetailsExpandedIntable(Map<Fields, String> accData, Map<Fields, String> holdData) {

		TestObject holdType = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Hold Details Section/lbl_HoldData', ['fieldName' : 'HOLD TYPE'])
		TestObject holdStartDate = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Hold Details Section/lbl_HoldData', ['fieldName' : 'START DATE'])
		TestObject holdDuration = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Hold Details Section/lbl_HoldData', ['fieldName' : 'DURATION'])
		TestObject holdAmount = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Hold Details Section/lbl_HoldData', ['fieldName' : 'HOLD AMOUNT'])

		'Wait for section to load'
		new actions.WaitFor().elementVisible(holdType, GlobalVariable.TIMEOUT)

		'Verify Hold type value'
		WebUI.verifyElementText(holdType, holdData.get(Fields.HOLD_TYPE))

		'Verify Hold Start Date'
		WebUI.verifyElementText(holdStartDate, holdData.get(Fields.HOLD_START_DATE_VIEW))

		'Verify Hold Duration'
		WebUI.verifyElementText(holdDuration, holdData.get(Fields.HOLD_DURATION_VIEW))

		'Verify Hold Amount'
		WebUI.verifyElementText(holdAmount, holdData.get(Fields.HOLD_AMOUNT_VIEW))
	}

	static def verifyHoldDetailsInTaskDrawer(Map<Fields, String> holdData) {

		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), GlobalVariable.TIMEOUT)

		'Verify selected hold type'
		WebUI.verifyOptionSelectedByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/select_HoldType'), holdData.get(Fields.HOLD_TYPE), false, GlobalVariable.TIMEOUT)

		'Verify start date'
		WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_StartDate'), 'value', holdData.get(Fields.HOLD_START_DATE), GlobalVariable.TIMEOUT)

		'Verify Hold amount'
		WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_HoldAmount'), 'value', holdData.get(Fields.HOLD_AMOUNT), GlobalVariable.TIMEOUT)

		'Verify Hold Notes'
		WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_Note'), 'value', holdData.get(Fields.HOLD_NOTE), GlobalVariable.TIMEOUT)

		'Verify Hold Reason'
		WebUI.verifyElementAttributeValue(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Hold/input_Reason'), 'value', holdData.get(Fields.HOLD_REASON), GlobalVariable.TIMEOUT)
	}

	static def verifyHoldDetailsInCancelHoldTaskDrawer(Map<Fields, String> cancelHoldData) {

		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_HoldType'), GlobalVariable.TIMEOUT)

		'Verify Hold Type'
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_HoldType'), cancelHoldData.get(Fields.HOLD_TYPE))

		'Verify Hold Start Date'
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_StartDate'), cancelHoldData.get(Fields.HOLD_START_DATE))

		'Verify Hold Duration'
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_HoldDuration'), cancelHoldData.get(Fields.HOLD_DURATION_VIEW))

		'Verify Hold Amount'
		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_HoldAmount'), cancelHoldData.get(Fields.HOLD_AMOUNT_VIEW))
	}

	static def fillCancelHoldDetails(Map<Fields, String> cancelHoldData) {

		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/lbl_HoldType'), GlobalVariable.TIMEOUT)

		if(StringUtil.isValidData(cancelHoldData, Fields.HOLD_CANCEL_DATE)) {
			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/input_CancelDate'), cancelHoldData.get(Fields.HOLD_CANCEL_DATE))
		}

		if(StringUtil.isValidData(cancelHoldData, Fields.HOLD_CANCEL_NOTE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Hold/input_Note'), cancelHoldData.get(Fields.HOLD_CANCEL_NOTE))
		}
	}

	static def fillOrderDetails(Map<Fields, String> orderData, Map<Fields, String> fromAcc, Map<Fields, String> toAcc) {

		'Wait for taske drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_OrderType'), GlobalVariable.TIMEOUT)

		if(StringUtil.isValidData(orderData, Fields.ORDER_TYPE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_OrderType'), orderData.get(Fields.ORDER_TYPE), false)

			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_OrderSource'), GlobalVariable.TIMEOUT)
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_SOURCE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_OrderSource'), orderData.get(Fields.ORDER_SOURCE), false)
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_INFO)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_OrderInfo'), orderData.get(Fields.ORDER_INFO))
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_ORIGIN_SOURCE)) {
			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_OriginSource'), orderData.get(Fields.ORDER_ORIGIN_SOURCE), false)
		}

		orderData.put(Fields.ORDER_NETWORK, WebUI.getAttribute(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_Network'), 'value'))

		if(StringUtil.isValidData(orderData, Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_CounterpartyAccountTitle'), orderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE))
		}

		if('Book transfer'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_CounterpartyAccountGroup'), orderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_GROUP), false)

			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_CounterpartyToAccountNumber'), toAcc.get(Fields.ACC_NUMBER))

			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_CounterpartyToAccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE), false)
		}

		if('Payment order'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_RecipientInstitutionRountingNumber'), orderData.get(Fields.ORDER_ROUTING_NUMBER))

			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_CounterpartyToAccountNumber'), toAcc.get(Fields.ACC_NUMBER))

			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_CounterpartyToAccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE), false)
		}

		if('Collection order'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_FromInstitutionRountingNumber'), orderData.get(Fields.ORDER_ROUTING_NUMBER))

			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_CounterpartyFromAccountNumber'), fromAcc.get(Fields.ACC_NUMBER))

			WebUI.selectOptionByLabel(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/select_CounterpartyFromAccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE), false)
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_TRANSFER_DATE)) {
			WebUI.uncheck(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_SendNow'))

			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), GlobalVariable.TIMEOUT)

			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), orderData.get(Fields.ORDER_TRANSFER_DATE))
		}
		else {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_SendNow'))

			new actions.WaitFor().elementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), GlobalVariable.TIMEOUT)
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_ISRECURRING)) {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_RecurringOrder'))
		}
		else {
			WebUI.uncheck(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_RecurringOrder'))
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_TRANSFER_AMOUNT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferAmount'), orderData.get(Fields.ORDER_TRANSFER_AMOUNT))
		}
	}

	static def reviewOrderDetails(Map<Fields, String> orderData, Map<Fields, String> fromAcc, Map<Fields, String> toAcc) {

		//String defaultTransferDate = 'Immediate'
		String defaultReccurringNo = 'No'
		String defaultReccurringYes = 'Yes'

		'Wait for review page to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderSource'), GlobalVariable.TIMEOUT)

		new actions.Common().moveToElement(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderType'))

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderType'), orderData.get(Fields.ORDER_TYPE), RegexOperator.CONTAINS)

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderSource'), orderData.get(Fields.ORDER_SOURCE), RegexOperator.CONTAINS)

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderInfo'), orderData.get(Fields.ORDER_INFO), RegexOperator.CONTAINS)

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OriginSource'), orderData.get(Fields.ORDER_ORIGIN_SOURCE), RegexOperator.CONTAINS)

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_Network'), orderData.get(Fields.ORDER_NETWORK), RegexOperator.CONTAINS)

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_CounterpartyAccountTitle'), orderData.get(Fields.ORDER_COUNTERPARTY_ACCOUNT_TITLE), RegexOperator.CONTAINS)

		if('Book transfer'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_CounterpartyToAccount'), toAcc.get(Fields.ACC_NUMBER), RegexOperator.CONTAINS)

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_AccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE), RegexOperator.CONTAINS)
		}

		if('Payment order'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_RecipientInstitutionRountingNumber'), orderData.get(Fields.ORDER_ROUTING_NUMBER), RegexOperator.CONTAINS)

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_CounterpartyToAccount'), toAcc.get(Fields.ACC_NUMBER), RegexOperator.CONTAINS)

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_AccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_TO_ACCOUNT_TYPE), RegexOperator.CONTAINS)
		}

		if('Collection order'.equalsIgnoreCase(orderData.get(Fields.ORDER_TYPE))) {

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_FromInstitutionRountingNumber'), orderData.get(Fields.ORDER_ROUTING_NUMBER), RegexOperator.CONTAINS)

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_CounterpartyFromAccount'), fromAcc.get(Fields.ACC_NUMBER), RegexOperator.CONTAINS)

			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_AccountType'), orderData.get(Fields.ORDER_COUNTERPARTY_FROM_ACCOUNT_TYPE), RegexOperator.CONTAINS)
		}

		new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_TransferDate'), orderData.get(Fields.ORDER_TRANSFER_DATE_VIEW), RegexOperator.CONTAINS)

		if(StringUtil.isValidData(orderData, Fields.ORDER_ISRECURRING)) {
			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_Recurring'), defaultReccurringYes, RegexOperator.CONTAINS)
		}
		else {
			new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_Recurring'), defaultReccurringNo, RegexOperator.CONTAINS)
		}

		//TODO: Need to enable this check once DOM issue is fixed by Dev team.
		//new actions.Common().verifyMatch(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Review Order/lbl_OrderAmount'), orderData.get(Fields.ORDER_TRANSFER_AMOUNT_VIEW), RegexOperator.CONTAINS)
	}

	static def verifyOrdersTable(Map<Fields, String> orderData, Map<Fields, String> fromAcc, Map<Fields, String> toAcc, int rowNo) {

		TestObject orderTable = findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Orders Tab/Orders Section/table_Orders')
		String currDateUTC = DateUtil.getCurrentDateTime(common.dateFormat, common.timezoneUTC)


		new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_TYPE, orderData.get(Fields.ORDER_TYPE))

		new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_CREATE_DATE, currDateUTC)

		if(StringUtil.isValidData(orderData, Fields.ORDER_TRANSFER_DATE)) {
			new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_ORDER_DATE, orderData.get(Fields.ORDER_TRANSFER_DATE_VIEW))
		}
		else {
			new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_ORDER_DATE, currDateUTC)
		}

		new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_FROM_ACCOUNT, fromAcc.get(Fields.ACC_NUMBER))

		new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_TO_ACCOUNT, toAcc.get(Fields.ACC_NUMBER))

		if(StringUtil.isValidData(orderData, Fields.ORDER_ROUTING_NUMBER)) {
			new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_COUNTERPARTY_INSTITUTION, orderData.get(Fields.ORDER_ROUTING_NUMBER))
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_STATUS)) {
			new actions.Table().verifyCellValueEquals(orderTable, rowNo, ColumnPos.ORDER_STATUS, orderData.get(Fields.ORDER_STATUS))
		}
	}

	static def editOrderDetails(Map<Fields, String> orderData) {

		if(StringUtil.isValidData(orderData, Fields.ORDER_TRANSFER_DATE)) {
			WebUI.uncheck(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_SendNow'))

			new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), GlobalVariable.TIMEOUT)

			new actions.JavaScript().setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), orderData.get(Fields.ORDER_TRANSFER_DATE))
		}
		else {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_SendNow'))

			new actions.WaitFor().elementNotPresent(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferDate'), GlobalVariable.TIMEOUT)
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_ISRECURRING)) {
			WebUI.check(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_RecurringOrder'))
		}
		else {
			WebUI.uncheck(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/chkbox_RecurringOrder'))
		}

		if(StringUtil.isValidData(orderData, Fields.ORDER_TRANSFER_AMOUNT)) {
			WebUI.setText(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Order/input_TransferAmount'), orderData.get(Fields.ORDER_TRANSFER_AMOUNT))
		}
	}

	static def fillCancelOrderDetails(Map<Fields, String> orderData) {

		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/lbl_OrderType'), orderData.get(Fields.ORDER_TYPE))

		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/lbl_OrderDate'), orderData.get(Fields.ORDER_TRANSFER_DATE))

		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/lbl_OrderAmount'), orderData.get(Fields.ORDER_TRANSFER_AMOUNT_VIEW))

		new actions.Common().verifyElementTextContains(findTestObject('Dashboard Page/Customer and Account Search Page/Account Details Page/Task Drawer/Cancel Order/lbl_OrderStatus'), orderData.get(Fields.ORDER_STATUS))
	}

	//	static def fillDocumentDetails(Map<Fields, String> documentData) {
	//
	//		TestObject e_FileUpload = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload')
	//		TestObject e_DocClass = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocClass')
	//		TestObject e_FileAfterUpload = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/lbl_FileNameAfterUpload')
	//		TestObject e_DocType = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_DocType')
	//		TestObject e_StartDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_StartDate')
	//		TestObject e_EndDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_EndDate')
	//		TestObject e_ReceivedDate = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_ReceivedDate')
	//		TestObject e_Status = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/select_Status')
	//		TestObject e_Description = findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_Description')
	//
	//		'Wait for Task drawer to load'
	//		new actions.WaitFor().elementVisible(e_DocClass, GlobalVariable.TIMEOUT)
	//
	//		'Upload file'
	//		//CustomKeywords.'actions.File.upload'(findTestObject('Dashboard Page/Customer and Account Search Page/Customer Details Page/Task Drawer/Customer Documents/input_FileUpload'), docData.get(Fields.DOCUMENT_FILEPATH))
	//		new actions.File().uploadAutoIt(e_FileUpload, documentData.get(Fields.DOCUMENT_FILEPATH))
	//
	//		'Wait for Uploaded file name to be visible'
	//		new actions.WaitFor().elementVisible(e_FileAfterUpload, GlobalVariable.TIMEOUT)
	//
	//		'Select doc class'
	//		new actions.Common().selectOptionByLabelIfNotEmpty(e_DocClass, documentData, Fields.DOCUMENT_CLASS)
	//
	//		'Wait for doc type field to be editable'
	//		new actions.WaitFor().elementClickable(e_DocType, GlobalVariable.TIMEOUT)
	//
	//		'Select doc type'
	//		new actions.Common().selectOptionByLabelIfNotEmpty(e_DocType, documentData, Fields.DOCUMENT_TYPE)
	//
	//		'Enter start date'
	//		new actions.Common().setTextJQueryIfNotEmpty(e_StartDate, documentData, Fields.DOCUMENT_START_DATE)
	//
	//		'Enter end date'
	//		new actions.Common().setTextJQueryIfNotEmpty(e_EndDate, documentData, Fields.DOCUMENT_END_DATE)
	//
	//		'Enter received date'
	//		new actions.Common().setTextJQueryIfNotEmpty(e_ReceivedDate, documentData, Fields.DOCUMENT_RECEIVED_DATE)
	//
	//		'Select status'
	//		new actions.Common().selectOptionByLabelIfNotEmpty(e_Status, documentData, Fields.DOCUMENT_STATUS)
	//
	//		'Enter description'
	//		new actions.Common().setTextIfNotEmpty(e_Description, documentData, Fields.ACC_AVAILABLE_BALANCE)
	//	}
}