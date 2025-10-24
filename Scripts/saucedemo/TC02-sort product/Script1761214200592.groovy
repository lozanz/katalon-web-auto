import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.callTestCase(findTestCase('saucedemo/TC1-login'), [('username') : 'standard_user', ('password') : 'secret_sauce'], FailureHandling.STOP_ON_FAILURE)
//actions.sendKeys(Keys.ESCAPE).perform()
//WebUI.click(findTestObject('Object Product Page/dropdownSort'))
WebUI.callTestCase(findTestCase('saucedemo/login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Product Page/dropdownSort'), sortType, false)

String firstProduct = WebUI.getText(findTestObject('Object Product Page/firstProductName'))

if (sortType == 'az') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Backpack', false)
} else if (sortType == 'za') {
    WebUI.verifyMatch(firstProduct, 'Test.allTheThings() T-Shirt (Red)', false)
} else if (sortType == 'lohi') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Onesie', false)
} else if (sortType == 'hilo') {
    WebUI.verifyMatch(firstProduct, 'Sauce Labs Fleece Jacket', false)
} else {
    KeywordUtil.markWarning("Sort type tidak dikenali: $sortType")
}

WebUI.closeBrowser()

