package pages

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

public class TaskDrawer {

	static def selectTask(String taskName) {

		TestObject taskItem = findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_TaskItem', ['taskName' : taskName])

		'Scroll to Tasks button'
		new actions.Common().moveToElement(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_Tasks'))

		'Select Tasks button'
		WebUI.click(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/btn_Tasks'))

		'Wait for task drawer to load'
		new actions.WaitFor().elementVisible(findTestObject('Dashboard Page/Customer and Account Search Page/TaskList Drawer/section_TaskLists'), GlobalVariable.TIMEOUT)
		WebUI.delay(1)

		'Scroll to Task Item'
		new actions.Common().moveToElement(taskItem)

		'Click on Task Item'
		WebUI.click(taskItem)
	}
}
