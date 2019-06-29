package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import java.time.LocalDateTime
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

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

public class DateUtil {

	public static String convert(String date, String currFormat, String expFormat) {

		def currFormatDate = new Date().parse(currFormat,date)
		return currFormatDate.format(expFormat)
	}

	public static String getCurrentDateTime(String format, String timezone) {

		String dateString = ZonedDateTime.now(ZoneId.of(timezone))format(DateTimeFormatter.ofPattern(format))
		println "Date is :"+dateString
		return dateString
	}

	public static String getCurrentDateTimeMinusDays(int days, String format, String timezone) {

		String dateString = ZonedDateTime.now(ZoneId.of(timezone)).minusDays(days).format(DateTimeFormatter.ofPattern(format))
		println "Date is :"+dateString
		return dateString
	}
}
