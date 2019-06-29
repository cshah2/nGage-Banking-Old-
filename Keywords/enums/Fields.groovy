package enums

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

public enum Fields {

	CUST_FIRST_NAME,
	CUST_MIDDLE_NAME,
	CUST_LAST_NAME,
	CUST_NAME_VIEW,
	CUST_DOB,
	CUST_DOB_MASKED,
	CUST_TAX_ID,
	CUST_TAX_ID_MASKED,
	CUST_COUNTRY_OF_RESIDENCE,
	CUST_RESIDENCY_STATUS,
	CUST_MARITAL_STATUS,
	CUST_CUSTOMER_ID,
	CUST_CUSTOMER_GROUP,
	ADDR_STREET,
	ADDR_CITY,
	ADDR_COUNTY,
	ADDR_STATE,
	ADDR_ZIPCODE,
	ADDR_VERIFIED_DATE,
	ADDR_VALID_FROM,
	ADDR_VALID_UNTIL,
	ADDR_ADDRESS_TYPE,
	ADDR_ADDRESS_LABEL,
	ADDR_VIEW,
	CT_PHONE_NUMBER,
	CT_PHONE_LABEL,
	CT_PHONE_VERIFIED_DATE,
	CT_PHONE_VALID_FROM,
	CT_PHONE_VALID_UNTIL,
	CT_PHONE_TYPE,
	CT_EMAIL,
	CT_EMAIL_LABEL,
	CT_EMAIL_VERIFIED_DATE,
	CT_EMAIL_VALID_FROM,
	CT_EMAIL_VALID_UNTIL,
	CT_EMAIL_TYPE,
	CT_PREFERRED_LANGUAGE,
	CT_PREFERRED_CONTACT_METHOD,
	ACC_TITLE,
	ACC_DESCRIPTION,
	ACC_GROUP,
	ACC_NUMBER,
	ACC_BROKERED,
	ACC_TIMEZONE,
	ACC_STATEMENT_FREQUENCY,
	ACC_PRODUCT_TYPE,
	ACC_POSITION_NAME,
	ACC_CURRENCY_CODE,
	ACC_VERTICAL,
	ACC_DEPT_ID,
	ACC_CREDIT_LIMIT,
	ACC_INTEREST_RATE,
	ACC_OPEN_DATE,
	ACC_OWNERSHIP,
	ACC_PRODUCT_NAME,
	ACC_LEDGER_BALANCE,
	ACC_AVAILABLE_BALANCE,
	DOC_TYPE,
	DOC_SIGNED_BY,
	DOC_SIGNED_DATE,
	DOC_VERSION,
	DOC_TYPE2,
	DOC_SIGNED_BY2,
	DOC_SIGNED_DATE2,
	DOC_VERSION2,
	DOCUMENT_FILEPATH,
	DOCUMENT_CLASS,
	DOCUMENT_TYPE,
	DOCUMENT_START_DATE,
	DOCUMENT_END_DATE,
	DOCUMENT_RECEIVED_DATE,
	DOCUMENT_STATUS,
	DOCUMENT_DESCRIPTION,
	DOCUMENT_LAUNCH,
	DOCUMENT_TITLE,
	
	IS_CREATED
}
