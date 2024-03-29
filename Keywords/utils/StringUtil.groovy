package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.util.Map

import org.apache.commons.lang3.StringUtils

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

import enums.Fields
import internal.GlobalVariable

public class StringUtil {

	public static boolean isValidData(Map<Fields, String> data, Fields field) {
		if(data.containsKey(field) && StringUtils.isNotBlank(data.get(field))) {
			return true
		}
		else {
			return false
		}
	}
	
	public static boolean printMap(Map<Fields, String> data) {
		data.each {entry -> println "$entry.key".padRight(40)+" = $entry.value"}
		data.each {entry -> KeywordUtil.logInfo("$entry.key".padRight(40)+" = $entry.value")}
	}
}
