package constants

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

import internal.GlobalVariable

public class ColumnPos {

	//Customer Table - Search Page
	public static int CUST_LAST_NAME = 1
	public static int CUST_FIRST_NAME = 2
	public static int CUST_CUSTOMER_GROUP = 3
	public static int CUST_CUSTOMER_ID = 4
	public static int CUST_DOB = 6
	public static int CUST_EMAIL = 5
	public static int CUST_TAX_ID = 7
	public static int CUST_DRIVER_LICENSE = 8
	public static int CUST_PHONE_NUMBER = 9
	
	//Accounts Table - Customer Details page
	public static int ACC_NUMBER = 1
	public static int ACC_TITLE = 2
	public static int ACC_OPEN_DATE = 3
	public static int ACC_OWNERSHIP = 4
	public static int ACC_PRODUCT_NAME = 5
	public static int ACC_DESCRIPTION = 6
	public static int ACC_STATUS = 7
	public static int ACC_POSITION_NAME = 8
	public static int ACC_INTEREST_RATE = 9
	public static int ACC_CURRENCY_CODE = 10
	public static int ACC_LEDGER_BALANCE = 11
	public static int ACC_AVAILABLE_BALANCE = 12

	//Documents Table - Account Details page
	public static int DOC_TYPE = 1
	public static int DOC_SIGNED_BY = 2
	public static int DOC_SIGNED_DATE = 3
	public static int DOC_VERSION = 4
	public static int DOC_RESCINDED_BY = 5
	public static int DOC_RECISION_DATE = 6

	//Address Table - Contact Details tab - Customer Details Page
	public static int ADDR_ADDRESS_TYPE = 2
	public static int ADDR_ADDRESS_LABEL = 3
	public static int ADDR_LINE1 = 4
	public static int ADDR_LINE2 = 5
	public static int ADDR_CITY = 6
	public static int ADDR_STATE = 7
	public static int ADDR_ZIPCODE = 8
	public static int ADDR_COUNTY = 9
	public static int ADDR_VALID_FROM = 10
	public static int ADDR_VALID_UNTIL = 11
	public static int ADDR_VERIFIED_DATE = 12
	public static int ADDR_TAX_ADDRESS = 13
	public static int ADDR_MOREICON = 14

	//Customer Phone Table - Contact Details tab - Customer Details Page
	public static int CT_PHONE_TYPE = 1
	public static int CT_PHONE_LABEL = 2
	public static int CT_PHONE_NUMBER = 3
	public static int CT_PHONE_VALID_FROM = 4
	public static int CT_PHONE_VALID_UNTIL = 5
	public static int CT_PHONE_VERIFIED_DATE = 6
	public static int CT_PHONE_PREFERRED = 7
	public static int CT_PHONE_EDITICON = 8

	//Customer Email Table - Contact Details tab - Customer Details Page
	public static int CT_EMAIL_TYPE = 1
	public static int CT_EMAIL_LABEL = 2
	public static int CT_EMAIL = 3
	public static int CT_EMAIL_VALID_FROM = 4
	public static int CT_EMAIL_VALID_UNTIL = 5
	public static int CT_EMAIL_VERIFIED_DATE = 6
	public static int CT_EMAIL_PREFERRED = 7
	public static int CT_EMAIL_EDITICON = 8

	//Customer Notes - Notes tab - Customer Details Page
	public static int NOTE_TEXT = 1
	public static int NOTE_CREATED_BY = 2
	public static int NOTE_CREATED_DATE = 3

	//Customer Documents - Documents tab - Customer Details Page
	public static int DOCUMENT_ICON = 1
	public static int DOCUMENT_ICON2 = 2
	public static int DOCUMENT_CLASS = 3
	public static int DOCUMENT_TYPE = 4
	public static int DOCUMENT_DESCRIPTION = 5
	public static int DOCUMENT_CUSTOMER_ID = 6
	public static int DOCUMENT_ACCOUNT_NUMBER = 7
	public static int DOCUMENT_POSITION_ACCOUNT_NUMBER = 8
	public static int DOCUMENT_CREATED_BY = 9
	public static int DOCUMENT_STATUS= 10
	
	//Account Details Page - Overview tab & Transaction tab - Transaction table
	public static int TXN_EXPAND_ICON = 1
	public static int TXN_CREATED_DATE = 2
	public static int TXN_EFFECTIVE_DATE = 3
	public static int TXN_GL_JOURNAL_DATE = 4
	public static int TXN_TYPE = 5
	public static int TXN_DEBIT = 6
	public static int TXN_CREDIT = 7
	public static int TXN_ENDING_BALANCE = 8
	public static int TXN_COMMENT = 9
	
	//Account Details Page - Overview tab & Holds tab - Holds table
	public static int HOLD_EXPAND_ICON = 1
	public static int HOLD_TYPE = 2
	public static int HOLD_START_DATE = 3
	public static int HOLD_END_DATE = 4
	public static int HOLD_DURATION = 5
	public static int HOLD_AMOUNT = 6
	public static int HOLD_CANCEL_DATE = 7
	public static int HOLD_MORE_ICON = 8
	
	//Account Details Page - Orders tab - Orders table
	public static int ORDER_EXPAND_ICON = 1
	public static int ORDER_TYPE = 2
	public static int ORDER_CREATE_DATE = 3
	public static int ORDER_ORDER_DATE = 4
	public static int ORDER_FROM_ACCOUNT = 5
	public static int ORDER_TO_ACCOUNT = 6
	public static int ORDER_COUNTERPARTY_INSTITUTION = 7
	public static int ORDER_TRANSFER_AMOUNT = 8
	public static int ORDER_STATUS = 9
	public static int ORDER_MORE_ICON = 10

	//Organization Table - Search Page
	public static int ORG_SEARCH_NAME = 1
	public static int ORG_SEARCH_CUSTOMER_GROUP = 2
	public static int ORG_SEARCH_ESTABLISHED_DATE = 3
	public static int ORG_SEARCH_COUNTRY = 4
	public static int ORG_SEARCH_DUN_BRADSTREET = 5
	public static int ORG_SEARCH_PHONE_NUMBER = 6
	public static int ORG_SEARCH_ADDRESS = 7
	public static int ORG_SEARCH_TAX_ID = 8



		
}
