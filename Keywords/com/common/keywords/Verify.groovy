package com.common.keywords

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
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import enums.RegexOperator
import com.common.util.LogUtil

import internal.GlobalVariable
import utils.RegexUtil

public class Verify {

	/**
	 * Compare two string values using regular expression.
	 * Function takes screenshot on failure.
	 * @param actText
	 * @param expText
	 * @param operator
	 * @return
	 */
	@Keyword
	def verifyStringMatches(String actText, String expText, RegexOperator operator) {

		//KeywordUtil.logInfo('KEYWORD START : Verify || verifyStringMatches')
		LogUtil.keywordStart()

		String actRegexText
		boolean isRegex
		if(operator == RegexOperator.NONE) {
			isRegex = false
			actRegexText = actText
		}
		else {
			isRegex = true
			actRegexText = RegexUtil.formRegexString(actText, operator)
		}

		KeywordUtil.logInfo('Expected Text = '+expText)
		KeywordUtil.logInfo('Actual Text = '+actText)
		KeywordUtil.logInfo('Actual Regex Text = '+actRegexText)
		KeywordUtil.logInfo('Operator = '+operator.toString())

		try {
			WebUI.verifyMatch(actRegexText, expText, isRegex)
			KeywordUtil.markPassed('KEYWORD PASSED : Verify || verifyStringMatches')
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop('KEYWORD FAILED : Verify || verifyStringMatches \n'
					+e.toString())
		}

		LogUtil.keywordEnd()
		//KeywordUtil.logInfo('KEYWORD END : Verify || verifyStringMatches')
	}

	/**
	 * Compare two integer values
	 * Function takes screenshot on failures
	 * @param expValue
	 * @param actValue
	 * @param operator
	 * @return
	 */
	@Keyword
	def verifyNumbericMatches(Object actValue, Object expValue, RegexOperator operator) {

		KeywordUtil.logInfo('KEYWORD START : Verify || verifyIntegerMatches')

		KeywordUtil.logInfo('Expected value = '+expValue.toString())
		KeywordUtil.logInfo('Actual value = '+actValue.toString())
		KeywordUtil.logInfo('Operator = '+operator.toString())

		try {
			switch(operator) {
				case RegexOperator.EQUALS:
					WebUI.verifyEqual(actValue, expValue)
					break;
				case RegexOperator.GREATER_THAN:
					WebUI.verifyGreaterThan(actValue, expValue)
					break;
				case RegexOperator.GREATER_THAN_OR_EQUAL:
					WebUI.verifyGreaterThan(actValue, expValue)
					break;
				case RegexOperator.LESS_THAN:
					WebUI.verifyLessThanOrEqual(actValue, expValue)
					break;
				case RegexOperator.LESS_THAN_OR_EQUAL:
					WebUI.verifyLessThanOrEqual(actValue, expValue)
					break;
				default:
					KeywordUtil.markFailedAndStop('KEYWORD FAILED : Verify || verifyNumbericMatches \n'
					+'Invalid operator type provided for integer comparison '+operator.toString())
					break;
			}
		}
		catch(Exception e) {
			WebUI.takeScreenshot()
			KeywordUtil.markFailedAndStop(e.toString())
		}

		KeywordUtil.logInfo('KEYWORD END : Verify || verifyIntegerMatches')
	}

	/**
	 * Verify text value of an element matches given text using regular expression
	 * @param obj
	 * @param expText
	 * @param operator
	 * @return
	 */
	@Keyword
	def verifyElementTextMatches(TestObject obj, String expText, RegexOperator operator) {

		KeywordUtil.logInfo('KEYWORD START : Verify || verifyElementTextMatches')

		String actText = WebUI.getText(obj)
		verifyStringMatches(actText, expText, operator)

		KeywordUtil.logInfo('KEYWORD END : Verify || verifyElementTextMatches')
	}

	/**
	 * Verify attribute value of an element matches given text using regular expression
	 * @param obj
	 * @param expText
	 * @param attributeName
	 * @param operator
	 * @return
	 */
	def verifyElementAttributeValueMatches(TestObject obj, int expText, String attributeName, RegexOperator operator) {

		KeywordUtil.logInfo('KEYWORD START : Verify || verifyElementAttributeValueMatches')

		String actText = WebUI.getAttribute(obj, attributeName)
		verifyStringMatches(actText, expText, operator)

		KeywordUtil.logInfo('KEYWORD END : Verify || verifyElementAttributeValueMatches')
	}
}