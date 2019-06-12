package utils

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.apache.commons.lang3.StringUtils

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

import enums.RegexOperator
import internal.GlobalVariable

public class RegexUtil {

	private static String addEscapeChars(String text) {

		text = text.replaceAll('\\+', '\\\\+')
		text = text.replaceAll('\\*', '\\\\*')
		return text
	}

	//	public static String containsString(String text) {
	//
	//		text = addEscapeChars(text)
	//		return '.*'+text+'.*'
	//	}

	public static String formRegexString(String text, RegexOperator operator) {


		switch(operator) {

			case RegexOperator.EQUALS:
				text = addEscapeChars(text)
				break;
			case RegexOperator.EQUALS_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '(?i)'+text+'(?i)'
				break;
			case RegexOperator.CONTAINS:
				text = addEscapeChars(text)
				text = '.*'+text+'.*'
				break;
			case RegexOperator.CONTAINS_IGNORE_CASE:
				text = addEscapeChars(text)
				text = '.*(?i)'+text+'(?i).*'
				break;
			case RegexOperator.STARTS_WITH:
				break;
			case RegexOperator.ENDS_WITH:
				break;
			case RegexOperator.NONE:
				break;
			default:
				break;

				return text;
		}
	}

	//    public static String maskString(String strText, int start, int end, char maskChar)
	//        throws Exception{
	//
	//        if(strText == null || strText.equals(""))
	//            return "";
	//
	//        if(start < 0)
	//            start = 0;
	//
	//        if( end > strText.length() )
	//            end = strText.length();
	//
	//        if(start > end)
	//            throw new Exception("End index cannot be greater than start index");
	//
	//        int maskLength = end - start;
	//
	//        if(maskLength == 0)
	//            return strText;
	//
	//        StringBuilder sbMaskString = new StringBuilder(maskLength);
	//
	//        for(int i = 0; i < maskLength; i++){
	//            sbMaskString.append(maskChar);
	//        }
	//
	//        return strText.substring(0, start)
	//            + sbMaskString.toString()
	//            + strText.substring(start + maskLength);
	//    }
}
