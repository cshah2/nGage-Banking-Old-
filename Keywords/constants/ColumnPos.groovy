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
	public static int ACC_INTEREST_RATE = 7
	public static int ACC_LEDGER_BALANCE = 8
	public static int ACC_AVAILABLE_BALANCE = 9
	
	//Documents Table - Account Details page
	public static int DOC_TYPE = 1
	public static int DOC_SIGNED_BY = 2
	public static int DOC_SIGNED_DATE = 3
	public static int DOC_VERSION = 4
	public static int DOC_RESCINDED_BY = 5
	public static int DOC_RECISION_DATE = 6
}
