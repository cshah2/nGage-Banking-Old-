package actions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

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
import internal.GlobalVariable
import utils.RegexUtil

public class table {

	private WebElement getTable(TestObject to) {
		return WebUiCommonHelper.findWebElement(to, GlobalVariable.TIMEOUT)
	}

	private WebElement getRow(TestObject to, int rowNo) {
		WebElement table = getTable(to)
		return table.findElement(By.xpath("//tbody/tr["+rowNo+"]"))
	}

	private WebElement getCell(TestObject to, int rowNo, int colNo) {
		WebElement table = getTable(to)
		return table.findElement(By.xpath("//tbody/tr["+rowNo+"]/td["+colNo+"]"))
	}

	private String getCellText(TestObject to, int rowNo, int colNo) {
		WebElement cell = getCell(to, rowNo, colNo)
		return cell.getText().trim()
	}

	private int getRowsCount(TestObject to) {
		WebElement table = getTable(to)
		return table.findElements(By.xpath("//tbody/tr")).size()
	}

	private List<String> getAllTextFromColumn(TestObject to, int colNo) {

		List<String> cellsText = new ArrayList<String>()
		List<WebElement> cells = new ArrayList<WebElement>()

		WebElement table = getTable(to)
		cells = table.findElements(By.xpath("//tbody/tr/td["+colNo+"]"))

		for(WebElement cell in cells) {
			cellsText.add(cell.getText())
		}
		
		return cellsText
	}

	//Keywords
	
	@Keyword
	def verifyRecordsCount(TestObject to, int expRowsCount, RegexOperator operator) {
		
		int actRowsCount = getRowsCount(to)
		println "Actual records count = "+actRowsCount
		
		switch(operator) {
			case RegexOperator.EQUALS:
				WebUI.verifyEqual(actRowsCount, expRowsCount)
				println actRowsCount+" is equal to "+expRowsCount
				break;
			case RegexOperator.GREATER_THAN:
				WebUI.verifyGreaterThan(actRowsCount, expRowsCount)
				println actRowsCount+" is greater than "+expRowsCount
				break;
			case RegexOperator.GREATER_THAN_OR_EQUAL:
				WebUI.verifyGreaterThanOrEqual(actRowsCount, expRowsCount)
				println actRowsCount+" is greater than or equal to "+expRowsCount
				break;
			case RegexOperator.LESS_THAN:
				WebUI.verifyLessThan(actRowsCount, expRowsCount)
				println actRowsCount+" is less than "+expRowsCount
				break;
			case RegexOperator.LESS_THAN_OR_EQUAL:
				WebUI.verifyLessThanOrEqual(actRowsCount, expRowsCount)
				println actRowsCount+" is less than or equal to "+expRowsCount
				break;
			case RegexOperator.NOT_EQUAL:
				WebUI.verifyNotEqual(actRowsCount, expRowsCount)
				println actRowsCount+" is not equal to "+expRowsCount
				break;
			default:
				KeywordUtil.markFailedAndStop('Incorrect operator provided in keyword for integer comparison operation.')
				break;
		}
	}

	//Cell value comparison
	@Keyword
	def verifyCellValueContains(TestObject to, int rowNo, int colNo, String expText) {
		String actText = getCellText(to, rowNo, colNo)
		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS), true)
	}

	@Keyword
	def verifyCellValueContainsIgnoreCase(TestObject to, int rowNo, int colNo, String expText) {
		String actText = getCellText(to, rowNo, colNo)
		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE), true)
	}

	@Keyword
	def verifyCellValueStartsWith(TestObject to, int rowNo, int colNo, String expText) {
		//TODO:
	}

	@Keyword
	def verifyCellValueEndsWith(TestObject to, int rowNo, int colNo, String expText) {
		//TODO:
	}

	@Keyword
	def verifyCellValueEquals(TestObject to, int rowNo, int colNo, String expText) {
		String actText = getCellText(to, rowNo, colNo)
		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS), true)
	}

	@Keyword
	def verifyCellValueEqualsIgnoreCase(TestObject to, int rowNo, int colNo, String expText) {
		String actText = getCellText(to, rowNo, colNo)
		WebUI.verifyMatch(actText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE), true)
	}

	//Column values comparison

	@Keyword
	def verifyAllValuesInColumnEquals(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.EQUALS)
		println "Regex String = "+regexString
		
		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def verifyAllValuesInColumnEqualsIgnoreCase(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE)
		println "Regex String = "+regexString

		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def VerifyAllValuesInColumnContains(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.CONTAINS)
		println "Regex String = "+regexString

		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def verifuAllValuesInColumnContainsIgnoreCase(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE)
		println "Regex String = "+regexString

		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def verifyAllValuesinColumnStartsWith(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.STARTS_WITH)
		println "Regex String = "+regexString

		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def verifyAllValuesInColumnEndsWith(TestObject to, int colNo, String expText) {
		
		String regexString = RegexUtil.formRegexString(expText, RegexOperator.ENDS_WITH)
		println "Regex String = "+regexString

		List<String> cellsText = getAllTextFromColumn(to, colNo)
		for(String cellText in cellsText) {
			println "Cell Text = "+cellText
			WebUI.verifyMatch(cellText, regexString, true)
		}
	}

	@Keyword
	def verifyAnyValueInColumnEquals(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	@Keyword
	def verifyAnyValueInColumnEqualsIgnoreCase(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.EQUALS_IGNORE_CASE), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	@Keyword
	def verifyAnyValueInColumnContains(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	@Keyword
	def verifyAnyValueInColumnContainsIgnoreCase(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.CONTAINS_IGNORE_CASE), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	@Keyword
	def verifyAnyValueInColumnStartsWith(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.STARTS_WITH), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	@Keyword
	def verifyAnyValueInColumnEndsWith(TestObject to, int colNo, String expText) {
		List<String> cellsText = getAllTextFromColumn(to, colNo)

		boolean isMatchFound = false
		int rowNo = 1
		for(String cellText in cellsText) {
			try {
				WebUI.verifyMatch(cellText, RegexUtil.formRegexString(expText, RegexOperator.ENDS_WITH), true)
				isMatchFound = true
				break
			}
			catch(Exception e) {
				rowNo++;
				println e.toString()
			}
		}

		if(isMatchFound) {
			KeywordUtil.markPassed("value "+expText+" found in column at row no "+rowNo)
		}
		else {
			KeywordUtil.markFailed("value "+expText+" not found in column")
		}
	}

	//Operation within cell

	@Keyword
	def clickCell(TestObject to, int rowNo, int colNo) {
		WebElement table = getTable(to)
		table.findElement(By.xpath("//tbody/tr["+rowNo+"]/td["+colNo+"]//a")).click()
	}

}
