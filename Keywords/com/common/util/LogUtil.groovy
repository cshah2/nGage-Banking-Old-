package com.common.util

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

import internal.GlobalVariable

public class LogUtil {
	
	public static void keywordStart() {
		
		String callerMethodName = Thread.currentThread().getStackTrace()[6].methodName
		KeywordUtil.logInfo("KEYWORD START || "+callerMethodName)
		
	}
	
	public static void keywordEnd() {
		
		String callerMethodName = Thread.currentThread().getStackTrace()[6].methodName
		KeywordUtil.logInfo("KEYWORD END || "+callerMethodName)
	}
	
	public static keywordPass() {
		
	}
	
	public static keywordFail() {
		
	}
	
	public static keywordInfo() {
		
	}
}
