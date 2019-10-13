package com.common.keywords
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords

import internal.GlobalVariable

import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import com.common.enums.TableType

import enums.RegexOperator

import org.openqa.selenium.WebElement
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By

import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty

import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil

import com.kms.katalon.core.webui.exception.WebElementNotFoundException


class Table {


	private WebElement getCell() {
	}

	private WebElement getRow() {
	}

	private List<WebElement> getAllRows() {
	}

	private List<WebElement> getEntireColumn() {
	}


	@Keyword
	def getNumberOfRowsCount(TestObject table) {

		KeywordUtil.logInfo('KEYWORD START : Table || getNumberOfRowsCount')

		int actRowsCount = getAllRows().size()
		KeywordUtil.logInfo('Number of rows = '+actRowsCount)

		KeywordUtil.logInfo('KEYWORD END : Table || getNumberOfRowsCount')

		return actRowsCount
	}

	@Keyword
	def verifyNumberOfRowsCount(TestObject table, int expRowsCount, RegexOperator operator, TableType type = TableType.DEFAULT) {

		KeywordUtil.logInfo('KEYWORD START : Table || verifyNumberOfRowsCount')

		int actRowsCount = getAllRows().size()
		KeywordUtil.logInfo('Number of rows = '+actRowsCount)
		new Verify().verifyNumbericMatches(actRowsCount, expRowsCount, operator)

		KeywordUtil.logInfo('KEYWORD START : Table || verifyNumberOfRowsCount')
	}

	@Keyword
	def getStringCellValue(TestObject table, int rowNo, int colNo, String expStringValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}

	@Keyword
	def verifyStringCellValueMatches(TestObject table, int rowNo, int colNo, String expStringValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}

	@Keyword
	def verifyIntegerCellValueMatches(TestObject table, int rowNo, int colNo, int expIntegerValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}

	@Keyword
	def verifyNumericCellValueMatches(TestObject table, int rowNo, int colNo, double expNumericValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}

	@Keyword
	def verifyAnyCellValuesMatches(TestObject table, int colNo, String expStringValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}

	@Keyword
	def verifyAllCellValuesMatches(TestObject table, int colNo, String expStringValue, RegexOperator operator, TableType type = TableType.DEFAULT) {
	}
}