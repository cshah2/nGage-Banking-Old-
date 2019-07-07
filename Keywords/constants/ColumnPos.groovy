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
	public static int CUST_PHONE_NUMBER = 7
	public static int CUST_TAX_ID = 5
	public static int CUST_DOB = 4

	//Accounts Table - Customer Details page
	public static int ACC_NUMBER = 1
	public static int ACC_TITLE = 2
	public static int ACC_OPEN_DATE = 3
	public static int ACC_OWNERSHIP = 4
	public static int ACC_PRODUCT_NAME = 5
	public static int ACC_DESCRIPTION = 6
	public static int ACC_POSITION_NAME = 7
	public static int ACC_INTEREST_RATE = 8
	public static int ACC_LEDGER_BALANCE = 9
	public static int ACC_AVAILABLE_BALANCE = 10

	//Documents Table - Account Details page
	public static int DOC_TYPE = 1
	public static int DOC_SIGNED_BY = 2
	public static int DOC_SIGNED_DATE = 3
	public static int DOC_VERSION = 4
	public static int DOC_RESCINDED_BY = 5
	public static int DOC_RECISION_DATE = 6

	//Address Table - Contact Details tab - Customer Details Page
	public static int ADDR_ADDRESS_TYPE = 1
	public static int ADDR_ADDRESS_LABEL = 2
	public static int ADDR_STREET = 3
	public static int ADDR_CITY = 4
	public static int ADDR_COUNTY = 5
	public static int ADDR_STATE = 6
	public static int ADDR_ZIPCODE = 7
	public static int ADDR_VALID_FROM = 8
	public static int ADDR_VALID_UNTIL = 9
	public static int ADDR_VERIFIED_DATE = 10
	public static int ADDR_PREFERRED = 11
	public static int ADDR_MOREICON = 12

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
	public static int DOCUMENT_CREATED_BY = 8
	public static int DOCUMENT_STATUS= 9

	
}
